// Módulo 4 - Ejercicio 6
// Con control de datos: si el usuario introduce un mes incorrecto o un día incorrecto, el programa informa de ello

import java.util.Scanner; // Importamos la clase Scanner

public class App {

	public static void main(String[] args) { // Método main
		
		// Declaramos 2 variables de tipo "byte" llamadas "mes" y "dia":
		byte mes, dia;
		
		// Creamos objeto de tipo "Scanner" y lo almacenamos en variable de tipo "Scanner" llamada "entrada":
		Scanner entrada = new Scanner(System.in);
		
		// Imprimimos en consola mensaje para el usuario para preguntar mes de nacimiento:
		System.out.println("Introduce el mes de nacimiento (en número)");
		
		// Capturamos dato introducido en consola mediante método "nextByte()" y lo guardamos en la variable
		// llamada "mes" declarada anteriormente:
		mes = entrada.nextByte();
		
		// Con un primer condicional if/else validamos que el usuario escriba un número de mes correcto (entre 1 y 12),
		// evaluando el valor que pueda haber tomado la variable "mes":
		if (mes>=1 && mes<=12) { // Si el número introducido en consola está entre el 1 y el 12, seguirá
								 // ejecutando el programa:
			
			// Imprimimos mensaje en consola para el usuario para preguntar día de nacimiento:
			System.out.println("Introduce el día de nacimiento");
			
			// Capturamos dato introducido en consola mediante método "nextByte()" y lo guardamos en la variable
			// llamada "dia" declarada anteriormente:
			dia = entrada.nextByte();
			
			// Con un switch, establecemos lo que el programa tiene que hacer para cada uno de los 12 valores
			// diferentes que puede haber tomado la variable "mes":
			
			switch (mes) {
			
				case 1: // Si el valor de la variable "mes" toma el valor 1, estamos en enero:
					if (dia>=1 && dia<20) {
						System.out.println("Has nacido el día " + dia + " de enero, por lo que tu signo del zodíaco es CAPRICORNIO");
					} else if (dia>=20 && dia<=31){
						System.out.println("Has nacido el día " + dia + " de enero, por lo que tu signo del zodíaco es ACUARIO");		
					} else { // Si el valor de día NO está entre "0" y "31": 
						System.out.println("¡¡El día que has introducido no existe!!");
						System.out.println("FIN DEL PROGRAMA POR DÍA ERRÓNEO: NOK");
					}
					break;
					
				case 2:
					if (dia>=1 && dia<19) {
						System.out.println("Has nacido el día " + dia + " de febrero, por lo que tu signo del zodíaco es ACUARIO");
					} else if (dia>=19 && dia<=29){
						System.out.println("Has nacido el día " + dia + " de febrero, por lo que tu signo del zodíaco es PISCIS");		
					} else {
						System.out.println("¡¡El día que has introducido no existe!!");
						System.out.println("FIN DEL PROGRAMA POR DÍA ERRÓNEO: NOK");
					}
					break;
					
				case 3:
					if (dia>=1 && dia<21) {
						System.out.println("Has nacido el día " + dia + " de marzo, por lo que tu signo del zodíaco es PISCIS");
					} else if (dia>=21 && dia<=31){
						System.out.println("Has nacido el día " + dia + " de marzo, por lo que tu signo del zodíaco es ARIES");		
					} else {
						System.out.println("¡¡El día que has introducido no existe!!");
						System.out.println("FIN DEL PROGRAMA POR DÍA ERRÓNEO: NOK");
					}
					break;
					
				case 4:
					if (dia>=1 && dia<20) {
						System.out.println("Has nacido el día " + dia + " de abril, por lo que tu signo del zodíaco es ARIES");
					} else if (dia>=20 && dia<=30){
						System.out.println("Has nacido el día " + dia + " de abril, por lo que tu signo del zodíaco es TAURO");		
					} else {
						System.out.println("¡¡El día que has introducido no existe!!");
						System.out.println("FIN DEL PROGRAMA POR DÍA ERRÓNEO: NOK");
					}
					break;
					
				case 5:
					if (dia>=1 && dia<21) {
						System.out.println("Has nacido el día " + dia + " de mayo, por lo que tu signo del zodíaco es TAURO");
					} else if (dia>=21 && dia<=31){
						System.out.println("Has nacido el día " + dia + " de mayo, por lo que tu signo del zodíaco es GÉMINIS");		
					} else {
						System.out.println("¡¡El día que has introducido no existe!!");
						System.out.println("FIN DEL PROGRAMA POR DÍA ERRÓNEO: NOK");
					}
					break;
					
				case 6:
					if (dia>=1 && dia<21) {
						System.out.println("Has nacido el día " + dia + " de junio, por lo que tu signo del zodíaco es GÉMINIS");
					} else if (dia>=21 && dia<=30){
						System.out.println("Has nacido el día " + dia + " de junio, por lo que tu signo del zodíaco es CÁNCER");		
					} else {
						System.out.println("¡¡El día que has introducido no existe!!");
						System.out.println("FIN DEL PROGRAMA POR DÍA ERRÓNEO: NOK");
					}
					break;
					
				case 7:
					if (dia>=1 && dia<23) {
						System.out.println("Has nacido el día " + dia + " de julio, por lo que tu signo del zodíaco es CÁNCER");
					} else if (dia>=23 && dia<=31){
						System.out.println("Has nacido el día " + dia + " de julio, por lo que tu signo del zodíaco es LEO");		
					} else {
						System.out.println("¡¡El día que has introducido no existe!!");
						System.out.println("FIN DEL PROGRAMA POR DÍA ERRÓNEO: NOK");
					}
					break;
					
				case 8:
					if (dia>=1 && dia<23) {
						System.out.println("Has nacido el día " + dia + " de agosto, por lo que tu signo del zodíaco es LEO");
					} else if (dia>=23 && dia<=31){
						System.out.println("Has nacido el día " + dia + " de agosto, por lo que tu signo del zodíaco es VIRGO");		
					} else {
						System.out.println("¡¡El día que has introducido no existe!!");
						System.out.println("FIN DEL PROGRAMA POR DÍA ERRÓNEO: NOK");
					}
					break;
					
				case 9:
					if (dia>=1 && dia<23) {
						System.out.println("Has nacido el día " + dia + " de septiembre, por lo que tu signo del zodíaco es VIRGO");
					} else if (dia>=23 && dia<=30){
						System.out.println("Has nacido el día " + dia + " de septiembre, por lo que tu signo del zodíaco es LIBRA");		
					} else {
						System.out.println("¡¡El día que has introducido no existe!!");
						System.out.println("FIN DEL PROGRAMA POR DÍA ERRÓNEO: NOK");
					}
					break;
					
				case 10:
					if (dia>=1 && dia<23) {
						System.out.println("Has nacido el día " + dia + " de octubre, por lo que tu signo del zodíaco es LIBRA");
					} else if (dia>=23 && dia<=31){
						System.out.println("Has nacido el día " + dia + " de octubre, por lo que tu signo del zodíaco es ESCORPIO");		
					} else {
						System.out.println("¡¡El día que has introducido no existe!!");
						System.out.println("FIN DEL PROGRAMA POR DÍA ERRÓNEO: NOK");
					}
					break;
					
				case 11:
					if (dia>=1 && dia<22) {
						System.out.println("Has nacido el día " + dia + " de noviembre, por lo que tu signo del zodíaco es ESCORPIO");
					} else if (dia>=22 && dia<=30){
						System.out.println("Has nacido el día " + dia + " de noviembre, por lo que tu signo del zodíaco es SAGITARIO");		
					} else {
						System.out.println("¡¡El día que has introducido no existe!!");
						System.out.println("FIN DEL PROGRAMA POR DÍA ERRÓNEO: NOK");
					}
					break;
					
				case 12:
					if (dia>=1 && dia<22) {
						System.out.println("Has nacido el día " + dia + " de diciembre, por lo que tu signo del zodíaco es SAGITARIO");
					} else if (dia>=22 && dia<=31){
						System.out.println("Has nacido el día " + dia + " de diciembre, por lo que tu signo del zodíaco es CAPRICORNIO");		
					} else {
						System.out.println("¡¡El día que has introducido no existe!!");
						System.out.println("FIN DEL PROGRAMA POR DÍA ERRÓNEO: NOK");
					}
					break;
				
				// default: => En este caso, no hace falta, porque si el programa ha llegado a este "switch"
				// es porque SEGURO que el valor de la variable "mes" está entre 1 y 12 (gracias al primer
				// if/else):
					
			} // Fin del switch
			
		} else { // Si el valor de la variable "mes" No está entre 1 y 12, el programa entre en el else:
			
			System.out.println("¡¡El mes que has introducido no existe!!");
			System.out.println("FIN DEL PROGRAMA POR MES ERRÓNEO: NOK");
			
		} // Fin del condicional if/else
		
		// Cerramos el objeto Scanner:
		entrada.close();
		
	} // Fin del método main
	
} // Fin de la clase App
