package com.pasqualehorse.gioco.muorimale.action;

import java.util.Map;

import com.pasqualehorse.gioco.muorimale.types.RelaxedComparator;

public class ActionResult {

	Map<String, RelaxedComparator<?>> applyToContext;

	public Map<String, RelaxedComparator<?>> getApplyToContext() {
		return applyToContext;
	}

	public void setApplyToContext(Map<String, RelaxedComparator<?>> applyToContext) {
		this.applyToContext = applyToContext;
	}

	public void addApplyToContext(String key, RelaxedComparator<Object> value) {
		if (applyToContext.containsKey(key)) {
			throw new RuntimeException("Duplicated entry not allowed");
		}
		applyToContext.put(key, value);
	}

}
