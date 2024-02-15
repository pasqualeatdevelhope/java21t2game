package com.pasqualehorse.gioco.muorimale.places;

import com.pasqualehorse.gioco.muorimale.action.ActionEngine;

public interface Place {

	public void doAction(Integer choose);	
	public ActionEngine	 getActionEngine();
	public String getPlaceName();
	public String getPlacePrintableName();
}
