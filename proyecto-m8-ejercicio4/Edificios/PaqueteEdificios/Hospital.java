// Módulo 8 - Ejercicio 4 (Opcion B)

package PaqueteEdificios;

public class Hospital extends Edificio{

	// DECLARACIÓN DE PROPIEDADES O ATRIBUTOS
	private int enfermosIngresados;
	
	// DECLARACIÓN DEL CONSTRUCTOR
	public Hospital(String tipoEdificio, String nombreEdificio, int numPlantas, int superficie) {
		super(tipoEdificio, nombreEdificio, numPlantas, superficie);
		enfermosIngresados=0;
	}
	
	// MÉTODOS GETTERS
	public int getEnfermos() {
		return enfermosIngresados;
	}
	
	// MÉTODOS SETTERS
	public void setEnfermos(int enfermosIngresados) {
		this.enfermosIngresados = enfermosIngresados;
	}
	
	// RESTO DE MÉTODOS DE CLASE
	
	// Método repartirAlmuerzo(). Exclusivo de los Hospitales. No está en la clase Edificio
	public void repartirAlmuerzo() {
		System.out.println("Se están repartiendo " + (enfermosIngresados*3) + " raciones.");
	}
	
	// Método heredado calcularCosteLimpiezaMes() => No es necesario sobreescribirlo
		
	// Método heredado limpiar() => No es necesario sobreescribirlo
		
	// Método heredado vigilantesNecesarios() => No es necesario sobreescribirlo
	
	// Método heredado para calcularCosteVigilancia() => No es necesario sobreescribirlo
		
	// Método heredado vigilar() => No es necesario sobreescribirlo

	// Método heredado toString => No es necesario sobreescribirlo
	
} // FINAL DE LA CLASE HOSPITAL
