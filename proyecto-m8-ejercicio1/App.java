// Módulo 8 - Ejercicio 1

import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		// DECLARACION DE ARRAYLIST A UTILIZAR (para hacer pruebas adicionales)
		ArrayList<Ordenador> listaEquipos = new ArrayList<Ordenador>();
		ArrayList<Ordenador> listaPorMarca = new ArrayList<Ordenador>();
		ArrayList<Ordenador> listaPorModelo = new ArrayList<Ordenador>();
		ArrayList<Ordenador> listaPorProcesador = new ArrayList<Ordenador>();
		ArrayList<Ordenador> listaPorRam = new ArrayList<Ordenador>();
		ArrayList<Ordenador> listaPorHdd = new ArrayList<Ordenador>();
		
		// CREACIÓN DE PRIMER OBJETO DE TIPO "Ordenador" (usando el Constructor(1))
		
		Ordenador equipo1 = new Ordenador("HP", "Portatil"); // Instanciación del objeto
		listaEquipos.add(equipo1); // Añadimos el objeto al arrayList de objetos de tipo Ordenador
		System.out.println("La marca del ordenador es " + equipo1.getMarca());
		System.out.println("El modelo del ordenador es " + equipo1.getModelo());
		System.out.println("El procesador del ordenador es " + equipo1.getProcesador());
		System.out.println("La memoria ram del ordenador es de " + equipo1.getRam() + "GB");
		System.out.println("El disco duro del ordenador es " + equipo1.getHdd() + "GB");
		System.out.println(equipo1);
			// Código equivalente a la línea inmediatamente anterior:
			//String descripcionEquipo1 = equipo1.toString();
			//System.out.println(descripcionEquipo1);
		equipo1.setProcesador("AMD");
		equipo1.setRam(16);
		equipo1.setHdd(500);
		System.out.println("El procesador del ordenador es " + equipo1.getProcesador());
		System.out.println("La memoria ram del ordenador es de " + equipo1.getRam() + "GB");
		System.out.println("El disco duro del ordenador es " + equipo1.getHdd()+ "GB");
		System.out.println(equipo1);
		System.out.println(equipo1.enEjecucion("VSC"));
		System.out.println();
		
		// CREACIÓN DE SEGUNDO OBJETO DE TIPO "Ordenador" (usando el Constructor(2))
		Ordenador equipo2 = new Ordenador("Acer", "Portatil", "AMD", 16, 320);
		listaEquipos.add(equipo2);
		System.out.println("La marca del ordenador es " + equipo2.getMarca());
		System.out.println("El modelo del ordenador es " + equipo2.getModelo());
		System.out.println("El procesador del ordenador es " + equipo2.getProcesador());
		System.out.println("La memoria ram del ordenador es de " + equipo2.getRam() + "GB");
		System.out.println("El disco duro del ordenador es " + equipo2.getHdd() + "GB");
		System.out.println(equipo2);
		equipo2.setProcesador("Intel");
		equipo2.setRam(32);
		equipo2.setHdd(250);
		System.out.println("El procesador del ordenador es " + equipo2.getProcesador());
		System.out.println("La memoria ram del ordenador es de " + equipo2.getRam() + "GB");
		System.out.println("El disco duro del ordenador es " + equipo2.getHdd()+ "GB");
		System.out.println(equipo2);
		System.out.println(equipo2.enEjecucion("SublimeText"));
		System.out.println();
		
		// CREACIÓN DE MÁS OBJETOS DE TIPO "Ordenador", que se van añadiendo a un ArrayList
		Ordenador equipo3 = new Ordenador("HP", "Portatil"); // Usando Constructor (1)
		listaEquipos.add(equipo3);
		Ordenador equipo4 = new Ordenador("Acer", "Torre"); // Usando Constructor (1)
		listaEquipos.add(equipo4);
		Ordenador equipo5 = new Ordenador("HP", "Torre", "Intel", 32, 750); // Usando Constructor (2)
		listaEquipos.add(equipo5);
		System.out.println();
		
		// PRUEBAS CON TODOS LOS OBJETOS DE TIPO "Ordenador"
		
		// 1) Imprimir todos los objetos existentes
		imprimeListaArray("Los ordenadores existentes actualmente son: ", listaEquipos);
		System.out.println();

		// 2) Buscar e imprimir listado de ordenadores de una marca determinada
		String marcaBuscada = pedirString("Escribe el nombre de la marca que buscas: ");
		listaPorMarca = buscarMarca(listaEquipos, marcaBuscada);
		imprimeResultadosBusqueda(listaPorMarca);
		System.out.println();

		// 3) Buscar e imprimir listado de ordenadores de un modelo determinado
		String modeloBuscado = pedirString("Escribe el modelo del ordenador que buscas: ");
		listaPorModelo = buscarModelo(listaEquipos, modeloBuscado);
		imprimeResultadosBusqueda(listaPorModelo);
		System.out.println();

		// 4) Buscar e imprimir listado de ordenadores con un procesador determinado
		String procesadorBuscado = pedirString("Escribe el procesador del ordenador que buscas: ");
		listaPorProcesador = buscarProcesador(listaEquipos, procesadorBuscado);
		imprimeResultadosBusqueda(listaPorProcesador);
		System.out.println();
		
		// 5) Buscar e imprimir listado de ordenadores con una Ram mayor o igual a un valor
		int ramBuscada = pedirInt("Escribe valor mínimo de la Ram:");
		listaPorRam = buscarRamMayorQue(listaEquipos, ramBuscada);
		imprimeResultadosBusqueda(listaPorRam);
		System.out.println();
		
		// 5) Buscar e imprimir listado de ordenadores con una Ram mayor o igual a un valor
		int hddBuscadb = pedirInt("Escribe valor mínimo del disco duro:");
		listaPorHdd = buscarHddMayorQue(listaEquipos, hddBuscadb);
		imprimeResultadosBusqueda(listaPorHdd);
		System.out.println();
		
	} // Fin del método main
	
	// -----------------------------
	
	// RESTO DE MÉTODOS
	
	// método para pedir un dato de tipo String
	static String pedirString (String msg) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		return entrada.nextLine();
	}
	
	// método para pedir un dato de tipo int
	static int pedirInt (String msg) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		return entrada.nextInt();
	}
	
	// método para buscar dentro de un ArrayList<Ordenador> en función de la
	// propiedad o atributo "marca". Devuelve TODOS los objetos del ArrayList cuya
	// propiedad "marca" coincide con el valor pasado en el segundo parámetro
	static ArrayList<Ordenador> buscarMarca (ArrayList<Ordenador> listaEquipos, String marca){
		ArrayList<Ordenador> listaDevuelta = new ArrayList<Ordenador>();
		for (int indice=0; indice<listaEquipos.size(); indice++) {
			if (listaEquipos.get(indice).getMarca().equalsIgnoreCase(marca)) {
				listaDevuelta.add(listaEquipos.get(indice));
			}
		}
		return listaDevuelta;
	}
	
	// método para buscar dentro de un ArrayList<Ordenador> en función de la
	// propiedad o atributo "modelo". Devuelve TODOS los objetos del ArrayList cuya
	// propiedad "modelo" coincide con el valor pasado en el segundo parámetro
	static ArrayList<Ordenador> buscarModelo (ArrayList<Ordenador> listaEquipos, String modelo){
		ArrayList<Ordenador> listaDevuelta = new ArrayList<Ordenador>();
		for (int indice=0; indice<listaEquipos.size(); indice++) {
			if (listaEquipos.get(indice).getModelo().equalsIgnoreCase(modelo)) {
				listaDevuelta.add(listaEquipos.get(indice));
			}
		}
		return listaDevuelta;
	}
	
	// método para buscar dentro de un ArrayList<Ordenador> en función de la
	// propiedad o atributo "procesador". Devuelve TODOS los objetos del ArrayList cuya
	// propiedad "procesador" coincide con el valor pasado en el segundo parámetro
	static ArrayList<Ordenador> buscarProcesador (ArrayList<Ordenador> listaEquipos, String procesador){
		ArrayList<Ordenador> listaDevuelta = new ArrayList<Ordenador>();
		for (int indice=0; indice<listaEquipos.size(); indice++) {
			if (listaEquipos.get(indice).getProcesador().equalsIgnoreCase(procesador)) {
				listaDevuelta.add(listaEquipos.get(indice));
			}
		}
		return listaDevuelta;
	}
	
	// método para buscar dentro de un ArrayList<Ordenador> en función de la
	// propiedad o atributo "ram". Devuelve TODOS los objetos del ArrayList cuya
	// propiedad "ram" sea mayor o igual que el valor pasado en el segundo parámetro
	static ArrayList<Ordenador> buscarRamMayorQue (ArrayList<Ordenador> listaEquipos, int ram){
		ArrayList<Ordenador> listaDevuelta = new ArrayList<Ordenador>();
		for (int indice=0; indice<listaEquipos.size(); indice++) {
			if (listaEquipos.get(indice).getRam() >= ram) {
				listaDevuelta.add(listaEquipos.get(indice));
			}
		}
		return listaDevuelta;
	}
	
	// método para buscar dentro de un ArrayList<Ordenador> en función de la
	// propiedad o atributo "hdd". Devuelve TODOS los objetos del ArrayList cuya
	// propiedad "hdd" sea mayor o igual que el valor pasado en el segundo parámetro
	static ArrayList<Ordenador> buscarHddMayorQue (ArrayList<Ordenador> listaEquipos, int hdd){
		ArrayList<Ordenador> listaDevuelta = new ArrayList<Ordenador>();
		for (int indice=0; indice<listaEquipos.size(); indice++) {
			if (listaEquipos.get(indice).getHdd() >= hdd) {
				listaDevuelta.add(listaEquipos.get(indice));
			}
		}
		return listaDevuelta;
	}
	
	// método para imprimir todos los elementos de un arrayList (+genérico)
	static void imprimeListaArray(String msg, ArrayList<Ordenador> listaElementos) {
		System.out.println(msg);
		for (int indice=0; indice<listaElementos.size(); indice++) {
			System.out.println(listaElementos.get(indice));
		}
	}

	// método para imprimir los resultados de una búsqueda (+específico)
	static void imprimeResultadosBusqueda(ArrayList<Ordenador> listaElementos) {
		if (listaElementos.size()>0) {
			System.out.println("Estos son los ordanadores existentes que coindicen con el criterio especificado:");
			for (int indice=0; indice<listaElementos.size(); indice++) {
				System.out.println(listaElementos.get(indice));
			}
		} else {
			System.out.println("No se ha encontrado ningún ordenador con esas características");

		}
		
	}
	
	

} // Fin de la clase App
