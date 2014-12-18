package example.java.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ExampleFunctionalInterfaceImplementation {

	/*
	 * Lambda Definition: 1. Define anonymous functions 2. Can be assigned to
	 * variables which are of type functional interface 3. Can be passed to
	 * functions e.g. for each accepts the Consumer Functional Interface 4. Can
	 * be returned to function
	 */

	static List<String> alphabet = Arrays.asList("A", "B", "C", "D", "E");

	public static void main(String... args) {
		customFunctionalInterface();
		consumerFunctionalInterface();
		useCustomDefaultMethod();
	}

	private static void consumerFunctionalInterface() {
		/*
		 * Note in this case you can directly send the consumer Object to the
		 * forEach because it is of type Consumer<T>.
		 * 
		 * In the customFunctionalInterface we send a lambda expression (which
		 * is of type Consumer) with a reference to the
		 * ExampleFunctionalInterface.
		 * 
		 * The type of a lambda expression is the same as the functional
		 * interface that the lambda expression in assigned to.
		 */
		System.out.println("consumerFunctionalInterface");

		// Assigning a Lambda to a local variable, where the type of the Lambda
		// expression must be the same as the functional interface that the
		// lambda expression is assigned to.
		Consumer<String> consumer = x -> System.out.println(x);
		alphabet.forEach(consumer);
	}

	private static void customFunctionalInterface() {
		/*
		 * Remember forEach accepts a function as an input and calls the
		 * function for each value in the Collection.
		 */
		System.out.println("customFunctionalInterface");
		ExampleFunctionalInterface<String> example = x -> System.out.println(x);
		alphabet.forEach(x -> example.process(x));
	}

	/*
	 * Natural place for lambdas to be used was the Java collections Framework:
	 * Iterable,Collection,Map,List,Set ..etc.
	 * 
	 * However if forEach method signature was defined at the Iterable interface
	 * it will mean that all existing implementations of Iterable will break.
	 * 
	 * How can published interfaces be evolved without breaking the existing
	 * implementations ? By using a default method on java interface that has an
	 * implementation provided in the interface and is inherited by classes that
	 * implement the interface.
	 * 
	 * It can be overrriden, if two interfaces have the same method signature
	 * and name there will be a compile time error, in an inheritance hierarchy
	 * with default methods the most specific default method wins
	 */
	private static void useCustomDefaultMethod() {
		System.out.println("useCustomDefaultMethod");
		ExampleFunctionalInterface<String> example = x -> System.out
				.println("Lambda" + x);
		alphabet.forEach(x -> example.print(x));
	}

}
