// Módulo 8 - Ejercicio 6 (Versión 2)

package PaqueteApp;

import PaqueteEscuderias.*;
import java.util.ArrayList;

public class ToolsAccionesMenu {

	// * * * * * * * * * * * * * * * * OPCIONES DE CREACIÓN  * * * * * * * * * * * * * * * * //
	
	// CREAR ESCUDERÍA ********************** (FINALIZADO)
	static void crearEscuderia(ArrayList<Escuderia> listaEscuderias) {
		String nombreEscuderia = ToolsDatos.pedirStringCapital("Escribe el nombre de la Escudería que quieres dar de alta:");
		int posicionEscuderiaEnArray = ToolsBusquedas.buscarIndiceDeEscuderia(listaEscuderias, nombreEscuderia);
		if (posicionEscuderiaEnArray<0) {
			int presupuestoEscuderia = ToolsDatos.pedirIntPositivo("Indica el presupuesto (en millones de euros) de la Escudería:");
			String paisEscuderia = ToolsDatos.pedirStringCapital("Indica el país de la Escudería:");
			Escuderia nuevaEscuderia = new Escuderia(nombreEscuderia, presupuestoEscuderia, paisEscuderia);
			listaEscuderias.add(nuevaEscuderia);
		} else {
			System.out.println("Esa Escudería ya existe en la base de datos.");
		}
	}
	
	// CREAR BÓLIDO ********************** (FINALIZADO)
	static void crearBolido(ArrayList<Escuderia> listaEscuderias, String msg) {
		if (listaEscuderias.size()==0) {
			System.out.println("No hay Escuderías en la base de datos. Antes de dar de alta un Bólido debes crear la Escudería.");
		} else {
			String nombreEscuderia = ToolsDatos.pedirStringCapital(msg);
			int posicionEscuderiaEnArray = ToolsBusquedas.buscarIndiceDeEscuderia(listaEscuderias, nombreEscuderia);
			if (posicionEscuderiaEnArray<0) {
				System.out.println("Esa Escudería aún no existe en la base de datos. Deberías crearla primero.");
			} else {
				String modeloBolido = ToolsDatos.pedirStringCapital("Escribe el modelo del Bólido:");
				if(listaEscuderias.get(posicionEscuderiaEnArray).buscarIndiceDeBolido(modeloBolido)>=0) {
					System.out.println("Ese modelo ya existe en la Escudería " +nombreEscuderia+ ".");
				} else {
					int potenciaBolido = ToolsDatos.pedirIntPositivo("Indica la potencia (CV) del Bólido:");
					int velocidadBolido = ToolsDatos.pedirIntPositivo("Indica la velocidad máxima (km/h) del Bólido:");
					String colorBolido = ToolsDatos.pedirString("Indica el color del Bólido:");
					int precioBolido = ToolsDatos.pedirIntPositivo("Indica el precio (en euros) del Bólido:");
					Bolido nuevoBolido = new Bolido(nombreEscuderia, modeloBolido, potenciaBolido, velocidadBolido, precioBolido, colorBolido);
					listaEscuderias.get(posicionEscuderiaEnArray).incluirBolidoEnArray(nuevoBolido);
				}
			}
		}	
	}
	
