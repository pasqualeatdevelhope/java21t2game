package com.pasqualehorse.gioco.muorimale;

import com.pasqualehorse.gioco.muorimale.action.exception.EndOfLifeException;
import com.pasqualehorse.gioco.muorimale.places.PlaceEngine;
import com.pasqualehorse.gioco.muorimale.states.HumanCharacter;
import com.pasqualehorse.gioco.muorimale.states.HumanCharacter.HumanCharacterCustomizer;
import com.pasqualehorse.gioco.muorimale.states.Player;

public class Game {

	PlaceEngine placeEngine = new PlaceEngine();

	public Game() {
	}

	public void run() {
		try {
			Player character = new HumanCharacter(HumanCharacterCustomizer.withDefault());
			placeEngine.runEngine(character);
		} catch (EndOfLifeException e) {
			System.out.println(e);
		}
	}

}
