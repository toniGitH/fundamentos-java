// Módulo 4 - Ejercicio 5

import java.util.Scanner; // Importamos la clase Scanner

public class App {
	
	public static void main(String[] args) { // Método main
		
		// Creamos objeto de tipo Scanner y lo almacenamos en una variable de tipo Scanner llamada "entrada"
		Scanner entrada = new Scanner(System.in);
		
		// Información impresa en consola:
		System.out.println("CALCULADORA BÁSICA");

		// Imprimimos mensaje para el usuario:
		System.out.println("Introduce un número entero:");
		// Declaramos variable de tipo "int" llamada "num1" y le asignamos el valor del número tecleado en consola
		int num1 = entrada.nextInt();
		
		// Imprimimos mensaje para el usuario:
		System.out.println("Introduce otro número entero:");
		// Declaramos variable de tipo "int" llamada "num2" y le asignamos el valor del número tecleado en consola
		int num2 = entrada.nextInt();
		
		//entrada.nextLine(); // Limpieza de buffer
		
		// Imprimimos mensaje para el usuario:
		System.out.println("Elige qué operación matemática quieres hacer:");
		System.out.println("Suma (pulsa +) -- Resta (pulsa -) -- Multiplicación (pulsa *) -- División (pulsa /)");
		// Declaramos variable tipo "char" llamada "operacion", y en ella almacenamos el valor introducido por usuario en consola:
		char operacion = entrada.next().charAt(0);
		
		// Mediante un condicional if/else, establecemos la condición de que:
		// -> si el usuario ha tecleado "+", "-", "*" ó "/", el programa ejecuta lo que hay dentro del if, que
		//    es entrar en un switch con 4 opciones (operaciones).
		// -> y si teclea cualquier otra cosa, ignorará lo que hay dentro del if y ejecutará lo que hay dentro
		//    del else, que es imprimir un mensaje de NOK.
		
		if ( (operacion=='+') || (operacion=='-') || (operacion=='*') || (operacion=='/') ) {
			
			// Switch para informar de la operación elegida y para hacer e imprimir el cálculo de esa operación
			
			switch (operacion) {
				case '+':
					System.out.print("Has elegido hacer una SUMA:");
					System.out.println(" el resultado de la suma de " + num1 + "+" +num2 + " es igual a " + (num1+num2)); // DUDA: sin paréntesis no funciona porque está concatenando
					break;
				case '-':
					System.out.print("Has elegido hacer una RESTA:");
					System.out.println(" el resultado de la resta de " + num1 + "-"+ num2 + " es igual a " + (num1-num2)); // DUDA: por qué no funciona sin paréntesis, pero "*" y "/" sí funcionan
					break;
				case '*':
					System.out.print("Has elegido hacer una MULTIPLICACIÓN:");
					System.out.println(" el resultado de la multiplicación de " + num1 + "x" + num2 + " es igual a " + num1*num2); // DUDA: por qué sí funciona sin paréntesis, pero "+" y "-" no funcionan
					break;
				case '/':
					System.out.print("Has elegido hacer una DIVISIÓN:");
					System.out.println(" el resultado de la multiplicación de " + num1 + "/" + num2 + " es igual a " + (double)num1/num2); // DUDA: por qué sí funciona sin paréntesis, pero "+" y "-" sí funcionan
					break;
				} // Final del switch
			
			System.out.println("FINAL DEL PROGRAMA: OK");
			
		} else {
			
			System.out.println("Esa opción no es válida.");	
			System.out.println("FIN DEL PROGRAMA: NOK");
			
		} // Final condicional if/else
		
		// Cerramos el objeto Scanner
		entrada.close();
		
	} // Fin del método main 

} // Fin de la clase App
