// Módulo 8 - Ejercicio 4 (Opcion B)

package PaqueteEdificios;

public class Cine extends Edificio{
	
	// DECLARACIÓN DE PROPIEDADES O ATRIBUTOS
	private final int aforoMax;
		
	// DECLARACIÓN DEL CONSTRUCTOR
	public Cine(String tipoEdificio, int superficie, int numPlantas, String nombreEficicio, int aforoMax) {
		super(tipoEdificio, superficie, numPlantas, nombreEficicio);
		this.aforoMax=aforoMax;
	}
	
	// MÉTODOS GETTERS
	public int getAforoMax() {
		return aforoMax;
	}
	
	// RESTO DE MÉTODOS DE CLASE
	
	// Método proyectarSesion(). Exclusivo de los Cines. No está en la clase Edificio
	public void proyectarSesion(int asistentes, byte precioSesion) {
		int recaudacion = asistentes*precioSesion;
		System.out.println("Se han recaudado "+ recaudacion +" euros.");
	}
	
	// Método heredado calcularCosteLimpiezaMes() => No es necesario sobreescribirlo
			
	// Método heredado limpiar() => No es necesario sobreescribirlo
		
	// Método heredado vigilantesNecesarios() => No es necesario sobreescribirlo
	
	// Método heredado para calcularCosteVigilancia() => No es necesario sobreescribirlo
		
	// Método heredado vigilar() => No es necesario sobreescribirlo
	// Método heredado toString => No es necesario sobreescribirlo
	
} // FINAL DE LA CLASE CINE
