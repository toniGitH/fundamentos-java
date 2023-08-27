// Módulo 7.1 - Ejercicio 8

import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		double gradosC = pedirDouble("Introduce la temperatura, en ºC");
		double gradosF = conversionTemp(gradosC);
		impresionConversion(gradosC, gradosF);
		
		// CÓDIGO RESUMIDO EQUIVALENTE
		//double gradosC = pedirDouble("Introduce la temperatura, en ºC");
		//impresionConversion(gradosC, conversionTemp(gradosC));
		
		
	} // Fin método main
	
	// RESTO DE MÉTODOS
	
	// método para pedir un double (temperatura en ºC)
	static double pedirDouble(String msg) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		return entrada.nextDouble();
 	}
	
	// método para aplicar fórmula
	static double conversionTemp(double paramCelsius) {
		final byte K = 32;
		return (paramCelsius*9/5)+K;	
	}
	
	// método para imprimir resultados
	static void impresionConversion(double paramC, double paramF) {
		System.out.println(paramC + " ºC son " + paramF + " ºF" );
	}

}
