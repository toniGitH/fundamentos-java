// Módulo 4 - Ejercicio 1

import java.util.Scanner; // Importamos la clase Scanner del paquete java.util

public class App {

	public static void main(String[] args) {

		// Creamos un objeto de tipo Scanner y lo almacenamos en una variable de tipo Scanner llamada "entrada":
		Scanner entrada = new Scanner(System.in);
				
		// Imprimimos en consola mensaje informativo en pantalla para el usuario para preguntar el nombre:
		System.out.println("Escribe tu nombre, por favor:");
		// Capturamos el dato introducido en consola por el usuario y lo almacenamos en la variable de tipo
		// String llamada "nombreUsuario":
		String nombreUsuario = entrada.nextLine();
		
		// Imprimimos en consola mensaje informativo en pantalla para el usuario para preguntar el apellido:
		System.out.println("Escribe tu apellido, por favor:");
		// Capturamos el dato introducido en consola por el usuario y lo almacenamos en la variable de tipo
		// String llamada "apellidoUsuario":
		String apellidoUsuario = entrada.nextLine();
				
		// Imprimimos en consola mensaje informativo en pantalla para el usuario para preguntar la edad:
		System.out.println("Introduce tu edad, por favor:");
		// Capturamos el dato introducido en consola por el usuario y lo almacenamos en la variable de tipo
		// int llamada "edadUsuario":
		int edadUsuario = entrada.nextInt();
		
		// Fuera de los bloques if/else declaramos una variable de tipo String a la que llamamos "mayorMenor" y
		// que vamos a necesitar más adelante:
		String mayorMenor;

		// Condicional if/else para asignar un valor a la variable de tipo String llamada "mayorMenor".
		// Ese valor se va a determinar dentro del if/else y estará en función del valor almacenado anteriormente
		// en la variable "edadUsuario":
		if (edadUsuario<18) {
			mayorMenor = "MENOR";
		} else {
			mayorMenor = "MAYOR"; 
		}
			
		// Imprimimos en consola los resultados finales:
		System.out.println("Tu nombre es " + nombreUsuario + " " + apellidoUsuario + 
						   " y eres " + mayorMenor + " de edad.");
				
		// Cierre del objeto Scanner:
		entrada.close();
	}

}