	// CREAR EMPLEADO ********************** (FINALIZADO)
	static void crearEmpleado(byte opcionAlta, ArrayList<Escuderia> listaEscuderias) {
		String msgTipoEmpleado;
		if (opcionAlta==3) {
			msgTipoEmpleado="piloto";
		} else {
			msgTipoEmpleado="mecánico";
		}
		if (listaEscuderias.size()==0) {
			System.out.println("No hay Escuderías en la base de datos. Antes de dar de alta un "+msgTipoEmpleado+" debes crear la Escudería.");
		} else {
			String nombreEscuderiaEmpleado = ToolsDatos.pedirStringCapital("¿A qué escudería pertenece el "+msgTipoEmpleado+" a dar de alta?");
			int posicionEscuderiaEnArray = ToolsBusquedas.buscarIndiceDeEscuderia(listaEscuderias, nombreEscuderiaEmpleado);
			if (posicionEscuderiaEnArray<0) {
				System.out.println("Esa Escudería aún no existe en la base de datos. Debes crearla primero.");
			} else {
				String nombreEmpleado = ToolsDatos.pedirStringCapital("Escribe el nombre del " +msgTipoEmpleado+ ":");
				String apellidoEmpleado = ToolsDatos.pedirStringCapital("Escribe el apellido del " +msgTipoEmpleado+ ":");
				int edadEmpleado = ToolsDatos.pedirIntPositivo("Indica la edad del " +msgTipoEmpleado+ ":");
				int antigEmpleado = ToolsDatos.pedirIntPositivo("Indica la antigüedad (en años) del " +msgTipoEmpleado+ " en la Escudería:");
				switch (opcionAlta) {
				case 3: // Dar de alta piloto
					int alturaEmpleado = ToolsDatos.pedirIntPositivo("Indica la altura en cm. del " +msgTipoEmpleado+ ":");
					int pesoEmpleado = ToolsDatos.pedirIntPositivo("Indica el peso en kg. del " +msgTipoEmpleado+ ":");
					Piloto nuevoPiloto = new Piloto(nombreEmpleado, apellidoEmpleado, edadEmpleado, antigEmpleado, alturaEmpleado, pesoEmpleado, nombreEscuderiaEmpleado);
					nuevoPiloto.setSueldo(nuevoPiloto.calcularSueldoEmpleado());
					listaEscuderias.get(posicionEscuderiaEnArray).incluirEmpleadoEnArray(nuevoPiloto);
					break;
				case 4: // Dar de alta mecánico
					String estudiosMecanica = ToolsDatos.pedirCharSiNo("¿El " + msgTipoEmpleado + " tiene estudios de mecánica (s/n)?");
					Mecanico nuevoMecanico = new Mecanico(nombreEmpleado, apellidoEmpleado, edadEmpleado, antigEmpleado, estudiosMecanica, nombreEscuderiaEmpleado);
					nuevoMecanico.setSueldo(nuevoMecanico.calcularSueldoEmpleado());
					listaEscuderias.get(posicionEscuderiaEnArray).incluirEmpleadoEnArray(nuevoMecanico);
					break;
				}
			}	
		}
	}
	
	// * * * * * * * * * * * * * * * * OPCIONES DE ELIMINACIÓN  * * * * * * * * * * * * * * * * //

	// ELIMINAR ESCUDERÍA ********************** (FINALIZADO)
	static void bajaEscuderia(ArrayList<Escuderia> listaEscuderias) {
		if (listaEscuderias.size()==0) {
			System.out.println("No hay Escuderías en la base de datos.");
		} else {
			String nombreEscuderia = ToolsDatos.pedirStringCapital("Escribe el nombre de la Escudería que quieres dar de baja:");
			int posicionEscuderiaEnArray = ToolsBusquedas.buscarIndiceDeEscuderia(listaEscuderias, nombreEscuderia);
			if (posicionEscuderiaEnArray<0) {
				System.out.println("Esa Escudería no existe en la base de datos.");
			} else {
				boolean tieneBolidos = listaEscuderias.get(posicionEscuderiaEnArray).sizeListaBolidos()>0;
				boolean tieneEmpleados = listaEscuderias.get(posicionEscuderiaEnArray).sizeListaEmpleados()>0;
				byte estadoEscuderia;
				if (tieneBolidos && tieneEmpleados) {
					estadoEscuderia=1;
				} else if (tieneBolidos && tieneEmpleados==false) {
					estadoEscuderia=2;
				} else if (tieneBolidos==false && tieneEmpleados) {
					estadoEscuderia=3;
				} else {
					estadoEscuderia=4;
				}
				switch (estadoEscuderia) {
				case 1:
					System.out.println("No puedes dar de baja la Escudería. Aún tiene Bólidos y Empleados.");
					System.out.println("Debes dar de baja primero los Bólidos y los Empleados.");
					break;
				case 2:
					System.out.println("No puedes dar de baja la Escudería. Aún tiene Bólidos.");
					System.out.println("Debes dar de baja primero los Bólidos.");
					break;
				case 3:
					System.out.println("No puedes dar de baja la Escudería. Aún tiene Empleados.");
					System.out.println("Debes dar de baja primero los Empleados.");
					break;
				case 4:
					System.out.println("La escudería no tiene Bólidos ni Empleados. Puedes darla de baja.");
					char confirmarBaja = ToolsDatos.pedirChar("¿Estás seguro de que quieres dar de baja la Escudería " + nombreEscuderia + "? (s/n)");
					if (confirmarBaja=='s') {
						listaEscuderias.remove(posicionEscuderiaEnArray);
						System.out.println("La escudería " + nombreEscuderia + " se ha dado de baja con éxito.");
					}
					else {
						System.out.println("Has abandonado el proceso de baja de la Escudería " + nombreEscuderia + ".");
					}
					break;
				}
			}
		}
	}
	
