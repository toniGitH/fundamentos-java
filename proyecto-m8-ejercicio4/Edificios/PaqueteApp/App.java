// Módulo 8 - Ejercicio 4 (Opcion B)

package PaqueteApp;

import java.util.Scanner;
import java.util.ArrayList;
import PaqueteEdificios.*;

public class App {

	public static void main(String[] args) {
		
		// DECLARACIÓN DE VARIABLES NECESARIAS
		
		ArrayList<Edificio> listaEdificios = new ArrayList<Edificio>();
		String tipoEdificio;
		String nombreEdificio;
		int posicionEdificioEnArray; 
		byte opcionMenuElegida; 
		char repetir='n';

		// MENÚ PRINCIPAL
		
		do {
			
			opcionMenuElegida = menuPrincipal();
			
			if (opcionMenuElegida!=0) {
				switch (opcionMenuElegida) {
					case 1: // Crear Edificio
						tipoEdificio = pedirTipoEdificioValido("¿De qué tipo es el edificio que quieres crear (Hospital/Cine/Hotel)?");
						nombreEdificio = (pedirString("Introduce el nombre del " + tipoEdificio + " a crear:")).toUpperCase();
						posicionEdificioEnArray = buscarIndiceDeEdificio(listaEdificios, tipoEdificio , nombreEdificio);
						crearEdificio(posicionEdificioEnArray, listaEdificios, tipoEdificio, nombreEdificio);
						break;
					case 2: // Eliminar Edificio
						tipoEdificio = pedirTipoEdificioValido("¿De qué tipo es el edificio que quieres eliminar (Hospital/Cine/Hotel)?");
						nombreEdificio = (pedirString("Introduce el nombre del " + tipoEdificio + " a eliminar:")).toUpperCase();
						posicionEdificioEnArray = buscarIndiceDeEdificio(listaEdificios, tipoEdificio , nombreEdificio);
						eliminarEdificio(posicionEdificioEnArray, listaEdificios, tipoEdificio);
						break;
					case 3: // Ver Edificio
						tipoEdificio = pedirTipoEdificioValido("¿De qué tipo es el edificio que quieres consultar (Hospital/Cine/Hotel)?");
						nombreEdificio = (pedirString("Introduce el nombre del " + tipoEdificio + " a consultar:")).toUpperCase();
						posicionEdificioEnArray = buscarIndiceDeEdificio(listaEdificios, tipoEdificio , nombreEdificio);
						verEdificio(posicionEdificioEnArray, listaEdificios, tipoEdificio);
						break;
					case 4: // Listar Edificios existentes
						listarEdificios(listaEdificios);
						break;
					//default: // En este caso no lo utilizo
				}				
				repetir = pedirChar("¿Quieres hacer otra operación (s/n)?");
			}
			
		} while (repetir=='s' && opcionMenuElegida!=0);
		
		System.out.println("Fin del programa");
		
	} // Fin método main
	
	// RESTO DE MÉTODOS -----------------------------------------------------------

