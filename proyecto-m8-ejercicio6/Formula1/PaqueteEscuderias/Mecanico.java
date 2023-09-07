// Módulo 8 - Ejercicio 6 (Versión 2)

package PaqueteEscuderias;

public class Mecanico extends Empleado{

	// DECLARACIÓN DE PROPIEDADES O ATRIBUTOS
	private String estudiosMecanica;
		
	// DECLARACIÓN DEL CONSTRUCTOR
	public Mecanico(String nombreEmpleado, String apellidoEmpleado, int edadEmpleado, int antiguedadEmpleado, String estudiosMecanica, String escuderiaEmpleado) {
		super(nombreEmpleado, apellidoEmpleado, edadEmpleado, antiguedadEmpleado, escuderiaEmpleado);
		tipoEmpleado="mecánico";
		this.estudiosMecanica=estudiosMecanica;
	}
	
	// MÉTODOS GETTERS
	public String getEstudiosMecanica() {
		return estudiosMecanica;
	}
	// MÉTODOS SETTERS
	public void setEstudiosMecanica(String estudiosMecanica) {
		this.estudiosMecanica=estudiosMecanica;
	}
	
	// RESTO DE MÉTODOS DE CLASE
	
	public String toString() {
		return super.toString() + "\nEste mecánico " + estudiosMecanica + " tiene estudios de mecánica.";
	}

} // FIN CLASE MECANICO
