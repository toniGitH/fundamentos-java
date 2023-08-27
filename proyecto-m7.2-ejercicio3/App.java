// Módulo 7.2 - Ejercicio 3 (Usando solo un *)

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		//byte numLineas = pedirByte("Introduce número de líneas a imprimir:");
		//piramide(numLineas, '*');
		// CÓDIGO RESUMIDO EQUIVALENTE
		piramide(pedirByte("Introduce el número de asteriscos de la fila más lagra:"), '*');
		
	} // Fin método main
	
	//-------------------------------------------------------------------------------
	
	// RESTO DE MÉTODOS

	static byte pedirByte(String msg) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		return entrada.nextByte();
	}
	
	static void imprimirLineasAsc(byte paramNumLineas, char paramSimbolo) {
		for (int lineas=1; lineas<=paramNumLineas; lineas++) {
			for (int columnas=1; columnas<=lineas; columnas++) {
				System.out.print(paramSimbolo + " ");
			}
			System.out.println();
		}
	}
	
	static void imprimirLineasDesc(byte paramNumLineas, char paramSimbolo) {
		for (int lineas=paramNumLineas; lineas>0; lineas--) {
			for (int columnas=1; columnas<=lineas; columnas++) {
				System.out.print(paramSimbolo + " ");
			}
			System.out.println();
		}
	}
	
	static void piramide (byte paramNumLineas, char paramSimbolo) {
		imprimirLineasAsc(paramNumLineas, paramSimbolo);
		imprimirLineasDesc((byte)(paramNumLineas-1), paramSimbolo);
	}
	
	
}
