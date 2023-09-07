// Módulo 8 - Ejercicio 6 (Versión 2)

package PaqueteEscuderias;

import java.util.ArrayList;
//import PaqueteApp.*;

public class Escuderia {

	// DECLARACIÓN DE PROPIEDADES O ATRIBUTOS
	private String nombreEscuderia;
	private int presupuestoEscuderia;
	private String paisEscuderia;
	private ArrayList<Bolido> listaBolidos;
	private ArrayList<Empleado> listaEmpleados;
	
	// DECLARACIÓN DEL CONSTRUCTOR
	public Escuderia(String nombreEscuderia, int presupuestoEscuderia, String paisEscuderia) {
		this.nombreEscuderia=nombreEscuderia;
		this.presupuestoEscuderia=presupuestoEscuderia;
		this.paisEscuderia=paisEscuderia;
		listaBolidos=new ArrayList<Bolido>();
		listaEmpleados=new ArrayList<Empleado>();
	}
	
	// MÉTODOS GETTERS
	public String getNombreEscuderia() {
		return nombreEscuderia;
	}
	
	public int getPresupuestoEscuderia() {
		return presupuestoEscuderia;
	}
	
	public String getPaisEscuderia() {
		return paisEscuderia;
	}
	
	// No incluimos este método getter para impedir violaciones de encapsulado en otras clases
	/*public ArrayList<Bolido> getListaBolidos(){
		return listaBolidos;
	}*/
	
	// No incluimos este método getter para impedir violaciones de encapsulado en otras clases
	/*public ArrayList<Empleado> getListaEmpleados(){
		return listaEmpleados;
	}*/
	
	// MÉTODOS SETTERS
	
	public void setNombreEscuderia(String nombreEscuderia) {
		this.nombreEscuderia=nombreEscuderia;
	}
	
	public void setPresupuestoEscuderia(int presupuestoEscuderia) {
		this.presupuestoEscuderia=presupuestoEscuderia;
	}
	
	public void setPaisEscuderia(String paisEscuderia) {
		this.paisEscuderia=paisEscuderia;
	}
	
	// No incluimos este método getter para impedir violaciones de encapsulado en otras clases
	/*public void setListaBolidos(ArrayList<Bolido> listaBolidos) {
		this.listaBolidos=listaBolidos;
	}*/
	
	// No incluimos este método getter para impedir violaciones de encapsulado en otras clases	
	/*public void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
		this.listaEmpleados=listaEmpleados;
	}*/
	
	// RESTO DE MÉTODOS DE CLASE
	
	// ------------------------ BOLIDOS ------------------------------------------
	
	// Añadir objeto Bolido al ArrayList<Bolido> de una Escuderia
	public void incluirBolidoEnArray(Bolido nuevoBolido) {
		listaBolidos.add(nuevoBolido);
	}
			
	// Eliminar objeto Bolido de ArrayList<Bolido> de una Escuderia
	public void eliminarBolidoDeArray(int indiceBolido) {
		listaBolidos.remove(indiceBolido);
	}
	
	// Devolver el tamaño del ArrayList<Bolido>
	public int sizeListaBolidos() {
		return listaBolidos.size();
	}
	
	// Devolver un objeto Bolido del interior del ArrayList<Bolido>
	public Bolido devolverBolido(int indiceBolido) {
		return listaBolidos.get(indiceBolido);
	}
	
	// Buscar el índice de un elemento Bolido en ArrayList<Bolido> de una Escuderia
	public int buscarIndiceDeBolido(String modeloBolido) {
		int indiceBolido=0;
		String modeloBolidoEvaluado;
		int indiceBuscado=-1;
		boolean bolidoEncontrado=false;
	
		if (listaBolidos.size()==0) {
			indiceBuscado=-1;
		}
		else {
			do {
				modeloBolidoEvaluado = listaBolidos.get(indiceBolido).getModeloBolido();
				if (modeloBolidoEvaluado.equalsIgnoreCase(modeloBolido)) {
					indiceBuscado=indiceBolido;
					bolidoEncontrado=true;
				} 
				else {
					indiceBolido++;
				}
			} while (bolidoEncontrado==false && indiceBolido<listaBolidos.size());
		}	
		return indiceBuscado;
	}
	
	// Verificar si hay algún Bólido (al menos 1) creado en alguna Escudería // MÉTODO ESTÁTICO //
	public static boolean hayBolidos(ArrayList<Escuderia> listaEscuderias) {
		boolean bolidosEncontrados=false;
		if (listaEscuderias.size()>0) {
			int contador=0;
			int numBolidos;
			do {
				numBolidos = listaEscuderias.get(contador).listaBolidos.size();
				if (numBolidos>0) {
					bolidosEncontrados=true;
				} else {
					contador++;
				}
			} while (bolidosEncontrados==false && listaEscuderias.size()<contador);
		} else {
			bolidosEncontrados=false;
		}
		return bolidosEncontrados;
	}
	


	
	// ------------------------ EMPLEADOS ------------------------------------------

	// Añadir objeto Empleado al ArrayList<Empleado> de una Escuderia
	public void incluirEmpleadoEnArray(Empleado nuevoEmpleado) {
		listaEmpleados.add(nuevoEmpleado);
	}
		
