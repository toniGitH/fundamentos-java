// Módulo 3 - Ejercicio Extra 3

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		// Declaración-asignación de la constante coberturaLitro:
		final double COBERTURALITRO = 12;
		
		// Creamos un objeto de tipo Scanner:
		Scanner entrada = new Scanner(System.in);
		
		// Petición y guardado de datos de altura y ancho de la pared y número de capas:
		System.out.println("Introduce el alto de la pared a pintar, en cm:");
		int altoCm = entrada.nextInt();
		System.out.println("Ahora introduce el largo de la pared a pintar, en cm:");
		int anchoCm = entrada.nextInt();
		System.out.println("¿Cuántas manos de pintura quieres darle a la pared?");
		int capas = entrada.nextInt();
		
		// Cálculos de área en cm cuadrados, área en metros cuadrados y pintura necesaria:
		int areaParedCM = altoCm * anchoCm;
		double areaParedM = (double)areaParedCM/10000;
		double pinturaNecesaria = (areaParedM/COBERTURALITRO)*capas;
		
		// Salida de resultados por consola:
		System.out.println("Resultado del álculo:");
		System.out.println("Para dar " + capas + " capas de pintura a tu pared de " + areaParedM + " metros cuadrados necesitarás un total de " + pinturaNecesaria + " litros de pintura.");
		
		// Cierre del objeto Scanner:
		entrada.close();
 	}

}
