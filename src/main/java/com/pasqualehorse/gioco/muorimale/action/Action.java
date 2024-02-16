package com.pasqualehorse.gioco.muorimale.action;

import java.util.Map;

public interface Action {

	public String getActionName();
		
	public ActionResult doAction();
	
	public Map<String, Requirement> actionRequirement();
	
	public boolean allowEndOfGameAction();
}
