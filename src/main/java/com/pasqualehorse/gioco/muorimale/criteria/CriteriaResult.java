package com.pasqualehorse.gioco.muorimale.criteria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriteriaResult {

	List<CriteriaResultEnum> state;

	public List<CriteriaResultEnum> getState() {
		return state;
	}

	public void setState(List<CriteriaResultEnum> state) {
		this.state = state;
	}

	public void setState(CriteriaResultEnum... state) {
		this.state = Arrays.asList(state);
	}

	public void addState(CriteriaResultEnum item) {
		if (state == null) {
			state = new ArrayList<>();
		}
		state.add(item);
	}

	public static CriteriaResult from(CriteriaResultEnum criteria) {
		CriteriaResult cr = new CriteriaResult();
		cr.setState(criteria);
		return cr;
	}

	// TODO: definire sta roba
	public enum CriteriaResultEnum {
		OK, NO_MONEY, NO_HP, HIGH_HIGH, NO_KARMA;
	}

	@Override
	public String toString() {
		return "CriteriaResult [state=" + state + "]";
	}

	
}
