package com.pasqualehorse.gioco.muorimale.action;

import java.util.HashMap;
import java.util.Map;

import com.pasqualehorse.gioco.muorimale.types.RelaxedComparator;

public class ActionResult {

	Map<String, RelaxedComparator<?>> applyToContext = new HashMap<>();

	public Map<String, RelaxedComparator<?>> getApplyToContext() {
		return applyToContext;
	}

	public void setApplyToContext(Map<String, RelaxedComparator<?>> applyToContext) {
		this.applyToContext = applyToContext;
	}

	public <T> void addApplyToContext(String key, RelaxedComparator<T> value) {
		if (applyToContext.containsKey(key)) {
			throw new RuntimeException("Duplicated entry not allowed");
		}
		applyToContext.put(key, value);
	}

}
