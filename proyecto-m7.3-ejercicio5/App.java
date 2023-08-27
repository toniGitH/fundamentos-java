// Módulo 7.3 - Ejercicio 6

import java.util.Scanner;
import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		
		// Generamos un ArrayList de "n" números aleatorios entre 1 y 100
		byte tamanoArray = pedirByte("¿Cuántos elementos quieres que tenga el ArrayList de ejemplo?");
		ArrayList<Byte> arrayAleatorio = crearArrayEjemplo(tamanoArray);
		
		// Extraemos dos subArrayList del ArrayList principal, uno de números pares
		// y el otro de números impares
		ArrayList<Byte> subArrayPares = extraePares(arrayAleatorio);
		ArrayList<Byte> subArrayImpares = extraeImpares(arrayAleatorio);
		
		// Llamamos al método suma dos veces: la primera le pasamos el subArrayList de
		// números pares, para que nos devuelva la suma de los mismos, y luego hacemos
		// lo mismo con el subArrayList de números impares
		int sumaPares = suma(subArrayPares);
		int sumaImpares = suma(subArrayImpares);
		
		// Imprimimos resultados
		impresion(sumaPares, sumaImpares);
		
		// SOLO PARA VERIFICACIÓN DE RESULTADOS
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
	
	// Método para recorrer un ArrayList de "n" números y extraer los pares
	static ArrayList<Byte> extraePares(ArrayList<Byte> listaNums){
		int tamanoArray = listaNums.size();
		ArrayList<Byte> subArrayPares = new ArrayList<>();
		for (int indice=0; indice<tamanoArray; indice++) {
			byte numEvaluado = listaNums.get(indice);
			if (esPar(numEvaluado)) {
				subArrayPares.add(numEvaluado);
			}
		}
		return subArrayPares;
	}
	
	// Método para recorrer un ArrayList de "n" números y extraer los pares
	static ArrayList<Byte> extraeImpares(ArrayList<Byte> listaNums){
		int tamanoArray = listaNums.size();
		ArrayList<Byte> subArrayImpares = new ArrayList<>();
		for (int indice=0; indice<tamanoArray; indice++) {
			byte numEvaluado = listaNums.get(indice);
			if (esPar(numEvaluado)==false) {
				subArrayImpares.add(numEvaluado);
			}
		}
		return subArrayImpares;
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
