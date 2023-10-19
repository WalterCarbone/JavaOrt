package examen.clases;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ort.tp1.tdas.implementaciones.ColaNodos;
import ort.tp1.tdas.implementaciones.ListaOrdenadaNodos;
import ort.tp1.tdas.interfaces.Cola;
import ort.tp1.tdas.interfaces.ListaOrdenada;

public class Taller {
	private static final int MAX_TRABAJOS_DIARIOS = 50;
	private static float PRECIO_HORA = 3000;
	private static int CANT_SERVICIOS = 5;
	private static Scanner input = new Scanner(System.in);
	private ColaNodos<Vehiculo> vehiculosEnPuerta;
	private ListaTrabajosPendientes ListaTrabajosPendientes;
	private Servicio[] servicios;
	private ArrayList<Trabajo> trabajosRealizados;

	public Taller() {
		vehiculosEnPuerta = new ColaNodos<Vehiculo>(MAX_TRABAJOS_DIARIOS);
		ListaTrabajosPendientes = new ListaTrabajosPendientes();
		servicios = new Servicio[CANT_SERVICIOS];
		trabajosRealizados = new ArrayList<>();
		cargarServicios();

	}

	public void agregarVehiculoEnEspera(String patente, String marca, EstadoAirbag airbag) {
		try {
			vehiculosEnPuerta.add(new Auto(patente, marca, airbag));
		} catch (RuntimeException rte) {
			System.out.println(rte.getMessage());
		}
	}


	public void agregarVehiculoEnEspera(String patente, String marca, int cilindrada, boolean tieneLimitador) {
		try {
			vehiculosEnPuerta.add(new Moto(patente, marca, cilindrada, tieneLimitador));
		} catch (RuntimeException rte) {
			System.out.println(rte.getMessage());
		}
	}


	private void agregarVehiculoEnEspera(Vehiculo vehiculo) {
		vehiculosEnPuerta.add(vehiculo);
	}

	public void cargarServicios() {
		String[] nombresServicios = { "Cambio de Bateria", "Cambio Aceite y Filtro", "Alineacion y Balanceo",
				"Cambio amortiguadores", "Servicio completo" };
		float[] duracionEstimadaServicio = { 0.5f, 1, 1.5f, 2, 3 };
		for (int i = 0; i < servicios.length; i++) {
			servicios[i] = new Servicio(i + 1, nombresServicios[i], duracionEstimadaServicio[i]);
		}

	}

	private Trabajo crearTrabajo(Vehiculo vehiculo) {
		int numero = 0;
		numero = pedirServicio();
		Servicio servicio = servicios[numero - 1];
		Trabajo trabajo = new Trabajo(vehiculo, servicio);
		return trabajo;
	}

	public void informarImporteServicios() {
		float total = 0;
		for (Trabajo trabajo : trabajosRealizados) {
			System.out.println(trabajo);
			total += trabajo.getImporte();
		}
		System.out.println("La recaudacion del dia fue:" + total);
	}

	
	public void informarResumenServicios() {
	
		int[] cantidadPorServicios = new int[CANT_SERVICIOS];
		String[] nombresServicios = { "Cambio de Bateria", "Cambio Aceite y Filtro", "Alineacion y Balanceo",
				"Cambio amortiguadores", "Servicio completo" };
		for (Trabajo trabajo : trabajosRealizados) {
			cantidadPorServicios[trabajo.getCodigo()-1]=cantidadPorServicios[trabajo.getCodigo()-1]+1;
		}
		for (int i = 0; i < cantidadPorServicios.length; i++) {
			System.out.println(nombresServicios[i]+": "+cantidadPorServicios[i]);
			
		}
	}

	private void mostrarMenuServicios() {
		for (int i = 0; i < servicios.length; i++) {
			System.out.println(servicios[i]);
		}
	}

	private int pedirServicio() {
		int numero = 0;
		boolean ok = false;
		while (!ok) {
			try {
				mostrarMenuServicios();
				System.out.println("Solicite un servicio 1-5:");
				numero = input.nextInt();
				if (numero > 0 && numero <= servicios.length) {
					ok = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Error. Ingrese un numero correcto");
			} finally {
				input.nextLine();
			}
		}
		return numero;
	}

	
	public void procesarIngresoVehiculos() {
		
		Vehiculo vehiculo = vehiculosEnPuerta.remove();

		while (!vehiculosEnPuerta.isEmpty()) {
			System.out.println("Ingreso vehiculo : " + vehiculo.getPatente());
			Trabajo trabajo = crearTrabajo(vehiculo);
			ListaTrabajosPendientes.add(trabajo);
			vehiculo=vehiculosEnPuerta.remove();
		}
	}

	public void procesarServicios() {
		Trabajo trabajo;
		while (!ListaTrabajosPendientes.isEmpty()) {
			trabajo = ListaTrabajosPendientes.removeAt(0);
			trabajo.aplicarPrecioHora(PRECIO_HORA);
			trabajosRealizados.add(trabajo);
		}
	}

	public void reportarTrabajosPendientes() {
		ListaTrabajosPendientes.reportar();
	}

	
	public void revisarVehiculosEnPuerta() {
		Vehiculo centinela = new Auto("111", "AAAA", EstadoAirbag.OK);
		vehiculosEnPuerta.add(centinela);
		Vehiculo aRevisar = vehiculosEnPuerta.remove();
		System.out.println("Vehículos que no pueden ingresar al taller:");
		while (aRevisar != centinela) {

			if (!aRevisar.autoDiagnostico()) {
				System.out.println("El vehiculo "+ aRevisar.getPatente()+" no cumple los requisitos");
			} else {
				vehiculosEnPuerta.add(aRevisar);
			}
			aRevisar = vehiculosEnPuerta.remove();
		}
	}

}