// Módulo 8 - Ejercicio 6 (Versión 2)
// IMPORTANTE: a modo de base de datos, podemos utilizar un solo ArrayList, que será el de Escuderías
// Por tanto, en la clase App solo se puede crear un ArrayList en el método main.
// Se pueden utilizar mas ArrayList en el programa, pero no creados en el método main

package PaqueteApp;

import java.util.ArrayList;
import PaqueteEscuderias.*;

public class App {

	public static void main(String[] args) {
		ArrayList<Escuderia> listaEscuderias = new ArrayList<Escuderia>();
		byte opcionMenuElegida;
		char repetir='n';
		
		do {
			
			opcionMenuElegida = ToolsMenu.menuPrincipal();
			
			if (opcionMenuElegida!=0) {
				switch (opcionMenuElegida) {
					case 1: // ALTAS
						ToolsMenu.subMenuAltas("¿Qué deseas dar de ALTA?", "Abandonar alta", listaEscuderias);
						break;
					case 2: // BAJAS
						if (listaEscuderias.size()==0) {
							System.out.println("La base de datos está vacía. No hay nada que dar de baja.");
						} else {
							ToolsMenu.subMenuBajas("¿Qué deseas dar de BAJA?", "Abandonar baja", listaEscuderias);
						}
						break;
					case 3: // CONSULTAS
						if (listaEscuderias.size()==0) {
							System.out.println("La base de datos está vacía. No hay nada que consultar");
						} else {
							ToolsMenu.subMenuVer("¿Qué deseas CONSULTAR?", "Abandonar consulta", listaEscuderias);
						}
						break;
					case 4: // LISTADOS
						if (listaEscuderias.size()==0) {
							System.out.println("La base de datos está vacía. No hay nada consultar.");
						} else {
							ToolsMenu.subMenuListados("¿De qué quieres obtener un listado?", "Abandonar consulta", listaEscuderias);
						}
						break;
					//default: // En este caso no lo utilizo
				}				
			repetir = ToolsDatos.pedirChar("¿Quieres hacer otra operación (s/n)?");
			}
			
		} while (repetir=='s' && opcionMenuElegida!=0);
		
		System.out.println("Fin del programa");

	} // Fin del método main
	
} // FIN DE LA CLASE APP
