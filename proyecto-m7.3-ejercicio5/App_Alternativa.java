// Módulo 7.3 - Ejercicio 6
// En esta versión hemos sustituido los dos métodos para extraer los ArrayList de pares
// y de impares, por uno solo, que extrae ambos, y devuelve uno de los dos, en función
// del segundo parámetro que recibe.

import java.util.Scanner;
import java.util.ArrayList;

public class App_Alternativa {

	public static void main(String[] args) {
		
		// Generamos un ArrayList de "n" números aleatorios entre 1 y 100
		byte tamanoArray = pedirByte("¿Cuántos elementos quieres que tenga el ArrayList de ejemplo?");
		ArrayList<Byte> arrayAleatorio = crearArrayEjemplo(tamanoArray);
		
		// Extraemos dos subArrayList del ArrayList principal, uno de números pares
		// y el otro de números impares
		ArrayList<Byte> subArrayPares = extraerSubArrays(arrayAleatorio, 's');
		ArrayList<Byte> subArrayImpares = extraerSubArrays(arrayAleatorio, 'n');
		
		// Llamamos al método suma dos veces: la primera le pasamos el subArrayList de
		// números pares, para que nos devuelva la suma de los mismos, y luego hacemos
		// lo mismo con el subArrayList de números impares
		int sumaPares = suma(subArrayPares);
		int sumaImpares = suma(subArrayImpares);
		
		// Imprimimos resultados
		impresion(sumaPares, sumaImpares);
		
		// SOLO PARA VERIFICACIÓN DE RESULTADOS. NO AFECTA AL PROGRAMA
		System.out.println("Este es tu ArrayList de ejemplo:");
		System.out.println(arrayAleatorio);
		System.out.println("Pares: " + subArrayPares);
		System.out.println("Impares: " + subArrayImpares);
		
		
	} // Fin del método main
	
	// -----------------------------------------------------------------------
	
	// RESTO DE MÉTODOS
	
	// Método para pedir un byte (para solicitar la cantidad de elementos que tendrá el
	// ArrayList de ejemplo aleatorio)
	static byte pedirByte(String msg) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		return entrada.nextByte();
	}
	
	// Método para generar un número aleatorio entre 1 y 100
	static byte generarAleatorio() {
		return (byte) Math.ceil(Math.random()*100);
	}

	// Método para crear un ArrayList de "n" numeros aleatorios
	static ArrayList<Byte> crearArrayEjemplo (byte paramTamanoArray){
		ArrayList<Byte> arrayEjemplo = new ArrayList<Byte>();
		byte numAleatorio;
		for (int i=0; i<paramTamanoArray; i++) {
			numAleatorio = generarAleatorio();
			arrayEjemplo.add(numAleatorio);
		}
		return arrayEjemplo;
	}
	
	// Método para determinar si un número es par o impar
	static boolean esPar(byte numEvaluado) {
		return numEvaluado%2==0;
	}
	
	// Método para recorrer un ArrayList de "n" números y extraer dos ArrayList
	// (pares e impares), y devuelve uno de ellos en función de un dato de tipo
	// char pasado en el segundo parámetro ('s' devuelve par, 'n' devuelve impar)
	static ArrayList<Byte> extraerSubArrays(ArrayList<Byte> listaNums, char paramTipo){
		// Declaración de variables del método;
		int tamanoArray = listaNums.size();
		ArrayList<Byte> subArrayPares = new ArrayList<>();
		ArrayList<Byte> subArrayImpares = new ArrayList<>();
		ArrayList<Byte> subArrayDevuelto = new ArrayList<>();
		// Separación de ArrayList según pares e impares:
		for (int indice=0; indice<tamanoArray; indice++) {
			byte numEvaluado = listaNums.get(indice);
			if (esPar(numEvaluado)) {
				subArrayPares.add(numEvaluado);
			} else {
				subArrayImpares.add(numEvaluado);
			}
		}
		// Selección del ArrayList a devolver según valor tipo pasado en segundo parámetro:
		switch (paramTipo) {
		case 's':
			subArrayDevuelto=subArrayPares;
			break;
		case 'n':
			subArrayDevuelto=subArrayImpares;
			break;
		//default:
		//	break;
		}
		return subArrayDevuelto;
	}
	
	// Método para sumar "n" números de un ArrayList de números
	static int suma(ArrayList<Byte> listaNums) {
		int tamanoArray = listaNums.size();
		int suma=0;
		for (int indice=0; indice<tamanoArray; indice++) {
			suma+=listaNums.get(indice);
		}
		return suma;
	}
	
	// Método para imprimir los resultados en consola
	static void impresion(int paramSumaPares, int paramSumaImpares) {
		System.out.println("La suma de los números pares es " + paramSumaPares);
		System.out.println("La suma de los números impares es " + paramSumaImpares);
	}
	
} // Fin clase App
