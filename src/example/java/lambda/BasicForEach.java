package example.java.lambda;

import java.util.Arrays;
import java.util.List;

public class BasicForEach {

	static List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

	public static void main(String[] args) {
		/*-
		 * This lambda is function defines an anonymous function with one
		 * parameter named x of type integer.
		 * 
		 * Note: There are two parts to an anonymous function: 
		 * 1. The signature defined in a functional interface (@FunctionalInterface)
		 * 2. The method body is defined in the lambda expression.
		 * 
		 * The forEach is a method that accepts a function as its input and
		 * calls the function for each value in the list.
		 * 
		 * Think of lambda expression as having two stage lifecycle:
		 * 1. Convert the lambda expression to a function
		 * 2. Call the generated function:
		 * 
		 * 	x-> System.out.print(x)
		 * 
		 *  public static generatedNameOfLambdaFunction(Integer x){
		 *  	System.out.println(x)
		 *  }
		 * 
		 * Note: It is not always generated into a static method.
		 */
		basicForEach();
		multiLineLamda();
		lambdaWithLocalVariable();
		specifyLambdaParameterTypes();
	}

	private static void specifyLambdaParameterTypes() {
		/*
		 * Note the type is automatically inferred from the Collection type
		 * specified.
		 */
		System.out.println("specifyLambdaParameterTypes");
		integers.forEach((Integer x) -> {
			int y = x + 2;
			System.out.println(y);
		});
	}

	private static void multiLineLamda() {
		System.out.println("multiLineLamda");
		integers.forEach(x -> {
			x = x + 10;
			System.out.println(x);
		});
	}

	private static void basicForEach() {
		System.out.println("basicForEach");
		integers.forEach(x -> System.out.println(x));
	}

	private static void lambdaWithLocalVariable() {
		System.out.println("lambdaWithLocalVariable");
		integers.forEach(x -> {
			int y = x * 2;
			System.out.println(y);
		});
	}

}
