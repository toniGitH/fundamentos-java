// Módulo 7.3 - Ejercicio 4
// Esta versión no utiliza ArrayList, sino simplemente una cadena de tipo String, con la
// que podemos hacer el mismo proceso lógico que si utilizáramos un ArrayList

import java.util.Scanner;

public class App_alternativa {

	public static void main(String[] args) {
		
		// DECLARACIÓN DE VARIABLES:
		String cadenaControl ="TRWAGMYFPDXBNJZSQVHLCKN";
		//ArrayList<Character> listaDeControl = creaListaDeControl();
		final byte K = 23;

		// RESTO DE PROGRAMA:
		
		/* 1) Llamamos al método "pedirString()" para que el usuario teclee su DNI y
		      almacenamos el valor devuelto en la variable "dni"*/
		String dni = pedirString("Escribe tu dni");
		
		/* 2) Llamamos al método "longitudString()", pasándole por parámetro el String
		      almacenado en el paso 1 para obtener la longitud total del DNI */
		int longString = longitudString(dni);
		
		/* 3) Llamamos al método "extraerStringNums()" para extraer la parte numérica del
		      String DNI, aunque la extraemos como un dato de tipo String, y lo guardamos
		      dentro de la variable "parteNumericaString"*/
		String parteNumericaString = extraerStringNums(dni, longString);
		
		/* 4) Llamamos al método "deLetraANumero()" para convertir el String de números
		      extraido anteriormente en un dato de tipo int*/
		int numero = deLetraANumero(parteNumericaString);
		
		/* 5) Llamamos al método "extraerUltimaPosicion()" para extraer la letra del DNI
		 	  TECLEADA por el usuario, y la guardamos en una variable de tipo char, pero
		 	  en mayúsculas*/
		char letraDniTecleada = extraerUltimaPosicion(dni, longString);
		
		/* 6) Llamamos al método "modulo()" para obtener el módulo(K) del número del DNI
		      tecelado por el usuario, siendo K una constante predefinida. El valor 
		      obtenido lo almacenamos en una variable de tipo byte llamada "residuo"*/
		byte residuo = modulo(numero, K);
		
		/* 7) Llamamos al método "extraeCaracterDeArrayControl()" para extraer del
		      ArrayList de control creado al inicio el valor que corresponde a la
		      posición o índice "residuo"*/
		char letraControl = extraeCaracterDeControl(cadenaControl, residuo);
		
		/* 8) Llamamos al método "imprimirMensaje()", que nos va a imprimir uno u otro
		      mensaje, en función de que la letraTecleada y la letraControl sean iguales
		      o diferentes*/
		imprimirMensaje(letraDniTecleada, letraControl);
		
	} // Final método main
	
	// ------------------------------------------------------------------
	
	// RESTO DE MÉTODOS
	
	// método para pedir String (para pedir el dni con números y letra)
	static String pedirString(String msg) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		return entrada.nextLine();
	}
	
	// método para determinar la longitud de un String
	static int longitudString(String paramString) {
		return paramString.length();
	}
	
	// método para extraer un substring de un String (no se extrae la última posición del String original)
	static String extraerStringNums(String paramString, int paramLongitudString) {
		return paramString.substring(0, paramLongitudString-1);
	}
	
	// método para extraer la última posición de un String, devuelta en Mayusc
	static char extraerUltimaPosicion(String paramString, int paramLongitudString) {
		//return paramString.charAt(paramLongitudString-1);
		return paramString.toUpperCase().charAt(paramLongitudString-1);
	}
	
	// método para convertir un String a int
	static int deLetraANumero(String paramString) {
		return Integer.parseInt(paramString);
	}
	
	// método para calcular módulo
	static byte modulo(int paramNumDni, byte paramK) {
		return (byte)(paramNumDni%paramK);
	}
	
	// método para obtener el carácter que ocupa un determinado núm de índice en un String
	static char extraeCaracterDeControl(String paramCadenaControl, byte paramResto) {
		return paramCadenaControl.charAt(paramResto);
	}
	
	// método para imprimir mensaje final
	static void imprimirMensaje(char paramLetraTecleada, char paramLetraControl) {
		if (paramLetraTecleada==paramLetraControl) {
			System.out.println("La letra de tu DNI es correcta");
		} else {
			System.out.println("La letra de tu DNI es incorrecta");
			System.out.println("La letra que le corresponde al número que has tecleado es la " + paramLetraControl);
		}
	}
	
} // Fin clase App_Alternativa
