// Módulo 8 - Ejercicio 5 (V2)

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
	
	// Este método, inicialmente estaba en esta clase, pero es más correcto que estuviera
	// en la clase Punto, que es donde está ahora.
	/*public double distanciaCentros(Circulo otroCirculo) {
		double cuadradoX = Math.pow((centro.getCoordenadaX() - otroCirculo.getCentro().getCoordenadaX()), 2);
		double cuadradoY = Math.pow((centro.getCoordenadaY() - otroCirculo.getCentro().getCoordenadaY()), 2);
		return Math.sqrt(cuadradoX+cuadradoY);
	}*/
	
	public double distanciaCirculos(Circulo otroCirculo) {
		return centro.distanciaCentros(otroCirculo.getCentro());
	}
		
	public boolean tieneIgualRadio(Circulo otroCirculo) {
		return radio == otroCirculo.getRadio();
		// En este caso, como en todos los demás, cuando quiero hacer referencia al radio
		// del otroCirculo, es posible usar otroCirculo.radio, pero es más correcto y más
		// claro, hacer otroCirculo.getRadio(), porque queda más claro que hago referencia
		// al radio del otro objeto.
	}
		
	public boolean sonIguales(Circulo otroCirculo) {
		//return centro.distanciaCentros(otroCirculo.getCentro())==0 && tieneIgualRadio(otroCirculo);
		return distanciaCirculos(otroCirculo)==0 && tieneIgualRadio(otroCirculo);
	}
		
	public boolean sonConcentricos(Circulo otroCirculo) {
		return distanciaCirculos(otroCirculo)==0 && tieneIgualRadio(otroCirculo)==false;
	}

	public boolean sonTangentes(Circulo otroCirculo) {
		boolean sonTangentes=false;
		if (sonIguales(otroCirculo)) {
			sonTangentes=true;
		} else if (radio + otroCirculo.getRadio() == distanciaCirculos(otroCirculo)) {
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
		else if (radio + otroCirculo.getRadio() > distanciaCirculos(otroCirculo)) {
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
		} else if(radio + otroCirculo.getRadio() >= distanciaCirculos(otroCirculo)) {
			noseTocan=false;
		}
		return noseTocan;
	}
		
	public String toString() {
		return "Centro = " + centro + " / Radio = " + radio;
	}

} // FIN CLASE CIRCULO
