// Módulo 8 - Ejercicio 5

public class Circulo {

	// DECLARACIÓN DE PROPIEDADES O ATRIBUTOS
	private Punto centro;
	private int radio;
	
	// DECLARACIÓN DEL CONSTRUCTOR
	public Circulo (Punto centro, int radio) {
		this.centro=centro;
		this.radio=radio;
	}
	
	// MÉTODOS GETTERS
	public Punto getCentro() {
		return centro;
	}
	
	public int getRadio() {
		return radio;
	}
		
	// MÉTODOS SETTERS
		
	public void setCentro(Punto centro) {
		this.centro=centro;
	}
	
	public void setRadio(int radio) {
		this.radio=radio;
	}
	
	// RESTO MÉTODOS DE CLASE
	
	public double distanciaCentros(Circulo otroCirculo) {
		double cuadradoX = Math.pow((centro.getCoordenadaX() - otroCirculo.getCentro().getCoordenadaX()), 2);
		double cuadradoY = Math.pow((centro.getCoordenadaY() - otroCirculo.getCentro().getCoordenadaY()), 2);
		return Math.sqrt(cuadradoX+cuadradoY);
	}
		
	public boolean tieneIgualRadio(Circulo otroCirculo) {
		return radio == otroCirculo.getRadio();
	}
		
	public boolean sonIguales(Circulo otroCirculo) {
		return distanciaCentros(otroCirculo)==0 && tieneIgualRadio(otroCirculo);
	}
		
	public boolean sonConcentricos(Circulo otroCirculo) {
		return distanciaCentros(otroCirculo)==0 && tieneIgualRadio(otroCirculo)==false;
	}

	public boolean sonTangentes(Circulo otroCirculo) {
		boolean sonTangentes=false;
		if (sonIguales(otroCirculo)) {
			sonTangentes=true;
		} else if (radio + otroCirculo.getRadio() == distanciaCentros(otroCirculo)) {
			if (sonConcentricos(otroCirculo)) {
				sonTangentes=false;
			} else {
				sonTangentes=true;
			}
		} 
		return sonTangentes;
	}
		
	public boolean sonSecantes(Circulo otroCirculo) {
		boolean sonSecantes=false;
		if (sonConcentricos(otroCirculo) || sonIguales(otroCirculo)) {
			sonSecantes=false;
		}
		else if (radio + otroCirculo.getRadio() > distanciaCentros(otroCirculo)) {
				sonSecantes=true;
		}
		return sonSecantes;
	}
	
	public boolean noSeTocan(Circulo otroCirculo) {
		boolean noseTocan=true;
		if (sonConcentricos(otroCirculo)) {
			noseTocan=true;
		} else if(sonIguales(otroCirculo)) {
			noseTocan=false;
		} else if(radio + otroCirculo.getRadio() >= distanciaCentros(otroCirculo)) {
			noseTocan=false;
		}
		return noseTocan;
	}
		
	public String toString() {
		return "Centro = " + centro + " / Radio = " + radio;
	}

} // FIN CLASE CIRCULO
