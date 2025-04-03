package generics;

public class Holder<T> {
	// state - should be able to hold/wrap ANY data type in java
	private T reference;

	public Holder(T reference) {
		super();
		this.reference = reference;
	}

	public T getReference() {
		return reference;
	}
	
}
