package com.pasqualehorse.gioco.muorimale.types;

public abstract class RelaxedComparator<T>{

	protected T value;
	
	public T getValue() {
		return value;
	}
	
	public int compare(RelaxedComparator<?> relaxedComparator) {
		if(relaxedComparator == this) {
			return 0;
		} else if(relaxedComparator == null) {
			throw new IllegalArgumentException("Cannot compare null value");
		} else if(!relaxedComparator.getClass().equals(this.getClass())) {
			throw new IllegalArgumentException("Cannot compare instances of differnt types");
		} else {
			T t = (T) relaxedComparator;
			return compareInternal(t);
		}
		
	}

	public abstract void applyChanges(RelaxedComparator<?> item);
	
	protected abstract int compareInternal(T t);
	
}
