// Módulo 4 - Ejercicio 4

import java.util.Scanner; // Importamos el método Scanner

public class App {

	public static void main(String[] args) { // Método main
	
		// Creamos objeto de tipo "Scanner" y lo guardamos en la variable de tipo Scanner "entrada":
		Scanner entrada = new Scanner(System.in);
		
		// Imprimimos en consola la pregunta al usuario:
		System.out.println("Escribe un número del 1 al 12, ambos incluidos:");
		
		// Declaramos una variable de tipo "byte" a la que llamamos "numeroMes" y dentro almacenamos el valor escrito por el usuario
		byte numeroMes = entrada.nextByte();
		
		// Con un condicional if/else establecemos 2 situaciones:
		if (numeroMes>=1 && numeroMes<=12) { // Si el número escrito está entre 1 y 12, ejecuta lo que hay dentro del if:
			
			// Con un switch, imprimimos una línea con información específica para cada uno de los 12 casos posibles:
			
			switch (numeroMes) {
				case 1 : 
					System.out.println("El mes de enero tiene 31 días");
					break;
				case 2 : 
					System.out.println("El mes de febrero tiene 28 días (29 si es año bisiesto");
					break;
				case 3 : 
					System.out.println("El mes de marzo tiene 31 días");
					break;
				case 4 : 
					System.out.println("El mes de abril tiene 30 días");
					break;
				case 5 : 
					System.out.println("El mes de mayo tiene 31 días");
					break;
				case 6 : 
					System.out.println("El mes de junio tiene 30 días");
					break;
				case 7 : 
					System.out.println("El mes de julio tiene 31 días");
					break;
				case 8 : 
					System.out.println("El mes de agosto tiene 31 días");
					break;
				case 9 : 
					System.out.println("El mes de septiembre tiene 30 días");
					break;
				case 10 : 
					System.out.println("El mes de octubre tiene 31 días");
					break;
				case 11 : 
					System.out.println("El mes de noviembre tiene 30 días");
					break;
				case 12 : 
					System.out.println("El mes de diciembre tiene 31 días");
					break;
				default:
					break;
			} // Fin del switch
			
			System.out.println("Final del programa: OK");
			
		} else { // Si el usuario escribe un número que no esté entre el 1 y el 12, ejecuta lo que hay dentro del else
			
			System.out.println("El número que has escrito no está entre el 1 y el 12");
			System.out.println("Final del programa: NOK");
			
		} // Final del if/else
		
		// Cerramos objeto Scanner:
		entrada.close();
		
	} // Fin del método main

} // Fin de clase App