	// Método que gestiona el Menu Principal
	static byte menuPrincipal() {
		byte opcion;
		do {
			System.out.println("PROGRAMA EDIFICIOS");
			System.out.println("");
			System.out.println("(1)- Crear Edificio");
			System.out.println("(2)- Eliminar Edificio");
			System.out.println("(3)- Ver Edificio");
			System.out.println("(4)- Lista Edificios");
			System.out.println("(0)- Salir del programa");
			opcion = pedirByte("Elige una opción:");
			
			if (opcion<0 || opcion>4) {
				System.out.println("Esa opción no existe. Inténtalo de nuevo.");
				System.out.println();
			}
		} while (opcion<0 || opcion>4);
		
		return opcion;
	}
	
	
	// Método para buscar índice de un elemento en un array de Edificios
	static int buscarIndiceDeEdificio(ArrayList<Edificio> listaEdificios, String tipoEdificio, String nombreEdificio) {
		int indiceEdificio=0;
		String nombreEvaluado, tipoEvaluado;
		int indiceEdificioBuscado=-1;
		boolean edificioEncontrado=false;
		
		if (listaEdificios.size()==0) {
			indiceEdificioBuscado=-1;
		}
		else {
			do {
				nombreEvaluado = listaEdificios.get(indiceEdificio).getNombreEdificio();
				tipoEvaluado = listaEdificios.get(indiceEdificio).getTipoEdificio();
				if (nombreEvaluado.equalsIgnoreCase(nombreEdificio) && tipoEvaluado.equalsIgnoreCase(tipoEdificio)) {
					indiceEdificioBuscado=indiceEdificio;
					edificioEncontrado=true;
				} else {
					indiceEdificio++;
				}
			}
			while (edificioEncontrado==false && indiceEdificio<listaEdificios.size());
		}
		return indiceEdificioBuscado;
	}
	
	// Método para crear un edificio (Opción 1)
	static void crearEdificio(int posicionEdificioEnArray, ArrayList<Edificio> listaEdificios, String tipoEdificio, String nombreEdificio) {
		if (posicionEdificioEnArray>=0) {
			System.out.println("Ese " + tipoEdificio + " ya existe.");
		} 
		else {
			int numPlantas = pedirBytePositivo("¿Cuántas plantas tendrá el " + tipoEdificio + " " + nombreEdificio + " ?");
			int superficie = pedirIntPositivo("¿Qué superficie, en metros cuadrados, tendrá el " + tipoEdificio + " " + nombreEdificio + " ?");
			if (tipoEdificio.equalsIgnoreCase("hospital")) {
				Hospital hospital = new Hospital(tipoEdificio, nombreEdificio, numPlantas, superficie);
				listaEdificios.add(hospital);
			} 
			else if (tipoEdificio.equalsIgnoreCase("cine")) {
				int aforoMax = pedirIntPositivo("¿Cuál será el aforo máximo del " + tipoEdificio + " " + nombreEdificio + "?");
				Cine cine = new Cine(tipoEdificio, superficie, numPlantas, nombreEdificio, aforoMax);
				listaEdificios.add(cine);
			} 
			else if(tipoEdificio.equalsIgnoreCase("hotel")){
				int numHabitaciones = pedirIntPositivo("¿Cuántas habitaciones tendrá el " + tipoEdificio + " " + nombreEdificio + "?");
				Hotel hotel = new Hotel(tipoEdificio, superficie, nombreEdificio, numPlantas, numHabitaciones);
				listaEdificios.add(hotel);
			}
			else{
				System.out.println("No puedes dar de alta un edificio del tipo " + tipoEdificio + ".");
			}
		}
	}
	
	// Método para Eliminar Edificios (opción 2)
	static void eliminarEdificio(int posicionEdificioEnArray, ArrayList<Edificio> listaEdificios, String tipoEdificio) {
		if (posicionEdificioEnArray<0) {
			System.out.println("Ese edificio no se encuentra en la base de datos.");
		} else {
			listaEdificios.remove(posicionEdificioEnArray);
			System.out.println("El edificio se ha dado de baja correctamente.");
		}
	}
	
