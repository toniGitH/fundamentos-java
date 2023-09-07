// Módulo 8 - Ejercicio 6 (Versión 2)

package PaqueteEscuderias;

public class Empleado { // Clase Padre de Clase Piloto y Clase Mecánico
	
	// DECLARACIÓN DE PROPIEDADES O ATRIBUTOS
	protected String nombreEmpleado;
	protected String apellidoEmpleado;
	protected int edadEmpleado;
	protected int antiguedadEmpleado; // En años
	protected int sueldo;
	protected int plusPeligro;
	protected String tipoEmpleado;
	protected String escuderiaEmpleado;
	
	// DECLARACIÓN DE CONSTRUCTORES
	// Constructor "completo"
	public Empleado(String nombreEmpleado, String apellidoEmpleado, int edadEmpleado, int antiguedadEmpleado, String escuderiaEmpleado) {
		this.nombreEmpleado=nombreEmpleado;
		this.apellidoEmpleado=apellidoEmpleado;
		this.edadEmpleado=edadEmpleado;
		this.antiguedadEmpleado=antiguedadEmpleado;
		sueldo=50000;
		plusPeligro=0;
		tipoEmpleado="empleado";
		this.escuderiaEmpleado=escuderiaEmpleado;
	}
	
	// MÉTODOS GETTERS
	public String getNombreEmpleado() {
		return nombreEmpleado;
	}
	public String getApellidoEmpleado() {
		return apellidoEmpleado;
	}
	public int getEdadEmpleado() {
		return edadEmpleado;
	}
	public int getAntiguedadEmpleado() {
		return antiguedadEmpleado;
	}
	public int getSueldo() {
		return sueldo;
	}
	public int getPlusPeligro() {
		return plusPeligro;
	}
	public String getTipoEmpleado() {
		return tipoEmpleado;
	}
	public String getEscuderiaEmpleado() {
		return escuderiaEmpleado;
	}
	
	// MÉTODOS SETTERS
	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado=nombreEmpleado;
	}
	public void setApellidoEmpleado(String apellidoEmpleado) {
		this.apellidoEmpleado=apellidoEmpleado;
	}
	public void setEdadEmpleado(int edadEmpleado) {
		this.edadEmpleado=edadEmpleado;
	}
	public void setAtiguedadEmpleado(int antiguedadEmpleado) {
		this.antiguedadEmpleado=antiguedadEmpleado;
	}
	public void setSueldo(int sueldo) {
		this.sueldo=sueldo;
	}
	public void setPlusPeligro(int plusPeligro) {
		this.plusPeligro=plusPeligro;
	}
	public void setTipoEmpleado(String tipoEmpleado) {
		this.tipoEmpleado=tipoEmpleado;
	}
	public void setEscuderiaEmpleado(String escuderiaEmpleado) {
		this.escuderiaEmpleado=escuderiaEmpleado;
	}
	
	// RESTO MÉTODOS DE CLASE
	
	public int calcularSueldoEmpleado() {
		return sueldo + plusPeligro + 10000*antiguedadEmpleado;
	}
	
	public String toString() {
		return nombreEmpleado + " " + apellidoEmpleado + " es un " + tipoEmpleado
				+ " de la escudería " + escuderiaEmpleado + " con un sueldo de "
				+ sueldo + " euros.";
	}

} // FIN CLASE EMPLEADO
