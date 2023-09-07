// Módulo 8 - Ejercicio 6 (Versión 2)

package PaqueteEscuderias;
//import java.util.ArrayList;

public class Bolido {

	// DECLARACIÓN DE PROPIEDADES O ATRIBUTOS
	private String escuderiaBolido;
	private String modeloBolido;
	private int potenciaBolido;
	private int velocidadBolido;
	private int precioBolido;
	private String colorBolido;
	
	// DECLARACIÓN DEL CONSTRUCTOR
	public Bolido(String escuderiaBolido, String modeloBolido, int potenciaBolido, int velocidadBolido, int precioBolido, String colorBolido) {
		this.escuderiaBolido=escuderiaBolido;
		this.modeloBolido=modeloBolido;
		this.potenciaBolido=potenciaBolido;
		this.velocidadBolido=velocidadBolido;
		this.precioBolido=precioBolido;
		this.colorBolido=colorBolido;
	}
	
	// MÉTODOS GETTERS
	
	public String getEscuderia() {
		return escuderiaBolido;
	}
	
	public String getModeloBolido() {
		return modeloBolido;
	}
	
	public int getPotenciaBolido() {
		return potenciaBolido;
	}
	
	public int getVelocidadBolido() {
		return velocidadBolido;
	}
	
	public int getPrecioBolido(){
		return precioBolido;
	}
	
	public String getColorBolido() {
		return colorBolido;
	}
	
	// MÉTODOS SETTERS
	
	public void setEscuderiaBolido(String escuderiaBolido) {
		this.escuderiaBolido=escuderiaBolido;
	}
	
	public void setModeloBolido(String modeloBolido) {
		this.modeloBolido=modeloBolido;
	}

	public void setPotenciaBolido(int potenciaBolido) {
		this.potenciaBolido=potenciaBolido;
	}
	
	public void setVelocidadBolido(int velocidadBolido) {
		this.velocidadBolido=velocidadBolido;
	}
	
	public void setPrecioBolido(int precioBolido) {
		this.precioBolido=precioBolido;
	}
	
	public void setColorBolido(String colorBolido) {
		this.colorBolido=colorBolido;
	}
	
	
	// RESTO MÉTODOS DE CLASE
	
	// Método toString()
	public String toString() {
		return "DATOS DEL BÓLIDO" +
				"\n---------------" +
				"\nNombre: " + modeloBolido +
				"\nPotencia: " + potenciaBolido + " CV" +
				"\nVelocidad máxima: " + velocidadBolido + " km/h" +
				"\nPrecio:" + precioBolido + " euros" +
				"\nEscudería:" + escuderiaBolido; 
	}
	
} // FIN CLASE BOLIDO