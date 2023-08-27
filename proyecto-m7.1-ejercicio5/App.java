// Módulo 7.1 - Ejercicio 5 (más genérico)

import java.util.Scanner;
import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		
		int numParElegido = pedirIntPar("Introduce un número entero positivo que sea par:", "El número introducido no es par. Prueba de nuevo:");
		ArrayList<Integer> listaNumerosPares = listaPares(numParElegido);
		char ordenImpresion = pedirOrden("Selecciona orden de impresion: (a:ascendente)/(d:descendente)", "Opción incorrecta. Prueba de nuevo");
		impresionOrdenada(listaNumerosPares, ordenImpresion);
		
		 // CÓDIGO RESUMIDO EQUIVALENTE:
		//impresionOrdenada(listaPares(pedirIntPar("Introduce un número entero que sea par:", "El número introducido no es par. Prueba de nuevo:")), pedirOrden("Selecciona orden de impresion: (a:ascendente)/(d:descendente)", "Opción incorrecta. Prueba de nuevo"));

	} // Fin método main
	
	// -------------------------------------------------------------------------------------
	
	// RESTO DE MÉTODOS
	
	// método para pedir int
	static int pedirInt(String paramMensaje) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(paramMensaje);
		return entrada.nextInt();
	}
	
	// método para validar si un int es par
	static boolean esPar(int paramNum) {
		return paramNum%2==0;
	}
	
	// método para pedir int que sea par
	static int pedirIntPar(String paramMensaje1, String paramMensaje2) {
		int numPar = pedirInt(paramMensaje1);
		while (esPar(numPar)==false) {
			numPar=pedirInt(paramMensaje2);
		}
		return numPar;
	}
	
	// método para crear ArrayList de números (desde 0 hasta número elegido)
	static ArrayList<Integer> listaPares(int paramNumPar){ // Método que "crea" y devuelve lista de números pares
		ArrayList<Integer> listaNumsPares = new ArrayList<>();
		for (int i=2; i<=paramNumPar; i+=2) {
			listaNumsPares.add(i);
		}
		return listaNumsPares;
	}
	
	// método para pedir char
	static char pedirChar(String paramMensaje) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(paramMensaje);
		return entrada.next().toLowerCase().charAt(0);
	}

	// método para validar que un char sea: 'a' o 'd'
	static boolean esOpcionCorrecta (char paramOpcion) {
		return (paramOpcion=='a'||paramOpcion=='d');
	}
	
	// método para pedir y devolver un char que sea: 'a' o 'd'
	static char pedirOrden(String paramMensaje1, String paramMensaje2) {
		char ordenCorrecto = pedirChar(paramMensaje1);
		while (esOpcionCorrecta(ordenCorrecto)==false) {
			ordenCorrecto = pedirChar(paramMensaje2);
		}
		return ordenCorrecto;
	}
	
	// metodo para recorrer/imprimir un array según un orden (ascendente/descendente)
	static void impresionOrdenada(ArrayList<Integer> paramListaPares, char paramOrden) { // Método que imprime la lista ordenada según el orden ascendente o descendente establecido previamente
		switch (paramOrden) {
			case 'a':
				for (int i=0; i<paramListaPares.size(); i++) {
					System.out.println(paramListaPares.get(i));	
				}
				break;
			case 'd':
				for (int i=paramListaPares.size()-1; i>=0; i--) {
					System.out.println(paramListaPares.get(i));	
				}
				break;
			//default: => En este caso, no es necesario
				//break;
		}
	}
	
} // Fin Clase AppGenérica