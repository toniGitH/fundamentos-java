// Módulo 7.3 - Ejercicio 1

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		byte opcion;
		do {
			opcion = menuOpciones();
			double resultado = calculadora(opcion);
			impresion(resultado);
		} while (opcion!=0);		
		
		// CÓDIGO RESUMIDO EQUIVALENTE
		//impresion(calculadora(menuOpciones()));
		
		
	} // Fin del método main
	
	// ------------------------------------------------------------------------------
	
	// RESTO DE MÉTODOS
	
	// método para pedir un byte (lo usaremos para pedir la opción a calcular)
	static byte pedirByte(String msg) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		return entrada.nextByte();
	}
	
	// método para pedir un double (lo usaremos para pedir las medidas de las figuras)
	static double pedirDouble(String msg) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		return entrada.nextDouble();
	}
	
	// método para pedir un char => ESTE MÉTODO NO APLICA
	/*static char pedirChar(String msg) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		return entrada.next().toLowerCase().charAt(0);
	}*/
	
	// método para pedir la opción a calcular
	static byte menuOpciones() {
		byte opcionElegida;
		System.out.println("Elige una opción:");
		System.out.println("1. Cuadrado");
		System.out.println("2. Triángulo");
		System.out.println("3. Rectángulo");
		System.out.println("4. Círculo");
		System.out.println("0. Salir del programa");
		opcionElegida = pedirByte("");
		while (opcionElegida<0 || opcionElegida>4) {
			opcionElegida = pedirByte("Opción incorrecta. Vuelve a intentarlo");
		}
		return opcionElegida;
	}
	
	// método que pide los datos de cálculo y llama a la función correspondiente
	static double calculadora(byte paramOpcion) {
		double resultado=0;
		switch (paramOpcion) {
		case 0: // Salir del programa
			break;
		case 1: // Cuadrado
			System.out.println("Has elegido calcular el área del CUADRADO");
			resultado=areaCuadrado(pedirDouble("Introduce el lado"));
			break;
		case 2: // Triángulo
			System.out.println("Has elegido calcular el área del TRIÁNGULO");
			resultado=areaTriangulo(pedirDouble("Introduce base"), pedirDouble("Introduce altura"));
			break;
		case 3: // Rectángulo
			System.out.println("Has elegido calcular el área del RECTÁNGULO");
			resultado=areaRectangulo(pedirDouble("Introduce base"), pedirDouble("Introduce altura"));
			break;
		case 4: // Círculo
			System.out.println("Has elegido calcular el área del CÍRCULO");
			resultado=areaCirculo(pedirDouble("Introduce el radio"));
			break;		
		//default:
		//	break;
		}
		return resultado;
	}
	
	// método que calcula el área de un cuadrado
	static double areaCuadrado(double paramLadoCuadrado) {
		return (paramLadoCuadrado*paramLadoCuadrado);
	}
	
	// método que calcula el área de un triángulo
	static double areaTriangulo(double paramBase, double paramAltura) {
		return (paramBase*paramAltura)/2;
	}
	
	// método que calcula el área de un rectángulo
	static double areaRectangulo(double paramBase, double paramAltura) {
		return (paramBase*paramAltura);
	}
	
	// método que calcula el área de un círculo
	static double areaCirculo(double paramRadio) {
		final double pi = 3.141592;
		return (paramRadio*paramRadio)*pi;
	}
	
	// método que imprime resultados en pantalla
	static void impresion(double paramResultado) {
		if (paramResultado==0) {
			System.out.println("¡¡ Hasta pronto !!");
		} else {
			System.out.println("El área de la figura que has elegido es " + paramResultado);
		}
	}
	
} // Fin de la clase App
