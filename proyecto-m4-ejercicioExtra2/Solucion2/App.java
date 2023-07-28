// Módulo 4 - Ejercicio Extra 2
// RESUELTO CON AYUDAS

import java.util.Scanner;

public class App{
	
    public static void main(String[] args) {
    
    	String[] unidades = {"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez", 
    						 "once", "doce", "trece", "catorce", "quince", "dieciseis", "diecisiete", "dieciocho",
    						 "diecinueve", "veinte", "veintiuno", "veintidos", "veintitres", "veinticuatro", "veinticinco", 
    						 "veintiseis", "veintisiete", "veintiocho", "veintinueve"};
    	        
    	String[] decenas = {"cero", "diez", "veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta",
    						"noventa"};
    	
    	Scanner entrada = new Scanner(System.in);

        System.out.print("Escribe un numero entre el 0 y el 99 (ambos incluidos: ");
        int numero = entrada.nextInt();

        if (numero >= 0 && numero <= 29) {
            System.out.print("El numero " + numero + " escrito en letras es " + unidades[numero]);
        } else if (numero > 29 && numero <= 99) {
            int decena = numero / 10;
            int unidad = numero % 10;
            if (unidad == 0) {
                System.out.print("El numero " + numero + " escrito en letras es " + decenas[decena]);
            } else {
                System.out.print("El numero " + numero + " escrito en letras es " + decenas[decena] + " y " + unidades[unidad]);
            }
        } else {
            System.out.print("El numero que has escrito no está entre el 0 y el 99");
        }

        entrada.close();
    }
}