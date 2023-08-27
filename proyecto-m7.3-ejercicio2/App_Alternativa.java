// Módulo 7.3 - Ejercicio 2 (Solución alternativa, sin usar ArrayList)
// Esta versión tiene menos código y no utiliza ArrayList

import java.util.Scanner;

public class App_Alternativa {

	public static void main(String[] args) {
		
		String cadenaEscrita = pedirString("Escribe una frase o palabra");
		String cadenaInvertidaString = invertirString(cadenaEscrita);
		imprimeResultados(cadenaEscrita, cadenaInvertidaString);
		
		// CÓDIGO RESUMIDO EQUIVALENTE
		// No se puede reducir más, porque estoy utilizando la variable "cadenaEscrita"
		// dos veces.
		
		
	} // Fin del método main
	
	// ------------------------------------------------------------------------------
	
	// RESTO DE MÉTODOS

	// método para pedir un String
	static String pedirString(String msg) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		return entrada.nextLine();
	}
	
	// metodo para invertir un String
	static String invertirString(String paramString) {
		String stringInvertido="";
		for (int i=paramString.length()-1; i>=0; i--) {
			stringInvertido+=paramString.charAt(i);
		}
		return stringInvertido;
	}
	
	// método para imprimir resultados
	static void imprimeResultados(String paramString, String paramStringInvertido) {
		System.out.println("Has escrito: " + paramString);
		System.out.println("Escrito al revés es: " + paramStringInvertido);
	}
	
} // Fin de la clase App
