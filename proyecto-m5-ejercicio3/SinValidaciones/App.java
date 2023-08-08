// Módulo 5 - Ejercicio 3

import java.util.Scanner; // Importamos clase Scanner

public class App { // Creamos la clase App
	
	public static void main(String[] args) { // Creamos el método main
		
		// Declaramos las variables y los objetos que vamos a necesitar ("aleatorio", "eleccion"
		// y "entrada"):
		
		byte aleatorio, eleccion; // Variables de tipo "byte"
		
		Scanner entrada = new Scanner(System.in); // Creamos un objeto de tipo "Scanner" y lo
												  // almacenamos dentro de una variable de 
												  // tipo "Scanner" llamada "entrada"

		// Generamos un número aleatorio, lo "casteamos" a tipo "byte" y lo almacenamos en la 
		// variable "aleatorio", que es de tipo "byte", creada anteriormente:
		
		aleatorio = (byte)Math.ceil((Math.random() * 10)); // Este será el número a adivinar

		// Mediante un bucle "do while":
		// -> primero, ejecutamos UNA vez el código que hay dentro del "do":
		//		- imprimir mensaje con instrucciones para el usuario en pantalla y
		//		- almacenar dentro de la variable "eleccion" el valor introducido por el usuario en consola
		// -> después, evaluamos una condición (si número almacenado en la variable "eleccion" es
		//	  diferente del número almacenado en la variable "aleatorio"),
		// -> MIENTRAS la condición que se evalúa dentro del "while" sea "true", el programa
		//	  volverá al "do" y ejecutará de nuevo el código que hay dentro y después volverá a
		//	  evaluar la condición que hay dentro del "while".
		// -> en el momento en que la condición que se evalúa dentro del "while" sea "false", el
		//	  programa ya no volverá al "do", sino que ejecuratá la siguiente instrucción que hay
		//	  después del "while".
		
		do {
			
			System.out.println("Escribe un número entre el 1 y el 10:");
			eleccion=entrada.nextByte();
			
		} while (eleccion!=aleatorio);

		// El programa ha salido del bucle, porque el número elegido por el usuario es el número
		// aleatorio.
		
		// Imprimimos mensaje en pantalla:
		System.out.println("Enhorabuena, el número era el " + aleatorio);
		
		// Cerramos el objeto Scanner:
		entrada.close();
		
	} // Fin del método main

} // Fin de la clase App
