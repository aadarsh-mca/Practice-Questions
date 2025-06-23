package modern_features2;

public interface B {
	default void show() {
		System.out.println("in B's show");
	}
}