	// ELIMINAR BÓLIDO ********************** (FINALIZADO)
	static void bajaBolido(ArrayList<Escuderia> listaEscuderias) {
		if (Escuderia.hayBolidos(listaEscuderias)==false) {
			System.out.println("Ninguna de las escuderías que hay en la base de datos tiene aún ningún Bólido.");
		} else {
			String modeloBolido = ToolsDatos.pedirStringCapital("Escribe el modelo del Bólido que quieres dar de baja:");
			int indiceEsc=0;
			int indiceBol=0;
			String modeloEvaluado;
			boolean bolidoEncontrado=false;
			do {
				do {
					modeloEvaluado = listaEscuderias.get(indiceEsc).devolverBolido(indiceBol).getModeloBolido();
					if (modeloEvaluado.equalsIgnoreCase(modeloBolido)) {
						char confirmarBaja = ToolsDatos.pedirChar("¿Estás seguro de que quieres dar de baja el Bólido " + modeloBolido + "? (s/n)");
						if (confirmarBaja=='s') {
							listaEscuderias.get(indiceEsc).eliminarBolidoDeArray(indiceBol);
						}
						else {
							System.out.println("Has abandonado el proceso de baja del Bólido " + modeloBolido + ".");
						}
						bolidoEncontrado=true;
					} else {
						indiceBol++;
					}
				} while (bolidoEncontrado==false && indiceBol<listaEscuderias.get(indiceBol).sizeListaBolidos());
				indiceEsc++;
			} while (bolidoEncontrado==false && indiceEsc<listaEscuderias.size());
			if (bolidoEncontrado) {
				System.out.println("El Bólido " + modeloBolido + " ha sido dado de baja con éxito.");
			} else {
				System.out.println("No se ha encontrado ningún Bólido " + modeloBolido + " en la base de datos.");
			}
		}
	}
	
	// ELIMINAR EMPLEADO (PILOTOS Y MECÁNICOS) ********************** (FINALIZADO)
	static void bajaEmpleado(byte opcionBaja, ArrayList<Escuderia> listaEscuderias) {
		String msgTipoEmpleado;
		if (opcionBaja==3) {
			msgTipoEmpleado="piloto";
		} else {
			msgTipoEmpleado="mecánico";
		}
		if (Escuderia.hayEmpleados(listaEscuderias)==false) {
			System.out.println("Ninguna de las escuderías que hay en la base de datos tiene aún ningún " +msgTipoEmpleado+ " dado de alta.");
		} else {
			switch (opcionBaja) {
			case 3: // Dar de baja piloto
				msgTipoEmpleado="piloto";
				if (Escuderia.hayPilotos(listaEscuderias)) {
					borradoDeEmpleado(listaEscuderias, msgTipoEmpleado);
				} else {
					System.out.println("No hay ningún " +msgTipoEmpleado+ " dado de alta en la base de datos.");
				}
				break;
			case 4: // Dar de baja mecánico
				msgTipoEmpleado="mecánico";
				if (Escuderia.hayMecanicos(listaEscuderias)) {
					borradoDeEmpleado(listaEscuderias, msgTipoEmpleado);
				} else {
					System.out.println("No hay ningún " +msgTipoEmpleado+ " dado de alta en la base de datos.");
				}
				break;
			}
		}
	}
	
