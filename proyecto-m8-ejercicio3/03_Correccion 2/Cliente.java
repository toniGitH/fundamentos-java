// Módulo 8 - Ejercicio 3

import java.util.ArrayList;

public class Cliente {
	
	// DECLARACIÓN DE ATRIBUTOS O PROPIEDADES
	
	private String nombreCliente;
	private String apellidoCliente;
	private String dniCliente;
	private ArrayList<Cuenta> listaCuentasCliente;

	// MÉTODO CONSTRUCTOR
	
	public Cliente(String dniCliente, String nombreCliente, String apellidoCliente) {
		this.nombreCliente=nombreCliente;
		this.apellidoCliente=apellidoCliente;
		this.dniCliente=dniCliente;
		listaCuentasCliente=new ArrayList<Cuenta>();
	}
	
	// MÉTODOS GETTERS
	
	public String getNombreCliente() {
		return nombreCliente;
	}
	
	public String getApellidoCliente() {
		return apellidoCliente;
	}
	
	public String getDniCliente() {
		return dniCliente;
	}
	
	// Este método sería mejor NO ponerlo, porque al tenerlo, estoy facilitando el modificar el array de cuentas
	// de un cliente desde fuera, desde la App, con lo que estoy facilitando la violación de la encapsulación.
	// Al eliminar este método, me obligo a rehacer los métodos de
	// - añadir cuenta a array (eso ahora ya está bien)
	// - eliminar cuenta de array (eso ahora ya está bien)
	// - buscar una cuenta en un array (el método de buscar una cuenta en un array de cliente debería estar dentro de la clase Cliente)
	// - hacer una lista de cuentas (también debería estar creado dentro de la clase Cliente).
	public ArrayList<Cuenta> getListaCuentasCliente(){
		return listaCuentasCliente;
	}
	
	// MÉTODOS SETTERS
	
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente=nombreCliente;
	}
	
	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente=apellidoCliente;
	}
	
	public void setDniCliente(String dniCliente) {
		this.dniCliente=dniCliente;
	}
	
	// Este método setter no es necesario
	public void setListaCuentasCliente (ArrayList<Cuenta> listaCuentasCliente) {
		this.listaCuentasCliente=listaCuentasCliente;
	}
	
	// RESTO DE MÉTODOS DE CLASE
	
	public boolean tieneCuentas() {
		return listaCuentasCliente.size()!=0;
	}
	
	public void incluirCuentaEnArray(Cuenta nuevaCuenta) {
		listaCuentasCliente.add(nuevaCuenta);
	}
	
	public void eliminarCuentaDeArray(int indiceCuentaOperacion) {
		listaCuentasCliente.remove(indiceCuentaOperacion);
	}
	
	public String toString() {
		return "Cliente: " + nombreCliente + " " + apellidoCliente + " con DNI: " + dniCliente;
	}


}