	// Método para ver un edificio (opción 3)
	static void verEdificio(int posicionEdificioEnArray, ArrayList<Edificio> listaEdificios, String tipoEdificio) {
		if (posicionEdificioEnArray<0) {
			System.out.println("Ese edificio no se encuentra en la base de datos.");
		} else {
			Edificio edificioExtraido = listaEdificios.get(posicionEdificioEnArray);
			switch (tipoEdificio) {
			case "HOSPITAL":
				// CASTEAMOS EL OBJETO EXTRAIDO DEL ARRAY AL TIPO DE OBJETO QUE ES, EN ESTE CASO, HOSPITAL:
				Hospital hospital = (Hospital)edificioExtraido; 
				int enfermos = pedirIntPositivo("¿Cuántos enfermos hay ingresados en este momento?");
				hospital.setEnfermos(enfermos);
				System.out.println("Datos del "+ edificioExtraido.getTipoEdificio() + " " + edificioExtraido.getNombreEdificio() + ":");
				System.out.println(hospital);
				hospital.limpiar();
				hospital.vigilar();
				hospital.repartirAlmuerzo();
				break;
			case "CINE":
				// CASTEAMOS EL OBJETO EXTRAIDO DEL ARRAY AL TIPO DE OBJETO QUE ES, EN ESTE CASO, CINE:
				Cine cine = (Cine)edificioExtraido;
				int asistentes;
				byte precioSesion;
				do {
					asistentes = pedirBytePositivo("¿Cuántos espectadores han asistido a la sesión (Aforo máximo: " + cine.getAforoMax() + " personas)?");
					if (asistentes>cine.getAforoMax()) {
						System.out.println("El número de asistentes no puede ser mayor que el aforo máximo de este cine");
					}
				} while (asistentes>cine.getAforoMax());
				precioSesion = pedirBytePositivo("¿Cuál es el precio de la entrada para la sesión?");
				System.out.println("Datos del "+ edificioExtraido.getTipoEdificio() + " " + edificioExtraido.getNombreEdificio() + ":");
				System.out.println(cine);
				cine.limpiar();
				cine.vigilar();
				cine.proyectarSesion(asistentes, precioSesion);
				break;
			case "HOTEL":
				// CASTEAMOS EL OBJETO EXTRAIDO DEL ARRAY AL TIPO DE OBJETO QUE ES, EN ESTE CASO, HOTEL:
				Hotel hotel = (Hotel)edificioExtraido;
				System.out.println("Datos del "+ edificioExtraido.getTipoEdificio() + " " + edificioExtraido.getNombreEdificio() + ":");
				System.out.println(hotel);
				hotel.limpiar();
				hotel.vigilar();
				hotel.calcularMantenimiento();
				break;
			}
		}
	}
	
	
	// Método para Listar Edificios existentes (opción 4)
	static void listarEdificios(ArrayList<Edificio> listaEdificios) {
		if (listaEdificios.size()==0) {
			System.out.println("Actualmente no hay Edificios dados de alta en la aplicación.");
		}
		else {
			System.out.println("Estos son todos los Edificios registrados actualmente en la aplicación:");
			for (int indice=0; indice<listaEdificios.size(); indice++) {
				System.out.println(listaEdificios.get(indice));
			}
		}
	}
	
	// Método para comprobar si un dato de tipo int es positivo
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

	// Método para pedir un dato de tipo byte que sea positivo
	static byte pedirBytePositivo (String msg) {
		Scanner entrada = new Scanner(System.in);
		byte nuevoValor;		
		do {
			nuevoValor = pedirByte(msg);
			if (esPositivo(nuevoValor)==false) {
			System.out.println("El valor introducido no es válido. Debe ser un valor positivo.");
			} 
		} while (esPositivo(nuevoValor)==false);
					
		return nuevoValor;
	}
	
	// Método para validar tipo de Edificio a construir
	static String pedirTipoEdificioValido(String msg) {
		String respuesta;
		boolean respuestaValida=false;
		Scanner entrada = new Scanner(System.in);
		do {
			System.out.println(msg);
			respuesta=entrada.nextLine().toUpperCase();
			if (respuesta.equalsIgnoreCase("hospital") || respuesta.equalsIgnoreCase("cine") || respuesta.equalsIgnoreCase("hotel")) {
				respuestaValida=true;
			} 
			else {
				System.out.println("Esta aplicación no admite Edificios de tipo " + respuesta + ". Inténtalo de nuevo.");
			}
		} while (respuestaValida==false);
		
		return respuesta;
	}
	
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

} // FIN DE LA CLASE APP