	// ELIMINACIÓN DE EMPLEADO ********************** (FINALIZADO)
	static void borradoDeEmpleado(ArrayList<Escuderia> listaEscuderias, String tipoEmpleado) {
		String nombreEmpleado = ToolsDatos.pedirStringCapital("Escribe el nombre del " +tipoEmpleado+ " al que quieres dar de baja:");
		String apellidoEmpleado = ToolsDatos.pedirStringCapital("Escribe también su apellido:");
		String nombreEmpleadoEvaluado;
		String apellidoEmpleadoEvaluado;
		String tipoEmpleadoEvaluado;
		int indiceEsc=0;
		int indiceEmpl=0;
		boolean pilotoEncontrado=false;
		do {
			do {
				nombreEmpleadoEvaluado=listaEscuderias.get(indiceEsc).devolverEmpleado(indiceEmpl).getNombreEmpleado();
				apellidoEmpleadoEvaluado=listaEscuderias.get(indiceEsc).devolverEmpleado(indiceEmpl).getApellidoEmpleado();
				tipoEmpleadoEvaluado=listaEscuderias.get(indiceEsc).devolverEmpleado(indiceEmpl).getTipoEmpleado();
				if (nombreEmpleadoEvaluado.equalsIgnoreCase(nombreEmpleado) && apellidoEmpleadoEvaluado.equalsIgnoreCase(apellidoEmpleado) && tipoEmpleadoEvaluado.equalsIgnoreCase(tipoEmpleado)) {
					pilotoEncontrado=true;
					char confirmarBaja = ToolsDatos.pedirChar("¿Estás seguro de que quieres dar de baja al "  +tipoEmpleado+ " " +nombreEmpleado+ " " +apellidoEmpleado+ "? (s/n)");
					if (confirmarBaja=='s') {
						listaEscuderias.get(indiceEsc).eliminarEmpleadoDeArray(indiceEmpl);
						System.out.println("El " +tipoEmpleado+ " " +nombreEmpleado+ " " +apellidoEmpleado+ " ha sido dado de baja con éxito.");
					} else {
						System.out.println("Has abandonado el proceso de baja del " + tipoEmpleado + " " +nombreEmpleado+ " " +apellidoEmpleado+ ".");
					} 
				} else {
					indiceEmpl++;
				}
			} while (pilotoEncontrado==false && indiceEmpl<listaEscuderias.get(indiceEsc).sizeListaEmpleados());
			indiceEsc++;
		} while (pilotoEncontrado==false && indiceEsc<listaEscuderias.size());
		if (pilotoEncontrado==false) {
			System.out.println("El " +tipoEmpleado+ " " +nombreEmpleado+ " " +apellidoEmpleado+ " no se encuentra dado de alta en la base de datos.");	
		}
	} 
	
	// * * * * * * * * * * * * * * * * OPCIONES DE CONSULTA  * * * * * * * * * * * * * * * * //

	// VER ESCUDERIA ********************** (FINALIZADO)
	static void verEscuderia(ArrayList<Escuderia> listaEscuderias) {
		String nombreEscuderiaString = ToolsDatos.pedirStringCapital("Escribe el nombre de la escudería que quieres consultar:");
		int indiceEsc = ToolsBusquedas.buscarIndiceDeEscuderia(listaEscuderias, nombreEscuderiaString);
		if (indiceEsc>=0) {
			System.out.println(listaEscuderias.get(indiceEsc).toString()); 
		} else {
			System.out.println("Esa escudería no consta en la base de datos.");
		}
	}
	
	// VER BÓLIDO ********************** (FINALIZADO)
	static void verBolido(ArrayList<Escuderia> listaEscuderias) {
		if (Escuderia.hayBolidos(listaEscuderias)==false) {
			System.out.println("Ninguna de las escuderías que hay en la base de datos tiene aún ningún Bólido.");
		} else {
			String modeloBolido = ToolsDatos.pedirStringCapital("Escribe el modelo del Bólido que quieres consultar:");
			int indiceEsc=0;
			int indiceBol=0;
			String modeloEvaluado;
			boolean bolidoEncontrado=false;
			do {
				do {
					modeloEvaluado = listaEscuderias.get(indiceEsc).devolverBolido(indiceBol).getModeloBolido();
					if (modeloEvaluado.equalsIgnoreCase(modeloBolido)) {
						System.out.println(listaEscuderias.get(indiceEsc).devolverBolido(indiceBol).toString()); 
						bolidoEncontrado=true;
					} else {
						indiceBol++;
					}
				} while (bolidoEncontrado==false && indiceBol<listaEscuderias.get(indiceEsc).sizeListaBolidos());
				indiceEsc++;
			} while (bolidoEncontrado==false && indiceEsc<listaEscuderias.size());
			if (bolidoEncontrado==false) {
				System.out.println("No se ha encontrado ningún Bólido " + modeloBolido + " en la base de datos.");
			}
		}
	}
	
