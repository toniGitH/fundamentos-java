// Módulo 3 - Ejercicio Extra 2

import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		// Creamos un objeto de tipo Scanner:
		Scanner entrada = new Scanner(System.in);
		
		// Petición y guardado del número escrito por el usuario:
		System.out.println("Escribe un número entero.");
		int varint = entrada.nextInt();
		
		// Condicional (ternario) para asignar el valor definitivo a la variable
		// "varint" según las condiciones del enunciado:
		varint = (varint<10)?varint:1;
		
		// Impresión en pantalla de información para el usuario:
		System.out.println("Vamos a trabajar con el número " + varint);
		System.out.println();
		System.out.println("Esta es la tabla de multiplicar del " + varint);
		System.out.println();
		
		// Bucle for para calcular e imprimir la tabla de multiplicar del número
		// asignado a la variable "varint":
		for (int i=1; i<11; i++) {
			System.out.println(varint + "x" + i + "=" + varint*i);			
		}
		
		// Cierre del objeto Scanner:
		entrada.close();
	}

}
