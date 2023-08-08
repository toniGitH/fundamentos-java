// Módulo 5 - Ejercicio 5

import java.util.ArrayList; // Importamos la clase ArrayList
import java.util.Scanner; // Importamos la clase Scanner

public class App {

	public static void main(String[] args) {
		
		// 1) DECLARACIÓN DE VARIABLES:
		
		// Creamos un objeto de tipo Scanner y lo almacenamos en una variable de tipo Scanner llamada "entrada":
		Scanner entrada = new Scanner(System.in);
		
		// Creamos las variables que vamos a necesitar:
		byte edadUsuario;
		byte contador= 0; // Inicializada a "0" porque inicialmente el número de becados es "0".
		String nombreUsuario, titulo, paro;
		// Creamos un arrayList de tipo "String" llamado "becados" que almacenará los nombres de los 5 becados:
		ArrayList<String> becados = new ArrayList<String>();
		
		// 2) DECLARACIÓN DE BUCLE DO WHILE QUE "ENVOLVERÁ" EL CÓDIGO DE LOS PASOS 3) Y 4), PUESTO
		//    QUE LO QUE QUEREMOS ES QUE ÉSTE SE REPITA INDEFINIDAMENTE MIENTRAS SE CUMPLA UNA 
		//    CONDICIÓN ESTABLECIDA POR NOSOTROS: mientras que el valor de la variable "contador",
		//    que está almacenando el número de personas que han conseguido beca sea menor que "5"
		//    el código que hay en el interior del bucle deberá repetirse.
		//	  Una vez que haya 5 becados (valor de contador valga 5), el programa abandonará el
		//    bucle "do while":
		
		do {
			// 3) CAPTURA DE INFORMACIÓN DEL USUARIO
			
			// Imprimimos en consola mensaje informativo para el usuario para preguntar su nombre:
			System.out.println("Introduce tu nombre");
					
			// Capturamos el dato introducido en consola por el usuario y lo almacenamos en la variable
			// de tipo "String" llamada "nombreUsuario":
			nombreUsuario=entrada.nextLine();
			
			// Imprimimos en consola mensaje informativo para el usuario para preguntar su edad:
			System.out.println("Introduce tu edad");
			
			// Capturamos el dato introducido en consola por el usuario y lo almacenamos en la variable
			// de tipo "int" llamada "edadUsuario":
			edadUsuario=entrada.nextByte();
			
			// Limpiamos buffer después de pedir un dato de tipo numérico porque ahora vamos a pedir
			// otro un dato de tipo String:
			entrada.nextLine();
			
			// Imprimimos en consola mensaje informativo para el usuario para preguntar sus datos
			// universitarios:
			System.out.println("¿Tienes algún título universitario (s/n)?");
			// Capturamos el dato introducido en consola por el usuario y lo almacenamos en la variable
			// de tipo "String" llamada "respuestaUni":
			titulo = entrada.nextLine();
			
			// Imprimimos en consola mensaje informativo para el usuario para preguntar datos de paro:
			System.out.println("¿Estás en el paro (s/n)?");
			// Capturamos el dato introducido en consola por el usuario y lo almacenamos en la variable
			// de tipo "String" llamada "respuestaParo":
			paro = entrada.nextLine();
			
			// 4) PROCESAMIENTO DE LOS DATOS RECOGIDOS
			
			// En función de los valores que tengan las variables "edadUsuario", "tituloUni" y "paro",
			// construimos un condicional if/else que sólo podrá dar lugar a dos situaciones:
			// 		-> que el usuario SI tenga derecho a beca
			// 		-> que el usuario NO tenga derecho a beca
			// Si el usuario SI tiene beca, el programa entrará dentro del bloque del "if" y hará 3
			// acciones (después de esas 3 acciones, ignora el resto del if/else y se sale de él):
			//		1. Imprimir mensaje en consola para informar al usuario de que tiene beca
			//		2. Añadir su nombre (almacenado en la variable "nombreUsuario") dentro del 
			//		   "arrayList" llamado "becados" mediante el método "add()" y
			//		3. Incrementar el valor de la variable "contador" en una unidad (esta variable 
			//		   representa el número de personas con beca en este momento del programa).
			// Si el usuario NO tiene derecho a beca, el programa ignora el "if" y entra en el "else"
			// dentro del cual sólo se imprime un mensaje informativo y después se sale del if/else.
			
			if ( (edadUsuario>=18 && titulo.equalsIgnoreCase("s")) || (paro.equalsIgnoreCase("s")) ) {
				System.out.println(nombreUsuario + " tiene derecho recibir a una beca");
				becados.add(nombreUsuario);
				contador++;
				System.out.println(nombreUsuario + " recibe la beca número " + contador);
				System.out.println(); // Para introducir un espacio en blanco
			} else {
				System.out.println(nombreUsuario + " no tiene derecho a recibir una beca");
				System.out.println(); // Para introducir un espacio en blanco
			}
			
		} while (contador<5); // FINAL BUCLE DO WHILE
		
		// 5) PRESENTACIÓN DE RESULTADOS EN PANTALLA. FUERA DEL BUCLE DO WHILE
		
		System.out.println(); // Para introducir un espacio en blanco
		System.out.println("LISTA DE BECADOS");
		
		for (int i=0; i< becados.size(); i++) {
			System.out.println(becados.get(i));
		}
		
		// Cierre del objeto Scanner:
		entrada.close();
		
	} // Fin metodo main

} // Fin clase App_con
