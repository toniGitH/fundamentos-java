// Módulo 6 - Ejercicio 2

import java.util.ArrayList; // Importamos la clase ArrayList
import java.util.Scanner; // Importamos la clase Scanner

public class App {
	
	public static void main(String[] args) { // Método main

		// Declaración de variables:
		Scanner entrada = new Scanner(System.in);
		byte numPersonas;
		double mediaEdad;
		
		// Captura de datos:
		System.out.println("¿Escribe número de personas a preguntar?");
		numPersonas = entrada.nextByte();
		
		// Caldulo de la media de edad llamando al método "calculoMedia()":
		mediaEdad=calculoMedia(numPersonas);

		// Impresión de resultados:
		System.out.println("La media de edad de las " + numPersonas + " personas introducidas es de " + mediaEdad);
	}
	
	static double calculoMedia(byte paramNumPersonas){
		
		// Definición de variables:
		short edadPersona; // Es de tipo "short" para evitar problemas cuando el usuario introduce la edad por consola
		ArrayList<Short> edades = new ArrayList<Short>(); // Guarda los diferentes valores que va tomando la variable "edadPersona" 
		short sumaEdades=0; // Inicializada a "0" para poder "utilizarla" dentro del segundo for
		double media;
		Scanner entrada = new Scanner(System.in);
		
		// Captura de datos de los usuarios:
		
		for (int i=1; i<=paramNumPersonas; i++) {
			System.out.println("Eres la persona número " + i + ". Introduce tu edad:");
			edadPersona = entrada.nextShort();
			while (edadPersona<0 || edadPersona>120) {
				System.out.println("Edad no válida. Debe estar entre 0 y 120 años.");
				System.out.println("Vuelve a introducir tu edad, por favor:");
				edadPersona = entrada.nextShort();
			}
			edades.add(edadPersona);
		} // Cierre de for
		
		// Calculo de la edad media de las personas:
		
		for (int i=0; i<paramNumPersonas; i++) {
			sumaEdades+=edades.get(i);
		}
		
		media=(double)sumaEdades/paramNumPersonas;
		
		// Retorno de datos
		
		return media;
		
	} // Fin del método "calculoMedia()"

}