package com.pasqualehorse.gioco.muorimale;

import java.util.HashMap;
import java.util.Map;

import com.pasqualehorse.gioco.muorimale.places.Place;
import com.pasqualehorse.gioco.muorimale.places.PlaceEngine;
import com.pasqualehorse.gioco.muorimale.states.HumanCharacter;
import com.pasqualehorse.gioco.muorimale.states.HumanCharacter.HumanCharacterCustomizer;
import com.pasqualehorse.gioco.muorimale.states.Player;

public class Game {

	PlaceEngine placeEngine = new PlaceEngine();
	
	
	public Game() { }


	public void run() {
		Player character = new HumanCharacter(HumanCharacterCustomizer.withDefault());
		do {
			placeEngine.runEngine(character);
		} while(character.stillAlive());
	}
	
	
}
