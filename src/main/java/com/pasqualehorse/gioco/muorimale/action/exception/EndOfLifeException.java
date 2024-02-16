package com.pasqualehorse.gioco.muorimale.action.exception;

import com.pasqualehorse.gioco.muorimale.criteria.CriteriaResult;

public class EndOfLifeException extends RuntimeException {

	private static final long serialVersionUID = 3737461573696707041L;
	private CriteriaResult criteriaResult;

	public CriteriaResult getCriteriaResult() {
		return criteriaResult;
	}

	public void setCriteriaResult(CriteriaResult criteriaResult) {
		this.criteriaResult = criteriaResult;
	}

	public EndOfLifeException(CriteriaResult criteriaResult, String message) {
		super(message);
		this.criteriaResult = criteriaResult;
	}

}
