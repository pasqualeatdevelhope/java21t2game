package com.pasqualehorse.gioco.muorimale.criteria;

import com.pasqualehorse.gioco.muorimale.action.Action;
import com.pasqualehorse.gioco.muorimale.states.Player;

public interface CriteriaEvaluator {

	public CriteriaResult evaluateSurvivorCriteria(Player player);
	CriteriaResult proceedByCriteria(Player player, Action action);
	
}
