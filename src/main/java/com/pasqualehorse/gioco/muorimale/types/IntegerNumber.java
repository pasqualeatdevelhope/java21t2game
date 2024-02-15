package com.pasqualehorse.gioco.muorimale.types;

public class IntegerNumber extends RelaxedComparator<Integer>{
	
	public static IntegerNumber from(Integer value) {
		IntegerNumber in = new IntegerNumber();
		in.value = value;
		return in;
	}

	@Override
	public void applyChanges(RelaxedComparator<?> item) {
		if(item.getValue() instanceof Integer i) {
			this.value += i;
		} else {
			throw new IllegalArgumentException("value field must be of type `Ingeter`");
		}
	}

	@Override
	protected int compareInternal(Integer t) {
		if(value.equals(t)) {
			return 0;
		} else if(value > t) {
			return 1;
		} else {
			return -1;
		}
	}

}
