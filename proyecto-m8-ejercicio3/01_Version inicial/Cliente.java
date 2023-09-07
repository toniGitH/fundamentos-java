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
	
	public void setListaCuentasCliente (ArrayList<Cuenta> listaCuentasCliente) {
		this.listaCuentasCliente=listaCuentasCliente;
	}
	
	// RESTO DE MÉTODOS DE CLASE
	
	public String toString() {
		return "Cliente: " + nombreCliente + " " + apellidoCliente + " con DNI: " + dniCliente;
	}
}
