// Módulo 4 - Ejercicio 6
// No hay ningún control de verificación de datos:
//	 - si el usuario introduce un número de mes que no está entre 1 y 12, el programa se ejecutará hasta el final,
//	   y al final imprimirá un mensaje de NOK
//	 - si el usuario introduce un número de día incorrecto, el programa se ejecutará hasta el final, no lanzará ningún
//	   mensaje de error, pero el resultado que imprimirá en consola no tendrá sentido.

import java.util.Scanner;

public class App {

	public static void main(String[] args) { // Método main
		
		// Creamos un objeto de tipo "Scanner" y lo almacenamos en la variable de tipo "Scanner" llamada "entrada": 
		Scanner entrada = new Scanner(System.in);
		
		// Imprimimos en consola un mensaje al usuario perguntando número de mes de nacimiento:
		System.out.println("Introduce el mes de nacimiento (en número)");
		
		// El valor introducido por el usuario en consola lo recogemos mediante el método "nextByte()" del objeto "Scanner"
		// al que hemos llamado "entrada" y lo almacenamos en una variable de tipo "byte" llamada "mes":
		byte mes = entrada.nextByte();
		
		// Con un primer condicional if/else validamos que el usuario escriba un número de mes correcto (entre 1 y 12),
		// evaluando el valor que pueda haber tomado la variable "mes":
		
		if (mes<0 || mes>12) { // Si el usuario NO introduce un número entre el 1 y el 12:
			System.out.println("El número que has introducido no corresponde a ninguno de los meses del año");
			System.out.println("Fin del programa: NOK"); // Porque al no entrar en el else, después de este if/else ya no hay más código a ejecutar.
		}
		
		else { // Pero si el usuario SÍ introduce un número entre el 1 y el 12, el programa puede continuar:
			
			// Imprimimos en consola un mensaje al usuario perguntando número de día de nacimiento:
			System.out.println("Introduce el día de nacimiento");
			
			// El valor introducido por el usuario en consola lo recogemos mediante el método "nextByte()" y lo almacenamos
			// en una variable de tipo "byte" llamada "dia":
			byte dia = entrada.nextByte();
			
			// Con un segundo condicional if/else eliminamos combinaciones mes/día que son incoherentes:
			if ( (dia<0 || dia>31) || (mes==2 && dia>29) || ((mes==4||mes==6||mes==9||mes==11))&&(dia>30) ) {
				System.out.println("El día que has introducido no puede ser un día de ningún mes");
				System.out.println("Fin del programa: NOK");
			} else { // Si el programa llega a entrar en este "switch", sabemos SEGURO que el mes está entre 1 y 12 y que el
					 // día también es coherente con el mes
				
				// Con un "switch" establecemos qué debe hacer el programa según el valor que se haya almacenado en la variable "mes":
				switch (mes) {
				
					case 1: // Si ha nacido en enero (el valor de la variable mes es 1)
						if (dia<20) { // Sabiendo que ha nacido en enero, si ha nacido entre el 1 y el 19, es Capricornio
							System.out.println("Has nacido el día " + dia + " de enero, por lo que tu signo del zodíaco es CAPRICORNIO");
						} else { // Sabiendo que ha nacido en enero, si ha nacido entre el 20 y el 31, es Acuario:
							System.out.println("Has nacido el día " + dia + " de enero, por lo que tu signo del zodíaco es ACUARIO");		
						}
						break;
						
					case 2: // Si ha nacido en febrero (el valor de la variable mes es 2)
						if (dia<19) {
							System.out.println("Has nacido el día " + dia + " de febrero, por lo que tu signo del zodíaco es ACUARIO");
						} else {
							System.out.println("Has nacido el día " + dia + " de febrero, por lo que tu signo del zodíaco es PISCIS");		
						}
						break;
						
					case 3: // Si ha nacido en marzo (el valor de la variable mes es 3)
						if (dia<21) {
							System.out.println("Has nacido el día " + dia + " de marzo, por lo que tu signo del zodíaco es PISCIS");
						} else {
							System.out.println("Has nacido el día " + dia + " de marzo, por lo que tu signo del zodíaco es ARIES");		
						}
						break;
						
					case 4: // Si ha nacido en abril (el valor de la variable mes es 4)
						if (dia<20) {
							System.out.println("Has nacido el día " + dia + " de abril, por lo que tu signo del zodíaco es ARIES");
						} else {
							System.out.println("Has nacido el día " + dia + " de abril, por lo que tu signo del zodíaco es TAURO");		
						}
						break;
						
					case 5: // Si ha nacido en mayo (el valor de la variable mes es 5)
						if (dia<21) {
							System.out.println("Has nacido el día " + dia + " de mayo, por lo que tu signo del zodíaco es TAURO");
						} else {
							System.out.println("Has nacido el día " + dia + " de mayo, por lo que tu signo del zodíaco es GÉMINIS");		
						}
						break;
						
					case 6: // Si ha nacido en junio (el valor de la variable mes es 6)
						if (dia<21) {
							System.out.println("Has nacido el día " + dia + " de junio, por lo que tu signo del zodíaco es GÉMINIS");
						} else {
							System.out.println("Has nacido el día " + dia + " de junio, por lo que tu signo del zodíaco es CÁNCER");		
						}
						break;
						
					case 7: // Si ha nacido en julio (el valor de la variable mes es 7)
						if (dia<23) {
							System.out.println("Has nacido el día " + dia + " de julio, por lo que tu signo del zodíaco es CÁNCER");
						} else {
							System.out.println("Has nacido el día " + dia + " de julio, por lo que tu signo del zodíaco es LEO");		
						}
						break;
						
					case 8: // Si ha nacido en agosto (el valor de la variable mes es 8)
						if (dia<23) {
							System.out.println("Has nacido el día " + dia + " de agosto, por lo que tu signo del zodíaco es LEO");
						} else {
							System.out.println("Has nacido el día " + dia + " de agosto, por lo que tu signo del zodíaco es VIRGO");		
						}
						break;
						
					case 9: // Si ha nacido en septiembre (el valor de la variable mes es 9)
						if (dia<23) {
							System.out.println("Has nacido el día " + dia + " de septiembre, por lo que tu signo del zodíaco es VIRGO");
						} else {
							System.out.println("Has nacido el día " + dia + " de septiembre, por lo que tu signo del zodíaco es LIBRA");		
						}
						break;
						
					case 10: // Si ha nacido en octubre (el valor de la variable mes es 10)
						if (dia<23) {
							System.out.println("Has nacido el día " + dia + " de octubre, por lo que tu signo del zodíaco es LIBRA");
						} else {
							System.out.println("Has nacido el día " + dia + " de octubre, por lo que tu signo del zodíaco es ESCORPIO");		
						}
						break;
						
					case 11: // Si ha nacido en noviembre (el valor de la variable mes es 11)
						if (dia<22) {
							System.out.println("Has nacido el día " + dia + " de noviembre, por lo que tu signo del zodíaco es ESCORPIO");
						} else {
							System.out.println("Has nacido el día " + dia + " de noviembre, por lo que tu signo del zodíaco es SAGITARIO");		
						}
						break;
						
					case 12: // Si ha nacido en diciembre (el valor de la variable mes es 12)
						if (dia<22) {
							System.out.println("Has nacido el día " + dia + " de diciembre, por lo que tu signo del zodíaco es SAGITARIO");
						} else {
							System.out.println("Has nacido el día " + dia + " de diciembre, por lo que tu signo del zodíaco es CAPRICORNIO");		
						}
						break;
						
					//default: =>  // No hace falta "default", porque gracias al if/else que lo envuelve, si el programa ha
								   // llegado al "switch" es porque seguro que el valor de "mes" está entre 1 y 12
						
				} // Fin del switch
			} // Fin del segundo condicional if/else que envuelve al "switch"
		} // Fin del primer condicional if/else que envuelve al "switch"
		
		// Cerramos el objeto Scanner:
		entrada.close();
		
	} // Fin del método main
	
} // Fin de la clase App
