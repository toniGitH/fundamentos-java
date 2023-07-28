// Módulo 4 - Ejercicio 4
// Utilizando bucle For y arrays

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		String[] meses = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
		int[] diasMes = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Escribe un número del 1 al 12, ambos incluidos:");
		byte numeroMes = entrada.nextByte();
		
		if (numeroMes>=1 && numeroMes<=12) {
			for (int i=1; i<=12; i++) {
				if (numeroMes==i) {
					if (i==2) {
						System.out.println("El mes " + i + " es el mes de " + meses[i-1] + " y tiene " + diasMes[i-1] + " días (29 si el año es bisiesto).");
					} else {
						System.out.println("El mes " + i + " es el mes de " + meses[i-1] + " y tiene " + diasMes[i-1] + " días.");
					}
				}
			}
		} else {
			System.out.println("El número que has introducido no está comprendido entre el 1 y el 12");
		}
		
		entrada.close();
	}
}