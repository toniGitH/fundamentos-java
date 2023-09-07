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
	
	// RESTO DE MÉTODOS DE CLASE
	
	// Método para añadir un objeto de tipo Cuenta al arrayList de cuentas de un cliente
	public void incluirCuentaEnArray(Cuenta nuevaCuenta) {
		listaCuentasCliente.add(nuevaCuenta);
	}
	
	// Método para eliminar un objeto de tipo Cuenta al arrayList de cuentas de un cliente
	public void eliminarCuentaDeArray(int indiceCuentaOperacion) {
		listaCuentasCliente.remove(indiceCuentaOperacion);
	}
	
	// Método para buscar el índice de un elemento Cuenta en el arrayList de cuentas
	public int buscarIndiceDeCuenta(int numCuenta) {
		int indiceCuenta=0;
		int cuentaEvaluada;
		int indiceBuscado=-1;
		boolean cuentaEncontrada=false;
	
		if (listaCuentasCliente.size()==0) {
			indiceBuscado=-1;
		}
		else {
			do {
				cuentaEvaluada = listaCuentasCliente.get(indiceCuenta).getNumCuenta();
				if (cuentaEvaluada == numCuenta) {
					indiceBuscado=indiceCuenta;
					cuentaEncontrada=true;
				} 
				else {
					indiceCuenta++;
				}
			}
			while (cuentaEncontrada==false && indiceCuenta<listaCuentasCliente.size());
		}	
		return indiceBuscado;
	}
	
	// Método para devolver el objeto de tipo Cuenta que ocupa una determinada posición en un
	// ArrayList de cuentas de un cliente.
	public Cuenta devuelveCuenta(int indiceDeCuenta) {
		return listaCuentasCliente.get(indiceDeCuenta);
	}
	
	public int tamanoArray() {
		return listaCuentasCliente.size();
	}
	
	public boolean tieneCuentas() {
		return listaCuentasCliente.size()!=0;
	}
		
	public String toString() {
		return "Cliente: " + nombreCliente + " " + apellidoCliente + " con DNI: " + dniCliente;
	}


}
