// Módulo 8 - Ejercicio 2 (Versión 4)

import java.util.Scanner;
import java.util.ArrayList;

public class App {

	public static void main(String[] args) {
		
		// DECLARACIÓN DE VARIABLES NECESARIAS
		
		ArrayList<Hotel> listaHoteles = new ArrayList<Hotel>(); // ArrayList que almacena los objetos de tipo Hotel que vamos creando
		int posicionHotelEnArray; // Almacenará la posición que un objeto concreto de tipo Hotel ocupa en el ArrayList 
		byte opcionMenuElegida; // Almacenará la opción del menú principal elegida por el usuario
		char repetir='n'; // Almacenará la respuesta a si el usuario quiere hacer o no otra operación
		Hotel nh = new Hotel("NH", 300, 3, 1200);

		// MENÚ PRINCIPAL
		
		do {
			
			do {
				menuPrincipal();
				opcionMenuElegida = pedirByte("Elige una opción:");
				if (esOpcionMenuValida(opcionMenuElegida)==false) {
					System.out.println("Esa opción no existe. Inténtalo de nuevo.");
				}
			} 
			while (esOpcionMenuValida(opcionMenuElegida)==false);
			
			if (opcionMenuElegida!=0) {
				switch (opcionMenuElegida) {
					case 1: // Crear Hotel
						String nombreHotel = pedirString("Introduce el nombre del Hotel a crear:");
						posicionHotelEnArray = buscarIndiceDeHotel(listaHoteles, nombreHotel);
						if (existeHotel(posicionHotelEnArray)) {
							System.out.println("El Hotel que estás creando ya existe.");
						} else {
							Hotel hotel = crearHotel(nombreHotel,
													 pedirIntPositivo("Introduce el número de habitaciones del Hotel a crear:"),
													 pedirIntPositivo("Introduce el número de plantas del Hotel a crear:"),
													 pedirIntPositivo("Introduce la superficie, en metros cuadrados, del Hotel a crear:")
													);
							listaHoteles.add(hotel);
							System.out.println("El Hotel se ha creado con éxito.");
						}
						break;
					case 2: // Eliminar Hotel
						posicionHotelEnArray = buscarIndiceDeHotel(listaHoteles, 
																pedirString("Introduce el nombre del Hotel a eliminar:")
												);
						eliminarHotel(listaHoteles, posicionHotelEnArray);
						break;
					case 3: // Ver Hotel
						posicionHotelEnArray = buscarIndiceDeHotel(listaHoteles, 
																   pedirString("Introduce el nombre del Hotel a consultar:")
												);
						verHotel(listaHoteles, posicionHotelEnArray);
						break;
					case 4: // Modificar Hotel
						posicionHotelEnArray = buscarIndiceDeHotel(listaHoteles,
																   pedirString("Introduce el nombre del Hotel a modificar:")
												);
						modificarHotel(listaHoteles, posicionHotelEnArray);
						break;
					case 5: // Listar Hoteles
						listarHoteles(listaHoteles);
						break;
					//default: NO NECESARIO
					//  break; NO NECESARIO
				}				
				repetir = pedirChar("¿Quieres hacer otra operación (s/n)?");
			}
			
		} // Cierre del primer "do"
		while (repetir=='s' && opcionMenuElegida!=0);
		
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
	
	// Método para determinar si un número es positivo (>0)
	static boolean esPositivo(int valor) {
		return valor>0;
	}
	
	// Método para pedir un dato de tipo int que sea positivo
	static int pedirIntPositivo (String msg) {
		Scanner entrada = new Scanner(System.in);
		int nuevoValor;		
		do {
			nuevoValor = pedirInt(msg);
			if (esPositivo(nuevoValor)==false) {
				System.out.println("El valor introducido no es válido. Debe ser un valor positivo.");
			} 
		} while (esPositivo(nuevoValor)==false);
		
		return nuevoValor;
	}
	
	// Método que imprime en consola el Menu Principal
	static void menuPrincipal() {
		System.out.println("PROGRAMA HOTELES");
		System.out.println("");
		System.out.println("(1)- Crear Hotel");
		System.out.println("(2)- Eliminar Hotel");
		System.out.println("(3)- Ver Hotel");
		System.out.println("(4)- Modificar Hotel");
		System.out.println("(5)- Lista de Hoteles");
		System.out.println("(0)- Salir del programa");
	}
	
	// Método para validar elección correcta en Menú principal
	static boolean esOpcionMenuValida(byte opcionMenuElegida) {
		return (opcionMenuElegida>=0 && opcionMenuElegida<=5);
	}
	
	// Método para buscar un elemento en un array
	static int buscarIndiceDeHotel(ArrayList<Hotel> listaHoteles, String nombreHotel) {
		int indiceHotel=0;
		String nombreEvaluado;
		int indiceBuscado=-1;
		boolean hotelEncontrado=false;
		
		if (listaHoteles.size()==0) {
			indiceBuscado=-1;
		}
		else {
			do {
				nombreEvaluado = listaHoteles.get(indiceHotel).getNombreHotel();
				if (nombreEvaluado.equalsIgnoreCase(nombreHotel)) {
					indiceBuscado=indiceHotel;
					hotelEncontrado=true;
				} else {
					indiceHotel++;
				}
			}
			while (hotelEncontrado==false && indiceHotel<listaHoteles.size());
		}
		
		return indiceBuscado;
	}
	
	// Método para validar si el nombre de un hotel ya existe
	static boolean existeHotel(int indiceBuscado) {
		return indiceBuscado!=-1;
	}
	
	// Método para Crear Hotel (opción 1)
	static Hotel crearHotel(String nombreHotel, int numHabitaciones, int numPlantas, int superficie) {
		return new Hotel(nombreHotel, numHabitaciones, numPlantas, superficie);
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
				nuevoValor=pedirIntPositivo("Introduce el nuevo número de habitaciones");
				listaHoteles.get(indiceHotel).setNumHabitaciones(nuevoValor);
			}
			modificar = pedirChar("¿Quieres modificar el número de plantas (s/n)?");
			if (modificar=='s') {
				nuevoValor=pedirIntPositivo("Introduce el nuevo número de plantas");
				listaHoteles.get(indiceHotel).setNumPlantas(nuevoValor);
			}
			modificar = pedirChar("¿Quieres modificar la superficie del hotel (s/n)?");
			if (modificar=='s') {
				nuevoValor=pedirIntPositivo("Introduce la nueva superficie");
				listaHoteles.get(indiceHotel).setSuperficie(nuevoValor);
			}
			System.out.println("Las modificaciones se han realizado con éxito");
		}
	}
	
	// Método para Listar Hoteles (opcion 5)
	static void listarHoteles(ArrayList<Hotel> listaHoteles) {
		if (listaHoteles.size()==0) {
			System.out.println("No se han encontrado registros");
		}
		else {
			System.out.println("Estos son todos los Hoteles registrados actualmente en la aplicación");
			for (int indice=0; indice<listaHoteles.size(); indice++) {
				System.out.println(listaHoteles.get(indice));
			}
		}
	}

} // FIN DE LA CLASE APP
