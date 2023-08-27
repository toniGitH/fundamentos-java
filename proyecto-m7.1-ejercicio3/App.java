// Módulo 7.1 - Ejercicio 3

import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
	
		impresion(esPar(pedirInt("Introduce un número entero:")));
		
		// CÓDIGO EQUIVALENTE
		/*int numeroElegido = pedirInt("Introduce un número entero:");
		boolean esPar = esPar(numeroElegido);
		impresion(esPar);*/
		

	} // Fin del método main

	// --------------------------------------------------------------------------------------

	// RESTO DE MÉTODOS
	
	static int pedirInt(String mensaje){ // Método para pedir datos de tipo int (número a evaluar)
		Scanner entrada = new Scanner(System.in);
		System.out.println(mensaje);
		return entrada.nextInt();
	}
	
	static boolean esPar(int paramNumero) { // Método que evalúa si el número es par o no
		return paramNumero%2==0;
	}	// Este método evalúa si el modulo2 del int pasado por parámetro es igual a cero. El
		// valor devuelto sólo puede ser "true" o "false". Si el número es par, este método
		// devolverá true, porque la expresion "paramNumero%2==0" será "true".
	
	static void impresion(boolean paramEsPar){
		if (paramEsPar) { // Esto equivale a if (paramEsPar==true)
			System.out.println("El número introducido es un número par");
		} else {
			System.out.println("El número introducido es un número impar");
		}
	}
}
