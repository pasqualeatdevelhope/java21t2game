package com.pasqualehorse.gioco.muorimale.types;

public class FloatingPointNumber extends RelaxedComparator<Double> {

	
	public static RelaxedComparator<?> from(Double value) {
		RelaxedComparator<Double> fpn = new FloatingPointNumber();
		fpn.value = value;
		return fpn;
	}
	
	
	@Override
	public void applyChanges(RelaxedComparator<?> item) {
		if(item.getValue() instanceof Double i) {
			this.value += i;
		} else {
			throw new IllegalArgumentException("value field must be of type `Ingeter`");
		}
	}


	@Override
	protected int compareInternal(Double t) {
		if(value.equals(t)) {
			return 0;
		} else if(value > t) {
			return 1;
		} else {
			return -1;
		}
	}
}
