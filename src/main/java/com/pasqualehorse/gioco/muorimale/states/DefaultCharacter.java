package com.pasqualehorse.gioco.muorimale.states;

import java.util.Map.Entry;

import com.pasqualehorse.gioco.muorimale.action.ActionResult;
import com.pasqualehorse.gioco.muorimale.criteria.CriteriaResult;
import com.pasqualehorse.gioco.muorimale.types.FloatingPointNumber;
import com.pasqualehorse.gioco.muorimale.types.IntegerNumber;
import com.pasqualehorse.gioco.muorimale.types.RelaxedComparator;

public abstract class DefaultCharacter implements Player {

	@Override
	public FloatingPointNumber getMoney() {
		return this.getGameContext().getAsType(MONEY_KEY, FloatingPointNumber.class);
	}

	@Override
	public IntegerNumber getHp() {
		return this.getGameContext().getAsType(HP_KEY, IntegerNumber.class);
	}

	@Override
	public IntegerNumber getHigh() {
		return this.getGameContext().getAsType(HIGH_KEY, IntegerNumber.class);
	}

	@Override
	public IntegerNumber getKarka() {
		return this.getGameContext().getAsType(KARMA_KEY, IntegerNumber.class);
	}

	@Override
	public CriteriaResult apply(ActionResult actionResult) {
		for(Entry<String, RelaxedComparator<?>> entry : actionResult.getApplyToContext().entrySet()) {
			this.getGameContext().get(entry.getKey()).applyChanges(entry.getValue());
		}
		return getCriteriaEvaluator().criteriaResult(actionResult, this);
	}

}
