package com.pasqualehorse.gioco.muorimale.states;

import com.pasqualehorse.gioco.muorimale.action.ActionResult;
import com.pasqualehorse.gioco.muorimale.criteria.CriteriaEvaluator;
import com.pasqualehorse.gioco.muorimale.types.FloatingPointNumber;

public interface Player {
	
	public static final String KARMA_KEY = "character.karma";
	public static final String HP_KEY = "character.hp";
	public static final String MONEY_KEY = "character.money";
	public static final String HIGH_KEY = "character.high";
	

	public GameContext getGameContext();
		
	public FloatingPointNumber getMoney();
	public FloatingPointNumber getHp();
	public FloatingPointNumber getHigh();
	public FloatingPointNumber getKarka();
	
	public void apply(ActionResult actionResult);

	public CriteriaEvaluator getCriteriaEvaluator();

	public void printStats();

	
}
