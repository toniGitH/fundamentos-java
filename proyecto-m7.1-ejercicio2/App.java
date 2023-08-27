// Módulo 7.1 - Ejercicio 2

import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		ArrayList<Double> notasAlumnos;
		mensajeFinal(calculoMedia(crearListaNotas(pedirByte("Introduce número de alumnos:"))));
		
		// Código equivalente al anterior:
		/*byte numAlumnos = pedirByte("Introduce número de alumnos:");
		ArrayList<Double> notasAlumnos = crearListaNotas(numAlumnos);
		double notaMedia = calculoMedia(notasAlumnos);
		mensajeFinal(notaMedia);*/
	}
	
	// ---------------------------------------------------------------------------
	
	// RESTO DE MÉTODOS
	
	static byte pedirByte(String mensaje) { // MÉTODO PARA PEDIR DATOS DE TIPO BYTE (nº alumnos)
		Scanner entrada = new Scanner(System.in);
		System.out.println(mensaje);
		return entrada.nextByte();
	}
	
	static double pedirDouble (String mensaje) { // MÉTODO PARA PEDIR DATOS DE TIPO DOUBLE (nota)
		Scanner entrada = new Scanner(System.in);
		System.out.println(mensaje);
		return entrada.nextDouble();
	}
	
	static boolean verificaNota(double parametroNota) { // MÉTODO PARA VALIDAR NOTAS (>=0 y <=10)
		boolean repetirNota;
		if (parametroNota<0 || parametroNota>10) {
			repetirNota=true;
		} else {
			repetirNota=false;
		}
		return repetirNota;
	}
	
	static ArrayList<Double> crearListaNotas(byte paramNumAlumnos){ // MÉTODO PARA CREAR LISTADO DE NOTAS VÁLIDAS
		double nota;
		ArrayList<Double> listaNotas = new ArrayList<Double>(); 
		for (int i=1; i<=paramNumAlumnos; i++) {
			nota = pedirDouble("Escribe la nota del alumno número " + i + ". Debe ser un valor entre 0 y 10");
			while (verificaNota(nota)) {
				System.out.println("El valor de la nota es erróneo.");
				nota = pedirDouble("Vuelve a escribir la nota del alumno número " + i + ". Debe ser un valor entre 0 y 10");
			}
			listaNotas.add(nota);
		}
		return listaNotas;
	}
	
	static double calculoMedia(ArrayList<Double> paramlistaNotas) { // MÉTODO PARA CALCULAR LA MEDIA DE LAS 3 NOTAS
		double sumaNotas=0;
		for (int i=0; i<paramlistaNotas.size(); i++) {
			sumaNotas+=paramlistaNotas.get(i);
		}
		return sumaNotas/paramlistaNotas.size();
	}
	
	static void mensajeFinal(double paramNotaMedia) { // MÉTODO PARA IMPRIMIR MENSAJE FINAL
		System.out.println("La nota media de la clase es un " + paramNotaMedia);
		if (paramNotaMedia<5) {
			System.out.println("La nota media de la clase es un suspenso. Los alumnos deberían preguntar sus dudas y trabajar más.");
		} else if (paramNotaMedia<7) {
			System.out.println("La nota media de la clase es buena, pero los alumnos deberían mejorar el trabajo personal.");
		} else {
			System.out.println("¡¡Enhorabuena!! La nota media de la clase se corresponde con el esfuerzo realizado.");
		}
	}
	
} // FIN CLASE APP
