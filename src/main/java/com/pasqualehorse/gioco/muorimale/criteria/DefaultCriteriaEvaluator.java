package com.pasqualehorse.gioco.muorimale.criteria;

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
import com.pasqualehorse.gioco.muorimale.states.Player;
import com.pasqualehorse.gioco.muorimale.types.FloatingPointNumber;
import com.pasqualehorse.gioco.muorimale.types.RelaxedComparator;

public class DefaultCriteriaEvaluator implements CriteriaEvaluator {

	private Map<String, Requirement> aliveAssertion = new HashMap<>();

	private DefaultCriteriaEvaluator() {
		aliveAssertion.put(Player.HIGH_KEY, Requirement.of(FloatingPointNumber.from(100d), Test.LT, CriteriaResultEnum.HIGH_HIGH));
		aliveAssertion.put(Player.HP_KEY, Requirement.of(FloatingPointNumber.from(0d), Test.GT, CriteriaResultEnum.NO_HP));
		aliveAssertion.put(Player.KARMA_KEY, Requirement.of(FloatingPointNumber.from(0d), Test.GT, CriteriaResultEnum.NO_KARMA));
		aliveAssertion.put(Player.MONEY_KEY, Requirement.of(FloatingPointNumber.from(0d), Test.GT, CriteriaResultEnum.NO_MONEY));
	}

	private static DefaultCriteriaEvaluator instance = new DefaultCriteriaEvaluator();
	
	public static DefaultCriteriaEvaluator instance() {
		return instance;
	}
	
	
	
	@Override
	public CriteriaResult evaluateSurvivorCriteria(Player player) {
		CriteriaResult result = new CriteriaResult();
		List<CriteriaResultEnum> currentCriteriaResult = new ArrayList<>();
		if (player instanceof DefaultCharacter c) {
			for (Entry<String, Requirement> requirements : aliveAssertion.entrySet()) {
				RelaxedComparator<?> currentValue = player.getGameContext().get(requirements.getKey());
				if (!successfultTestedComparison(currentValue, requirements.getValue())) {
					currentCriteriaResult.add(requirements.getValue().getOnTestFailureResult());
				}
			}
			if(currentCriteriaResult.isEmpty()) {
				currentCriteriaResult.add(CriteriaResultEnum.OK);
			}
			result.setState(currentCriteriaResult);
			return result;
		} else {
			throw new IllegalArgumentException("Player must be of type DefaultCharacter");
		}
	}

	@Override
	public CriteriaResult proceedByCriteria(Player player, Action action) {
		Map<String, Requirement> actionRequirement = action.actionRequirement();
		CriteriaResult result = new CriteriaResult();
		List<CriteriaResultEnum> currentCriteriaResult = new ArrayList<>();
		if (player instanceof DefaultCharacter c) {
			for (Entry<String, Requirement> requirements : actionRequirement.entrySet()) {
				RelaxedComparator<?> currentValue = player.getGameContext().get(requirements.getKey());
				if (!successfultTestedComparison(currentValue, requirements.getValue())) {
					currentCriteriaResult.add(requirements.getValue().getOnTestFailureResult());
				}
			}
			if(currentCriteriaResult.isEmpty()) {
				currentCriteriaResult.add(CriteriaResultEnum.OK);
			}
			result.setState(currentCriteriaResult);
			return result;
		} else {
			throw new IllegalArgumentException("Player must be of type DefaultCharacter");
		}

	}

	private boolean successfultTestedComparison(RelaxedComparator<?> currentValue, Requirement requirement) {
		int result = currentValue.compare(requirement.getValue());
		return (result == 0 && requirement.getTest().equals(Test.EQ))
				|| (result == 1 && (requirement.getTest().equals(Test.EQGT) || requirement.getTest().equals(Test.GT)))
				|| (result == -1
						&& (requirement.getTest().equals(Test.LT) || requirement.getTest().equals(Test.EQLT)));
	}

}
