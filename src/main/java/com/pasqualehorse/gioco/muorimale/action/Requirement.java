package com.pasqualehorse.gioco.muorimale.action;

import com.pasqualehorse.gioco.muorimale.types.RelaxedComparator;

public class Requirement {

	private RelaxedComparator<?> value;
	private Test test;

	public Requirement() {}
	
	private Requirement(RelaxedComparator<?> value, Test test) {
		this.value = value;
		this.test = test;
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

	public enum Test {
		EQ, GT, LT, EQGT, EQLT;
	}
	
	public static Requirement of(RelaxedComparator<?> value, Test test) {
		return new Requirement(value, test);
	}
	
	public Test test(Requirement)
	
}
