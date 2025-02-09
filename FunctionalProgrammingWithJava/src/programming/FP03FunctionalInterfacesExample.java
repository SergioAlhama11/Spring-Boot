package programming;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FP03FunctionalInterfacesExample {

	public static void main(String[] args) throws Exception {
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Predicate: Para filtrar números pares
        Predicate<Integer> isEvenPredicate = n -> n % 2 == 0;

        // Function: Para elevar al cuadrado cada número
        Function<Integer, Integer> squareFunction = n -> n * n;

        // Consumer: Para imprimir cada número
        Consumer<Integer> sysoutConsumer = System.out::println;

        // Supplier: Para obtener una lista de números
        Supplier<List<Integer>> numberSupplier = () -> numbers;

        // UnaryOperator: Para sumar 1 a cada número (operación unaria)
        UnaryOperator<Integer> incrementOperator = n -> n + 1;

        // BinaryOperator: Para sumar dos números (operación binaria)
        BinaryOperator<Integer> sumOperator = (a, b) -> a + b;

        // Callable: Para devolver el primer número de la lista
        Callable<Integer> firstNumberCallable = () -> numbers.get(0);

        // Runnable: Una tarea que imprime un mensaje (sin parámetros ni retorno)
        Runnable messageRunnable = () -> System.out.println("Processing numbers...");

        // Uso de Runnable
        messageRunnable.run();

        // Uso de Supplier para obtener la lista de números
        List<Integer> suppliedNumbers = numberSupplier.get();

        // Procesamiento de la lista usando Predicate, Function y Consumer
        suppliedNumbers.stream()
            .filter(isEvenPredicate)               // Filtrar números pares
            .map(squareFunction)                   // Elevar al cuadrado
            .forEach(sysoutConsumer);              // Imprimir

        // Uso de UnaryOperator para incrementar cada número e imprimir
        suppliedNumbers.stream()
            .map(incrementOperator)                // Incrementar cada número
            .forEach(sysoutConsumer);              // Imprimir

        // Uso de BinaryOperator para sumar los números
        int sum = suppliedNumbers.stream()
            .reduce(0, sumOperator);               // Sumar todos los números
        System.out.println("Sum of numbers: " + sum);

        // Uso de Callable para obtener el primer número
        System.out.println("First number: " + firstNumberCallable.call());

	}

}
