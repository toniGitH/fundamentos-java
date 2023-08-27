// Módulo 7.2 - Ejercicio 5

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		int numElegido = pedirInt("Escribe un número entero:");
		boolean primo = esPrimo(numElegido);
		impresion(numElegido, primo);
		
	} // Fin del método main
	
	// -----------------------------------------------------------------------------------
	
	// RESTO DE MÉTODOS
	
	// método para pedir int
	static int pedirInt(String msg) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		return entrada.nextInt();
	}
	
	// método para calcular el módulo_i de un int
	static int modulo_i(int paramNumElegido, int param_i) {
		return paramNumElegido%param_i;
	}
		
	// método para averiguar si un número es primo
	static boolean esPrimo(int paramNumElegido) {
		boolean primo=true;
		if (paramNumElegido<2) { // Todos los nums menores a 2 son primos (incluidos negativos)
			primo=false;
		} 
		else if (paramNumElegido==2) { // El número 2 es primo
			primo=true;
		}
		else { // Dado un número "num", mediante un bucle while vamos haciendo los módulos
			   // "num%num-i" mientras que dicho cálculo sea !=0 y num-1 sea >1.
			   // El programa acabará sí o sí saliendo del bucle, dándose 2 posibilidades:
			   //   1) salirse porque el módulo NUNCA ha dado "!=0", y por tanto param_i valdrá
			   //      1, por lo que el valor de la variable "primo" no se modificará en el 
			   //      interior de este "else" y por tanto, primo se quedará con valor "true", lo
		       //      que significará que el número SI es primo.
			   //   2) salirse porque en algún momento, excepto el caso anterior, el módulo salga
			   //	   "==0". En este caso, "param_i" será, seguro, ">1", por lo que, tras abandonar
			   //      el bucle, entraremos en el if, donde le cambiaremos el valor a la variable primo,
			   //      que ahora será "false", lo que significará que el número NO es primo.
			int param_i = paramNumElegido-1;
			while (modulo_i(paramNumElegido, param_i)!=0 && param_i>1) {
				param_i--;
			}
			if (param_i>1) {
				primo=false;
			}
		}
		return primo;
		
	} // Fin método esPrimo()
		
	// método para imprimir resultado
	static void impresion(int paramNumElegido , boolean paramPrimo) {
		if (paramPrimo) {
			System.out.println("El número " + paramNumElegido + " es un número primo.");
		} else {
			System.out.println("El número " + paramNumElegido + " no es un número primo.");
		}
	}

} // Fin de la clase App
