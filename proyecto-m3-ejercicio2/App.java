// Módulo 3 - Ejercicio 2

import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
		
		// Creamos un objeto de tipo Scanner y lo almacenamos en la variable "entrada":
		Scanner entrada = new Scanner(System.in);
		
		// Petición y guardado del primer y segundo número:
		System.out.println("Introduce un número entero, por favor:");
		int num1 = entrada.nextInt();
		System.out.println("Introduce otro número entero, por favor:");
		int num2 = entrada.nextInt();
		
		// Salida de datos por consola:
		System.out.println("El resultado de la suma es " + (num1 + num2));
		System.out.println("El resultado de la resta es " + (num1 - num2));
		System.out.println("El resultado de la multiplicación es " + (num1 * num2));
		System.out.println("El resultado de la división es " + ((double)num1 / (double)num2));
		System.out.println("El resultado del módulo es " + (num1 % num2));

		// Cierre del objeto Scanner:
		entrada.close();
	}

	
	
}
