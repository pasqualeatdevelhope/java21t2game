package com.pasqualehorse.gioco.muorimale.places;

import java.util.HashMap;
import java.util.Map;

import com.pasqualehorse.gioco.muorimale.input.Iutils;
import com.pasqualehorse.gioco.muorimale.inventario.InventarioEngine;
import com.pasqualehorse.gioco.muorimale.states.Player;

public class PlaceEngine {

	Map<Integer, Place> places = new HashMap<>();
	InventarioEngine inventarioEngine = new InventarioEngine();

	public void runEngine(Player player) {
		do {
			int choiche = printPlaces();
			if (choiche == 0) {
				inventarioEngine.goInventario(player);
			} else {
				Place p = places.get(choiche);
				if (p != null) {
					p.getActionEngine().runEngine(player);
				} else {
					System.out.println("Place not found");
				}
			}
		} while (player.stillAlive());
	}

	private int printPlaces() {
		System.out.println("0. Inventario");
		places.forEach((key, value) -> {
			System.out.println(key + ". " + value.getPlacePrintableName());
		});
		return Iutils.getInt();
	}
}
