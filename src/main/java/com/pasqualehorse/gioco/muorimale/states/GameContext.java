package com.pasqualehorse.gioco.muorimale.states;

import java.util.HashMap;

import com.pasqualehorse.gioco.muorimale.types.RelaxedComparator;

public class GameContext extends HashMap<String, RelaxedComparator<?>> {

	private static final long serialVersionUID = 5156574415830179771L;

	@Override
	public void clear() {
		throw new RuntimeException("Method not implemented");
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getAsType(String key, Class<T> t) {
		if(containsKey(key)) {
			return (T)get(key);
		}
		return null;
	}
	
}
