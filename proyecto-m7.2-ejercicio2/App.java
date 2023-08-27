// Módulo 7.2 - Ejercicio 2

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		byte numLineas = pedirByte("Introduce número de líneas a imprimir:");
		imprimirLineasDesc(numLineas, '*');
	
		// CÓDIGO RESUMIDO EQUIVALENTE
		//imprimirLíneasDesc(pedirByte("Introduce número de líneas a imprimir:"), '*');
		
	} // Fin método main
	
	//-------------------------------------------------------------------------------
	
	// RESTO DE MÉTODOS

	static byte pedirByte(String msg) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		return entrada.nextByte();
	}
	
	static void imprimirLineasDesc(byte paramNumLineas, char paramSimbolo) {
		for (int lineas=paramNumLineas; lineas>0; lineas--) {
			for (int columnas=1; columnas<=lineas; columnas++) {
				System.out.print(paramSimbolo + " ");
			}
			System.out.println();
		}
	}
	
} // Fin de clase App
