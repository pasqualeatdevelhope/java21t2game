package com.pasqualehorse.gioco.muorimale.action.actions;

import java.util.Map;

import com.pasqualehorse.gioco.muorimale.action.Action;
import com.pasqualehorse.gioco.muorimale.action.ActionResult;
import com.pasqualehorse.gioco.muorimale.action.Requirement;
import com.pasqualehorse.gioco.muorimale.action.Requirement.Test;
import com.pasqualehorse.gioco.muorimale.criteria.CriteriaResult.CriteriaResultEnum;
import com.pasqualehorse.gioco.muorimale.states.Player;
import com.pasqualehorse.gioco.muorimale.types.FloatingPointNumber;
import com.pasqualehorse.gioco.muorimale.types.IntegerNumber;

public class DrinkACoffee implements Action {

	@Override
	public String getActionName() {
		return "Drink a coffee";
	}

	@Override
	public ActionResult doAction() {
		System.out.println("You're drink a coffee");
		ActionResult result = new ActionResult();
		result.addApplyToContext(Player.MONEY_KEY, FloatingPointNumber.from(-1d));
		return result;

	}

	@Override
	public Map<String, Requirement> actionRequirement() {
		return Map.of(Player.MONEY_KEY, 
						Requirement.of(FloatingPointNumber.from(1d), Test.EQGT, CriteriaResultEnum.NO_MONEY));
	}

	@Override
	public boolean allowEndOfGameAction() {
		return false;
	}
	

}
