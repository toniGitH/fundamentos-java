// Módulo 8 - Ejercicio 5

public class Punto {

	// DECLARACIÓN DE PROPIEDADES O ATRIBUTOS
	private int pX;
	private int pY;
	
	// DECLARACIÓN DEL CONSTRUCTOR
	public Punto (int coordenadaX, int coordenadaY) {
		pX = coordenadaX;
		pY = coordenadaY;
	}
	
	// MÉTODOS GETTERS
	public int getCoordenadaX() {
		return pX;
	}
	
	public int getCoordenadaY() {
		return pY;
	}
	
	// MÉTODOS SETTERS
	
	public void setCoordenadaX(int coordenadaX) {
		pX = coordenadaX;
	}
	
	public void setCoordenadaY(int coordenadaY) {
		pY = coordenadaY;
	}
	
	// RESTO MÉTODOS DE CLASE
	
	public String toString() {
		return "Coordenadas cartesianas = (" + pX + "," + pY + ")";
	}
	
} // FIN CLASE PUNTO
