// Módulo 8 - Ejercicio 6 (Versión 2)

package PaqueteApp;

import java.util.ArrayList;
import PaqueteEscuderias.*;

public class ToolsMenu {

	// MENU PRINCIPAL
	static byte menuPrincipal() {
		byte opcion;
		do {
			System.out.println("PROGRAMA ESCUDERÍAS");
			System.out.println("");
			System.out.println("(1)- Altas (Escuderías/Bólidos/Pilotos/Mecánicos)");
			System.out.println("(2)- Bajas (Escuderías/Bólidos/Pilotos/Mecánicos)");
			System.out.println("(3)- Consultas (Escuderías/Bólidos/Pilotos/Mecánicos)");
			System.out.println("(4)- Listados (Escuderías/Bólidos/Pilotos/Mecánicos)");
			System.out.println("(0)- Salir del programa");
			
			opcion = ToolsDatos.pedirByte("Elige una opción:");
			if (opcion<0 || opcion>4) {
				System.out.println("Esa opción no existe. Inténtalo de nuevo.");
				System.out.println();
			}
		} while (opcion<0 || opcion>4);
		
		return opcion;
	}
	
	// SUB-MENU PRINCIPAL
	static byte subMenuPrincipal(String msg1, String msg2, ArrayList<Escuderia> listadoEscuderias) {
		byte opcionElegida;
		do {
			System.out.println(msg1);
			System.out.println("");
			System.out.println("(1)- Escuderías");
			System.out.println("(2)- Bólidos");
			System.out.println("(3)- Pilotos");
			System.out.println("(4)- Mecánicos");
			System.out.println("(0)- " + msg2);
			opcionElegida = ToolsDatos.pedirByte("Elige una opción:");
			if (opcionElegida<0 || opcionElegida>4) {
				System.out.println("Esa opción no existe. Inténtalo de nuevo.");
				System.out.println();
			}
		} while (opcionElegida<0 || opcionElegida>4);
		
		return opcionElegida;
	}
	
	// SUB-MENU ALTAS ************************************************************* (FINALIZADO)
	static void subMenuAltas(String msg1, String msg2, ArrayList<Escuderia> listadoEscuderias) {
		byte opcionAlta = subMenuPrincipal(msg1, msg2, listadoEscuderias);	
		switch (opcionAlta) {
			case 1:
				ToolsAccionesMenu.crearEscuderia(listadoEscuderias);
				break;
			case 2:
				ToolsAccionesMenu.crearBolido(listadoEscuderias, "¿A qué escudería pertenece el Bólido a dar de alta?");
				break;
			case 3:
			case 4:
				ToolsAccionesMenu.crearEmpleado(opcionAlta ,listadoEscuderias);
				break;
		}
	}
	
	// SUB-MENU BAJAS ************************************************************* (FINALIZADO)
	static void subMenuBajas(String msg1, String msg2, ArrayList<Escuderia> listadoEscuderias) {
		byte opcionBaja = subMenuPrincipal(msg1, msg2, listadoEscuderias);	
		switch (opcionBaja) {
			case 1:
				ToolsAccionesMenu.bajaEscuderia(listadoEscuderias);
				break;
			case 2:
				ToolsAccionesMenu.bajaBolido(listadoEscuderias);
				break;
			case 3:
			case 4:
				ToolsAccionesMenu.bajaEmpleado(opcionBaja ,listadoEscuderias);
				break;
		}
	}
	
	// SUB-MENU CONSULTAS (VER) ------- EN CONSTRUCCIÓN
	static void subMenuVer(String msg1, String msg2, ArrayList<Escuderia> listadoEscuderias) {
		byte opcionVer = subMenuPrincipal(msg1, msg2, listadoEscuderias);	
		switch (opcionVer) {
			case 1:
				ToolsAccionesMenu.verEscuderia(listadoEscuderias);
				break;
			case 2:
				ToolsAccionesMenu.verBolido(listadoEscuderias);
				break;
			case 3:
			case 4:
				ToolsAccionesMenu.verEmpleado(opcionVer ,listadoEscuderias);
				break;
		}
	}
		
	// SUB-MENU LISTADOS ************************************************************* (FINALIZADO)
	static void subMenuListados(String msg1, String msg2, ArrayList<Escuderia> listadoEscuderias) {
		byte opcionLista = subMenuPrincipal(msg1, msg2, listadoEscuderias);	
		switch (opcionLista) {
			case 1:
				ToolsAccionesMenu.verListaEscuderias(listadoEscuderias);
				break;
			case 2:
				ToolsAccionesMenu.verListaBólidos(listadoEscuderias);
				break;
			case 3:
			case 4:
				ToolsAccionesMenu.verListaEmpleados(opcionLista, listadoEscuderias);
				break;
		}
	}
	
} // FINAL CLASE TOOLSMENU
