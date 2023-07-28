// Módulo 4 - Ejercicio 3
// Utilizando el método de comparación de Strings ".equalsIgnoreCase()"

import java.util.Scanner; // Importamos la clase Scanner del paquete java.util

public class App_con {

	public static void main(String[] args) {
		
		// Creamos un objeto de tipo Scanner y lo almacenamos en una variable de tipo Scanner llamada "entrada":
		Scanner entrada = new Scanner(System.in);
		
		// Imprimimos en consola mensaje informativo en pantalla para el usuario para preguntar la edad:
		System.out.println("¿Cuántos años tienes?");
		
		// Capturamos el dato introducido en consola por el usuario y lo almacenamos en la variable de tipo
		// int llamada "edadUsuario":
		int edadUsuario=entrada.nextInt();
		
		// Limpiamos buffer después de pedir dato de tipo numérico porque ahora vamos a pedir dato de tipo String:
		entrada.nextLine();
		
		// Imprimimos en consola mensaje informativo en pantalla para el usuario para preguntar datos universitarios:
		System.out.println("¿Tienes algún título universitario (s/n)?");
		// Capturamos el dato introducido en consola por el usuario y lo almacenamos en la variable de tipo
		// String llamada "respuestaUni":
		String respuestaUni = entrada.nextLine();
		
		// Declaramos una variable de tipo boolean llamada "tituloUni" que necesitaremos más adelante, y le asignamos
		// el valor "false":
		boolean tituloUni = false;
		
		// Mediante un condicional if establecemos el valor de la variable booleana "tituloUni": si el usuario tiene título
		// universitario, la variable "tituloUni" tomará el valor de "true", y si no tiene título, tomará el valor "false".
		// Esta asignación se hará dentro del if/else siguiente, de forma que si el valor de la variable "respuestaUni",
		// capturado anteriormente es una "s" o una "S", el valor asignado a la variable "tituloUni" será "true", mientras
		// que para cualquier otro caso, mantendrá su valor inicial de "false":
		if (respuestaUni.equalsIgnoreCase("s")==true) {
			tituloUni=true;
		}
		
		// Imprimimos en consola mensaje informativo en pantalla para el usuario para preguntar datos de paro:
		System.out.println("¿Estás en el paro (s/n)?");
		
		// Capturamos el dato introducido en consola por el usuario y lo almacenamos en la variable de tipo
		// String llamada "respuestaParo":
		String respuestaParo = entrada.nextLine();
		
		// Declaramos una variable de tipo boolean llamada "paro" que necesitaremos más adelante, y le asignamos
		// el valor "false":
		boolean paro = false;
		
		// Mediante un condicional if establecemos el valor de la variable booleana "paro": si el usuario está en el paro,
		// la variable "paro" tomará el valor de "true", y si no está en el paro, tomará el valor "false".
		// Esta asignación se hará dentro del if/else siguiente, de forma que si el valor de la variable "respuestaParo",
		// capturado anteriormente es una "s" o una "S", el valor asignado a la variable "paro" será "true", mientras
		// que para cualquier otro caso, mantendrá su valor inicial de "false":
		if (respuestaParo.equalsIgnoreCase("s")==true) {
			paro=true;
		}
		
		// Mediante un último condicional, un if/else, en función de los valores que tengan las variables "edadUsuario",
		// "tituloUni" y "paro", imprimiremos una u otra respuesta en consola:
		if ( (edadUsuario>=18 && tituloUni==true) || (paro==true) ) {
			System.out.println("Tienes derecho recibir a una beca");
		} else {
			System.out.println("No tienes derecho a recibir una beca");
		}
		
		// Cierre del objeto Scanner:
		entrada.close();
		
	} // Fin metodo main

} // Fin clase App_con
