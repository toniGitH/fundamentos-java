// Módulo 3 - Ejercicio 1

import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
		
		// Creamos un objeto de tipo Scanner y lo almacenamos en la variable "entrada":
		Scanner entrada = new Scanner(System.in);
		
		// Petición y guardado del nombre:
		System.out.println("Escribe tu nombre, por favor:");
		String nombreUsuario = entrada.nextLine();
		
		// Petición y guardado del apellido:
		System.out.println("Escribe tu apellido, por favor:");
		String apellidoUsuario = entrada.nextLine();
		
		// Petición y guardado de la edad:
		System.out.println("Introduce tu edad, por favor:");
		int edadUsuario = entrada.nextInt();
		
		// Salida de datos por consola:
		System.out.println("Tu nombre es " + nombreUsuario + " " + apellidoUsuario +
							" y tienes " + edadUsuario + " años.");
		
		// Cierre del objeto Scanner:
		entrada.close();
	}

}
