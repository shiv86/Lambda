package example.java.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*
 * Variable capture:
 * >Lambda can interact with variables defined outside the body of the lambda.
 * >Using variable outside the body of the lambda expression is called variable capture.
 */
public class VariableCaptureExample {

	private static List<Integer> integers = Arrays.asList(1, 2, 3, 4);
	static int staticvar = 20;
	private int classvar = 30;
	private static VariableCaptureExample INSTANCE = new VariableCaptureExample();

	public static void main(String... args) {
		localVariableCapture();
		localVariableCaptureEffectivelyFinal();
		staticAndClassVariableCapture();
		thisKeywordLamba();
		thisKeywordAnonymousInnerClass();
	}

	private static void thisKeywordAnonymousInnerClass() {
		System.out
				.println("thisKeywordAnonymousInnerClass -> showThisAnonymousInnerClass");
		INSTANCE.showThisAnonymousInnerClass();
	}

	private void showThisAnonymousInnerClass() {
		integers.forEach(new Consumer<Integer>() {
			@Override
			public void accept(Integer x) {
				//have to use VariableCaptureExample.this.classvar to access the classvar instead of this.classvar
				System.out.println(x + VariableCaptureExample.this.classvar);
				if (!this.equals(INSTANCE)) {
					System.out
							.println("Anonymous class `this` refers to the instance of the AnonymousInnerClass and not the enclosing context, unlike the lambda");
				}
			}
		});
	}

	private static void thisKeywordLamba() {
		System.out.println("thisKeywordLamba-->showThisLambdaVariable");
		INSTANCE.showThisLambdaVariable();
	}

	/* "With in lambda body `this` refers to this of the enclosing object" */
	private void showThisLambdaVariable() {
		integers.forEach(x -> {
			System.out.println(x + this.classvar);
			if (this == INSTANCE) {
				System.out
						.println("With in lambda body `this` refers to this of the enclosing object");
			}
		});
	}

	private static void staticAndClassVariableCapture() {
		System.out
				.println("staticVariableCapture --> showClassVariableCapture");
		integers.forEach(x -> {
			System.out.println(x + staticvar);
		});
		new VariableCaptureExample().showClassVariableCapture();
	}

	private void showClassVariableCapture() {
		System.out.println("classVariableCapture");
		integers.forEach(x -> {
			System.out.println(x + classvar);
		});
	}

	private static void localVariableCaptureEffectivelyFinal() {
		System.out.println("localVariableCaptureEffectivelyFinal");
		int var = 10;
		integers.forEach(x -> {
			// var++;
			/*
			 * <- Not Allowed local variables used inside the body of a lambda
			 * must be declared final or the compiler must be able to tell that
			 * they are effectively final because their values are note modifed
			 * elsewhere
			 */
			System.out.println(x + var);
		});
	}

	private static void localVariableCapture() {
		System.out.println("localVariableCapture");
		int var = 10;
		integers.forEach(x -> System.out.println(x + var));
	}

}
