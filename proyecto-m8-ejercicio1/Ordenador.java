// Módulo 8 - Ejercicio 1

public class Ordenador {

	// Declaración de ATRIBUTOS o propiedades
	private String marca;
	private String modelo;
	private String procesador;
	private int ram;
	private int hdd;
	
	// Médodo CONSTRUCTOR (1)
	public Ordenador(String marca, String modelo) {
		this.marca = marca;
		this.modelo = modelo;
		procesador = "Intel";
		ram = 8;
		hdd = 250;
	}
	
	// Método CONSTRUCTOR (2)
	public Ordenador(String marca, String modelo, String procesador, int ram, int hdd) {
		this.marca = marca;
		this.modelo = modelo;
		this.procesador = procesador;
		this.ram = ram;
		this.hdd = hdd;
	}
	
	// Métodos GETTERS
	
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public String getProcesador() {
		return procesador;
	}
	public int getRam() {
		return ram;
	}
	public int getHdd() {
		return hdd;
	}
	
	// Métodos SETTERS (excepto para "marca" y "modelo")
	
	public void setProcesador(String procesador) {
		this.procesador=procesador;
	}
	public void setRam(int ram) {
		this.ram=ram;
	}
	public void setHdd(int hdd) {
		this.hdd=hdd;
	}
	
	
	// Resto métodos de clase
	
	public String enEjecucion(String programa) {
		return "En estos momentos se está ejecutando: " + programa;
	}
	
	public String toString() {
		return "Ordenador " + marca + " " + modelo + " con procesador " + procesador + ", "
				+ ram + "Gb de memoria ram y " + hdd + "Gb de disco duro";
	}
	
}
