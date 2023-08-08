// Módulo 6 - Ejercicio 1 (Usando varios métodos)

import java.util.ArrayList; // Importamos la clase ArrayList
import java.util.Scanner; // Importamos la clase Scanner

public class App {
	
	public static void main(String[] args) { // Método "main":

		// DECLARACIÓN DE VARIABLES A UTILIZAR:
		
		ArrayList<Integer> numerosElegidos = new ArrayList<Integer>();
		char operacionElegida;
		double resultadoFinal;
		
		// LLAMADAS A MÉTODOS:
		
		numerosElegidos = pedirNumeros();
		operacionElegida = pedirOperacion();
		resultadoFinal = calculadora(numerosElegidos.get(0), numerosElegidos.get(1), operacionElegida);
		impresion(numerosElegidos.get(0), numerosElegidos.get(1), operacionElegida, resultadoFinal);
		
	} // Fin del método main
	
	// RESTO DE MÉTODOS
	
	static ArrayList<Integer> pedirNumeros() { // Método "pedirNumeros()"
		
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Introduce un número entero:");
		numeros.add(entrada.nextInt());
		
		System.out.println("Introduce otro número entero:");
		numeros.add(entrada.nextInt());
		
		//entrada.close(); // Comentado para que no de errores

		return numeros; 

	} // Fin del método "pedirNumeros()"
	
	static char pedirOperacion() { // Método "pedirOperacion()"
		
		char operacion;
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Elige qué operación matemática quieres hacer:");
		System.out.println("Suma (pulsa +) -- Resta (pulsa -) -- Multiplicación (pulsa *) -- División (pulsa /) -- Módulo (pulsa %)");
		operacion = entrada.next().charAt(0);
		// Bucle while para validar que el tipo de operación elegido sea correcto:
		while (operacion!='+' && operacion!='-' && operacion!='*' && operacion!='/' && operacion!='%') {
			System.out.println("El tipo de operación que has elegido no es correcto. Vuelve a elegir una opción:");
			System.out.println("Suma (pulsa +) -- Resta (pulsa -) -- Multiplicación (pulsa *) -- División (pulsa /) -- Módulo (pulsa %)");
			operacion = entrada.next().charAt(0);
		}
		
		//entrada.close(); // Comentado para que no de errores
		
		return operacion; 
		
	} // Fin del método "pedirOperacion()"
	
	static double calculadora(int paramNum1, int paramNum2, char paramOperacion) { // Método "calculadora()"
		
		double resultadoOp=0; 
		
		switch (paramOperacion) {
			case '+':
				resultadoOp=paramNum1+paramNum2;
				break;
			case '-':
				resultadoOp=paramNum1-paramNum2;
				break;
			case '*':
				resultadoOp=paramNum1*paramNum2;
				break;
			case '/':
				resultadoOp=(double)paramNum1/paramNum2;
				break;
			case '%':
				resultadoOp=paramNum1%paramNum2;
				break;
			//default: // No es necesario
		} // Fin switch
		
		return resultadoOp; 
		
	} // Fin del método "calculadora()"
	
	static void impresion(int paramNum1, int paramNum2, char paramOperacion, double paramResultado) { // Método "impresion()"
	
		System.out.println("OPERACIÓN REALIZADA: " + paramNum1 + paramOperacion + paramNum2 + " = " + paramResultado);

	} // Fin del método "impresion()"
	
} // Fin de la clase App