	// Eliminar objeto Empleado al ArrayList<Empleado> de una Escuderia
	public void eliminarEmpleadoDeArray(int indiceEmpleado) {
		listaEmpleados.remove(indiceEmpleado);
	}

	// Devolver el tamaño del ArrayList<Empleado>
	public int sizeListaEmpleados() {
		return listaEmpleados.size();
	}
		
	// Devolver un objeto Empleado del interior del ArrayList<Empleadoo>
	public Empleado devolverEmpleado(int indiceEmpleado) {
		return listaEmpleados.get(indiceEmpleado);
	}
	
	// Buscar el índice de un elemento Empleado en ArrayList<Empleado> de una Escuderia
	public int buscarIndiceDeEmpleado(String nombreEmpleado, String apellidoEmpleado) {
		int indiceEmpleado=0;
		String nombreEmpleadoEvaluado, apellidoEmpleadoEvaluado;
		int indiceBuscado=-1;
		boolean empleadoEncontrado=false;
	
		if (listaEmpleados.size()==0) {
			indiceBuscado=-1;
		}
		else {
			do {
				nombreEmpleadoEvaluado = listaEmpleados.get(indiceEmpleado).getNombreEmpleado();
				apellidoEmpleadoEvaluado = listaEmpleados.get(indiceEmpleado).getApellidoEmpleado();
				if (nombreEmpleadoEvaluado.equalsIgnoreCase(nombreEmpleado) && apellidoEmpleadoEvaluado.equalsIgnoreCase(apellidoEmpleado)) {
					indiceBuscado=indiceEmpleado;
					empleadoEncontrado=true;
				} 
				else {
					indiceEmpleado++;
				}
			} while (empleadoEncontrado==false && indiceEmpleado<listaEmpleados.size());
		}	
		return indiceBuscado;
	}
		
	// Verificar si hay algún Empleado (al menos 1) creado en alguna Escudería // MÉTODO ESTÁTICO //
	public static boolean hayEmpleados(ArrayList<Escuderia> listaEscuderias) {
		boolean empleadosEncontrados=false;
		if (listaEscuderias.size()>0) {
			int contador=0;
			int numEmpleados;
			do {
				numEmpleados = listaEscuderias.get(contador).listaEmpleados.size();
				if (numEmpleados>0) {
					empleadosEncontrados=true;
				} else {
					contador++;
				}
			} while (empleadosEncontrados==false && contador<listaEscuderias.size());
		} 
		return empleadosEncontrados;
	}
	
	// Verificar si hay algún Piloto (al menos 1) creado en alguna Escudería // MÉTODO ESTÁTICO //
	public static boolean hayPilotos(ArrayList<Escuderia> listaEscuderias) {
		boolean pilotosEncontrados=false;
		if (listaEscuderias.size()>0) {
			int indiceEsc=0;
			int indiceEmpl=0;
			String tipoEmpleadoEvaluado;
			do {
				do {
					if (listaEscuderias.get(indiceEsc).listaEmpleados.size()>0) {
						tipoEmpleadoEvaluado = listaEscuderias.get(indiceEsc).listaEmpleados.get(indiceEmpl).tipoEmpleado;
						 if (tipoEmpleadoEvaluado.equalsIgnoreCase("piloto")) {
								pilotosEncontrados=true;
							} else {
								indiceEmpl++;
							}
					} 
				} while (pilotosEncontrados==false && indiceEmpl<listaEscuderias.get(indiceEsc).listaEmpleados.size() );
					indiceEsc++;
					indiceEmpl=0;
			} while (pilotosEncontrados==false && indiceEsc<listaEscuderias.size());
		} 
		return pilotosEncontrados;
	}
	
	// Verificar si hay algún Mecánico (al menos 1) creado en alguna Escudería // MÉTODO ESTÁTICO //
	public static boolean hayMecanicos(ArrayList<Escuderia> listaEscuderias) {
		boolean mecanicosEncontrados=false;
		if (listaEscuderias.size()>0) {
			int indiceEsc=0;
			int indiceEmpl=0;
			String tipoEmpleadoEvaluado;
			do {
				do {
					if (listaEscuderias.get(indiceEsc).listaEmpleados.size()>0) {
						tipoEmpleadoEvaluado = listaEscuderias.get(indiceEsc).listaEmpleados.get(indiceEmpl).tipoEmpleado;
						 if (tipoEmpleadoEvaluado.equalsIgnoreCase("mecánico")) {
								mecanicosEncontrados=true;
							} else {
								indiceEmpl++;
							}
					} 
				} while (mecanicosEncontrados==false && indiceEmpl<listaEscuderias.get(indiceEsc).listaEmpleados.size() );
					indiceEsc++;
					indiceEmpl=0;
			} while (mecanicosEncontrados==false && indiceEsc<listaEscuderias.size());
		} 
		return mecanicosEncontrados;
	}
	
	// -----------------------------------------------------------------------------
	
	// Método toString()
	public String toString() {
		return "Nombre Escudería: " + nombreEscuderia +
				"\nPaís Escudería: " + paisEscuderia + 
				"\nPresupuesto Escudería: " + presupuestoEscuderia + " millones de euros."; 
	}

} // FIN CLASE ESCUDERIA
