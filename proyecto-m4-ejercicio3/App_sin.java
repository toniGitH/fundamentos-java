// Módulo 4 - Ejercicio 3
// Sin utilizar métodos de comparación de Strings

import java.util.Scanner; // Importamos la clase Scanner del paquete java.util

public class App_sin {

	public static void main(String[] args) {
		
		// Creamos un objeto de tipo Scanner y lo almacenamos en una variable de tipo Scanner llamada "entrada":
		Scanner entrada = new Scanner(System.in);
		
		// Imprimimos en consola mensaje informativo en pantalla para el usuario para preguntar la edad:
		System.out.println("¿Cuántos años tienes?");
		// Capturamos el dato introducido en consola por el usuario y lo almacenamos en la variable de tipo
		// int llamada "edadUsuario":
		int edadUsuario=entrada.nextInt();
		
		// Limpieza de buffer:
		entrada.nextLine();
		
		// Imprimimos en consola mensaje informativo en pantalla para el usuario para preguntar datos universitarios:
		System.out.println("¿Tienes algún título universitario (s/n)?");
		// Declaramos una variable de tipo "char" para capturar una "s" o una "n", pero como no existe el método
		// .nextChar(), debemos utilizar el método ".nextLine()", que devuelve un dato de tipo "String", y sobre ese
		// dato, aplicamos el método ".charAt(índice)", que sí devuelve un dato de tipo "char":
		char tituloUni = entrada.nextLine().charAt(0);
		
		
		// Imprimimos en consola mensaje informativo en pantalla para el usuario para preguntar datos de paro:
		System.out.println("¿Estás en el paro (s/n)?");
		// Para capturar el dato y guerdarlo en una variable de tipo "char", hacemos igual que en el caso del
		// título universitario:
		char paro = entrada.nextLine().charAt(0);
		
		// Condicional if/else para imprimir uno u otro mensaje en consola en función de las condiciones
		// requeridas en el enunciado:
		if ( (edadUsuario>=18 && (tituloUni=='s' || tituloUni=='S') ) || (paro=='s' || paro=='S') ) {
			System.out.println("Tienes derecho recibir a una beca");
		} else {
			System.out.println("No tienes derecho a recibir una beca");
		}
		
		// Cierre del objeto Scanner:
		entrada.close();
		
	} // Fin método main

} // Fin App_sin