	// VER EMPLEADO (PILOTOS Y MECÁNICOS) XXXXXXXXXXX SEGIR DESDE AQUÍ XXXXXXXXXXXX
	static void verEmpleado(byte opcionVer, ArrayList<Escuderia> listaEscuderias) {
		String msgTipoEmpleado;
		if (opcionVer==3) {
			msgTipoEmpleado="piloto";
		} else {
			msgTipoEmpleado="mecánico";
		}
		if (Escuderia.hayEmpleados(listaEscuderias)==false) {
			System.out.println("Ninguna de las escuderías que hay en la base de datos tiene aún ningún " +msgTipoEmpleado+ " dado de alta.");
		} else {
			switch (opcionVer) {
			case 3: // Dar de baja piloto
				msgTipoEmpleado="piloto";
				if (Escuderia.hayPilotos(listaEscuderias)) {
					imprimirEmpleado(listaEscuderias, msgTipoEmpleado);
				} else {
					System.out.println("No hay ningún " +msgTipoEmpleado+ " dado de alta en la base de datos.");
				}
				break;
			case 4: // Dar de baja mecánico
				msgTipoEmpleado="mecánico";
				if (Escuderia.hayMecanicos(listaEscuderias)) {
					imprimirEmpleado(listaEscuderias, msgTipoEmpleado);
				} else {
					System.out.println("No hay ningún " +msgTipoEmpleado+ " dado de alta en la base de datos.");
				}
				break;
			}
		}
	}
	
	// IMPRIMIR EMPLEADO
	static void imprimirEmpleado(ArrayList<Escuderia> listaEscuderias, String tipoEmpleado) {
		String nombreEmpleado = ToolsDatos.pedirStringCapital("Escribe el nombre del " +tipoEmpleado+ " que quieres consultar:");
		String apellidoEmpleado = ToolsDatos.pedirStringCapital("Escribe también su apellido:");
		String nombreEmpleadoEvaluado;
		String apellidoEmpleadoEvaluado;
		String tipoEmpleadoEvaluado;
		int indiceEsc=0;
		int indiceEmpl=0;
		boolean pilotoEncontrado=false;
		do {
			do {
				nombreEmpleadoEvaluado=listaEscuderias.get(indiceEsc).devolverEmpleado(indiceEmpl).getNombreEmpleado();
				apellidoEmpleadoEvaluado=listaEscuderias.get(indiceEsc).devolverEmpleado(indiceEmpl).getApellidoEmpleado();
				tipoEmpleadoEvaluado=listaEscuderias.get(indiceEsc).devolverEmpleado(indiceEmpl).getTipoEmpleado();
				if (nombreEmpleadoEvaluado.equalsIgnoreCase(nombreEmpleado) && apellidoEmpleadoEvaluado.equalsIgnoreCase(apellidoEmpleado) && tipoEmpleadoEvaluado.equalsIgnoreCase(tipoEmpleado)) {
					pilotoEncontrado=true;
					System.out.println(listaEscuderias.get(indiceEsc).devolverEmpleado(indiceEmpl).toString());
				} else {
					indiceEmpl++;
				}
			} while (pilotoEncontrado==false && indiceEmpl<listaEscuderias.get(indiceEsc).sizeListaEmpleados());
			indiceEsc++;
			indiceEmpl=0;
		} while (pilotoEncontrado==false && indiceEsc<listaEscuderias.size());
		if (pilotoEncontrado==false) {
			System.out.println("El " +tipoEmpleado+ " " +nombreEmpleado+ " " +apellidoEmpleado+ " no se encuentra dado de alta en la base de datos.");	
		}
	}
	
	// * * * * * * * * * * * * * * * * OPCIONES DE LISTADOS  * * * * * * * * * * * * * * * * //
	
