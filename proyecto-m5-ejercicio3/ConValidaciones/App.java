// Módulo 5 - Ejercicio 3 (Con validaciones)

import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
		
		// Declaramos las variables y los objetos que vamos a necesitar:
		
		byte aleatorio, eleccion;
		
		Scanner entrada = new Scanner(System.in); // Creamos un objeto de tipo "Scanner" y lo
		  										  // almacenamos dentro de una variable de 
		  										  // tipo "Scanner" llamada "entrada"
		
		// Generamos un número aleatorio y lo almacenamos en la variable "aleatorio":
		
		aleatorio = (byte)Math.ceil((Math.random() * 10)); // Este será el número a adivinar
 		
		// Mediante un bucle "doWhile", ejecutamos UNA vez el código que hay dentro del "do", y
		// MIENTRAS se cumpla la condición que se evalúa dentro del "While", dicho código se
		// seguirá ejecutando.
		
		System.out.println("¡¡ADIVINA EL NÚMERO!!");
		//System.out.println("Control: " + aleatorio);
		System.out.println("Escribe un número entre el 1 y el 10");
		eleccion=entrada.nextByte();
		
		while ((eleccion<1 || eleccion>10) || (eleccion!=aleatorio)) {
			if (eleccion<1 || eleccion>10) {
				System.out.println("El número " + eleccion + " no está entre el 1 y el 10. Inténtalo de nuevo");
				eleccion=entrada.nextByte();
			} else {
				System.out.println("¡¡Has fallado!! Vuelve a probar.");
				System.out.println("Escribe otro número entre el 1 y el 10:");
				eleccion=entrada.nextByte();
			}
		}
		
		System.out.println("Enhorabuena, el número era el " + aleatorio);
		
		entrada.close();
		
	} // Fin del método main

} // Fin de la clase App
