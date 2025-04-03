package non_generic;

public class Holder {
	// state - should be able to hold/wrap ANY data type in java
	private Object reference;

	public Holder(Object reference) {
		super();
		this.reference = reference;
	}

	public Object getReference() {
		return reference;
	}
	
}
