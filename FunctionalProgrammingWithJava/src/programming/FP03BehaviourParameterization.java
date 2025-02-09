package programming;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FP03BehaviourParameterization {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
		
		//filterAndPrint(numbers, x -> x % 2 == 0); // Pinta numeros pares
		//filterAndPrint(numbers, x -> x % 2 == 1); // Pinta numeros impares
		filterAndPrint(numbers, x -> x % 3 == 0); // Pinta los multiplos de 3
		
		
		Function<Integer, Integer> squaredFunction = x -> x * x;
		Function<Integer, Integer> cubedFunction = x -> x * x * x;
		Function<Integer, Integer> doubledFunction = x -> 2 * x ;
		
		List<Integer> listaCuadrados = mapAndCreateList(numbers, squaredFunction); // Crea una lista elevando al cuadrado los elementos de la lista inicial
		List<Integer> listaCubos = mapAndCreateList(numbers, cubedFunction); // Crea una lista elevando al cubo los elementos de la lista inicial
		List<Integer> listaDobles = mapAndCreateList(numbers, doubledFunction); // Crea una lista duplicando los elementos de la lista inicial
		
		System.out.println(listaCuadrados);
		System.out.println(listaCubos);
		System.out.println(listaDobles);
	}

	private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate) {
		numbers.stream().filter(predicate).forEach(System.out::println);
	}
	
	private static List<Integer> mapAndCreateList(List<Integer> numbers, Function<Integer, Integer> mappingFunction) {
		return numbers.stream().map(mappingFunction).collect(Collectors.toList());
	}

}
