package com.pasqualehorse.gioco.muorimale.criteria;

import com.pasqualehorse.gioco.muorimale.action.Action;
import com.pasqualehorse.gioco.muorimale.action.ActionResult;
import com.pasqualehorse.gioco.muorimale.states.Player;

public interface CriteriaEvaluator {

	public CriteriaResult criteriaResult(ActionResult actionResult, Player player);
	CriteriaResult criteriaProceed(Player player, Action action);
	
}
