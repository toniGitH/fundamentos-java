// Módulo 7.1 - Ejercicio 7

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		byte lado = pedirByte("Introduce un número. Será el lado del cuadrado.");
		char relleno = pedirChar("Introduce un carácter. Será el relleno del cuadrado.");
		String linea = pintarLinea(lado, relleno);
		pintarCuadrado(lado, linea);
		
		// CÓDIGO RESUMIDO EQUIVALENTE:
		// No se puede reducir más, porque las variables "lado" y "relleno" se usan
		// más de una vez
		
	} // Fin del método main
	
	// ------------------------------------------------------------------------------------

	// RESTO DE MÉTODOS
	
	// método para pedir byte => lado del cuadrado
	static byte pedirByte(String mensaje) { 
		Scanner entrada = new Scanner(System.in);
		System.out.println(mensaje);
		return entrada.nextByte();
	}
	
	 // método para pedir char => relleno del cuadrado
	static char pedirChar(String mensaje) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(mensaje);
		return entrada.next().charAt(0);
	}
	
	// método para pintar línea
	static String pintarLinea(byte paramLado, char paramRelleno) { 
		String fila="";
		for (int j=1; j<=paramLado; j++) {
			fila+=paramRelleno + " ";
		}
		return fila;
	}
	
	//método para pintar el cuadrado, utilizando las filas que ya tenemos de otro método
	static void pintarCuadrado(byte paramLado, String fila) { 
		for (int i=1; i<=paramLado; i++) {
			System.out.println(fila);
		}
	}
	
	// ---------- ALTERNATIVA ----------
	
	// El método pintarCuadrado se podría dividir en 2 métodos. En este caso, las llamadas
	// que se hacen en el main cambiarían.
	
	// método para pintar el cuadrado
		/*static void pintarCuadrado(byte paramLado, char paramRelleno) {	
			for (int i=1; i<=paramLado; i++) {
				for (int j=1; j<=paramLado; j++) {
					System.out.print(" " + paramRelleno);
				}
				System.out.println();
			}
		}*/
	
} // Final clase App
