// Módulo 5 - Ejercicio 2 (mi versión)
// En esta versión, utilizo 2 variables adicionales ("int mayor" e "int menor"), y además un
// "arrayList", pero se puede resolver sólo con una (p.ej. "int numAuxiliar") y sin usar "arrayList"
// El códido de esa versión optimizada está en el ProyectoM5_E2_versionOptimizada (pero no tiene
// comentarios).
// Sin embargo, esta versión da más información respecto a los números involucrados, que no da la
// otra versión.

import java.util.Scanner; // Importamos clase Scanner
import java.util.ArrayList; // Importamos la clase ArrayList

public class App {

	public static void main(String[] args) {
		
		// Creamos un objeto de tipo "Scanner" y un objeto de tipo "ArrayList" y los almacenamos en variables:
		Scanner entrada = new Scanner(System.in);
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		
		// Imprimimos primer mensaje para el usuario en consola:
		System.out.println("Introduce un número entero:");
		// Capturamos el primer número introducido por el usuario dentro de una variable de tipo "int" llamada "num1"
		int num1 = entrada.nextInt();
		// Imprimimos primer mensaje para el usuario en consola:
		System.out.println("Introduce otro número entero, diferente al anterior:");
		// Capturamos el primer número introducido por el usuario dentro de una variable de tipo "int" llamada "num1"
		int num2 = entrada.nextInt();
		
		// Determinamos cuál de los dos números es mayor y cual menor, usando dos variables y un if/elseif/else:
		
		int mayor=0; // Declaramos variable tipo "int" llamada "mayor" e inicializamos en "0":
		int menor=0; // Declaramos variable tipo "int" llamada "menor" e inicializamos en "0":

		if (num1>num2) { // Si num1>num2, asignamos a la variable "mayor" el valor "num1" y a la variable "menor" el valor "num2"
			mayor=num1;
			menor=num2;
		} else if (num2>num1){ // Si num2>num1, asignamos a la variable "mayor" el valor "num2" y a la variable "menor" el valor "num1"
			mayor=num2;
			menor=num1;
		} else { // Si ambos números son iguales, imprime mensaje de error
			System.out.println("Los dos números que has escrito son iguales");
		}
		
		// Con otro condicional if/else hacemos que el programa
		// -> "se termine" si ambos números son iguales o 
		// -> que realice una serie de cálculos si los números tecleados son distintos:
		
		if (num1==num2) { // Si pasa esto, ejecuta lo que hay dentro del if, y después ignora el else, y después
						  // ya no hay más código que ejecutar:
			
			System.out.println("Fin del programa: NOK");
			
		} else { // Si la condición del if anterior no se cumple, se ejecuta lo que hay entro de este else, 
				 // que son las líneas de código que van a hacer los cálculos que nos interesan.
			// Una vez sabemos cuál es el número mayor y cual es el menor, calculamos el intervalo entre ambos
			// y le sumamos "1", y asignamos ese valor a una variable de tipo "int" llamada "intervalo" (de esta
			// manera, dentro de la variable "intervalo" tenemos almacenado un número que indica la cantidad de
			// números que tenemos entre el mayor y el menor, ambos incluidos, y que son los que tendremos que
			// sumar para resolver el ejercicio):
			int intervalo = (mayor-menor)+1;
			
			// Antes de empezar el sumatorio que nos pide el enunciado, establecemos el primer elemento del
			// sumatorio, que en mi caso yo quiero que sea el número más pequeño de los dos que ha elegido el
			// usuario, y que tenemos almacenado en la variable de tipo "int" llamada "menor".
			// Declaramos una nueva variable de tipo "int", a la que llamamos "numeroSumado" y a ésta le
			// asignamos el valor almacenado en la variable "menor" (el primer numero sumado será el valor
			// de "menor"):
			int numeroSumado=menor;
			
			// Ahora necesitamos un "listado" de todos los números que queremos sumar.
			// Definimos un bucle for que se repetirá tantas veces como números a sumar tenemos (la cantidad de
			// números que hay entre el número menor y el mayor, ambos incluidos). A CADA ITERACIÓN del bucle,
			// primero añadimos al arrayList "numeros" el valor que EN ESE MOMENTO esté guardado en la variable
			// "numeroSumado", y justo después de eso, incrementamos el valor almacenado en "numneroSumado" en "1".
			// Y así sucesivamente, un total de "intervalo" veces (con esto, obtenemos un array que contiene 
			// todos los números entre menor y mayor, ambos incluidos).
			for (int i=0; i<intervalo; i++) {
				numeros.add(numeroSumado);
				numeroSumado++;
			}
			
			// Como información, imprimimos en pantalla los datos que tenemos hasta ahora:
			System.out.println("Entre el número " + menor + " y el número " + mayor + " hay un total de " + intervalo + " números, que son los siguientes:");
			System.out.println(numeros);
			
			// Finalmente, para obtener el sumatorio que nos piden, declaramos una nueva variable de tipo "int"
			// llamada "sumatorio" y le asignamos el valor del primer elemento del "arrayList" llamado "numeros":
			int sumatorio=numeros.get(0);
			
			// Mediante un bucle for, vamos "REASIGNANDO" el valor de la variable sumatorio, de forma que a cada
			// iteración del bucle, el valor almacenado en la variable "sumatorio" se actualizará y pasará a ser
			// el que tenía hasta ese momento, más el siguiente valor contenido en el "arrayList" llamado 
			// "numeros" (el número de iteraciones de este bucle será el número de números a sumar):
			for (int i=1; i<intervalo; i++) {
				sumatorio+=numeros.get(i);
			}

			// Imprimimos los datos del sumatorio en consola:
			System.out.println("La suma total de todos ellos es " + sumatorio);
			System.out.println("Fin del programa: OK");
		}
		
		// Cerramos el objeto Scanner:
		entrada.close();
		
	} // Final método main
} // Final clase App
