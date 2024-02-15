package com.pasqualehorse.gioco.muorimale.criteria;

import static org.assertj.core.api.Assertions.entry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.pasqualehorse.gioco.muorimale.action.Action;
import com.pasqualehorse.gioco.muorimale.action.ActionResult;
import com.pasqualehorse.gioco.muorimale.action.Requirement;
import com.pasqualehorse.gioco.muorimale.action.Requirement.Test;
import com.pasqualehorse.gioco.muorimale.criteria.CriteriaResult.CriteriaResultEnum;
import com.pasqualehorse.gioco.muorimale.states.DefaultCharacter;
import com.pasqualehorse.gioco.muorimale.states.GameContext;
import com.pasqualehorse.gioco.muorimale.states.Player;
import com.pasqualehorse.gioco.muorimale.types.FloatingPointNumber;
import com.pasqualehorse.gioco.muorimale.types.RelaxedComparator;

public class DefaultCriteriaEvaluator implements CriteriaEvaluator {

	private Map<String, Requirement> aliveAssertion = new HashMap<>();

	public DefaultCriteriaEvaluator() {
		aliveAssertion.put(Player.HIGH_KEY, Requirement.of(FloatingPointNumber.from(100d), Test.LT));
		aliveAssertion.put(Player.HP_KEY, Requirement.of(FloatingPointNumber.from(0d), Test.GT));
		aliveAssertion.put(Player.KARMA_KEY, Requirement.of(FloatingPointNumber.from(0d), Test.GT));
		aliveAssertion.put(Player.MONEY_KEY, Requirement.of(FloatingPointNumber.from(0d), Test.GT));
	}

	@Override
	public CriteriaResult criteriaResult(ActionResult actionResult, Player player) {
		CriteriaResult result = new CriteriaResult();
		List<CriteriaResultEnum> currentCriteriaResult = new ArrayList<>();
		if(player instanceof DefaultCharacter c) {
			for(Entry<String, Requirement> requirements : aliveAssertion.entrySet()) {
				switch (requirements.getKey()) {
				case Player.HIGH_KEY:
					RelaxedComparator<?> currentValue = player.getGameContext().get(Player.HIGH_KEY);
					if(successfultTestedComparison(currentValue, requirements.getValue())) {
						currentCriteriaResult.add(CriteriaResultEnum.HIGH_HIGH);
					}
					break;
				case Player.HP_KEY:
					break;
				case Player.KARMA_KEY:
					break;
				case Player.MONEY_KEY:
					break;
				}					
			}
		} else {
			throw new IllegalArgumentException("Player must be of type DefaultCharacter");
		}
	}

	@Override
	public CriteriaResult criteriaProceed(Player player, Action action) {
		GameContext context = player.getGameContext();
		boolean setOk = true;
		for (Entry<String, Requirement> entry : action.actionRequirement().entrySet()) {
			RelaxedComparator<?> item = context.getAsType(entry.getKey(), entry.getValue().getValue().getClass());
			int result = item.compare(entry.getValue().getValue());
			if ((result == 0 && !entry.getValue().getTest().equals(Test.EQ)) || (result == 1
					&& !(entry.getValue().getTest().equals(Test.EQGT) || entry.getValue().getTest().equals(Test.EQ)))
					|| (result == -1 && !(entry.getValue().getTest().equals(Test.LT)
							|| entry.getValue().getTest().equals(Test.EQLT)))) {
				setOk = false;
			}
			if (!setOk) {
				break;
			}
		}
		return setOk;
	}

	private boolean successfultTestedComparison(RelaxedComparator<?> currentValue, Requirement requirement) {
		int result = currentValue.compare(requirement.getValue());
		return (result == 0 && !requirement.getTest().equals(Test.EQ))
				|| (result == 1 && !(requirement.getTest().equals(Test.EQGT) || requirement.getTest().equals(Test.EQ)))
				|| (result == -1
						&& !(requirement.getTest().equals(Test.LT) || requirement.getTest().equals(Test.EQLT)));
	}

}
