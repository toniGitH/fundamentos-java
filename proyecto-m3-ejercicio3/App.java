// Módulo 3 - Ejercicio 3

import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		// Creamos un objeto de tipo Scanner y lo almacenamos en la variable "entrada":
		Scanner entrada = new Scanner(System.in);
		
		// Petición y guardado de las 3 notas:
		System.out.println("Introduce la primera nota (número entero), por favor:");
		int nota1 = entrada.nextInt();
		System.out.println("Introduce la segunda nota(número entero), por favor:");
		int nota2 = entrada.nextInt();
		System.out.println("Introduce la tercera nota (número entero), por favor:");
		int nota3 = entrada.nextInt();
		
		// Salida de datos por consola:
		System.out.println("Tu nota media es un " + ( ((double)nota1) + ((double)nota2) + ((double)nota3) ) / 3);
		
		// Cierre del objeto Scanner:
		entrada.close();
	}

}
