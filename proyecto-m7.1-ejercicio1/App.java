// Módulo 7.1 - Ejercicio 1

import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		ArrayList<Double> notasAlumno = crearListaNotas();
		mensajeFinal(calculoMedia(notasAlumno));
		
		// Código equivalente al anterior:
		/*ArrayList<Double> notasAlumno = crearListaNotas();
		double notaMedia = calculoMedia(notasAlumno);
		mensajeFinal(notaMedia);*/
	}
	
	// ---------------------------------------------------------------------------
	
	// RESTO DE MÉTODOS
	
	static double pedirDouble (String mensaje) { // MÉTODO PARA PEDIR DATOS DE TIPO DOUBLE
		Scanner entrada = new Scanner(System.in);
		System.out.println(mensaje);
		return entrada.nextDouble();
	}
	
	static boolean verificaNota(double parametroNota) { // MÉTODO PARA VALIDAR NOTAS
		boolean repetirNota;
		if (parametroNota<0 || parametroNota>10) {
			repetirNota=true;
		} else {
			repetirNota=false;
		}
		return repetirNota;
	}
	
	static ArrayList<Double> crearListaNotas(){ // MÉTODO PARA CREAR LISTADO DE NOTAS VÁLIDAS
		double nota;
		ArrayList<Double> listaNotas = new ArrayList<Double>(); 
		for (int i=1; i<=3; i++) {
			nota = pedirDouble("Escribe la nota número " + i + ". Debe ser un valor entre 0 y 10");
			while (verificaNota(nota)) {
				System.out.println("El valor de la nota es erróneo.");
				nota = pedirDouble("Vuelve a escribir la nota número " + i + ". Debe ser un valor entre 0 y 10");
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
		System.out.println("Tu nota media es un " + paramNotaMedia);
		if (paramNotaMedia<5) {
			System.out.println("No has superado el curso. Debes recuperar");
		} else if (paramNotaMedia<=7) {
			System.out.println("¡¡Enhorabuena!! Has aprobado, pero deberías seguir practicando");
		} else {
			System.out.println("¡¡Enhorabuena, has superado el curso!! Pasas al siguiente nivel");
		}
	}
	
} // FIN CLASE APP
