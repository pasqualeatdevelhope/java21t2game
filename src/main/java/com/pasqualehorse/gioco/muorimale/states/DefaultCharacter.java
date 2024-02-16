package com.pasqualehorse.gioco.muorimale.states;

import java.util.Map.Entry;

import com.pasqualehorse.gioco.muorimale.action.ActionResult;
import com.pasqualehorse.gioco.muorimale.criteria.CriteriaResult;
import com.pasqualehorse.gioco.muorimale.types.FloatingPointNumber;
import com.pasqualehorse.gioco.muorimale.types.RelaxedComparator;

public abstract class DefaultCharacter implements Player {

	@Override
	public FloatingPointNumber getMoney() {
		return this.getGameContext().getAsType(MONEY_KEY, FloatingPointNumber.class);
	}

	@Override
	public FloatingPointNumber getHp() {
		return this.getGameContext().getAsType(HP_KEY, FloatingPointNumber.class);
	}

	@Override
	public FloatingPointNumber getHigh() {
		return this.getGameContext().getAsType(HIGH_KEY, FloatingPointNumber.class);
	}

	@Override
	public FloatingPointNumber getKarka() {
		return this.getGameContext().getAsType(KARMA_KEY, FloatingPointNumber.class);
	}

}
