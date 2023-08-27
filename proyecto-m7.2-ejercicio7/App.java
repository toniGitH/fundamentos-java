// Módulo 7.2 - Ejercicio 7

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		// Declaración de variables
		short any;
		char repetir='s';
		
		System.out.println("DETECTOR DE AÑOS BISIESTOS");
		System.out.println();
		do {
			any = pedirShort("Introduce un año:");
			if (primerCalculo(any)) {
				System.out.println("El año " + any + " es bisiesto");
			} else if (segundoCalculo(any)){
				System.out.println("El año " + any + " es bisiesto");
			} else {
				System.out.println("El año " + any + " NO es bisiesto");
			}
			
			System.out.println();
			repetir = pedirChar("¿Quieres comprobar otro año (s/n)?");
			
		} while (repetir=='s');
		
		System.out.println("Fin del programa");

	} // Fin del método main
	
	// RESTO DE MÉTODOS
	
	// Método pedir short
	static short pedirShort(String msg) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		return entrada.nextShort();
	}
	
	// Método pedir char
	static char pedirChar(String msg) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		return entrada.next().toLowerCase().charAt(0);
	}
	
	// Método calculo1
	static boolean primerCalculo(short any) {
		return any%400==0;
	}
	// Método calculo1
	static boolean segundoCalculo(short any) {
		return (any%4==0 && any%100!=0);
	}
	

} // FIN DE LA CLASE APP
