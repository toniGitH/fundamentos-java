// Módulo 6 - Ejercicio 1

import java.util.ArrayList; // Importamos la clase ArrayList
import java.util.Scanner; // Importamos la clase Scanner

public class App {

	// MÉTODO "main":
	
	public static void main(String[] args) { 

		// DECLARACIÓN DE VARIABLES A UTILIZAR:
		
		ArrayList<Integer> numerosElegidos = new ArrayList<Integer>();
		char operacionElegida;
		double resultadoFinal;
		
		// LLAMADAS A MÉTODOS:
		
		numerosElegidos = pedirNumeros();
		/* 1) Llamada al método "pedirNumeros()" para pedir/retornar ArrayList con los dos
			  números elegidos por el usuario y nos quedamos con esos números almacenados
	    	  dentro del ArrayList llamado "numeros" para utilizarlos después*/
		
		operacionElegida = pedirOperacion();
		/* 2) Llamada al método "pedirOperacion()" para pedirle al usuario que elija la
		      operacion a realizar, y el valor que devuelve el método lo almacenamos dentro
		      de la variable de tipo char llamada "operacionElegida" (para utilizar ese valor
		      más adelante)*/
		
		resultadoFinal = calculadora(numerosElegidos.get(0), numerosElegidos.get(1), operacionElegida);
		/* 3) Llamada al método "calculadora()": este método requiere que le pasemos 3
		 	  parámetros (los dos números a operar y la operación a realizar). Este método
		 	  realiza la operación y nos retorna el valor de dicha operación, que almacenamos
		 	  en la variable "resultadoFinal", que podremos utilizar más tarde para imprimir
		 	  los resultados.*/
		
		impresion(numerosElegidos.get(0), numerosElegidos.get(1), operacionElegida, resultadoFinal);
		/* 4) Llamada al método "impresion() para imprimir en consola los valores de las
		      variables que hemos ido guardando */
		
	} // Fin del método main
	
	//***************************************************************************************
	
	// RESTO DE MÉTODOS: "pedirNumero()", "pedirOperacion()", "calculadora()" e "impresion()"
	
					// -- MÉTODO "pedirNumeros()" -- //
	/* Cuando se llama a este método, se declara un ArrayList llamado "numeros" y un objeto
	   Scanner llamado "entrada"; mediante el Scanner se capturan los 2 números que teclea
	   usuario, y mediante el método "add()" se añaden al ArrayList.
	   Finalmente, el método "pedirNumeros()" retorna el ArrayList para que el programa lo 
	   almacene dentro del ArrayList llamado "numerosElegidos" y lo pueda utilizar después */
	
	static ArrayList<Integer> pedirNumeros() {
		
		// Declaramos el ArrayList y el objeto Scanner:
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		Scanner entrada = new Scanner(System.in);
		
		// Pedimos el primer número y lo almacenamos en el ArrayList:
		System.out.println("Introduce un número entero:");
		numeros.add(entrada.nextInt());
		
		// Pedimos el segundo número y lo almacenamos en el ArrayList:
		System.out.println("Introduce otro número entero:");
		numeros.add(entrada.nextInt());
		
		//entrada.close(); // Comentado para que no de errores

		return numeros; // Retornamos el ArrayList de los dos números escritos para que el
						// programa lo pueda almacenar para usarlo luego.

	} // Fin del método "pedirNumeros()"
	//------------------------------------------------------------------------------------------
	
					// -- MÉTODO "pedirOperacion()" -- //
	/* Cuando se llama a este método, se declara una variable de tipo char llamada "operacion"
	   y un objeto Scanner llamado "entrada"; mediante el Scanner se captura el valor 
	   introducido por el usuario y ese valor capturado se almacena dentro de la variable
	   "operacion". Finalmente, el método "pedirOperacion" retorna el valor de la variable
	   "operacion" para que el programa lo almacene dentro de la variable de tipo char 
	   llamada "operacionElegida" y lo pueda utilizar después */
	
