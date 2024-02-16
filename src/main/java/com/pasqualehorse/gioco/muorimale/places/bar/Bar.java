package com.pasqualehorse.gioco.muorimale.places.bar;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.pasqualehorse.gioco.muorimale.action.Action;
import com.pasqualehorse.gioco.muorimale.action.ActionEngine;
import com.pasqualehorse.gioco.muorimale.action.engine.BarActionEngine;
import com.pasqualehorse.gioco.muorimale.places.Place;

public class Bar implements Place {

	private ActionEngine actionEngine = new BarActionEngine();
	
	
	@Override
	public void doAction(Integer choose) {
		
	}
	
	@Override
	public String getPlaceName() {
		return "Bar";
	}

	@Override
	public ActionEngine getActionEngine() {
		return actionEngine;
	}

	@Override
	public String getPlacePrintableName() {
		return "Bar";
	}



}
