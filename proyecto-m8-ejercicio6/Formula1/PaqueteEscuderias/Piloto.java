// Módulo 8 - Ejercicio 6 (Versión 2)

package PaqueteEscuderias;

public class Piloto extends Empleado {
	
	// DECLARACIÓN DE PROPIEDADES O ATRIBUTOS
	private int alturaPiloto;
	private int pesoPiloto;
	
	// DECLARACIÓN DEL CONSTRUCTOR
	public Piloto(String nombreEmpleado, String apellidoEmpleado, int edadEmpleado, int antiguedadEmpleado, int alturaPiloto, int pesoPiloto, String escuderiaEmpleado) {
		super(nombreEmpleado, apellidoEmpleado, edadEmpleado, antiguedadEmpleado, escuderiaEmpleado);
		plusPeligro=50000;
		tipoEmpleado="piloto";
		this.alturaPiloto=alturaPiloto;
		this.pesoPiloto=pesoPiloto;
		this.escuderiaEmpleado=escuderiaEmpleado;
	}
	
	// MÉTODOS GETTERS
	
	public int getAlturaPiloto() {
		return alturaPiloto;
	}
	public int getPesoPiloto() {
		return pesoPiloto;
	}
	
	// MÉTODOS SETTERS
	
	public void setAlturaPiloto(int alturaPiloto) {
		this.alturaPiloto=alturaPiloto;
	}
	public void setPesoPiloto(int pesoPiloto) {
		this.pesoPiloto=pesoPiloto;
	}
	
	// RESTO DE MÉTODOS DE CLASE
	public String toString() {
		return super.toString() + "\nSu peso es de " + pesoPiloto +
						"kg y su altura es de " + alturaPiloto + "cm.";
	}
	
} // FIN CLASE PILOTO