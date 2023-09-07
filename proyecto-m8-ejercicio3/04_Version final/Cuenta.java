// Módulo 8 - Ejercicio 3

public class Cuenta {
	
	// DECLARACIÓN DE ATRIBUTOS O PROPIEDADES
	
	private int numCuenta; // Por simplificar, utilizo int, aunque debería ser de tipo más grande
	private int saldo; // Debería ser un double, por el tema de céntimos, pero por simplificar, elijo int
	
	// MÉTODO CONSTRUCTOR
	
	public Cuenta(int numCuenta) {
		this.numCuenta=numCuenta;
		this.saldo=0;
	}
	
	// MÉTODOS GETTERS
	
	public int getNumCuenta() {
		return numCuenta;
	}
	
	public int getSaldo() {
		return saldo;
	}
	
	// MÉTODOS SETTERS
	
	public void setNumCuenta(int numCuenta) {
		this.numCuenta=numCuenta;
	}

	public void setSaldo(int saldo) {
		this.saldo=saldo;
	}

	// RESTO DE MÉTODOS DE CLASE
	
	public int aumentarSaldo(int importeIngreso) {
		return saldo+importeIngreso;
	}
	
	public int reducirSaldo(int importeReintegro) {
		return saldo-importeReintegro;
	}
	
	public int tieneUnSaldoDe(int cantidad) {
		return saldo-cantidad;
	}
	
	public String toString() {
		return "El saldo actual de la cuenta número " + numCuenta + " es de " + saldo + " euros.";
	}
}
