// Módulo 8 - Ejercicio 6 (Versión 2)

package PaqueteApp;

import java.util.Scanner;

public class ToolsDatos {
	
	// Método para pedir un dato de tipo int
	static int pedirInt (String msg) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		return entrada.nextInt();
	}
	
	// Método para pedir un dato de tipo int que sea positivo
	static int pedirIntPositivo (String msg) {
		Scanner entrada = new Scanner(System.in);
		int nuevoValor;		
		do {
			nuevoValor = pedirInt(msg);
			if (esPositivo(nuevoValor)==false) {
				System.out.println("El valor introducido no es válido. Debe ser un valor positivo.");
			} 
		} while (esPositivo(nuevoValor)==false);
		
		return nuevoValor;
	}
	
	// Método para pedir un dato de tipo byte
	static byte pedirByte (String msg) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		return entrada.nextByte();
	}
	
	// Método para pedir un dato de tipo byte que sea positivo
	static byte pedirBytePositivo (String msg) {
		Scanner entrada = new Scanner(System.in);
		byte nuevoValor;		
		do {
			nuevoValor = pedirByte(msg);
			if (esPositivo(nuevoValor)==false) {
			System.out.println("El valor introducido no es válido. Debe ser un valor positivo.");
			} 
		} while (esPositivo(nuevoValor)==false);
					
		return nuevoValor;
	}
	
	// Método para pedir un dato de tipo String
	static String pedirString(String msg) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		return entrada.nextLine();
	}
	
	// Método para pedir un dato de tipo String y devolverlo en "capital"
	static String pedirStringCapital(String msg) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		String palabra = entrada.nextLine();
		return palabra.toUpperCase().charAt(0) + palabra.substring(1, palabra.length()).toLowerCase();
	}
	
	// Método para pedir un dato de tipo char
	static char pedirChar(String msg) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		return entrada.next().toLowerCase().charAt(0);
	}
	
	// Método para pedir un dato de tipo char y devolver un dato de tipo String
	static String pedirCharSiNo(String msg) {
		String valorADevolver = "no";
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		if (entrada.next().toLowerCase().charAt(0)=='s') {
			valorADevolver="si";
		}
		return valorADevolver;
	}

	// Método para comprobar si un dato de tipo int es positivo
	static boolean esPositivo(int valor) {
		return valor>0;
	}
		
} // FIN DE LA TOOLSDATOS