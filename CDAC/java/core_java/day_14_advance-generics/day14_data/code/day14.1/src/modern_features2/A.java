package modern_features2;

public interface A {
	default void show() {
		System.out.println("in A's show");
	}
}
