package example.java.lambda;

@FunctionalInterface
public interface ExampleFunctionalInterface<T> {
	/*
	 * A functional interface is regular java interface with only one non
	 * default method.
	 * 
	 * The @FunctionalInterface annotation applies static checking.
	 */
	void process(T t);
	
	default void print(T t){
		System.out.println("Default: " + t);
	}
}
