// Módulo 4 - Ejercicio 2

import java.util.Scanner; // Importamos la clase Scanner del paquete java.util

public class App {

	public static void main(String[] args) {
		
		// Creamos un objeto de tipo Scanner y lo almacenamos en una variable de tipo Scanner llamada "entrada":
		Scanner entrada = new Scanner(System.in);
						
		// Imprimimos en consola mensaje informativo en pantalla para el usuario para preguntar la edad:
		System.out.println("Escribe tu edad, por favor:");
		// Capturamos el dato introducido en consola por el usuario y lo almacenamos en la variable de tipo
		// int llamada "edadUsuario":
		int edadUsuario = entrada.nextInt();
		
		// Fuera de los bloques if/else declaramos una variable de tipo String a la que llamamos "estudios" y 
		// que vamos a necesitar más adelante:
		String estudios;
		
		// Condicional if/else para asignar un valor a la variable de tipo String llamada "estudios".
		// Ese valor se va a determinar dentro del if/else y estará en función del valor almacenado anteriormente
		// en la variable "edadUsuario":
		if (edadUsuario<0) {
			System.out.println("La edad que has escrito no es correcta");
			System.out.println("Fin de programa: NOK");
		} else {
			if (edadUsuario<=5) {
				estudios="preescolar";
			} else if (edadUsuario<=11) {
				estudios="primaria";
			} else if (edadUsuario<=15) {
				estudios="ESO";
			} else if (edadUsuario<=17) {
				estudios="Bachillerato";
			} else {
				estudios="FP o Universidad";
			}
			
			// Imprimimos en consola los resultados finales:
			System.out.println("Tu edad es " + edadUsuario + " años y te corresponden estudios de " + estudios);
			System.out.println("Fin de programa: OK");			
		} // Fin else/if
				
		// Cierre del objeto Scanner:
		entrada.close();

	}

}
