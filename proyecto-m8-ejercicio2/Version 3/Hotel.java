// Módulo 8 - Ejercicio 2 (Versión 3)

public class Hotel {

	// DECLARACIÓN DE PROPIEDADES O ATRIBUTOS
	private String nombreHotel;
	private int numHabitaciones;
	private int numPlantas;
	private int superficie;
	
	// MÉTODO CONSTRUCTOR
	
	public Hotel (String nombreHotel, int numHabitaciones, int numPlantas, int superficie) {
		this.nombreHotel=nombreHotel;
		this.numHabitaciones=numHabitaciones;
		this.numPlantas=numPlantas;
		this.superficie=superficie;
	}
	
	// MÉTODOS GETTERS
	
	public String getNombreHotel() {
		return nombreHotel;
	}
	
	public int getNumHabitaciones() {
		return numHabitaciones;
	}
	
	public int getNumPlantas() {
		return numPlantas;
	}
	
	public int getSuperficie() {
		return superficie;
	}
	
	// MÉTODOS SETTERS
	
	public void setNombreHotel(String nombreHotel) {
		this.nombreHotel = nombreHotel;
	}
	
	public void setNumHabitaciones(int numHabitaciones) {
		this.numHabitaciones = numHabitaciones;
	}
	
	public void setNumPlantas(int numPlantas) {
		this.numPlantas = numPlantas;
	}
	
	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	
	// RESTO MÉTODOS DE CLASE
	
	public int personalNecesario() { // Este método calcula el número de empleados de un hotel
		return (int)(Math.ceil(this.numHabitaciones/(double)20)); // Devuelve un int, redondeado hacia arriba, sin parte decimal
	}
	
	public int costeTotal() { // Este método calcula el coste de personal de un hotel
		return personalNecesario()*1500;
	}
	
	public void calcularMantenimiento() { // Este método imprime la información del mantenimiento del hotel
		System.out.println("El hotel " + nombreHotel + " necesita " + personalNecesario() + " empleados.");
		System.out.println("El coste de los empleados que necesita el hotel " + nombreHotel + " es de " + costeTotal() + " euros al mes.");
	}
	
	// MÉTODO toString()
	public String toString() {
		return "El hotel " + nombreHotel + " tiene un total de " + numHabitaciones 
				+ " habitaciones, distribuidas en " + numPlantas + " plantas, y tiene una superficie total de "
				+ superficie + " metros cuadrados.";
	}
	
}
