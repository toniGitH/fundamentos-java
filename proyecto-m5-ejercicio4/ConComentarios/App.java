// Módulo 5 - Ejercicio 4

import java.util.Scanner; // Importamos la clase Scanner

public class App { // Creamos la clase App
	
	public static void main (String[] args) { // Creamos el método main
		
		// Declaramos las variables y objetos que vamos a necesitar:
		
		byte aleatorio, eleccion; // Variables para almacenar el número aleatorio y el número
								  // tecleado por el usuario en consola.
		byte intentos = 5; // Variable que usaremos como contador de intentos. La inicializamos
						   // ya en 5 porque son los intentos que marca el ejercicio.
		
		Scanner entrada = new Scanner(System.in); // Creamos un objeto de tipo "Scanner" y lo
		  										  // almacenamos dentro de una variable de 
		  										  // tipo "Scanner" llamada "entrada"
		
		// Generamos un número aleatorio, lo "casteamos" a "byte" y lo almacenamos en la 
		// de tipo "byte" llamada "aleatorio":
		
		aleatorio = (byte)Math.ceil((Math.random() * 10)); // Este será el número a adivinar
		System.out.println(aleatorio);
		// Mediante un bucle "do while":
		// -> primero, ejecutamos UNA vez el código que hay dentro del "do":
		//		- imprimir mensaje con instrucciones para el usuario en pantalla,
		//		- almacenar dentro de la variable "eleccion" el valor introducido por el usuario en consola
		//		- decrementar en una unidad el valor almacenado en la variable "intentos", porque en este
		//		  momento del programa, el usuario ya ha escrito un número y, por tanto, ya ha "gastado" un
		//		  intento.
		// -> después, evaluamos una DOBLE condición: que el número almacenado en la variable "eleccion"
		//	  sea diferente del número almacenado en la variable "aleatorio" y además que el valor de la 
		//	  variable "intentos" sea mayor que "0" (es decir, que al usuario aún le queden intentos)
		// -> MIENTRAS esa DOBLE condición que se evalúa dentro del "while" sea "true", el programa
		//	  volverá al "do" y ejecutará de nuevo el código que hay dentro y después volverá a
		//	  evaluar la condición que hay dentro del "while".
		// -> en el momento en que la condición que se evalúa dentro del "while" sea "false", el
		//	  programa ya no volverá al "do", sino que ejecuratá la siguiente instrucción que hay
		//	  después del "while". Esta evaluación SÓLO devolverá "false" cuando:
		//		- el usuario haya agotado sus intentos sin haber acertado o
		//		- el usuario haya acertado antes de agotarse sus intentos
		
		do {
			System.out.println("Escribe un número entre el 1 y el 10:");
			System.out.println("Tienes " + intentos + " intentos.");
			eleccion = entrada.nextByte();
			intentos--;
		} while ( (eleccion != aleatorio) && (intentos>0) );
		
		// Cuando el programa sale del bucle, mediante un condicional if/else validamos si el
		// usuario ha acertado o no:
		
		if (eleccion==aleatorio) { // Si ha acertado, lo imprime en pantalla:

			System.out.println("¡¡Enhorabuena!! El número es el " + aleatorio + 
							   " y has necesitado " + (5-intentos) + " intentos para acertarlo.");	
		} 
		
		else { // Si no ha acertado, imprime el mensaje correspondiente:
			
			System.out.println("Se acabaron los intentos. ¡¡Has fallado!!");
		}
		entrada.close();
	} // Fin método main
} // Fin clase App
