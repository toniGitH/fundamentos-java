// Módulo 6 - Ejercicio 1

import java.util.Scanner; // Importamos la clase Scanner

public class App {
	
	public static void main(String[] args) { // Método main
		
		// 1) DEFINICIÓN DE VARIABLES:
		
		int num1, num2;
		char operacion;
		
		// 2) PETICIÓN/CAPTURA DE DATOS:
		
		// Creamos objeto de tipo Scanner y lo almacenamos en una variable de tipo Scanner llamada "entrada"
		Scanner entrada = new Scanner(System.in);
		
		// Información impresa en consola:
		System.out.println("CALCULADORA BÁSICA");

		// Imprimimos mensaje para el usuario:
		System.out.println("Introduce un número entero:");
		// Declaramos variable de tipo "int" llamada "num1" y le asignamos el valor del número tecleado en consola
		num1 = entrada.nextInt();
		
		// Imprimimos mensaje para el usuario:
		System.out.println("Introduce otro número entero:");
		// Declaramos variable de tipo "int" llamada "num2" y le asignamos el valor del número tecleado en consola
		num2 = entrada.nextInt();
		
		entrada.nextLine(); // Limpieza de buffer
		
		// Imprimimos mensaje para el usuario:
		System.out.println("Elige qué operación matemática quieres hacer:");
		System.out.println("Suma (pulsa +) -- Resta (pulsa -) -- Multiplicación (pulsa *) -- División (pulsa /) -- Módulo (pulsa %)");
		operacion = entrada.next().charAt(0);
		// Bucle while para validar que el tipo de operación elegido sea correcto:
		while (operacion!='+' && operacion!='-' && operacion!='*' && operacion!='/' && operacion!='%') {
			System.out.println("El tipo de operación que has elegido no es correcto. Vuelve a elegir una opción:");
			System.out.println("Suma (pulsa +) -- Resta (pulsa -) -- Multiplicación (pulsa *) -- División (pulsa /) -- Módulo (pulsa %)");
			operacion = entrada.next().charAt(0);
		}
		
		// 3) CALCULOS/LLAMADAS A MÉTODOS/IMPRESION DE RESULTADOS:
			
		switch (operacion) { // Switch para determinas a qué función de cálculo llamar:

			case '+':
				suma (num1, num2);
				break;
			case '-':
				resta (num1, num2);
				break;
			case '*':
				multiplicacion(num1, num2);
				break;
			case '/':
				division(num1, num2);
				break;
			case '%':
				modulo(num1, num2);
				break;
			// No hace falta "default"
		} // Final del switch
		
		// Cerramos el objeto Scanner
		entrada.close();
		
	} // Fin del método main
	
	//---------------------------------------------------------------------------------//
	
	// *) RESTO DE MÉTODOS: 
	
	static void suma(int paramNum1, int paramNum2) {
		System.out.print("Has elegido hacer una SUMA:");
		System.out.println(" el resultado de la suma de " + paramNum1 + "+" +paramNum2 + " es igual a " + (paramNum1+paramNum2));
	}
	
	static void resta (int paramNum1, int paramNum2) {
		System.out.print("Has elegido hacer una RESTA:");
		System.out.println(" el resultado de la resta de " + paramNum1 + "-" +paramNum2 + " es igual a " + (paramNum1-paramNum2));
	}
	
	static void multiplicacion (int paramNum1, int paramNum2) {
		System.out.print("Has elegido hacer una MULTIPLICACIÓN:");
		System.out.println(" el resultado de la multiplicación de " + paramNum1 + "x" +paramNum2 + " es igual a " + (paramNum1*paramNum2));
	}
	
	static void division (int paramNum1, int paramNum2) {
		System.out.print("Has elegido hacer una DIVISIÓN:");
		System.out.println(" el resultado de la división de " + paramNum1 + "/" +paramNum2 + " es igual a " + ((double)paramNum1/paramNum2));
	}
	
	static void modulo (int paramNum1, int paramNum2) {
		System.out.print("Has elegido calcular el MÓDULO:");
		System.out.println(" el resultado del módulo de " + paramNum1 + "%" +paramNum2 + " es igual a " + (paramNum1%paramNum2));
	}

} // Fin de la clase App
