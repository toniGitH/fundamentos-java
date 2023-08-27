// Módulo 7.2 - Ejercicio 6

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		boolean primo;
		do {
			int numElegido = pedirInt("Escribe un número entero");
			boolean menorA2 = esMenorQue2(numElegido);
			primo = esPrimo(numElegido, menorA2);
			impresion(numElegido, primo);
		} while (primo==false);
		
	} // Fin del método main
	
	// -----------------------------------------------------------------------------------
	
	// RESTO DE MÉTODOS
	
	// método para pedir int
	static int pedirInt(String msg) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		return entrada.nextInt();
	}
		
	// metodo para determinar si un int es menor que 2 (todos esos números NO son primos)
	static boolean esMenorQue2(int paramNumElegido) {
		return paramNumElegido<2;
	}
		
	// método para averiguar si un número es primo
	static boolean esPrimo(int paramNumElegido, boolean menor2) {
		boolean primo=true;
		if (menor2) {
			primo=false;
		}
		else {
			int numControl;
			for (int i=paramNumElegido-1; i>1; i--) {
				numControl=paramNumElegido%i;
				if (numControl==0) {
					primo=false;
				}
			}
		}
		return primo;
	}
		
	// método para imprimir resultado
	static void impresion(int paramNumElegido , boolean paramPrimo) {
		if (paramPrimo) {
			System.out.println("¡¡Exacto!! El número " + paramNumElegido + " es un número primo.");
		} else {
			System.out.println("El número " + paramNumElegido + " no es un número primo. Escribe otro número");
		}
	}
	
	// método para pedir int solo positivo (MÉTODO NO UTILIZADO)
	/*static int pedirIntPositivo(String msg1, String msg2) {
		int numPositivo=pedirInt(msg1);
		while (esPositivo(numPositivo)==false) {
			numPositivo=pedirInt(msg2);
		}
		return numPositivo;
	}*/
			
	// método para determinar si un int es positivo o negativo (MÉTODO NO UTILIZADO)
	/*static boolean esPositivo(int paramNumEscrito) {
		return paramNumEscrito>0;
	}*/

} // Fin de la clase App
