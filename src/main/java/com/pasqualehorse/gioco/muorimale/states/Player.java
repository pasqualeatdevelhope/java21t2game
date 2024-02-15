package com.pasqualehorse.gioco.muorimale.states;

import com.pasqualehorse.gioco.muorimale.action.ActionResult;
import com.pasqualehorse.gioco.muorimale.criteria.CriteriaEvaluator;
import com.pasqualehorse.gioco.muorimale.criteria.CriteriaResult;
import com.pasqualehorse.gioco.muorimale.types.FloatingPointNumber;
import com.pasqualehorse.gioco.muorimale.types.IntegerNumber;

public interface Player {
	
	public static final String KARMA_KEY = "character.karma";
	public static final String HP_KEY = "character.hp";
	public static final String MONEY_KEY = "character.money";
	public static final String HIGH_KEY = "character.high";
	
	public final GameContext gameContext = new GameContext();

	default GameContext getGameContext() {
		return this.getGameContext();
	}
		
	public FloatingPointNumber getMoney();
	public IntegerNumber getHp();
	public IntegerNumber getHigh();
	public IntegerNumber getKarka();
	
	public CriteriaResult apply(ActionResult actionResult);

	public boolean stillAlive();

	public CriteriaEvaluator getCriteriaEvaluator();

	
}
