// Módulo 5 - Ejercicio 4

import java.util.Scanner; // Importamos la clase Scanner

public class App { // Creamos la clase App
	
	public static void main (String[] args) { // Creamos el método main
		
		// Declaramos las variables y objetos que vamos a necesitar:
		
		byte aleatorio, eleccion; // Almacenan el nª aleatorio y el nº tecleado por el usuario.
		byte intentos = 5; // Contador de intentos. La inicializamos en 5 (intentos que tenemos)
		Scanner entrada = new Scanner(System.in); // Creación de objeto Scanner almacenado en "entrada"
		
		aleatorio = (byte)Math.ceil((Math.random() * 10)); // Generamos nº a adivinar
	
		// Bucle "do while" para REPETIR un código mientras que el usuario NO acierte:
		
		do {
			System.out.println("Tienes " + intentos + " intentos.");
			System.out.println("Escribe un número entre el 1 y el 10:");
			eleccion = entrada.nextByte();
			intentos--;
		} while ( (eleccion != aleatorio) && (intentos>0) );
		
		// Condicional: si ha salido del bucle por haber acertado o por haber agotado intentos:
		
		if (eleccion==aleatorio) { // Si ha acertado, lo imprime en pantalla:

			System.out.println("¡¡Enhorabuena!! El número es el " + aleatorio + " y has necesitado " + (5-intentos) + " intentos para acertarlo.");	
		} 
		
		else { // Si no ha acertado, imprime el mensaje correspondiente:
		
			System.out.println("Se acabaron los intentos. ¡¡Has fallado!!");
		}
		
		entrada.close();
		
	} // Fin método main
} // Fin clase App
