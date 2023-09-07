// Módulo 8 - Ejercicio 2

import java.util.Scanner;
import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		
		// DECLARACIÓN DE VARIABLES NECESARIAS
		// NOTA: Estas variables se pueden omitir modificando algunas llamadas dentro de la estructura
		// "switch" que hay más adelante, pero en esta versión no las he eliminado para entender mejor
		// todo el código del programa "paso a paso"
		String nombreHotel; // Ver NOTA
		int numHabitaciones; // Ver NOTA
		int numPlantas; // Ver NOTA
		int superficie; // Ver NOTA
		ArrayList<Hotel> listaHoteles = new ArrayList<Hotel>(); // ArrayList que almacena los objetos de tipo Hotel que vamos creando
		int posicionHotelEnArray; // Almacenará la posición que un objeto concreto de tipo Hotel ocupa en el ArrayList 
		byte opcionMenuElegida; // Almacenará la opción del menú principal elegida por el usuario
		char repetir='n'; // Almacenará la respuesta a si el usuario quiere hacer o no otra
						  // operación después de ejecutarse cualquiera de las 4 opciones del
						  // menú principal (crear, borrar, ver o modificar)
		
		// MENÚ PRINCIPAL
		// Código que controla el funcionamiento del menú principal: imprimirlo en consola,
		// repetir indefinidamente si se elige una opción que no es una de las 5 posibles,
		// salir del programa si se elige la opción (0) y volver a mostrar el menú principal
		// si tras la ejecución de una de las 4 opciones (que no sean la de salir), el usuario
		// contesta que sí quiere hacer otra operación:
		
		do {
			do {
				menuPrincipal();
				opcionMenuElegida = pedirByte("Elige una opción:");
				if (esOpcionMenuValida(opcionMenuElegida)==false) {
					System.out.println("Esa opción no existe. Inténtalo de nuevo.");
				}
			} while (esOpcionMenuValida(opcionMenuElegida)==false);
			
			// Al salir de doWhile interno, el valor de "opciónMenuElegida" SOLO puede ser 0,
			// 1, 2, 3, ó 4.
			// Si el usuario elige el 0, el programa finaliza.
			// Si el usuario elige del 1 al 4, se ejecuta el "case" correspondiente, que hace
			// de selector entre las 4 opciones principales que no son la (0) y tras finalizar
			// el "case", se pregunta al usuario si quiere hacer otra operación. Si el usuario
			// contesta que sí, el menú principal se repite (gracias al doWhile externo), pero
			// si contesta que no, el programa acaba.
			if (opcionMenuElegida!=0) {
				switch (opcionMenuElegida) {
					case 1: // Crear Hotel
						nombreHotel = pedirString("Introduce el nombre del Hotel a crear:");
						numHabitaciones = pedirInt("Introduce el número de habitaciones del Hotel a crear:");
						numPlantas = pedirInt("Introduce el número de plantas del Hotel a crear:");
						superficie = pedirInt("Introduce la superficie, en metros cuadrados, del Hotel a crear:");
						Hotel hotel = crearHotel(nombreHotel, numHabitaciones, numPlantas, superficie);
						listaHoteles.add(hotel);
						break;
					case 2: // Eliminar Hotel
						nombreHotel = pedirString("Introduce el nombre del Hotel a eliminar:");
						posicionHotelEnArray = buscarIndiceDeHotel(listaHoteles, nombreHotel);
						eliminarHotel(listaHoteles, posicionHotelEnArray);
						break;
					case 3: // Ver Hotel
						nombreHotel = pedirString("Introduce el nombre del Hotel a consultar:");
						posicionHotelEnArray = buscarIndiceDeHotel(listaHoteles, nombreHotel);
						verHotel(listaHoteles, posicionHotelEnArray);
						break;
					case 4: // Modificar Hotel
						nombreHotel = pedirString("Introduce el nombre del Hotel a modificar:");
						posicionHotelEnArray = buscarIndiceDeHotel(listaHoteles, nombreHotel);
						modificarHotel(listaHoteles, posicionHotelEnArray);
						break;
					//default: NO NECESARIO
					//  break; NO NECESARIO
				}				
				repetir = pedirChar("¿Quieres hacer otra operación (s/n)?");
			}
		} while (repetir=='s' && opcionMenuElegida!=0);
		
		System.out.println("Fin del programa");
		
	} // Fin método main
	
	// ----------------------------------------------------------------------------------
	
	// RESTO DE MÉTODOS
	
	// Método para pedir un dato de tipo int
	static int pedirInt (String msg) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		return entrada.nextInt();
	}
	
	// Método para pedir un dato de tipo byte
	static byte pedirByte (String msg) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		return entrada.nextByte();
	}
	
	// Método para pedir un dato de tipo String
	static String pedirString(String msg) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		return entrada.nextLine();
	}
	
	// Método para pedir un dato de tipo char
	static char pedirChar(String msg) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		return entrada.next().toLowerCase().charAt(0);
	}
	
	// Método que imprime en consola el Menu Principal
	static void menuPrincipal() {
		System.out.println("PROGRAMA HOTELES");
		System.out.println("");
		System.out.println("(1)- Crear Hotel");
		System.out.println("(2)- Eliminar Hotel");
		System.out.println("(3)- Ver Hotel");
		System.out.println("(4)- Modificar Hotel");
		System.out.println("(0)- Salir del programa");
	}
	
	// Método para validar elección correcta en Menú principal
	static boolean esOpcionMenuValida(byte opcionMenuElegida) {
		return (opcionMenuElegida>=0 && opcionMenuElegida<=4);
	}
	
	// Método para buscar un elemento en un array
	static int buscarIndiceDeHotel(ArrayList<Hotel> listaHoteles, String nombreHotel) {
		int indiceHoteles=0;
		String nombreEvaluado;
		int indiceBuscado=-1;
		if (listaHoteles.size()==0) {
			indiceBuscado=-1;
		} else {
			do {
				nombreEvaluado = listaHoteles.get(indiceHoteles).getNombreHotel();
				if (nombreEvaluado.equalsIgnoreCase(nombreHotel)) {
					indiceBuscado=indiceHoteles;
				} else {
					indiceHoteles++;
				}
			} while (nombreEvaluado.equalsIgnoreCase(nombreHotel)==false && indiceHoteles<listaHoteles.size());
		}
		
		return indiceBuscado;
	}
	
	// Método para Crear Hotel (opción 1)
	static Hotel crearHotel(String nombreHotel, int numHabitaciones, int numPlantas, int superficie) {
		Hotel hotel = new Hotel(nombreHotel, numHabitaciones, numPlantas, superficie);
		return hotel;
	}
	
	// Método para Eliminar Hotel (opción 2)
	static void eliminarHotel(ArrayList<Hotel> listaHoteles, int indiceHotel) {
		if (indiceHotel==-1) {
			System.out.println("Ese Hotel no está registrado en la aplicación");
		} else {
			listaHoteles.remove(indiceHotel);
			System.out.println("El Hotel ha sido eliminado de la aplicación");
		}
	}
	
	// Método para Ver Hotel (opción 3)
	static void verHotel(ArrayList<Hotel> listaHoteles, int indiceHotel) {
		if (indiceHotel==-1) {
			System.out.println("Ese Hotel no está registrado en la aplicación");
		} else {
			System.out.println("Estos son los datos del HOTEL " + listaHoteles.get(indiceHotel).getNombreHotel() + ":");
			System.out.println("Número de habitaciones: " + listaHoteles.get(indiceHotel).getNumHabitaciones());
			System.out.println("Número de plantas: " + listaHoteles.get(indiceHotel).getNumPlantas());
			System.out.println("Superficie total: " + listaHoteles.get(indiceHotel).getSuperficie());
			listaHoteles.get(indiceHotel).calcularMantenimiento();
		}
	}
	
	// Método para Modificar Hotel (opción 4)
	static void modificarHotel(ArrayList<Hotel> listaHoteles, int indiceHotel) {
		char modificar='n';
		int nuevoValor;
		if (indiceHotel==-1) {
			System.out.println("Ese Hotel no está registrado en la aplicación");
		} 
		else {
			modificar = pedirChar("¿Quieres modificar el número de habitaciones (s/n)?");
			if (modificar=='s') {
				nuevoValor = pedirInt("Introduce el nuevo número de habitaciones:");
				listaHoteles.get(indiceHotel).setNumHabitaciones(nuevoValor);
			}
			modificar = pedirChar("¿Quieres modificar el número de plantas (s/n)?");
			if (modificar=='s') {
				nuevoValor = pedirInt("Introduce el nuevo número de plantas:");
				listaHoteles.get(indiceHotel).setNumHabitaciones(nuevoValor);
			}
			modificar = pedirChar("¿Quieres modificar la superficie del hotel (s/n)?");
			if (modificar=='s') {
				nuevoValor = pedirInt("Introduce el nuevo valor de superficie:");
				listaHoteles.get(indiceHotel).setNumHabitaciones(nuevoValor);
			}
			System.out.println("Las modificaciones se han realizado con éxito");
		}
	}

} // FIN DE LA CLASE APP
