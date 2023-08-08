// Módulo 5 - Ejercicio 5

import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
	
		// DECLARACIÓN DE VARIABLES
		Scanner entrada = new Scanner(System.in);
		byte edadUsuario;
		byte contador= 0; // Inicializada a "0" porque inicialmente el número de becados es "0".
		String nombreUsuario, titulo, paro;
		ArrayList<String> becados = new ArrayList<String>();
		
		// INICIO BUCLE DO WHILE
		do {
			// Captura de datos del usuario:
			System.out.println("Introduce tu nombre");
			nombreUsuario=entrada.nextLine();
			System.out.println("Introduce tu edad");
			edadUsuario=entrada.nextByte();
			entrada.nextLine(); // Limpieza de buffer
			System.out.println("¿Tienes algún título universitario (s/n)?");
			titulo = entrada.nextLine();
			System.out.println("¿Estás en el paro (s/n)?");
			paro = entrada.nextLine();

			// Determinamos si, en función de los datos recogidos, hay beca o no hay beca:
			if ( (edadUsuario>=18 && titulo.equalsIgnoreCase("s")) || (paro.equalsIgnoreCase("s")) ) {
				System.out.println(nombreUsuario + " tiene derecho recibir a una beca");
				becados.add(nombreUsuario);
				contador++;
				System.out.println(nombreUsuario + " recibe la beca número " + contador);
				System.out.println();
			}
			
			else {
				System.out.println(nombreUsuario + " no tiene derecho a recibir una beca");
				System.out.println();
			}
			
		} while (contador<5); // Final bucle do while
		
		// Impresion de resultados:
		System.out.println();
		System.out.println("LISTA DE BECADOS");
		// Bucle for para recorrer arrayList de nombres de becados:
		for (int i=0; i< becados.size(); i++) {
			System.out.println(becados.get(i));
		}
		
		entrada.close(); // Cierre del objeto Scanner:
		
	} // Fin metodo main

} // Fin clase App_con
