package programming;

import java.util.Optional;

public class OptionalExample {

	public static void main(String[] args) {
		String nombre = "Sergio";
		
		Optional<String> nombreOptional = Optional.ofNullable(nombre); // Transforma un objeto es un optional, si es NULL crea un Optinal.empty
		
		String nombreFinal = nombreOptional.orElse("Nombre por defecto");
		
		System.out.println(nombreOptional);
		System.out.println(nombreFinal);
		
		nombreOptional.ifPresent(name -> System.out.println("Nombre en mayusculas: " + name.toUpperCase())); // Si nombre NO es NULL entra aqui!!!
		
		nombreOptional.orElseThrow(() -> new IllegalArgumentException("El nombre no puede ser nulo")); // Si nombre es NULL entra aqui!!!
		
		System.out.println("Nombre final: " + nombreFinal);
	}
	

}