	// LISTADO DE ESCUDERÍAS ********************** (FINALIZADO)
	static void verListaEscuderias(ArrayList<Escuderia> listaEscuderias) {
		if (listaEscuderias.size()==0) {
			System.out.println("No se encuentra ninguna Escudería en la base de datos.");
		} else {
			System.out.println("NOMBRE ESCUDERÍA // PAÍS // PRESUPUESTO ");
			System.out.println("--------------------------------------- ");
			for (int indice = 0; indice<listaEscuderias.size(); indice++) {
				System.out.print(listaEscuderias.get(indice).getNombreEscuderia());
				System.out.print("  //  ");
				System.out.print(listaEscuderias.get(indice).getPaisEscuderia());
				System.out.print("  //  ");
				System.out.print(listaEscuderias.get(indice).getPresupuestoEscuderia() + " millones de euros");			
				System.out.println();
			}
		}
	}
	
	// LISTADO DE BÓLIDOS ********************** (FINALIZADO)
	static void verListaBólidos(ArrayList<Escuderia> listaEscuderias) {
		if (Escuderia.hayBolidos(listaEscuderias)) {
			System.out.println("MODELO DEL BÓLIDO // ESCUDERÍA // POTENCIA // MAX. VELOCIDAD // COLOR // PRECIO");
			System.out.println("------------------------------------------------------------------------------ ");
			for (int indiceEsc=0; indiceEsc<listaEscuderias.size(); indiceEsc++) {
				for (int indiceBol = 0; indiceBol<listaEscuderias.get(indiceEsc).sizeListaBolidos(); indiceBol++) {
					System.out.print(listaEscuderias.get(indiceEsc).devolverBolido(indiceBol).getModeloBolido());
					System.out.print("  //  ");
					System.out.print(listaEscuderias.get(indiceEsc).getNombreEscuderia());
					System.out.print("  //  ");
					System.out.print(listaEscuderias.get(indiceEsc).devolverBolido(indiceBol).getPotenciaBolido()+ " CV.");
					System.out.print("  //  ");
					System.out.print(listaEscuderias.get(indiceEsc).devolverBolido(indiceBol).getVelocidadBolido()+ " km/h");
					System.out.print("  //  ");
					System.out.print(listaEscuderias.get(indiceEsc).devolverBolido(indiceBol).getColorBolido());
					System.out.print("  //  ");
					System.out.print(listaEscuderias.get(indiceEsc).devolverBolido(indiceBol).getPrecioBolido()+ " euros.");			
					System.out.println();
				}
			}
		} else {
			System.out.println("No se encuentra ningún Bólido en la base de datos.");
		}
	}
	
	// LISTADO DE EMPLEADOS (MECÁNICOS Y PILOTOS) ********************** (FINALIZADO)
	static void verListaEmpleados(byte opcionLista, ArrayList<Escuderia> listaEscuderias) {
		switch (opcionLista) {
			case 3:
				if (Escuderia.hayPilotos(listaEscuderias)) {
					for (int indiceEsc = 0; indiceEsc<listaEscuderias.size(); indiceEsc++) {
						for (int indiceEmpl = 0; indiceEmpl<listaEscuderias.get(indiceEsc).sizeListaEmpleados(); indiceEmpl++) {
							Empleado empleadoExtraido = listaEscuderias.get(indiceEsc).devolverEmpleado(indiceEmpl);
							if (empleadoExtraido.getTipoEmpleado().equalsIgnoreCase("piloto")) {
								System.out.println(empleadoExtraido);
							}
						}
					}
				} else {
					System.out.println("No hay Pilotos dados de alta en la base de datos.");
				}
				break;
			case 4:
				if (Escuderia.hayMecanicos(listaEscuderias)) {
					for (int indiceEsc = 0; indiceEsc<listaEscuderias.size(); indiceEsc++) {
						for (int indiceEmpl = 0; indiceEmpl<listaEscuderias.get(indiceEsc).sizeListaEmpleados(); indiceEmpl++) {
							Empleado empleadoExtraido = listaEscuderias.get(indiceEsc).devolverEmpleado(indiceEmpl);
							if (empleadoExtraido.getTipoEmpleado().equalsIgnoreCase("mecánico")) {
								System.out.println(empleadoExtraido);
							}
						}
					}
				} else {
					System.out.println("No hay Mecánicos dados de alta en la base de datos.");
				}
				break;
		}
	}
	
} // FIN DE LA CLASE TOOLSACCIONESMENU