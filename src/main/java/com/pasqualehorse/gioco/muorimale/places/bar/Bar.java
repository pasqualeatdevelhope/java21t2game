package com.pasqualehorse.gioco.muorimale.places.bar;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.pasqualehorse.gioco.muorimale.action.Action;
import com.pasqualehorse.gioco.muorimale.places.Place;

public class Bar implements Place {

	Map<Integer, Action> actions;
	
	
	@Override
	public void doAction(Integer choose) {
		
	}
	
	@Override
	public Map<Integer, String> getActions() {
		Map<Integer, String> returnMap = new HashMap<>();
		for(Entry<Integer, Action> entry : actions.entrySet()) {
			returnMap.put(entry.getKey(), entry.getValue().getActionName());
		}
		return returnMap;
	}

	@Override
	public String getPlaceName() {
		return "Bar";
	}



}
