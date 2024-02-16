package com.pasqualehorse.gioco.muorimale.action;

import java.util.Map;

import com.pasqualehorse.gioco.muorimale.action.exception.EndOfLifeException;
import com.pasqualehorse.gioco.muorimale.criteria.CriteriaResult;
import com.pasqualehorse.gioco.muorimale.criteria.CriteriaResult.CriteriaResultEnum;
import com.pasqualehorse.gioco.muorimale.input.Iutils;
import com.pasqualehorse.gioco.muorimale.states.Player;

public abstract class ActionEngine {

	public void runEngine(Player player) {
		int choiche = 0;
		do {
			choiche = printActions();
			if(choiche == 0) {
				break;
			}
			Action a = getActions().get(choiche);
			if (a != null) {
				CriteriaResult operationProceedEvaluator = null;
				
				if(a.allowEndOfGameAction()) {
					operationProceedEvaluator = player.getCriteriaEvaluator().proceedByCriteria(player, a);
				} else {
					operationProceedEvaluator = CriteriaResult.from(CriteriaResultEnum.OK);
				}
				
				if(operationProceedEvaluator.getState().size() == 1 && operationProceedEvaluator.getState().get(0).equals(CriteriaResultEnum.OK)) {
					player.apply(a.doAction());
					player.printStats();
					CriteriaResult operationResultEvaluator = player.getCriteriaEvaluator().evaluateSurvivorCriteria(player);
					if(!(operationResultEvaluator.getState().size() == 1 && operationResultEvaluator.getState().get(0).equals(CriteriaResultEnum.OK))) {
						throw new EndOfLifeException(operationProceedEvaluator, "Game over");
					} 
				} else {
					System.out.println("Non puoi eseguire questa operazione in quanto finirebbe il gioco. "
							+ "Risultato della valutazione: " + operationProceedEvaluator );
				}
			} else {
				System.out.println("Place not found");
			}
		} while (choiche != 0);

	}

	private int printActions() {
		getActions().forEach((key, value) -> {
			System.out.println(key + ". " + value.getActionName());
		});
		System.out.println("0. Back to main menu");
		return Iutils.getInt();
	}

	protected abstract Map<Integer, Action> getActions();

}
