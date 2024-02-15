package com.pasqualehorse.gioco.muorimale.action;

import com.pasqualehorse.gioco.muorimale.criteria.CriteriaResult.CriteriaResultEnum;
import com.pasqualehorse.gioco.muorimale.types.RelaxedComparator;

public class Requirement {

	private RelaxedComparator<?> value;
	private CriteriaResultEnum onTestFailureResult;
	private Test test;

	public Requirement() {}
	
	private Requirement(RelaxedComparator<?> value, Test test, CriteriaResultEnum onTestFailureResult) {
		this.value = value;
		this.test = test;
		this.onTestFailureResult = onTestFailureResult;
	}
	
	public RelaxedComparator<?> getValue() {
		return value;
	}

	public void setValue(RelaxedComparator<?> value) {
		this.value = value;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public CriteriaResultEnum getOnTestFailureResult() {
		return onTestFailureResult;
	}
	
	public void setOnTestFailureResult(CriteriaResultEnum onTestFailureResult) {
		this.onTestFailureResult = onTestFailureResult;
	}
	
	public enum Test {
		EQ, GT, LT, EQGT, EQLT;
	}
	
	public static Requirement of(RelaxedComparator<?> value, Test test, CriteriaResultEnum onTestFailureResult) {
		return new Requirement(value, test, onTestFailureResult);
	}
		
}
