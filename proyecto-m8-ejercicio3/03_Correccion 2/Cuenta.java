// Módulo 8 - Ejercicio 3

public class Cuenta {
	
	// DECLARACIÓN DE ATRIBUTOS O PROPIEDADES
	
	private int numCuenta; // Por simplificar, utilizo int, aunque debería ser de tipo más grande
	private int saldo; // Debería ser un double, por el tema de céntimos, pero por simplificar, elijo int
	private Cliente titular; // Este atributo, realmente, no haría falta. Se podría rehacer el código sin este
							 // atributo, porque cuando se crea una cuenta, ya se introduce en un array de 
							 // cuentas de un cliente, y por tanto desde ese momento, la nueva cuenta ya 
							 // tiene asignado un cliente dueño de esa cuenta.
	
	// MÉTODO CONSTRUCTOR
	
	public Cuenta(int numCuenta, Cliente titular) {
		this.numCuenta=numCuenta;
		this.saldo=0;
		this.titular = titular; 
	}
	
	// MÉTODOS GETTERS
	
	public int getNumCuenta() {
		return numCuenta;
	}
	
	public int getSaldo() {
		return saldo;
	}
	
	public Cliente getTitular() {
		return titular;
	}
	
	// MÉTODOS SETTERS
	
	public void setNumCuenta(int numCuenta) {
		this.numCuenta=numCuenta;
	}

	public void setSaldo(int saldo) {
		this.saldo=saldo;
	}
	
	public void setTitular(Cliente titular) {
		this.titular=titular;
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
