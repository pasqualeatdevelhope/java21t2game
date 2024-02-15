package com.pasqualehorse.gioco.muorimale.action;

import java.util.HashMap;
import java.util.Map;

import com.pasqualehorse.gioco.muorimale.action.impl.Bigiotteria;
import com.pasqualehorse.gioco.muorimale.states.Player;

public class ActionEngine {

	Map<Integer, Action> actions = new HashMap<>();
	
	public ActionEngine() {
		actions.put(1, new Bigiotteria());		
	}
	
	public void runEngine(Player player) {
	}
	
	private void printActions() {
		actions.forEach((key, value) -> {
			System.out.println(key  + ". " + value.getActionName());
		});
	}

	
	
}
