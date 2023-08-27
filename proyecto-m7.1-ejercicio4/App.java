// Módulo 7.1 - Ejercicio 4

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		impresionRespuesta(esNegativo(pedirShort("Introduce un número entero, positivo o negativo:"), pedirShort("Introduce un número entero, positivo o negativo:")));
		
		// CÓDIGO EQUIVALENTE
		/*short num1 = pedirShort("Introduce un número entero, positivo o negativo:");
		short num2 = pedirShort("Introduce otro número entero, positivo o negativo:");
		boolean evaluacionNegativo = esNegativo(num1, num2);
		impresionRespuesta(evaluacionNegativo);*/
		
	} // Fin método main
	
	// ----------------------------------------------------------------------------------
	
	// RESTO DE MÉTODOS
	
	static short pedirShort(String mensaje) { // Método para pedir datos de tipo short (números a evaluar)
		System.out.println(mensaje);
		Scanner entrada = new Scanner(System.in);
		return entrada.nextShort();
	}
	
	static boolean esNegativo(short paramNum1, short paramNum2) { // Método para determinar si hay algún negativo
		return paramNum1*paramNum2<0; // Este método devuelve "true" si SOLO UN NUMERO ES NEGATIVO
									  // Devuelve "false" si ambos números son positivos o negativos
	}
	
	static void impresionRespuesta(boolean esNegativo) { // Método para imprimir resultados
		if (esNegativo) { // Esto equivale a if (esNegativo==true)
			System.out.println("Solo uno de los dos números es negativo");
		} else {
			System.out.println("Ambos números son positivos o negativos");
		}
	}
}
