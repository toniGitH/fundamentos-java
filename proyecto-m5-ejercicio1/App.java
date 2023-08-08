// Módulo 5 - Ejercicio 1

import java.util.Scanner; // Importamos clase Scanner
import java.util.ArrayList; // Importamos clase ArrayList

public class App {

	public static void main(String[] args) { // Método main
		
		// Creamos un objeto de tipo ArrayList y lo almacenamos dentro de una variable de tipo ArrayList
		// llamado "palabras":
	    ArrayList<String> palabras = new ArrayList<String>();
	    // Creamos un objeto de tipo "Scanner" y lo almacenamos dentro de una variable de tipo 
	    // "Scanner" llamada "entrada":
		Scanner entrada = new Scanner(System.in);
		
		// Imprimimos en consola mensaje para el usuario, para informarle qué tiene que hacer:
		System.out.println("¿Cuántas palabras quieres escribir (escribe un número entero)?");
		
		// Declaramos una variable de tipo "int" llamada "numPalabras" en la que almacenamos la respuesta que ha
		// escrito el usuario en la consola, que capturamos con el método nextInt:
		int numPalabras = entrada.nextInt();
	
		// Declaramos una variable de tipo "String" llamada "palabra" que utilizaremos más adelante
		// dentro de un bucle para ir recogiendo las palabras escritas por el usuario.
		// MUY IMPORTANTE: NO SE DEBE DECLARAR UNA VARIABLE DENTRO DE UN BUCLE
		String palabra;
		
		entrada.nextLine(); // Limpieza de buffer, porque vamos a utilizar el método nextLine() justo después
							// de utilizar el método nextInt()
		
		// Construimos un bucle for, que va a repetir unas intrucciones tantas veces como número de palabras ha
		// dicho el usuario que quiere escribir, y ese número de palabras lo hemos almacenado en la variable
		// llamada "numPalabras":
		
		for (int i=1; i<=numPalabras; i++) { // Stmnt 1: declaramos una variable de tipo "int" llamada "i", que va
											 // a ser nuestro CONTADOR de iteraciones, y lo inicializamos en "1".
											 // Stmnt 2: la condición a evaluar en cada iteración, y que debe
											 // cumplirse para que el programa entre dentro del bucle es que el 
											 // valor de ese contador llamado "i" sea menor o igual que el valor
											 // almacenado dentro de la variable "numPalabras", que es el número 
											 // de palabras que el usuario ha dicho que va a escribir.
											 // Stmnt 3: después de cada vez que se haya ejecutado el código que
											 // hay en el interior del bucle for, se va a incrementar el valor de
											 // nuestro contador "i" en "1" unidad
			
			// Las líneas de código que el programa REPETIRÁ un total de "numPalabras" veces son estas:
			// En este bucle NO nos afecta cómo está construido el contador, porque no estamos usando la variable
			// "i" como índice en las líneas de código que hay dentro del bucle.
			
			System.out.println("Escribe la palabra"); // Imprimimos mensaje en consola para el usuario
			
			palabra = entrada.nextLine(); // Lo que el usuario escribe, lo capturamos con método nextLine y lo
												 // almacenamos en la variable de tipo "String" a la que hemos llamado "palabra"
			palabras.add(palabra); // Añadimos el valor almacenado en la variable "palabra" dentro del objeto de 
								   // tipo "ArrayList" llamado "palabra"
		} // Final bucle for
		
		// Imprimimos los resultados en consola
		
		// Una opción es imprimir directamente el "arrayList" llamado "palabras", tal cual:
		
		System.out.println("El array de palabras que has escrito es este:");
		System.out.println(palabras);
		
		// Otra opción es usar un bucle "for" para RECORRER elemento a elemento el "arrayList" llamado
		// "palabras":
		
		// Mensaje informativo en consola:
		System.out.println("Si recorremos el array de palabras con un bucle for obtenemos esto:");
		// Este bucle for va a repetir unas intrucciones tantas veces como número de palabras ha dicho el
		// usuario que quiere escribir, y ese número de palabras lo hemos almacenado en la variable llamada
		// "numPalabras":
		for (int i=0; i<numPalabras; i++) { // Stmnt 1: declaramos una variable de tipo "int" llamada "i", que va
											// a ser nuestro CONTADOR de iteraciones, y lo inicializamos en "0".
											// La inicializamos en "0" y no en "1" porque sé que voy a usar este
											// bucle para recorrer un arrayList y los índices de un arrayList
											// empiezan en "0" y no en "1".
			 								// Stmnt 2: la condición a evaluar en cada iteración, y que debe
			 								// cumplirse para que el programa entre dentro del bucle es que el 
			 								// valor de ese contador llamado "i" sea menor que el valor
			 								// almacenado dentro de la variable "numPalabras", que es el número 
			 								// de palabras que el usuario ha dicho que va a escribir.
			 								// Stmnt 3: después de cada vez que se haya ejecutado el código que
			 								// hay en el interior del bucle for, se va a incrementar el valor de
			 								// nuestro contador "i" en "1" unidad
			// La línea de código que el programa REPETIRÁ un total de "numPalabras" veces es esta:
			// En este bucle SÍ AFECTA cómo está construido el contador, porque ahora SÍ estamos usando la
			// variable contador "i" como índice en la línea de código que hay dentro del bucle:
			System.out.print(palabras.get(i)+" ");
		}
		
		// Cerramos el objeto Scanner
		entrada.close();
		
	}// Fin método main
} // Fin clase App
