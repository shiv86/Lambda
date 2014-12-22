package example.java.lambda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class JavaUtilFunction {

	static List<LocalDate> alldates = Arrays.asList(LocalDate.now()
			.minusDays(1), LocalDate.now(), LocalDate.now().plusDays(1));

	static List<LocalDate> futureDates = new ArrayList<>();

	public static void main(String... args) {
		/*
		 * java.util.function: Contains a list of function interface which might
		 * be of use.
		 * 
		 * Some of the most common ones are:
		 * Consumer,Supplier,Predicate,Function
		 */
		supplierInterface();
		predicateInterface();
		functionInterface();
	}

	private static void functionInterface() {
		System.out
				.println("functionInterface() Example. Function takes an argument of Type T and returns result of type R");

		Function<Integer, LocalDate> addDays = x -> LocalDate.now().plusDays(x);
		LocalDate tomorrow = addDays.apply(1);

		System.out.println("tomorrow:"
				+ tomorrow.format(DateTimeFormatter.BASIC_ISO_DATE));

	}

	private static void predicateInterface() {
		System.out
				.println("predicateInterface() Example. Function takes an argument of Type T and returns boolean");

		System.out.println("All dates in the system:");
		alldates.forEach(x -> {
			System.out.println(x.format(DateTimeFormatter.BASIC_ISO_DATE));
		});

		futureDates = alldates.stream().filter(datesInTheFuture())
				.collect(Collectors.toList());

		System.out.println("All future dates:");
		futureDates.forEach(x -> {
			System.out.println(x.format(DateTimeFormatter.BASIC_ISO_DATE));
		});

		System.out.println("");
	}

	private static Predicate<LocalDate> datesInTheFuture() {
		return p -> p.isAfter(LocalDate.now());
	}

	private static void supplierInterface() {
		System.out
				.println("supplierInterface() Example. Functional interface takes no argument returns T");
		Supplier<LocalDate> dateSupplier = LocalDate::now;
		LocalDate today = dateSupplier.get();
		System.out
				.println("Supplier functional interface refers to a static method `now` to supply LocalDate : "
						+ today.format(DateTimeFormatter.BASIC_ISO_DATE) + '\n');
	}
}
