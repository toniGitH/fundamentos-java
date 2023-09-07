// Módulo 8 - Ejercicio 3
// IMPORTANTE: en la clase App SOLO SE PUEDE USAR UN ARRAYLIST COMO BBDD: de CLIENTES!!!
// ELIMINAR CUENTA: sólo se podrá cancelar una cuenta si su saldo es 0
// ELIMINAR CLIENTE: sólo se podrá eliminar un cliente si éste no tiene cuentas vigentes
// REINTEGROS: no se pueden hacer reintegros por mayor importe del saldo de la cuenta.
//			   No se puede dejar una cuenta con saldo negativo.

import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>(); // ArrayList que almacena los objetos de tipo Cliente que vamos creando
		String dniCliente; // Almacenará el DNI de un cliente (5 posiciones almfanuméricas)
		int posicionClienteEnArray; // Almacenará la posición que un objeto concreto de tipo Cliente ocupa en el ArrayList 
		int indiceCuentaOperacion; // Almacenará la posición que ocupa en un ArrayList<Cuenta> un determinado objeto de tipo Cuenta
		byte opcionMenuElegida; // Almacenará la opción del menú principal elegida por el usuario
		char repetir='n'; // Almacenará la respuesta a si el usuario quiere hacer o no otra operación
		int numeroCuentaGenerada=0; // Almacena el último número de cuenta generado
		do {
			
			do {
				menuPrincipal();
				opcionMenuElegida = pedirByte("Elige una opción:");
				if (esOpcionMenuValida(opcionMenuElegida)==false) {
					System.out.println("Esa opción no existe. Inténtalo de nuevo.");
				}
			} 
			while (esOpcionMenuValida(opcionMenuElegida)==false);
			
			if (opcionMenuElegida!=0) {
				switch (opcionMenuElegida) {
					case 1: // CREAR CLIENTE ----------------------------------------------------------------
						dniCliente = pedirString("Introduce el DNI del cliente (5 posiciones alfanuméricas)");
						if (esDniValido(dniCliente)==false) {
							System.out.println("El DNI introducido no es válido.");
						} 
						else {
							posicionClienteEnArray = buscarIndiceDeCliente(listaClientes, dniCliente);
							if (existeCliente(posicionClienteEnArray)) {
								System.out.println("El Cliente ya existe.");
							} 
							else {
								Cliente clienteX = crearCliente(dniCliente, 
					 	  			    pedirString("Introduce el nombre del Cliente:"),
					 				    pedirString("Introduce el apellido del Cliente:")
									    );
								listaClientes.add(clienteX);
								System.out.println("El Cliente " + clienteX.getNombreCliente() + " " + clienteX.getApellidoCliente() + " ha sido dado de alta con éxito.");
							}	
						}
						break;
					case 2: // ELIMINAR CLIENTE ---------------------------------------------------------------
						posicionClienteEnArray = validacionCliente(listaClientes, "Introduce el DNI del cliente que quieres eliminar (5 posiciones alfanuméricas)");
						if (posicionClienteEnArray>=0) {
							if (listaClientes.get(posicionClienteEnArray).tieneCuentas()==false) {
								System.out.println("El Cliente " + listaClientes.get(posicionClienteEnArray).getNombreCliente() + listaClientes.get(posicionClienteEnArray).getApellidoCliente() + " ha sido dado de baja de la aplicación.");
								listaClientes.remove(posicionClienteEnArray);
							}
							else {
								System.out.println("El cliente aún tiene cuentas vigentes. No se puede eliminar");
							}
						}
						break;
					case 3: // CREAR NUEVA CUENTA A UN CLIENTE -----------------------------------------------
						posicionClienteEnArray = validacionCliente(listaClientes, "Introduce el DNI del cliente al que quieras abrir una cuenta (5 posiciones alfanuméricas)");
						if (posicionClienteEnArray>=0) {
							numeroCuentaGenerada = generaCuenta(numeroCuentaGenerada);
							// MUY IMPORTANTE!!!!!!!!!!!
							// La siguiente línea es una VIOLACIÓN DE LA ENCAPSULACIÓN (porque estamos accediendo a una propiedad de un 
							// objeto de tipo cliente (listaClientes.get(posicionClienteEnArray).getListaCuentasCliente()) mediante un
							// método que NO es de la clase cliente (.add()). Hay que crear un método en la clase Cliente que nos permita
							// interactuar con ese ArrayList. Más abajo hay otro error igual.
							listaClientes.get(posicionClienteEnArray).getListaCuentasCliente().add(abrirCuenta(numeroCuentaGenerada, listaClientes.get(posicionClienteEnArray)));
							System.out.println("La nueva cuenta de D./Dª " + listaClientes.get(posicionClienteEnArray).getNombreCliente() + " " + listaClientes.get(posicionClienteEnArray).getApellidoCliente() + " se ha creado con éxito.");
							System.out.println("El número asignado a esa nueva cuenta es el # " + numeroCuentaGenerada + " #");
						}
						break;
					case 4: // CANCELAR UNA CUENTA DE UN CLIENTE --------------------------------------------
						posicionClienteEnArray = validacionCliente(listaClientes, "Introduce el DNI del cliente al que quieras cancelar una cuenta (5 posiciones alfanuméricas)");
						if (posicionClienteEnArray>=0) {
							indiceCuentaOperacion = elegirCuentaOperacion(listaClientes, posicionClienteEnArray, "¿Qué cuenta quieres cancelar?");
							if (indiceCuentaOperacion>=0) {
								eliminarCuenta(indiceCuentaOperacion, listaClientes, posicionClienteEnArray);
							}
						}
						break;
					case 5: // INGRESAR EN UNA CUENTA DE UN CLIENTE ------------------------------------------
						posicionClienteEnArray = validacionCliente(listaClientes, "Introduce el DNI del cliente al que quieras hacer un ingreso (5 posiciones alfanuméricas)");
						if (posicionClienteEnArray>=0) {
							indiceCuentaOperacion = elegirCuentaOperacion(listaClientes, posicionClienteEnArray, "¿En qué cuenta quieres ingresar?");
							if (indiceCuentaOperacion>=0) {
								ingresar(indiceCuentaOperacion, listaClientes, posicionClienteEnArray);
							}
						}
						break;
					case 6: // REINTEGRAR DINERO DE UNA CUENTA DE UN CLIENTE ---------------------------------
						posicionClienteEnArray = validacionCliente(listaClientes, "Introduce el DNI del cliente al que quieras hacer un reintegro (5 posiciones alfanuméricas)");
						if (posicionClienteEnArray>=0) {
							indiceCuentaOperacion = elegirCuentaOperacion(listaClientes, posicionClienteEnArray, "¿De qué cuenta quieres sacar dinero?");
							if (indiceCuentaOperacion>=0) {
									reintegrar(indiceCuentaOperacion, listaClientes, posicionClienteEnArray);
							}
						}
						break;
					case 7: // LISTAR CLIENTES ---------------------------------------------------------------
						listarClientes(listaClientes);
						break;	
					case 8: // VER POSICIÓN GLOBAL DE UN CLIENTE ---------------------------------------------
						posicionClienteEnArray = validacionCliente(listaClientes, "Introduce el DNI del cliente que quieras consultar (5 posiciones alfanuméricas)");
						if (posicionClienteEnArray>=0) {
							posicionGlobal(listaClientes, posicionClienteEnArray);
						}
						break;	
					//default: No necesario en este caso
				}				
				repetir = pedirChar("¿Quieres hacer otra operación (s/n)?");
			}
			
		} // Cierre del primer "do"
		while (repetir=='s' && opcionMenuElegida!=0);
		
		System.out.println("Fin del programa");
		
	} // FIN DEL MÉTODO MAIN
	
	// ---------------------------------------------------------------------------------
	
	// RESTO DE MÉTODOS
	
	// ---------- Métodos para crear/manejar el Menú Principal ---------- //
	
	// Método que imprime en consola el Menu Principal
	static void menuPrincipal() {
		System.out.println("EL BANCO MALO");
		System.out.println("");
		System.out.println("(1)- Crear nuevo cliente");
		System.out.println("(2)- Eliminar cliente");
		System.out.println("(3)- Abrir nueva cuenta a un cliente");
		System.out.println("(4)- Cancelar una cuenta de un cliente");
		System.out.println("(5)- Ingreso en cuenta de cliente");
		System.out.println("(6)- Reintegro en cuenta de cliente");
		System.out.println("(7)- Lista de clientes");
		System.out.println("(8)- Posición global de un cliente");
		System.out.println("(0)- Salir del programa");
	}
	
	// Método para validar elección correcta en Menú principal
	static boolean esOpcionMenuValida(byte opcionMenuElegida) {
		return (opcionMenuElegida>=0 && opcionMenuElegida<=8);
	}

	// ---------- Métodos para ejecutar las acciones del menú ---------- //
	
	// Método para Crear un nuevo Cliente (opción 1)
	static Cliente crearCliente(String dniCliente, String nombreCliente, String apellidoCliente) {
		return new Cliente(dniCliente, nombreCliente , apellidoCliente);
	}

	// Método para Eliminar Cliente (opción 2)
	static void eliminarCliente(ArrayList<Cliente> listaClientes, int posicionClienteEnArray) {
		listaClientes.remove(posicionClienteEnArray);
		System.out.println("El Cliente " + listaClientes.get(posicionClienteEnArray).getNombreCliente() + listaClientes.get(posicionClienteEnArray).getApellidoCliente() + " ha sido dado de baja de la aplicación.");
	}

	// Método para Abrir una nueva cuenta a un Cliente (opción 3)
	static Cuenta abrirCuenta(int numCuenta, Cliente titular) {
		return new Cuenta(numCuenta, titular);
	}

	// Método para Eliminar una cuenta de un cliente (opción 4).  La cuenta debe estar a cero
	static void eliminarCuenta(int indiceCuentaOperacion, ArrayList<Cliente> listaClientes, int posicionClienteEnArray) {
		if ((listaClientes.get(posicionClienteEnArray).getListaCuentasCliente().get(indiceCuentaOperacion).tieneUnSaldoDe(0))>0) {
			System.out.println("La cuenta tiene saldo positivo. No se puede cancelar.");
		} else {
			int cuentaACancelar = listaClientes.get(posicionClienteEnArray).getListaCuentasCliente().get(indiceCuentaOperacion).getNumCuenta();
			// MUY IMPORTANTE!!!!!!!!!!!
			// La siguiente línea es una VIOLACIÓN DE LA ENCAPSULACIÓN (porque estamos accediendo a una propiedad de un 
			// objeto de tipo cliente (listaClientes.get(posicionClienteEnArray).getListaCuentasCliente()) mediante un
			// método que NO es de la clase cliente (.remove()). Hay que crear un método en la clase Cliente que nos permita
			// interactuar con ese ArrayList.
			listaClientes.get(posicionClienteEnArray).getListaCuentasCliente().remove(indiceCuentaOperacion);
			System.out.println("La cuenta número # " + cuentaACancelar + " # se ha cancelado correctamente.");
		}
	}

	// Método para Ingresar en una cuenta de un cliente (opción 5)
	static void ingresar(int indiceCuentaOperacion, ArrayList<Cliente> listaClientes, int posicionClienteEnArray) {
		int importeIngreso;
		int cuentaDeIngreso = listaClientes.get(posicionClienteEnArray).getListaCuentasCliente().get(indiceCuentaOperacion).getNumCuenta();
		int nuevoSaldo;
		do {
			importeIngreso = pedirInt("¿Cuánto dinero quieres ingresar en la cuenta número # " + cuentaDeIngreso + " # ?");
			if (esPositivo(importeIngreso)==false) {
				System.out.println("El importe a ingresar debe ser una cantidad positiva.");
			}
		} while (esPositivo(importeIngreso)==false);
		nuevoSaldo = listaClientes.get(posicionClienteEnArray).getListaCuentasCliente().get(indiceCuentaOperacion).aumentarSaldo(importeIngreso);
		listaClientes.get(posicionClienteEnArray).getListaCuentasCliente().get(indiceCuentaOperacion).setSaldo(nuevoSaldo);
		System.out.println("Ingreso de " + importeIngreso + " euros realizado con éxito.");
		System.out.println("El saldo actual de la cuenta número # " + cuentaDeIngreso  + " # es de " + nuevoSaldo + " euros.");
	}

	// Método para Reintegrar de una cuenta de un cliente (opción 6). La cuenta no se puede quedar en negativo
	static void reintegrar(int indiceCuentaOperacion, ArrayList<Cliente> listaClientes, int posicionClienteEnArray) {
		int importeReintegro;
		int cuentaDeReintegro = listaClientes.get(posicionClienteEnArray).getListaCuentasCliente().get(indiceCuentaOperacion).getNumCuenta();
		int nuevoSaldo;
		do {
			importeReintegro = pedirInt("¿Cuánto dinero quieres sacar de la cuenta número # " + cuentaDeReintegro + " # ?");
			if (esPositivo(importeReintegro)==false) {
				System.out.println("El importe a reintegrar debe ser una cantidad positiva.");
			}
		} while (esPositivo(importeReintegro)==false);
		if (listaClientes.get(posicionClienteEnArray).getListaCuentasCliente().get(indiceCuentaOperacion).tieneUnSaldoDe(importeReintegro)>=0) {
			nuevoSaldo = listaClientes.get(posicionClienteEnArray).getListaCuentasCliente().get(indiceCuentaOperacion).reducirSaldo(importeReintegro);
			listaClientes.get(posicionClienteEnArray).getListaCuentasCliente().get(indiceCuentaOperacion).setSaldo(nuevoSaldo);
			System.out.println("Reintegro de " + importeReintegro + " euros realizado con éxito.");
			System.out.println("El saldo actual de la cuenta número # " + listaClientes.get(posicionClienteEnArray).getListaCuentasCliente().get(indiceCuentaOperacion).getNumCuenta() + " # es de " + nuevoSaldo + " euros.");
		} else {
			System.out.println("El saldo actual de la cuenta numero # " + listaClientes.get(posicionClienteEnArray).getListaCuentasCliente().get(indiceCuentaOperacion).getNumCuenta() + " # es de " + listaClientes.get(posicionClienteEnArray).getListaCuentasCliente().get(indiceCuentaOperacion).getSaldo() + " euros.");
			System.out.println("No hay suficiente saldo para hacer un reintegro de " + importeReintegro + " euros.");
		}
	}

	// Método para Listar Clientes (opción 7)
	static void listarClientes(ArrayList<Cliente> listaClientes) {
		if (listaClientes.size()==0) {
			System.out.println("Actualmente no hay clientes dados de alta en la aplicación.");
		}
		else {
			System.out.println("Estos son todos los Clientes registrados actualmente en la aplicación:");
			for (int indice=0; indice<listaClientes.size(); indice++) {
				System.out.println(listaClientes.get(indice));
			}
		}
	}

	// Método para mostrar todas las cuentas de un Cliente (opción 8)
	static void posicionGlobal(ArrayList<Cliente> listaClientes, int posicionClienteEnArray) {
		System.out.println("Posición global de " + listaClientes.get(posicionClienteEnArray).getNombreCliente() + " " + listaClientes.get(posicionClienteEnArray).getApellidoCliente() + ":");
		System.out.println("--------------------------------------------------------------------");
		if (listaClientes.get(posicionClienteEnArray).tieneCuentas()==false) {
			System.out.println();
			System.out.println("Actualmente D./Dª " + listaClientes.get(posicionClienteEnArray).getNombreCliente() + " " +listaClientes.get(posicionClienteEnArray).getApellidoCliente() + " no tiene ninguna cuenta abierta a su nombre.");
		} else {
			System.out.println();
			for (int indice=0; indice<listaClientes.get(posicionClienteEnArray).getListaCuentasCliente().size(); indice++) {
				System.out.println("Número de cuenta: " + listaClientes.get(posicionClienteEnArray).getListaCuentasCliente().get(indice).getNumCuenta());
				System.out.println("Saldo: " + listaClientes.get(posicionClienteEnArray).getListaCuentasCliente().get(indice).getSaldo() + " euros.");
				System.out.println("********************");
			}
		}
	}

	// ---------- Métodos para ayudar en las validaciones ---------- //

	// Método para validar el documento de identidad
		static boolean esDniValido(String dniCliente) {
			return (dniCliente.length()==5);
		}
	
	// Método para validar si el dni de un Cliente ya existe (para la opción 1)
	static boolean existeCliente(int indiceBuscado) {
		return indiceBuscado!=-1;
	}
	
	// Método para hacer validaciones previas a operar con cuentas (para opciones 2,3,4,5,6,8)
	static int validacionCliente (ArrayList<Cliente> listaClientes, String msg) {
		int posicionClienteEnArray;
		int resultadoValidacion=-1;
		String dniCliente = pedirString(msg);
		if (esDniValido(dniCliente)==false) {
			System.out.println("El DNI introducido no es válido.");
		} else {
			posicionClienteEnArray = buscarIndiceDeCliente(listaClientes, dniCliente);
			if (posicionClienteEnArray==-1) {
				System.out.println("Ese Cliente no está registrado en la aplicación.");
			} 
			else {
				resultadoValidacion=posicionClienteEnArray;
			}
		}
		return resultadoValidacion;
	}
	
	// Método para seleccionar cuenta en la que operar (cancelar, ingresar y reintegrar)
	static int elegirCuentaOperacion(ArrayList<Cliente> listaClientes, int posicionClienteEnArray, String msg) {
		posicionGlobal(listaClientes, posicionClienteEnArray);
		int indiceCuentaOperacion;
		if (listaClientes.get(posicionClienteEnArray).tieneCuentas()==false) {
			indiceCuentaOperacion=-1;
		} else {
			int cuentaOperacion = pedirInt(msg);
			indiceCuentaOperacion = buscarIndiceDeCuentas(listaClientes.get(posicionClienteEnArray).getListaCuentasCliente(), cuentaOperacion);
			if (indiceCuentaOperacion==-1) {
				System.out.println("Esa cuenta no es del cliente con DNI " + listaClientes.get(posicionClienteEnArray).getDniCliente() +". No puedes operar en ella.");
			}
		}
		return indiceCuentaOperacion;
	}
	

	// ---------- Métodos para buscar en ArrayList ---------- //
	
	// Método para buscar un elemento Cliente en el arrayList de clientes. 
	// Devuelve el valor del índice que ese elemento ocupa en el ArrayList
	static int buscarIndiceDeCliente(ArrayList<Cliente> listaClientes, String dniCliente) {
		int indiceCliente=0;
		String dniEvaluado;
		int indiceBuscado=-1;
		boolean clienteEncontrado=false;
		
		if (listaClientes.size()==0) {
			indiceBuscado=-1;
		}
		else {
			do {
				dniEvaluado = listaClientes.get(indiceCliente).getDniCliente();
				if (dniEvaluado.equalsIgnoreCase(dniCliente)) {
					indiceBuscado=indiceCliente;
					clienteEncontrado=true;
				} else {
					indiceCliente++;
				}
			}
			while (clienteEncontrado==false && indiceCliente<listaClientes.size());
		}
		
		return indiceBuscado;
	}

	// Método para buscar un elemento Cuenta en el arrayList de cuentas
	// Devuelve el valor del índice que ese elemento ocupa en el ArrayList
	static int buscarIndiceDeCuentas(ArrayList<Cuenta> listaCuentasCliente, int numCuenta) {
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
				} else {
					indiceCuenta++;
				}
			}
			while (cuentaEncontrada==false && indiceCuenta<listaCuentasCliente.size());
		}
		
		return indiceBuscado;
	}	
	
	// ---------- Otros métodos específicos ---------- //
	
	// Método para generar números de cuenta consecutivos (servirá para generar cuentas correlativas)
	static int generaCuenta(int numeroCuentaGenerada) {
		return ++numeroCuentaGenerada;
	}
	
	// ---------- Métodos genéricos ---------- //
	
	// Método para pedir un dato de tipo int
	static int pedirInt (String msg) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		return entrada.nextInt();
	}
		
	// Método para pedir un dato de tipo byte
	static byte pedirByte (String msg) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		return entrada.nextByte();
	}
	
	// Método para pedir un dato de tipo String
	static String pedirString(String msg) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		return entrada.nextLine();
	}
		
	// Método para pedir un dato de tipo char
	static char pedirChar(String msg) {
		Scanner entrada = new Scanner(System.in);
		System.out.println(msg);
		return entrada.next().toLowerCase().charAt(0);
	}
	
	// Método para saber determinar si un número es positivo
	static boolean esPositivo(int numero) {
		return numero>0;
	}
	
} // FIN DE LA CLASE APP
