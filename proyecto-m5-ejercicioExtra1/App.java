// Módulo 5 - Ejercicio Extra 1

import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		// DECLARACIÓN DE VARIABLES
		Scanner entrada = new Scanner(System.in);
		short eleccionUsuario, aleatorio, diferencia;
		
		// Generación del número aleatorio entre 1 y 500
		aleatorio = (short)(Math.ceil(Math.random()*500));
		System.out.println("Control: " + aleatorio);
		
		System.out.println("Adivina el número: escribe un número entero entre 1 y 500.");

		do {
			eleccionUsuario = entrada.nextShort();
			
			diferencia = diferencia(aleatorio, eleccionUsuario);
			
			if (diferencia==0) {
				System.out.println("¡¡Correcto!!");
			} 
			else {
				if (diferencia>0) {
					if (diferencia<15) {
						System.out.println("Caliente. El número que buscas es mayor.");
					} 
					else if (diferencia<50){
						System.out.println("Templado. El número que buscas es mayor.");
					} 
					else {
						System.out.println("Frío. El número que buscas es mayor.");
					}
				} 
				else {
					diferencia=(short)(diferencia*(-1));
					if (diferencia<15) {
						System.out.println("Caliente. El número que buscas es menor.");
					}
					else if (diferencia<50){
						System.out.println("Templado. El número que buscas es menor.");
					}
					else {
						System.out.println("Frío. El número que buscas es menor.");
					}
				}
				System.out.println("Prueba de nuevo.");
			}
		} while (diferencia!=0);
		
		entrada.close();
	} // Fin del método main
	
	// RESTO DE MÉTODOS
	
	// Método para determinar la diferencia entre el número aleatorio y el
	// propuesto por el usuario
	
	static short diferencia(short aleatorio, short eleccionUsuario) {
		
		return (short)(aleatorio-eleccionUsuario);
	}

}
