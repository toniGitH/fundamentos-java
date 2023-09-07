// Módulo 8 - Ejercicio 4 (Opcion B)
// Opcion B: en la clase Edificio defino 4 constructores, uno genérico, y otros 3, uno
// para cada tipo de edificio.
// De esta manera, todos los métodos que los 3 tipos específicos de edificios hereden
// serán válidos y no tendrán que ser sobreescritos, y tan solo habrá que crear algún
// método específico para alguna de las clases hijas.

package PaqueteEdificios;

public abstract class Edificio {

	// DECLARACIÓN DE PROPIEDADES O ATRIBUTOS
	
	protected final String tipoEdificio; // ¿¿Para preguntarle al ArrayList<Edificio> de qué tipo es el objeto que tiene dentro
	protected final String nombreEdificio;
	protected final int numPlantas;
	protected final int superficie;
	protected final double ratioVigilancia;
	protected final int sueldoVigilante;
	
	// DECLARACIÓN DEL CONSTRUCTOR
	
	// Constructor "Genérico" => Este no se usará
	public Edificio(String tipoEdificio, String nombreEficicio, int numPlantas, int superficie, double ratioVigilancia, int sueldoVigilante) {
		this.tipoEdificio=tipoEdificio;
		this.nombreEdificio=nombreEficicio;
		this.numPlantas=numPlantas;
		this.superficie=superficie;
		this.ratioVigilancia=ratioVigilancia;
		this.sueldoVigilante=sueldoVigilante;
	}
	
	// Constructor para Hospitales
	public Edificio(String tipoEdificio, String nombreEficicio, int numPlantas, int superficie) {
		this.tipoEdificio=tipoEdificio;
		this.nombreEdificio=nombreEficicio;
		this.numPlantas=numPlantas;
		this.superficie=superficie;
		ratioVigilancia=0.001;
		sueldoVigilante=1300;
	}
	
	// Constructor para Cines
	public Edificio(String tipoEdificio, int superficie, int numPlantas, String nombreEficicio) {
		this.tipoEdificio=tipoEdificio;
		this.nombreEdificio=nombreEficicio;
		this.numPlantas=numPlantas;
		this.superficie=superficie;
		ratioVigilancia=0.0003;
		sueldoVigilante=1300;
	}
		
	// Constructor para Hoteles
	public Edificio(String tipoEdificio, int superficie, String nombreEficicio, int numPlantas) {
		this.tipoEdificio=tipoEdificio;
		this.nombreEdificio=nombreEficicio;
		this.numPlantas=numPlantas;
		this.superficie=superficie;
		ratioVigilancia=0.001;
		sueldoVigilante=1800;
	}
		
	// MÉTODOS GETTERS (obligatorios, según el enunciado del ejercicio)
	
	public String getTipoEdificio() {
		return tipoEdificio;
	}
	public String getNombreEdificio() {
		return nombreEdificio;
	}
	public int getNumPlantas() {
		return numPlantas;
	}
	public int getSuperficie() {
		return superficie;
	}
	
	public double getRatioVigilancia() {
		return ratioVigilancia;
	}
	
	public int sueldoVigilante() {
		return sueldoVigilante;
	}
	
	// MÉTODOS SETTERS (no se definen, para no dar acceso a las propiedades, aunque
	// éstas son "final".
	
	// RESTO DE MÉTODOS DE CLASE
	
	// Método para calcular tiempo de limpieza. Retorna double expresado en minutos
	public double calcularMinutosLimpieza() {
		double minutosLimpieza = (double)superficie/5;
		if (numPlantas>1) {
			minutosLimpieza += ((numPlantas-1)*0.5);
		}
		return minutosLimpieza;
	}
	
	// Método para calcular el coste de limpieza
	public double calcularCosteLimpiezaMes() {
		return calcularMinutosLimpieza()*30;
	}
	
	// Método limpiar
	public void limpiar() {
		System.out.println("Tiempo diario de limpieza: " + calcularMinutosLimpieza() + " minutos.");
		System.out.println("Coste mensual de limpieza: " + calcularCosteLimpiezaMes() + " euros.");
	}
	
	// Método para determinar el número de vigilantes que necesita un edificio
	public int vigilantesNecesarios() {
		return (int)(Math.ceil(superficie*ratioVigilancia)); // Devuelve un int, redondeado hacia arriba, sin parte decimal
	}
		
	// Método para calcular el coste de vigilancia
	public int calcularCosteVigilancia() {
		return vigilantesNecesarios()*sueldoVigilante;
	}
	
	// Método para imprimir el cálculo del coste de vigilancia
	public void vigilar() {
		System.out.println("Coste de vigilancia: " + calcularCosteVigilancia() + " euros al mes.");
	}
	
	// Método toString
	public String toString() {
		return "El " + tipoEdificio + " " + nombreEdificio
				+ " tiene " + numPlantas + " plantas y una superficie"
				+ " total de " + superficie + " metros cuadrados."; 
	}
}
