// Módulo 7.1 - Ejercicio 6

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		byte numeroObjetivo = pedirNum1a10("Introduce un número del 1 al 10", "Número incorrecto, prueba de nuevo");
		imprimirTabla(numeroObjetivo);
		
		// CÓDIGO EQUIVALENTE
		//imprimirTabla(pedirNum1a10("Introduce un número del 1 al 10", "Número incorrecto, prueba de nuevo"));
		
	} // Fin método main
	
	// ------------------------------------------------------------------------------------
	
	// RESTO DE MÉTODOS
	
	// método para pedir un byte
	static byte pedirByte(String mensaje) { // MÉTODO PARA PEDIR DATOS DE TIPO BYTE (nº del 1 al 10)
		Scanner entrada = new Scanner(System.in);
		System.out.println(mensaje);
		return entrada.nextByte();
	}
	
	// método para validar que un byte esté entre 1 y 10
	static boolean esValido(byte paramNumeroElegido) {
		return (paramNumeroElegido>=1 && paramNumeroElegido<=10);
	}
	
	// método para pedir un número y no devolverlo mientras que no esté entre 1 y 10
	static byte pedirNum1a10(String msg1, String msg2) {
		byte numElegido = pedirByte(msg1);
		while (esValido(numElegido)==false) {
			numElegido=pedirByte(msg2);
		}
		return numElegido;
	}
	
	// método para imprimir la tabla de multiplicar de un número
	static void imprimirTabla(byte paramNunElegido) {
		System.out.println("La tabla del " + paramNunElegido + " es:");
		System.out.println();
		for (int i=1; i<=10; i++) {
			System.out.println(paramNunElegido + "x" + i + " = " + paramNunElegido*i);
		}
	}
	
} // Final clase App
