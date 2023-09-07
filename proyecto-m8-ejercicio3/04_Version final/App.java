// Módulo 8 - Ejercicio 3
// IMPORTANTE: en la clase App SOLO SE PUEDE USAR UN ARRAYLIST COMO BBDD: de CLIENTES!!!
// ELIMINAR CUENTA: sólo se podrá cancelar una cuenta si su saldo es 0
// ELIMINAR CLIENTE: sólo se podrá eliminar un cliente si éste no tiene cuentas vigentes
// REINTEGROS: no se pueden hacer reintegros por mayor importe del saldo de la cuenta.
//			   No se puede dejar una cuenta con saldo negativo.
// CORRECCIONES:
// - En la clase Cuenta, no hace falta, tal y como está propuesto el ejercicio,
//   crear un atributo llamado "titular". El motivo es porque al crear una nueva
//   cuenta o instanciar un objeto de tipo cuenta, justo después lo meto dentro de
//   un arrayList de cuentas de un cliente, por lo que de manera implícita ya se 
//   asocian la cuenta y el cliente mediante este arrayList. (OK)
// - Sería interesante deshacernos del método getListaCuentasCliente() de la clase Cliente,
//   porque su existencia permite hacer "cosas" en el main (crear y borrar cuentas
//   del arrayList de cuentas) que permitirían "violar" el encapsulamiento de la
//   propiedad "listaCuentasCliente" de la clase Cliente.(OK)
//   ¡¡OJO!! Si nos deshacemos de este método, me obligo a tener en la clase Cliente los siguientes
//   métodos de clase: 
// 			- añadir cuenta a array (OK)
// 			- eliminar cuenta de array (OK)
// 			- buscar una cuenta en un array (OK)
// 			- listar cuentas (OK)
// - Igualmente, el método setListaCuentasCliente() tampoco debería existir. (OK)
// - El método buscarIndiceDeCuenta() que está en la clase App NO DEBE ESTAR AHÍ,
//   porque es un método que está interactuando con la propiedad "listaCuentasCliente"
//   de la clase Cliente, por lo que DEBERÍA ESTAR DEFINIDO EN LA CLASE CLIENTE. (OK) 
// - Se debería maximizar la reutilización del código y evitar repeticiones del
//   mismo para optimizar el código. (NOK)
// - Las opciones de "Ingresar" y "Reintegro" se podrían unir en una sola para
//   optimizar código. (NOK)

