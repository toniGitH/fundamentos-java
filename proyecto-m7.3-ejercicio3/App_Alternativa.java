// Módulo 7.3 - Ejercicio 3 (Solución alternativa, sin usar ArrayList)
// Esta versión tiene menos código y no utiliza ArrayList

import java.util.Scanner;

public class App_Alternativa {

	public static void main(String[] args) {
		
		String cadenaEscrita = pedirString("Escribe una frase o palabra");
		boolean palindromo = esPalindromo(cadenaEscrita);
		imprimeResultados(palindromo);
		
		// CÓDIGO REDUCIDO EQUIVALENTE
		//imprimeResultados(esPalindromo(pedirString("Escribe una frase o palabra")));
		
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
	
	// método para comparar dos Strings
	static boolean esPalindromo(String paramStringOriginal) {
		return paramStringOriginal.equalsIgnoreCase(invertirString(paramStringOriginal));
	}
	
	// método para imprimir resultados
	static void imprimeResultados(boolean paramPalindromo) {
		if (paramPalindromo) {
			System.out.println("Has escrito un palíndromo");
		} else {
			System.out.println("No has escrito un palíndromo");
		}
	}
	
} // Fin de la clase App
