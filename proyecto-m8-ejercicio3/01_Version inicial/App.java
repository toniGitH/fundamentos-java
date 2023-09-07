// Módulo 8 - Ejercicio 3
// IMPORTANTE: en la clase App SOLO SE PUEDE USAR UN ARRAYLIST COMO BBDD: de CLIENTES!!!

import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		ArrayList<Cliente> listaClientes = new ArrayList<Cliente>(); // ArrayList que almacena los objetos de tipo Cliente que vamos creando
		String dniCliente;
		int posicionClienteEnArray; // Almacenará la posición que un objeto concreto de tipo Cliente ocupa en el ArrayList 
		byte opcionMenuElegida; // Almacenará la opción del menú principal elegida por el usuario
		char repetir='n'; // Almacenará la respuesta a si el usuario quiere hacer o no otra operación
		int numeroCuentaGenerada=0; // Almacena el último número de cuenta generado
		int saldoActual;
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
							//(sólo se podrá eliminar un cliente si éste NO tiene cuentas vigentes, 
							// y para poder cerrar una cuenta, ésta deberá tener saldo 0)
						dniCliente = pedirString("Introduce el DNI del cliente que quieres eliminar (5 posiciones alfanuméricas).");
						if (esDniValido(dniCliente)==false) {
							System.out.println("El DNI introducido no es válido.");
						} 
						else {
							posicionClienteEnArray = buscarIndiceDeCliente(listaClientes, dniCliente);
							if (posicionClienteEnArray==-1) {
								System.out.println("Ese Cliente no está registrado en la aplicación.");
							}
							else {
								if (tieneCuentas(listaClientes.get(posicionClienteEnArray).getListaCuentasCliente())==false) {
									eliminarCliente(listaClientes, posicionClienteEnArray);
								}
								else {
									System.out.println("El cliente aún tiene cuentas vigenes. No lo puedes dar de baja.");
									System.out.println("Debes cancelar todas las cuentas del cliente para darlo de baja.");
								}
							}
						}
						break;
					case 3: // CREAR NUEVA CUENTA A UN CLIENTE -----------------------------------------------
						dniCliente = pedirString("Introduce el DNI del cliente al que quieres abrir una nueva cuenta (5 posiciones alfanuméricas)");
						if (esDniValido(dniCliente)==false) {
							System.out.println("El DNI introducido no es válido.");
						} 
						else {
							posicionClienteEnArray = buscarIndiceDeCliente(listaClientes, dniCliente);
							if (posicionClienteEnArray==-1) {
								System.out.println("Ese Cliente no está registrado en la aplicación. Debes darlo de alta antes de abrir una cuenta.");
							}
							else {
								numeroCuentaGenerada = generaCuenta(numeroCuentaGenerada);
								listaClientes.get(posicionClienteEnArray).getListaCuentasCliente().add(abrirCuenta(numeroCuentaGenerada, listaClientes.get(posicionClienteEnArray)));
								System.out.println("La nueva cuenta de D./Dª " + listaClientes.get(posicionClienteEnArray).getNombreCliente() + " " + listaClientes.get(posicionClienteEnArray).getApellidoCliente() + " se ha creado con éxito.");
								System.out.println("El número asignado a esa nueva cuenta es el # " + numeroCuentaGenerada + " #");
							}
						}
						break;
					case 4: // CANCELAR UNA CUENTA DE UN CLIENTE --------------------------------------------
							// (Debe tener saldo cero)
						dniCliente = pedirString("Introduce el DNI del cliente al que quieras cancelar una cuenta (5 posiciones alfanuméricas)");
						if (esDniValido(dniCliente)==false) {
							System.out.println("El DNI introducido no es válido.");
						}
						else {
							posicionClienteEnArray = buscarIndiceDeCliente(listaClientes, dniCliente);
							if (posicionClienteEnArray==-1) {
								System.out.println("Ese Cliente no está registrado en la aplicación.");
							} 
							else if (tieneCuentas(listaClientes.get(posicionClienteEnArray).getListaCuentasCliente())==false) {
								System.out.println("El cliente no tiene ninguna cuenta abierta a su nombre que poder cancelar.");
							}
							else {
								posicionGlobal(listaClientes, posicionClienteEnArray);
								int cuentaACancelar = pedirInt("¿Qué cuenta quieres cancelar?");
								int indiceCuentaACancelar = buscarIndiceDeCuentas(listaClientes.get(posicionClienteEnArray).getListaCuentasCliente(), cuentaACancelar);
								if (indiceCuentaACancelar==-1) {
									System.out.println("Esa cuenta no es del cliente con DNI " + listaClientes.get(posicionClienteEnArray).getDniCliente() +". No puedes cancelar esa cuenta.");
								} 
								else {
									saldoActual = listaClientes.get(posicionClienteEnArray).getListaCuentasCliente().get(indiceCuentaACancelar).getSaldo();
									if (tieneSaldo(saldoActual)) {
										System.out.println("La cuenta tiene saldo positivo. No se puede cancelar.");
									} else {
										//listaClientes.get(posicionClienteEnArray).getListaCuentasCliente().remove(indiceCuentaACancelar);
										//System.out.println("La cuenta número # " + cual + " # se ha cancelado correctamente.");
										eliminarCuenta(listaClientes, posicionClienteEnArray, indiceCuentaACancelar, cuentaACancelar);
									}
								}
							}
						}
						break;
					case 5: // INGRESAR EN UNA CUENTA DE UN CLIENTE ------------------------------------------
						dniCliente = pedirString("Introduce el DNI del cliente que quiere hacer el ingreso (5 posiciones alfanuméricas)");
						if (esDniValido(dniCliente)==false) {
							System.out.println("El DNI introducido no es válido.");
						}
						else {
							posicionClienteEnArray = buscarIndiceDeCliente(listaClientes, dniCliente);
							if (posicionClienteEnArray==-1) {
								System.out.println("Ese Cliente no está registrado en la aplicación.");
							} 
							else if (tieneCuentas(listaClientes.get(posicionClienteEnArray).getListaCuentasCliente())==false) {
								System.out.println("El cliente no tiene ninguna cuenta abierta a su nombre donde poder ingresar.");
							}
							else {
								posicionGlobal(listaClientes, posicionClienteEnArray);
								int donde = pedirInt("¿En qué cuenta quieres hacer el ingreso?");
								int indiceCuentaIngreso = buscarIndiceDeCuentas(listaClientes.get(posicionClienteEnArray).getListaCuentasCliente(), donde);
								if (indiceCuentaIngreso==-1) {
									System.out.println("Esa cuenta no es del cliente con DNI " + listaClientes.get(posicionClienteEnArray).getDniCliente() +". No puedes ingresar en esa cuenta.");
								} 
								else {
									int importeIngreso;
									do {
										importeIngreso= pedirInt("¿Cuánto dinero quieres ingresar en la cuenta número # " + donde + " # ?");
										if (esPositivo(importeIngreso)==false) {
											System.out.println("El importe a ingresar debe ser una cantidad positiva.");
										}
									} while (esPositivo(importeIngreso)==false);
									saldoActual = listaClientes.get(posicionClienteEnArray).getListaCuentasCliente().get(indiceCuentaIngreso).aumentarSaldo(importeIngreso);
									listaClientes.get(posicionClienteEnArray).getListaCuentasCliente().get(indiceCuentaIngreso).setSaldo(saldoActual);
									// Código equivalente a las 2 líneas anteriores:
									//listaClientes.get(posicionClienteEnArray).getListaCuentasCliente().get(indiceCuentaIngreso).setSaldo(listaClientes.get(posicionClienteEnArray).getListaCuentasCliente().get(indiceCuentaIngreso).ingresar(cuanto));
									System.out.println("Ingreso de " + importeIngreso + " euros realizado con éxito.");
									System.out.println("El saldo actual de la cuenta número # " + listaClientes.get(posicionClienteEnArray).getListaCuentasCliente().get(indiceCuentaIngreso).getNumCuenta() + " # es de " + saldoActual + " euros.");
								}
							}
						}
						break;
					case 6: // REINTEGRAR DINERO DE UNA CUENTA DE UN CLIENTE ---------------------------------
							// No se podrá sacar más importe del saldo actual. No podrá quedar saldo negativo
						dniCliente = pedirString("Introduce el DNI del cliente que quiere hacer el reintegro (5 posiciones alfanuméricas)");
						if (esDniValido(dniCliente)==false) {
							System.out.println("El DNI introducido no es válido.");
						}
						else {
							posicionClienteEnArray = buscarIndiceDeCliente(listaClientes, dniCliente);
							if (posicionClienteEnArray==-1) {
								System.out.println("Ese Cliente no está registrado en la aplicación.");
							} 
							else if (tieneCuentas(listaClientes.get(posicionClienteEnArray).getListaCuentasCliente())==false) {
								System.out.println("El cliente no tiene ninguna cuenta abierta a su nombre de la que poder hacer un reintegro.");
							}
							else {
								posicionGlobal(listaClientes, posicionClienteEnArray);
								int donde = pedirInt("¿De qué cuenta quieres sacar dinero?");
								int indiceCuentaReintegro = buscarIndiceDeCuentas(listaClientes.get(posicionClienteEnArray).getListaCuentasCliente(), donde);
								if (indiceCuentaReintegro==-1) {
									System.out.println("Esa cuenta no es del cliente con DNI " + listaClientes.get(posicionClienteEnArray).getDniCliente() +". No puedes sacar dinero de esa cuenta.");
								} 
								else {
									int importeReintegro;
									do {
										importeReintegro= pedirInt("¿Cuánto dinero quieres sacar de la cuenta número # " + donde + " # ?");
										if (esPositivo(importeReintegro)==false) {
											System.out.println("El importe a reintegrar debe ser una cantidad positiva.");
										}
									} while (esPositivo(importeReintegro)==false);									saldoActual = listaClientes.get(posicionClienteEnArray).getListaCuentasCliente().get(indiceCuentaReintegro).getSaldo();
									if (haySaldoSuficiente(saldoActual, importeReintegro)) {
										saldoActual = listaClientes.get(posicionClienteEnArray).getListaCuentasCliente().get(indiceCuentaReintegro).reducirSaldo(importeReintegro);
										listaClientes.get(posicionClienteEnArray).getListaCuentasCliente().get(indiceCuentaReintegro).setSaldo(saldoActual);
										System.out.println("Reintegro de " + importeReintegro + " euros realizado con éxito.");
										System.out.println("El saldo actual de la cuenta número # " + listaClientes.get(posicionClienteEnArray).getListaCuentasCliente().get(indiceCuentaReintegro).getNumCuenta() + " # es de " + saldoActual + " euros.");
									} else {
										System.out.println("El saldo actual de la cuenta numero # " + listaClientes.get(posicionClienteEnArray).getListaCuentasCliente().get(indiceCuentaReintegro).getNumCuenta() + " # es de " + saldoActual + " euros. No hay suficiente saldo para hacer un reintegro de " + importeReintegro + " euros.");
									}
								}
							}
						}
						break;
					case 7: // LISTAR CLIENTES ---------------------------------------------------------------
						listarClientes(listaClientes);
						break;	
					case 8: // VER POSICIÓN GLOBAL DE UN CLIENTE ---------------------------------------------
						dniCliente = pedirString("Introduce el DNI del cliente que quieres consultar (5 posiciones alfanuméricas)");
						if (esDniValido(dniCliente)==false) {
							System.out.println("El DNI introducido no es válido.");
						} 
						else {
							posicionClienteEnArray = buscarIndiceDeCliente(listaClientes, dniCliente);
							if (posicionClienteEnArray==-1) {
								System.out.println("Ese Cliente no está registrado en la aplicación.");
							} 
							else {
								posicionGlobal(listaClientes, posicionClienteEnArray);
							}
						}
						break;	
					//default: No necesario en este caso
					//  break; No necesario en este caso
				}				
				repetir = pedirChar("¿Quieres hacer otra operación (s/n)?");
			}
			
		} // Cierre del primer "do"
		while (repetir=='s' && opcionMenuElegida!=0);
		
		System.out.println("Fin del programa");
		
	} // FIN DEL MÉTODO MAIN
	
	// ---------------------------------------------------------------------------------
	
	// RESTO DE MÉTODOS
	
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
	
			// ---------- Métodos para operaciones de Cliente ---------- //
	
	// Método para validar el documento de identidad
	static boolean esDniValido(String dniCliente) {
		return (dniCliente.length()==5);
	}
	
	// Método para buscar un elemento Cliente en el arrayList de clientes. 
	// Devuelve el valor del índice que ese elemento ocupa en el ArrayList
	static int buscarIndiceDeCliente(ArrayList<Cliente> listaClientes, String dniCliente) {
		int indiceCliente=0;
		String dniEvaluado;
		int indiceBuscado=-1;
		
		if (listaClientes.size()==0) {
			indiceBuscado=-1;
		}
		else {
			do {
				dniEvaluado = listaClientes.get(indiceCliente).getDniCliente();
				if (dniEvaluado.equalsIgnoreCase(dniCliente)) {
					indiceBuscado=indiceCliente;
				} else {
					indiceCliente++;
				}
			}
			while (dniEvaluado.equalsIgnoreCase(dniCliente)==false && indiceCliente<listaClientes.size());
		}
		
		return indiceBuscado;
	}
	
	// Método para validar si el dni de un Cliente ya existe
	static boolean existeCliente(int indiceBuscado) {
		return indiceBuscado!=-1;
	}

			// ---------- Métodos para operaciones de Cuenta ---------- //

	// Método para generar números de cuenta consecutivos (servirá para generar cuentas correlativas)
	static int generaCuenta(int numeroCuentaGenerada) {
		return ++numeroCuentaGenerada;
	}
		
	// Método para validar si un cliente tiene o no cuentas vigentes
	static boolean tieneCuentas(ArrayList<Cuenta> listaCuentasCliente) {
		return listaCuentasCliente.size()!=0;
	}
	
	// Método para comprobar si hay saldo suficiente para hacer un reintegro
	static boolean haySaldoSuficiente(int saldoActual, int importeReintegro) {
		return saldoActual>=importeReintegro;
	}
	
	// Método para comprobar si una cuenta tiene saldo
	static boolean tieneSaldo(int saldoActual) {
		return saldoActual!=0;
	}
	
	// Método para buscar un elemento Cuenta en el arrayList de cuentas
	// Devuelve el valor del índice que ese elemento ocupa en el ArrayList
		static int buscarIndiceDeCuentas(ArrayList<Cuenta> listaCuentasCliente, int numCuenta) {
			int indiceCuenta=0;
			int cuentaEvaluada;
			int indiceBuscado=-1;
			
			if (listaCuentasCliente.size()==0) {
				indiceBuscado=-1;
			}
			else {
				do {
					cuentaEvaluada = listaCuentasCliente.get(indiceCuenta).getNumCuenta();
					if (cuentaEvaluada == numCuenta) {
						indiceBuscado=indiceCuenta;
					} else {
						indiceCuenta++;
					}
				}
				while ((cuentaEvaluada!=numCuenta) && indiceCuenta<listaCuentasCliente.size());
			}
			
			return indiceBuscado;
		}
	
			// ---------- Métodos específicos (acciones del menú) ---------- //
	
	// Método para Crear un nuevo Cliente (opción 1)
	static Cliente crearCliente(String dniCliente, String nombreCliente, String apellidoCliente) {
		return new Cliente(dniCliente, nombreCliente , apellidoCliente);
	}
	
	// Método para Eliminar Cliente (opción 2)
	static void eliminarCliente(ArrayList<Cliente> listaClientes, int posicionClienteEnArray) {
		if (posicionClienteEnArray==-1) {
			System.out.println("Este Cliente no está registrado en la aplicación.");
		} else {
			listaClientes.remove(posicionClienteEnArray);
			System.out.println("El Cliente " + listaClientes.get(posicionClienteEnArray).getNombreCliente() + listaClientes.get(posicionClienteEnArray).getApellidoCliente() + " ha sido dado de baja de la aplicación.");
		}
	}
	
	// Método para Abrir una nueva cuenta a un Cliente (opción 3)
	static Cuenta abrirCuenta(int numCuenta, Cliente titular) {
		return new Cuenta(numCuenta, titular);
	}
	
	// Método para Eliminar una cuenta de un cliente (opción 4)
	// La cuenta debe estar a cero
	static void eliminarCuenta(ArrayList<Cliente> listaClientes, int posicionClienteEnArray, int indiceCuentaACancelar, int cuentaACancelar) {
		listaClientes.get(posicionClienteEnArray).getListaCuentasCliente().remove(indiceCuentaACancelar);
		System.out.println("La cuenta número # " + cuentaACancelar + " # se ha cancelado correctamente.");
	}
	
	// Método para Listar Clientes (opcion 7)
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
		if (tieneCuentas(listaClientes.get(posicionClienteEnArray).getListaCuentasCliente())==false) {
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

} // FIN DE LA CLASE APP
