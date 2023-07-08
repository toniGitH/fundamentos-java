// Módulo 3 - Ejercicio Extra 1

import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		// Creamos un objeto de tipo Scanner:
		Scanner entrada = new Scanner(System.in);
		
		// Petición y guardado del número introducido:
		System.out.println("Introduce un número entero, por favor:");
		int numero = entrada.nextInt();
		
		// Salida de resultados por consola:
		System.out.println("Has escrito el número " + numero);
		System.out.println("El doble del número " + numero + " es " + 2*numero);
		System.out.println("El triple del número " + numero + " es " + 3*numero);

		// Cierre del objeto Scanner:
		entrada.close();
	}

}
