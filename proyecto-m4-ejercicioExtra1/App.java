// Módulo 4 - Ejercicio Extra 1

import java.util.Scanner;

public class App {

	public static void main(String[] args){
	
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Escribe un número entero. Será el DIVIDENDO");
		
		int dividendo = entrada.nextInt();
		
		System.out.println("Introduce otro número entero, entre el 2 y el 7 (incluidos). Será el DIVISOR");
		
		int divisor = entrada.nextInt();
		
		if (divisor>=2 && divisor<=7) {
			if (dividendo%divisor==0) {
				System.out.println("El número " + dividendo + " es múltiplo de " + divisor);
			} else {
				System.out.println("El número " + dividendo + " no es múltiplo de " + divisor);
			}
			System.out.println("Fin del programa");
		} else {
			System.out.println("El número que has escrito no está entre el 2 y el 7");
			System.out.println("Fin del programa");
		}
		
		entrada.close();
	}
	
}
