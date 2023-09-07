// Módulo 8 - Ejercicio 4 (Opcion B)

package PaqueteEdificios;

public class Hotel extends Edificio {

	// DECLARACIÓN DE PROPIEDADES O ATRIBUTOS
	private final int numHabitaciones;
	
	// DECLARACIÓN DEL CONSTRUCTOR
	public Hotel(String tipoEdificio, int superficie, String nombreEdificio, int numPlantas, int numHabitaciones) {
		super(tipoEdificio, superficie, nombreEdificio, numPlantas);
		this.numHabitaciones=numHabitaciones;
	}
	
	// MÉTODOS GETTERS
	
	public int getNumHabitaciones() {
		return numHabitaciones;
	}
	
	// RESTO DE MÉTODOS DE CLASE
	
	public void calcularMantenimiento() { // Este método imprime la información del mantenimiento del hotel
		System.out.println("El hotel " + nombreEdificio + " necesita " + personalNecesario() + " empleados.");
		System.out.println("El coste de los empleados que necesita el hotel " + nombreEdificio + " es de " + costeTotal() + " euros al mes.");
	}
	
	public int personalNecesario() { // Este método calcula el número de empleados de un hotel
		return (int)(Math.ceil(numHabitaciones/(double)20)); // Devuelve un int, redondeado hacia arriba, sin parte decimal
	}
	
	public int costeTotal() { // Este método calcula el coste de personal de un hotel
		return personalNecesario()*1000;
	}
	
	// Método heredado calcularCosteLimpiezaMes() => No es necesario sobreescribirlo
		
	// Método heredado limpiar() => No es necesario sobreescribirlo
		
	// Método heredado vigilantesNecesarios() => No es necesario sobreescribirlo
		
	// Método heredado para calcularCosteVigilancia() => No es necesario sobreescribirlo
	
	// Método heredado para calcularCosteVigilancia() => Es necesario sobreescribirlo
		
	// Método heredado vigilar() => No es necesario sobreescribirlo

	// Método heredado toString => No es necesario sobreescribirlo	

} // FINAL DE LA CLASE HOTEL
