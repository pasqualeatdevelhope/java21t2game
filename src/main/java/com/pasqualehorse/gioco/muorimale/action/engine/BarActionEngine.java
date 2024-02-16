package com.pasqualehorse.gioco.muorimale.action.engine;

import java.util.Map;

import com.pasqualehorse.gioco.muorimale.action.Action;
import com.pasqualehorse.gioco.muorimale.action.ActionEngine;
import com.pasqualehorse.gioco.muorimale.action.actions.DrinkACoffee;

public class BarActionEngine extends ActionEngine {

	Map<Integer, Action> actions;
	
	public BarActionEngine() {
		actions = Map.of(1, new DrinkACoffee());
	}
	
	@Override
	protected Map<Integer, Action> getActions() {
		return actions;
	
	}

}
