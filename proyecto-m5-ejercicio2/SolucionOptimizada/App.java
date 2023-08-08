// Módulo 5 - Ejercicio 2 (versión optimizada)

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		byte num1, num2, numAuxiliar;
		int suma=0;
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Escribe un primer número (debe ser entero):");
		num1 = entrada.nextByte();
		System.out.println("Escribe un segundo número (debe ser entero):");
		num2 = entrada.nextByte();
		
		if (num1>num2) {
			numAuxiliar=num1;
			num1=num2;
			num2=numAuxiliar;
		}
		
		for (int i=num1; i<=num2; i++) {
			suma+=i;
		}
		
		System.out.println("El valor de la suma es " + suma);
		
		entrada.close();	
	}
}