import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		// DECLARACIÓN DE VARIABLES
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>(); // ArrayList que almacena los objetos de tipo Cliente que vamos creando
		String dniCliente; // Almacenará el DNI de un cliente (5 posiciones almfanuméricas)
		int posicionClienteEnArray; // Almacenará la posición que un objeto concreto de tipo Cliente ocupa en el ArrayList 
		int indiceCuentaOperacion; // Almacenará la posición que ocupa en un ArrayList<Cuenta> un determinado objeto de tipo Cuenta
		byte opcionMenuElegida; // Almacenará la opción del menú principal elegida por el usuario
		char repetir='n'; // Almacenará la respuesta a si el usuario quiere hacer o no otra operación
		int numeroCuentaGenerada=0; // Almacena el último número de cuenta generado
		
		// MENU PRINCIPAL
		do {
			opcionMenuElegida = menu();
			if (opcionMenuElegida!=0) {
				switch (opcionMenuElegida) {
					case 1: // CREAR CLIENTE ----------------------------------------------------------------
						dniCliente = pedirString("Introduce el DNI del cliente (5 posiciones alfanuméricas)");
						posicionClienteEnArray = buscarIndiceDeCliente(listaClientes, dniCliente);
						crearCliente(dniCliente, dniCliente, dniCliente, posicionClienteEnArray, listaClientes);
						break;
					case 2: // ELIMINAR CLIENTE ---------------------------------------------------------------
						posicionClienteEnArray = validacionCliente(listaClientes, "Introduce el DNI del cliente que quieres eliminar (5 posiciones alfanuméricas)");
						eliminarCliente(listaClientes, posicionClienteEnArray);
						break;
					case 3: // CREAR NUEVA CUENTA A UN CLIENTE -----------------------------------------------
						posicionClienteEnArray = validacionCliente(listaClientes, "Introduce el DNI del cliente al que quieras abrir una cuenta (5 posiciones alfanuméricas)");
						numeroCuentaGenerada = generaCuenta(numeroCuentaGenerada);
						abrirCuenta(numeroCuentaGenerada, listaClientes, posicionClienteEnArray);
						break;
					case 4: // CANCELAR UNA CUENTA DE UN CLIENTE --------------------------------------------
						posicionClienteEnArray = validacionCliente(listaClientes, "Introduce el DNI del cliente al que quieras cancelar una cuenta (5 posiciones alfanuméricas)");
						indiceCuentaOperacion = elegirCuentaOperacion(listaClientes, posicionClienteEnArray, "¿Qué cuenta quieres cancelar?");
						eliminarCuenta(listaClientes, posicionClienteEnArray, indiceCuentaOperacion);
						break;
					case 5:
					case 6: // INGRESAR/REINTEGRAR EN UNA CUENTA DE UN CLIENTE ------------------------------------------
						posicionClienteEnArray = validacionCliente(listaClientes, "Introduce el DNI del cliente al que quieras hacer el ingreso/reintegro (5 posiciones alfanuméricas)");
						indiceCuentaOperacion = elegirCuentaOperacion(listaClientes, posicionClienteEnArray, "¿En qué cuenta quieres hacer la operación?");
						moverFondos(listaClientes, posicionClienteEnArray, indiceCuentaOperacion, opcionMenuElegida);
						break;	
					case 7: // LISTAR CLIENTES ---------------------------------------------------------------
						listarClientes(listaClientes);
						break;	
					case 8: // VER POSICIÓN GLOBAL DE UN CLIENTE ---------------------------------------------
						posicionClienteEnArray = validacionCliente(listaClientes, "Introduce el DNI del cliente que quieras consultar (5 posiciones alfanuméricas)");
						posicionGlobal(listaClientes, posicionClienteEnArray);
						break;	
					//default: No necesario en este caso
				}				
				repetir = pedirChar("¿Quieres hacer otra operación (s/n)?");
			}
		}
		while (repetir=='s' && opcionMenuElegida!=0);
		
		System.out.println("Fin del programa");
		
	} // FIN DEL MÉTODO MAIN
	
	// ---------------------------------------------------------------------------------
	
	// RESTO DE MÉTODOS
	
	// ---------- Métodos para crear/manejar el Menú Principal ---------- //
	
	// Método que gestiona el menu principal
	static byte menu() {
		byte opcion;
		do {
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
			opcion = pedirByte("Elige una opción:");
			if (opcion<0 || opcion>8) {
				System.out.println("Esa opción no existe. Inténtalo de nuevo.");
			}
		} 
		while (opcion<0 || opcion>8);
		return opcion;
	}

	// ---------- Métodos para ejecutar las acciones del menú ---------- //
	
	// Método para Crear un nuevo Cliente (opción 1)
	static void crearCliente(String dniCliente, String nombreCliente, String apellidoCliente, int posicionClienteEnArray, ArrayList<Cliente> listaClientes) {
		if (esDniValido(dniCliente)==false) {
			System.out.println("El DNI introducido no es válido.");
		} 
		else {
			if (existeCliente(posicionClienteEnArray)) {
				System.out.println("El Cliente ya existe.");
			} 
			else {
				Cliente clienteX = new Cliente(dniCliente, 
											   pedirString("Introduce el nombre del Cliente:"),
											   pedirString("Introduce el apellido del Cliente:")
											   );
				listaClientes.add(clienteX);
				System.out.println("El Cliente " + clienteX.getNombreCliente() + " " + clienteX.getApellidoCliente() + " ha sido dado de alta con éxito.");
			}	
		}
	}
	
	// Método para Eliminar un Cliente (opción 2)
	static void eliminarCliente(ArrayList<Cliente> listaClientes, int posicionClienteEnArray) {
		if (posicionClienteEnArray>=0) {
			if (listaClientes.get(posicionClienteEnArray).tamanoArray()!=0) {
				System.out.println("El cliente aún tiene cuentas vigentes. No se puede eliminar");
			}
			else {
				System.out.println("El Cliente " + listaClientes.get(posicionClienteEnArray).getNombreCliente() + listaClientes.get(posicionClienteEnArray).getApellidoCliente() + " ha sido dado de baja de la aplicación.");
				listaClientes.remove(posicionClienteEnArray); // Si esta línea va antes de la anterior, da error de Index out of bounds
			}
		}
	}
	
	// Método para Abrir nueva cuenta y añadir as ArrayList de cuentas del cliente titular de esa cuenta (opción 3)
	static void abrirCuenta(int numeroCuentaGenerada, ArrayList<Cliente> listaClientes, int posicionClienteEnArray) {
		if (posicionClienteEnArray>=0) {
			Cuenta nuevaCuenta = new Cuenta(numeroCuentaGenerada);
			listaClientes.get(posicionClienteEnArray).incluirCuentaEnArray(nuevaCuenta);
			System.out.println("La nueva cuenta de D./Dª " + listaClientes.get(posicionClienteEnArray).getNombreCliente() + " " + listaClientes.get(posicionClienteEnArray).getApellidoCliente() + " se ha creado con éxito.");
			System.out.println("El número asignado a esa nueva cuenta es el # " + numeroCuentaGenerada + " #");
		}
	}

	// Método para Eliminar una cuenta de un cliente (opción 4).  La cuenta debe estar a cero
	static void eliminarCuenta(ArrayList<Cliente> listaClientes, int posicionClienteEnArray, int indiceCuentaOperacion) {
		if (posicionClienteEnArray>=0) {
			if (indiceCuentaOperacion>=0) {
				if (listaClientes.get(posicionClienteEnArray).devuelveCuenta(indiceCuentaOperacion).tieneUnSaldoDe(0)>0){
					System.out.println("La cuenta tiene saldo positivo. No se puede cancelar.");
				} 
				else {
					System.out.println("La cuenta número # " + listaClientes.get(posicionClienteEnArray).devuelveCuenta(indiceCuentaOperacion).getNumCuenta() + " # se ha cancelado correctamente.");
					listaClientes.get(posicionClienteEnArray).eliminarCuentaDeArray(indiceCuentaOperacion); // Si esta línea va antes de la anterior, da error de Index out of bounds
				}
			}
		}
	}
	
	// Método para gestionar ingresos y reintegros
	static void moverFondos(ArrayList<Cliente> listaClientes, int posicionClienteEnArray, int indiceCuentaOperacion, int opcionMenuElegida) {
		if (posicionClienteEnArray>=0) {
			if (indiceCuentaOperacion>=0) {
				int importeOperacion;
				int nuevoSaldo;
				switch (opcionMenuElegida) {
				case 5:
					do {
						importeOperacion = pedirInt("¿Cuánto dinero quieres ingresar en la cuenta número # " + listaClientes.get(posicionClienteEnArray).devuelveCuenta(indiceCuentaOperacion).getNumCuenta() + " # ?");
						if (esPositivo(importeOperacion)==false) {
							System.out.println("El importe a ingresar debe ser una cantidad positiva.");
						}
					} while (esPositivo(importeOperacion)==false);
					nuevoSaldo = listaClientes.get(posicionClienteEnArray).devuelveCuenta(indiceCuentaOperacion).aumentarSaldo(importeOperacion);
					listaClientes.get(posicionClienteEnArray).devuelveCuenta(indiceCuentaOperacion).setSaldo(nuevoSaldo);
					System.out.println("Ingreso de " + importeOperacion + " euros realizado con éxito.");
					System.out.println("El saldo actual de la cuenta número # " + listaClientes.get(posicionClienteEnArray).devuelveCuenta(indiceCuentaOperacion).getNumCuenta()  + " # es de " + nuevoSaldo + " euros.");
					break;
				case 6:
					do {
						importeOperacion = pedirInt("¿Cuánto dinero quieres retirar de la cuenta número # " + listaClientes.get(posicionClienteEnArray).devuelveCuenta(indiceCuentaOperacion).getNumCuenta() + " # ?");
						if (esPositivo(importeOperacion)==false) {
							System.out.println("El importe a retirar debe ser una cantidad positiva.");
						}
					} while (esPositivo(importeOperacion)==false);
					if (listaClientes.get(posicionClienteEnArray).devuelveCuenta(indiceCuentaOperacion).tieneUnSaldoDe(importeOperacion)>=0){
						nuevoSaldo = listaClientes.get(posicionClienteEnArray).devuelveCuenta(indiceCuentaOperacion).reducirSaldo(importeOperacion);
						listaClientes.get(posicionClienteEnArray).devuelveCuenta(indiceCuentaOperacion).setSaldo(nuevoSaldo);
						System.out.println("Reintegro de " + importeOperacion + " euros realizado con éxito.");
						System.out.println("El saldo actual de la cuenta número # " + listaClientes.get(posicionClienteEnArray).devuelveCuenta(indiceCuentaOperacion).getNumCuenta() + " # es de " + nuevoSaldo + " euros.");
					}
					else {
						System.out.println("El saldo actual de la cuenta numero # " + listaClientes.get(posicionClienteEnArray).devuelveCuenta(indiceCuentaOperacion).getNumCuenta() + " # es de " + listaClientes.get(posicionClienteEnArray).devuelveCuenta(indiceCuentaOperacion).getSaldo() + " euros.");
						System.out.println("No hay suficiente saldo para hacer un reintegro de " + importeOperacion + " euros.");
					}
					break;
				// default: no es necesario
				}
			}
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
		if (posicionClienteEnArray>=0) {
			System.out.println("Posición global de " + listaClientes.get(posicionClienteEnArray).getNombreCliente() + " " + listaClientes.get(posicionClienteEnArray).getApellidoCliente() + ":");
			System.out.println("--------------------------------------------------------------------");
			if (listaClientes.get(posicionClienteEnArray).tamanoArray()==0) {
				System.out.println();
				System.out.println("Actualmente D./Dª " + listaClientes.get(posicionClienteEnArray).getNombreCliente() + " " +listaClientes.get(posicionClienteEnArray).getApellidoCliente() + " no tiene ninguna cuenta abierta a su nombre.");
			} else {
				System.out.println();
				//for (int indice=0; indice<listaClientes.get(posicionClienteEnArray).getListaCuentasCliente().size(); indice++) {
				for (int indice=0; indice<listaClientes.get(posicionClienteEnArray).tamanoArray() ; indice++) {
					System.out.println("Número de cuenta: " + listaClientes.get(posicionClienteEnArray).devuelveCuenta(indice).getNumCuenta());
					System.out.println("Saldo: " + listaClientes.get(posicionClienteEnArray).devuelveCuenta(indice).getSaldo() + " euros.");
					System.out.println("********************");
				}
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
		if (listaClientes.get(posicionClienteEnArray).tamanoArray()==0) {
			indiceCuentaOperacion=-1;
		} else {
			int cuentaOperacion = pedirInt(msg);
			indiceCuentaOperacion = listaClientes.get(posicionClienteEnArray).buscarIndiceDeCuenta(cuentaOperacion);
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
