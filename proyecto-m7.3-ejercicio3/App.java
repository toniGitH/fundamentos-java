// Módulo 7.3 - Ejercicio 3

import java.util.Scanner;
import java.util.ArrayList;

public class App {

	public static void main(String[] args) {

		//String frase = pedirString("Escribe una palabra o frase");
		//ArrayList<Character> arrayFrase = crearArrayChars(frase);
		//impresion(sonIguales(arrayFrase));
		
		// CÓDIGO RESUMIDO EQUIVALENTE
		impresion(sonIguales(crearArrayChars(pedirString("Escribe una palabra o frase"))));
		
	} // Fin del método main
	
	// ------------------------------------------------------------------------------
	
	// RESTO DE MÉTODOS

	// método para pedir un String
	static String pedirString(String msg) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		return entrada.nextLine();
	}
	
	// método para extraer los caracteres de un String y meterlos en un ArrayList todos en minusculas
	static ArrayList<Character> crearArrayChars(String paramString){
		ArrayList<Character> arrayCaracteres = new ArrayList<Character>();
		int longitudFrase = paramString.length();
		for (int i=0; i<longitudFrase; i++) {
			char caracterIn = paramString.toLowerCase().charAt(i);
			arrayCaracteres.add(caracterIn);
		}
		return arrayCaracteres;
	}
	
	// método para extraer caracteres de un ArrayList y colocarlos en otro, al revés
	static ArrayList<Character> reverseArrayChars(ArrayList<Character> paramArrayChars){
		ArrayList<Character> arrayCaracteresReverse = new ArrayList<Character>();
		int longitudArray = paramArrayChars.size();
		for (int i=longitudArray-1; i>=0; i--) {
			char caracterOut = paramArrayChars.get(i);
			arrayCaracteresReverse.add(caracterOut);
		}
		return arrayCaracteresReverse;
	}
	
	// método para comparar dos ArrayList
	static boolean sonIguales(ArrayList<Character> paramArray) {
		return paramArray.equals(reverseArrayChars(paramArray));
	}
	
	// método para imprimir resultados
	static void impresion(boolean paramSonIguales) {
		if (paramSonIguales) {
			System.out.println("Has escrito un palíndromo");
		} else {
			System.out.println("No has escrito un palíndromo");
		}
	}
	
	// método para mostrar en cosola un ArrayList elemento a elemento (No se usa en este ejemplo)
	/*static void imprimirArray (ArrayList<Character> paramArrayChars) {
		int longitudArray = paramArrayChars.size();
		for (int i=0; i<longitudArray; i++) {
			System.out.print(paramArrayChars.get(i));
		}
	}*/
	
} // Fin de la clase App
