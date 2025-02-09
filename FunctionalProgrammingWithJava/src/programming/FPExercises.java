package programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FPExercises {
	
	public static void main(String[] args) {

		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
		
		
		// Exercise 1 - Print Only Odd Numbers from the List.
		System.out.println(" - Ejercicio 1 - ");
		numbers.stream().filter(number -> number % 2 == 1).forEach(System.out::println);
		
		// Exercise 2 - Print All Courses injdividually.
		System.out.println(" - Ejercicio 2 - ");
		courses.stream().forEach(System.out::println);
		
		// Exercise 3 - Print Courses Containing the word "Spring"
		System.out.println(" - Ejercicio 3 - ");
		courses.stream().filter(course -> course.contains("Spring")).forEach(System.out::println);
		
		// Exercise 4 - Print Courses Whose Name has at least 4 letters.
		System.out.println(" - Ejercicio 4 - ");
		courses.stream().filter(course -> course.length() >= 4).forEach(System.out::println);
		
		// Exercise 5 - Print the cubes of the odd numbers
		System.out.println(" - Ejercicio 5 - ");
		numbers.stream().filter(number -> number % 2 == 1).map(number -> number * number * number).forEach(System.out::println);
		
		// Exercise 6 - Print the number of characters in each course name
		System.out.println(" - Ejercicio 6 - ");
		courses.stream().map(course -> course + " -> " + course.length()).forEach(System.out::println);
		
//		Predicate<Integer> isMoreThan10 = number -> number > 10;
//		Predicate<Integer> isMoreOrEqualThan15 = number -> number >= 15;
//		Boolean resultado = numbers.stream().filter(isMoreThan10).anyMatch(isMoreOrEqualThan15);
//		System.out.println(resultado);
		
		// Exercise 7 - Square every number in a list and find the sum of squares
		System.out.println(" - Ejercicio 7 - ");
		System.out.println(numbers.stream().map(number -> number * number).reduce(0, (x, y) -> x + y));
		
		// Exercise 8 - Cube every number in a list and find the sum of cubes
		System.out.println(" - Ejercicio 8 - ");
		System.out.println(numbers.stream().map(number -> number * number * number).reduce(0, (x, y) -> x + y));
		
		// Exercise 9 - Find Sum of Odd Numbers in a list
		System.out.println(" - Ejercicio 9 - ");
		System.out.println(numbers.stream().filter(number -> number % 2 == 1).reduce(0, Integer::sum));
		
		// Exercise 10 - Create a List with Even Numbers Filtered from the Numbers List
		
		// Exercise 11 - Create a List with lengths of all course titles
		
	
		System.out.println(" - Ejemplo usando -> .distinct() - ");
		numbers.stream().distinct().forEach(System.out::println);
		
		System.out.println(" - Ejemplo usando -> .sorted(Comparator.naturalOrder()) - ");
		courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
		
		System.out.println(" - Ejemplo usando -> .sorted(Comparator.reverseOrder()) - ");
		courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
		System.out.println(" - Ejemplo usando -> .sorted(Comparator.comparing(str -> str.length())) - ");
		courses.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);
		
		System.out.println(" - Ejemplo usando -> .distinct.sorted() - ");
		numbers.stream().distinct().sorted().forEach(System.out::println);
		
		/* Exercise 12 - Find Functional Interface behind the second argument of reduce method. Create an implementation for the Funtional Interface.
		 * int sum = numbers.stream().reduce(0, sumBinaryOperator);
		 */
		
		BinaryOperator<Integer> sumBinaryOperator = Integer::sum;		
		BinaryOperator<Integer> sumBinaryOperator2 = new BinaryOperator<Integer>() {
			
			@Override
			public Integer apply(Integer t, Integer u) {
				return t + u;
			}
		};
		
		/* Exercise 13 - Do Behaviour Parameterization for the mapping logic.
		 * List squaredNumbers = numbers.stream().map(x -> x * x).collect(Collectors.toList());
		 */
		
		Function<Integer, Integer> mappingFunction = x -> x * x;
		
		mapAndCreateNewList(numbers, mappingFunction);
		
	}
	
	private static List<Integer> mapAndCreateNewList(List<Integer> numbers, Function<Integer, Integer> mappingFunction) {
		return numbers.stream().map(mappingFunction).collect(Collectors.toList());
	}
}
