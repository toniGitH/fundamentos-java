// Módulo 4 - Ejercicio Extra 2

import java.util.Scanner; // Importamos la clase Scanner
import java.util.ArrayList; // Importamos la clase ArrayList

public class App { // Inicio de la clase App

	public static void main(String[] args) { // Inicio método main
		
		// Declaramos las diferentes variables que vamos a necesitar:
		
		byte eleccion;
		int decena, unidad;
		
		
		// Declaramos e inicializamos los diferentes "arrayList" que vamos a necesitar:
		
		// Primer "arrayList" para los números especiales, que no se pueden "crear" 
		// combinando otros números:
		ArrayList <String> numsEspeciales = new ArrayList<String>();
		numsEspeciales.add("cero");
		numsEspeciales.add("uno");
		numsEspeciales.add("dos");
		numsEspeciales.add("tres");
		numsEspeciales.add("cuatro");
		numsEspeciales.add("cinco");
		numsEspeciales.add("seis");
		numsEspeciales.add("siete");
		numsEspeciales.add("ocho");
		numsEspeciales.add("nueve");
		numsEspeciales.add("diez");
		numsEspeciales.add("once");
		numsEspeciales.add("doce");
		numsEspeciales.add("trece");
		numsEspeciales.add("catorce");
		numsEspeciales.add("quince");
		
		
		// Segundo "arrayList" con las decenas, que nos servirá para "crear" otros números:
		ArrayList<String> decenas = new ArrayList<String>();
		decenas.add("cero");
		decenas.add("dieci");
		decenas.add("veinti");
		decenas.add("treinta");
		decenas.add("cuarenta");
		decenas.add("cincuenta");
		decenas.add("sesenta");
		decenas.add("setenta");
		decenas.add("ochenta");
		decenas.add("noventa");
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Escribe un número entre el 0 y el 99");
		eleccion = entrada.nextByte();
		
		// Condicional para validar que el usuario escriba un número dentro del rango solicitado:
		
		if (eleccion<0 || eleccion>99) { // Si escribe un número fuera del rango <0-99>:
			System.out.println("El número " + eleccion +" NO está entre el 0 y el 99");
			System.out.println("Fin de programa: NOK");
		} 
		
		else { // Si escribe un número dentro del rango <0-99>:
			
			if (eleccion>=0 && eleccion <=15) { // Si el usuario escribe un número menor a 15:
				System.out.println("El número " + eleccion + " escrito en letras es \"" + numsEspeciales.get(eleccion) + "\"");
			} 
			
			else if (eleccion==20) { // Si escribe el 20:
				System.out.println("El número " + eleccion + " escrito en letras es \"veinte\"");
			} 
			
			else { // Si el usuario NO escribe un número entre 1 y el 15 o el número 20:
				// Si el programa entra en este else, va a determinar las decenas y las unidades
				// que van a componer el número tecleado por el usuario:
				
				decena = eleccion/10; // Como guardo la división en un "int", no habrá decimales
				unidad = eleccion%10; // Esta operación da como resultado el valor de las unidades
				
				if ( (eleccion>15 && eleccion <20) || (eleccion>20 && eleccion<30) ) { // Si el usuario escribe un número entre 16 y 29, excepto el 20:
					System.out.println("El número " + eleccion + " escrito en letras es \"" + decenas.get(decena) + numsEspeciales.get(unidad) + "\"");
				}
				
				else if (unidad==0) { // Esto pasará si el número es 30, 40, 50, etc...
					System.out.println("El número " + eleccion + " escrito en letras es \"" + decenas.get(decena) + "\"");
				
				} else { // Esto pasará si el número NO acaba en 0;
					System.out.println("El número " + eleccion + " escrito en letras es \"" + decenas.get(decena) + " y " + numsEspeciales.get(unidad)+ "\"");
				}
			} // Final de condicional if/else

		} // Fin Primer concicional if/else
		
		entrada.close();
		
	} // Fin del método main
	
} // Fin de la clase App
