// Módulo 8 - Ejercicio 6 (Versión 2)

package PaqueteApp;

import java.util.ArrayList;
import PaqueteEscuderias.*;

public class ToolsBusquedas {
	
	// Buscar índice de elemento Esduderia en el ArrayList<Escuderia>
	static int buscarIndiceDeEscuderia(ArrayList<Escuderia> listaEscuderias, String nombreEscuderia) {
		int indiceEscuderia=0;
		String nombreEscuderiaEvaluado;
		int indiceBuscado=-1;
		boolean escuderiaEncontrada=false;
		
		if (listaEscuderias.size()==0) {
			indiceBuscado=-1;
		}
		else {
			do {
				nombreEscuderiaEvaluado = listaEscuderias.get(indiceEscuderia).getNombreEscuderia();
				if (nombreEscuderiaEvaluado.equalsIgnoreCase(nombreEscuderia)) {
					indiceBuscado=indiceEscuderia;
					escuderiaEncontrada=true;
				} else {
					indiceEscuderia++;
				}
			}
			while (escuderiaEncontrada==false && indiceEscuderia<listaEscuderias.size());
		}
		
		return indiceBuscado;
	}
	
	// Verificar si hay alguna (al menos una) Escudería creada
	public static boolean hayEscuderias(ArrayList<Escuderia> listaEscuderias) {
		return listaEscuderias.size()>0;
	}

} // FIN CLASE TOOLSBUSQUEDAS