	static char pedirOperacion() {
		
		// Declaramos el objeto Scanner y la variable de tipo char llamada "operacion"
		char operacion;
		Scanner entrada = new Scanner(System.in);
		
		// Pedimos al usuario la operación a realizar y almacenamos ese dato en la variable 
		// "operacion" (introducimos una estructura "while" para asegurarnos de que el usuario
		// escoge una opción válida):
	
		System.out.println("Elige qué operación matemática quieres hacer:");
		System.out.println("Suma (pulsa +) -- Resta (pulsa -) -- Multiplicación (pulsa *) -- División (pulsa /) -- Módulo (pulsa %)");
		operacion = entrada.next().charAt(0);
		
		while (operacion!='+' && operacion!='-' && operacion!='*' && operacion!='/' && operacion!='%') {
			System.out.println("El tipo de operación que has elegido no es correcto. Vuelve a elegir una opción:");
			System.out.println("Suma (pulsa +) -- Resta (pulsa -) -- Multiplicación (pulsa *) -- División (pulsa /) -- Módulo (pulsa %)");
			operacion = entrada.next().charAt(0);
		}
		
		//entrada.close(); // Comentado para que no de errores
		
		return operacion; // Retornamos el valor de la variable "operacion" para que el
						  // programa pueda usarlo luego.
		
	} // Fin del método "pedirOperacion()"
	//------------------------------------------------------------------------------------------
	
					// -- MÉTODO "calculadora()" -- //
	/* Cuando se llama a este método, lo hacemos pasándole 3 parámetros, que son los dos
	   números que ha elegido el usuario y la operación seleccionada. Esos parámetros se 
	   han obtenido de los métodos "pedirNumeros()" y "pedirOperacion", que se han retornado
	   al programa para que este los almacene dentro del ArrayList "numerosElegidos" y la
	   variable "operacionElegida" respectivamente".
	   Lo que hará este método es, mediante una estructura "switch", cuyos "case" serán los
	   diferentes valores posibles de la variable "operacionElegida", determinar qué operación
	   se debe realizar, y dentro de cada uno de esos "case", tomar los dos valores numéricos
	   pasados por parámetros (los números almacenados en el ArrayList "numerosElegidos"), y
	   realizar la operación correspondiente.
	   Finalmente, éste método retorma al programa el valor de dicha operación para que el 
	   programa lo almacene dentro de la variable "resultadoFinal" y lo pueda imprimir */
	
	static double calculadora(int paramNum1, int paramNum2, char paramOperacion) {
		
		double resultadoOp=0; // Se debe inicializar con un valor, porque si no, la instrucción
							  // del "return" de más abajo, da error.
		
		switch (paramOperacion) {
			case '+':
				resultadoOp=paramNum1+paramNum2;
				break;
			case '-':
				resultadoOp=paramNum1-paramNum2;
				break;
			case '*':
				resultadoOp=paramNum1*paramNum2;
				break;
			case '/':
				resultadoOp=(double)paramNum1/paramNum2;
				break;
			case '%':
				resultadoOp=paramNum1%paramNum2;
				break;
			//default: // No es necesario este "default" porque hay una validación previa
					   // en el método "pedirOperacion()" que nos asegura que el valor de 
					   // "paramOperacion" solo puede ser uno de los 4 valores válidos.
		} // Fin switch
		
		return resultadoOp; // Retornamos el valor de la variable "resultadoOp" para que el
							// programa pueda usarlo luego.
		
	} // Fin del método "calculadora()"
	//------------------------------------------------------------------------------------------
	
					// -- MÉTODO "impresion()" -- //
	/* Cuando se llama a éste método, se hace pasándole 4 parámetros, que son los que queremos
	   que imprima por consola */
	
	static void impresion(int paramNum1, int paramNum2, char paramOperacion, double paramResultado) {
	
		System.out.println("OPERACIÓN REALIZADA: " + paramNum1 + paramOperacion + paramNum2 + " = " + paramResultado);

	} // Fin del método "impresion()"
	
} // Fin de la clase App
