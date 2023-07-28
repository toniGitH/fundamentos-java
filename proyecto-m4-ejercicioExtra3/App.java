// Módulo 4 - Ejercicio Extra 2

import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
		
		// Creamos un array con los elementos del juego y el resto de variables que vamos a necesitar:
		String[] elementos = {"piedra", "papel", "tijeras"};
		int opcion, aleatorio;
		String mensaje="";

		// Creamos un objeto de tipo "Scanner" y lo almacenamos en una variable de tipo "Scanner" llamada "entrada":
		
		Scanner entrada = new Scanner(System.in);

		// Imprimimos mensajes informativos en consola:
		
		System.out.println("Juguemos a Piedra, Papel o Tijera");
		System.out.println();
		System.out.println("1. Piedra");
		System.out.println();
		System.out.println("2. Papel");
		System.out.println();
		System.out.println("3. Tijeras");
		System.out.println();
		System.out.println("Elige una opción (1, 2 ó 3)");
		
		// Declaramos una variable de tipo "int" llamada "opcion" y en ella almacenamos el valor de lo que el
		// usuario ha escrito por consola:
		opcion = entrada.nextInt(); // Aquí almacenamos la "jugada" del usuario.
		
		// Condicional if/else para decidir si el usuario quiere jugar o no:
		
		if (opcion<1 || opcion>3) { // Esto significa que el jugador NO quiere jugar. Imprimirá el "syso" y fin del programa
			
			System.out.println("Entiendo que no quieres jugar. ¡¡Adiós!!");
			
		} else { // Esto significa que el jugador SI quiere jugar. Ejecutará lo que hay dentro (ejecución del juego)
			
			// Como el usuario quiere jugar, primero generamos la "jugada" de la máquina (el número aleatorio entre 1 y 3):
			aleatorio = (int)(Math.random()*3)+1;
			
			// Ya tenemos almacenadas en 2 variables de tipo "int" las jugadas de la máquina ("aleatorio") y del usuario ("opcion")
						
			// Con un switch, para cada uno de los 3 posibles valores que puede almacenar la variable "opcion" (1, 2 ó 3),
			// evaluamos las 3 posibilidades que pueden darse según el valor aleatorio guardado en la variable "aleatorio":
			switch (opcion) {
			
				case 1: // El usuario ha escrito el 1 (piedra)
					if (aleatorio==2) { // La máquina ha elegido 2 (papel)
						mensaje = "¡¡Lo siento, he ganado yo!!"; // El papel gana a la piedra
					} else if (aleatorio==3) { // La máquina ha elegido 3 (tijeras)
						mensaje = "¡¡Enhorabuena, has ganado!!"; // La piedra gana a las tijeras
					} else { // La máquina ha elegido 1 (piedra)
						mensaje = "¡¡Empate!!"; // Empate
					}
					break;
					
				case 2:
					if (aleatorio==2) {
						mensaje = "¡¡Empate!!";
					} else if (aleatorio==3) {
						mensaje = "¡¡Lo siento, he ganado yo!!";
					} else {
						mensaje = "¡¡Enhorabuena, has ganado!!";
					}
					break;
					
				case 3:
					if (aleatorio==2) {
						mensaje = "¡¡Enhorabuena, has ganado!!";
					} else if (aleatorio==3) {
						mensaje = "¡¡Lo siento, he ganado yo!!";
					} else {
						mensaje = "¡¡Empate!!";
					}
					break;
					
			} // Final switch
			
			// Imprimimos en consola el resultado, utilizando los valores del array y las variables anteriores:
			System.out.println("Yo " + elementos[aleatorio-1] + " y tu " + elementos[opcion-1] + ". " + mensaje);
			
		} // Final condicional if/else
		
		// Cerramos el objeto Scanner
		entrada.close();
		
	} // Final método main

} // Final clase App
