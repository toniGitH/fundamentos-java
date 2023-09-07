// Módulo 8 - Ejercicio 5 (V1)

import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		// DECLARACIÓN DE VARIABLES
		ArrayList<Circulo> listaCirculos=new ArrayList<Circulo>();
		char repetir='n';

		// MENU PRINCIPAL
		do {
			System.out.println("Introduce los datos del PRIMER CÍRCULO:");
			crearCirculo(listaCirculos);
			System.out.println("Introduce los datos del SEGUNDO CÍRCULO:");
			crearCirculo(listaCirculos);
			verCirculos(listaCirculos);
			imprimirResultados(listaCirculos.get(0), listaCirculos.get(1));
			
			// Reiniciamos el ArrayList de círculos:
			listaCirculos=new ArrayList<Circulo>();
			repetir = pedirChar("¿Quieres hacer otra operación (s/n)?");
		} while (repetir=='s');	
		
		System.out.println("FIN DEL PROGRAMA");
			
	} // Fin del método main
	
	// -------------------------------------------------------------------------
	
	// RESTO DE MÉTODOS
	
	// Método para crear un círculo
	public static void crearCirculo(ArrayList<Circulo> listaCirculos) {
		int coordenadaX, coordenadaY, radio;
		coordenadaX = pedirInt("Indica la coordenada del eje X:");
		coordenadaY = pedirInt("Indica la coordenada del eje Y:");
		radio =  pedirIntPositivo("Indica el radio del círculo:");
		Punto centro = new Punto(coordenadaX, coordenadaY);
		Circulo circulo = new Circulo(centro, radio);
		listaCirculos.add(circulo);
	}
	
	// Método para imprimir todos los resultados
	public static void imprimirResultados(Circulo circulo, Circulo otroCirculo) {
		imprimirDistancia(circulo, otroCirculo);
		imprimirSiIguales(circulo, otroCirculo);
		imprimirConcentricos(circulo, otroCirculo);
		imprimirSiIgualRadio(circulo, otroCirculo);
		imprimirSiTangentes(circulo, otroCirculo);
		imprimirSiSecantes(circulo, otroCirculo);
		imprimirSiNoSeTocan(circulo, otroCirculo);
	}
	
	// Método para imprimir la distancia entre los centros de los dos círculos
	public static void imprimirDistancia(Circulo circulo, Circulo otroCirculo) {
		System.out.println("La distancia entre los centros es " + circulo.distanciaCentros(otroCirculo));
	}
	
	// Método para imprimir si dos círculos son iguales
	public static void imprimirSiIguales(Circulo circulo, Circulo otroCirculo) {
		if (circulo.sonIguales(otroCirculo)) {
			System.out.println("Los círculos son iguales.");
		} else {
			System.out.println("Los círculos no son iguales.");
		}
	}
	
	// Método para imprimir si dos círculos son concéntricos
	public static void imprimirConcentricos(Circulo circulo, Circulo otroCirculo) {
		if (circulo.sonConcentricos(otroCirculo)) {
			System.out.println("Los círculos son concéntricos.");
		} else {
			System.out.println("Los círculos no son concéntricos.");
		}
	}
	
	// Método para imprimir si dos círculos tienen el mismo radio
	public static void imprimirSiIgualRadio(Circulo circulo, Circulo otroCirculo) {
		if (circulo.tieneIgualRadio(otroCirculo)) {
			System.out.println("Ambos círculos tienen el mismo radio.");
		} else {
			System.out.println("Los círculos tienen radios diferentes.");
		}
	}
	
	// Método para imprimir si dos círculos son tangentes
	public static void imprimirSiTangentes(Circulo circulo, Circulo otroCirculo) {
		if (circulo.sonTangentes(otroCirculo)) {
			System.out.println("Los círculos son tangentes.");
		} else {
			System.out.println("Los círculos no son tangentes.");
		}
	}
	
	// Método para imprimir si dos círculos son secantes
	public static void imprimirSiSecantes(Circulo circulo, Circulo otroCirculo) {
			if (circulo.sonSecantes(otroCirculo)) {
				System.out.println("Los círculos son secantes.");
			} else {
				System.out.println("Los círculos no son secantes.");
			}
	}
	
	// Método para imprimir si dos círculos no se tocan
	public static void imprimirSiNoSeTocan(Circulo circulo, Circulo otroCirculo) {
		if (circulo.noSeTocan(otroCirculo)) {
			System.out.println("Los círculos no se tocan.");
		} else {
			System.out.println("Los círculos se tocan.");
		}
	}
	
	// Método para imprimir listado de círculos (para poder comprobar los resultados)
	public static void verCirculos(ArrayList<Circulo> listaCirculos) {
		for (int i=0; i<2; i++) {
			System.out.println("Círculo " + (i+1) + " :" + listaCirculos.get(i));
		} 
	}
	
	// Método para pedir un dato de tipo int
	public static int pedirInt(String msg) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		return entrada.nextInt();
	}
	
	// Método para pedir un dato de tipo int que sea positivo
	static int pedirIntPositivo (String msg) {
		Scanner entrada = new Scanner(System.in);
		int nuevoValor;		
		do {
			nuevoValor = pedirInt(msg);
			if (nuevoValor<=0) {
				System.out.println("El valor introducido no es válido. Debe ser un valor positivo.");
			} 
		} while (nuevoValor<=0);
		
		return nuevoValor;
	}
	
	static char pedirChar(String msg) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		return entrada.next().toLowerCase().charAt(0);
	}

	// ¡¡¡ ESTE MÉTODO NO VA AQUÍ !!!  ?????????????????????????????????????
	// DUDA : ¿POR QUÉ NO PUEDE IR AQUÍ?
	// Método para calcular distancia entre 2 puntos de un eje cartesiano
	public static double distancia(ArrayList<Circulo> listaCirculos) {
		double x1 = listaCirculos.get(0).getCentro().getCoordenadaX();
		double x2 = listaCirculos.get(1).getCentro().getCoordenadaX();
		double y1 = listaCirculos.get(0).getCentro().getCoordenadaY();
		double y2 = listaCirculos.get(1).getCentro().getCoordenadaY();
		return Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2));
	}
		
} // FIN DE LA CLASE APP
