// Módulo 7.2 - Ejercicio 4

import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		byte numNatural = pedirByteNatural("Escribe un número natural (entero mayor o igual que cero)", "Ese número no es mayor o igual a cero. Inténtalo de nuevo");
		long resultadoFactorial = factorial(numNatural);
		impresion(numNatural, resultadoFactorial);
		
	} // Fin del método main
	
	// RESTO DE MÉTODOS
	
	// método para pedir byte
	static byte pedirByte(String msg) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		return entrada.nextByte();
	}
	
	// método para determinar si un byte es un numero natural
	static boolean esNatural(byte paramNumEscrito) {
		return paramNumEscrito>=0;
	}
	
	// método para pedir byte solo natural => podemos prescindir de este método si
	// cambiando las llamadas a pedirByte() y a esNatural() en el "main"
	static byte pedirByteNatural(String msg1, String msg2) {
		byte numNatural=pedirByte(msg1);
		while (esNatural(numNatural)==false) {
			numNatural=pedirByte(msg2);
		}
		return numNatural;
	}
	
	// método para calcular factorial
	static long factorial(byte paramNumNatural) {
		long factorial=1;
			for (int i=paramNumNatural; i>0; i--) {
				factorial=factorial*i;
			}
		return factorial;
	}
	
	// método para imprimir resultados
	static void impresion(byte paramNumNatural, long paramFactorial) {
		System.out.println("El factorial de " + paramNumNatural + " es " + paramFactorial);
	}
}
