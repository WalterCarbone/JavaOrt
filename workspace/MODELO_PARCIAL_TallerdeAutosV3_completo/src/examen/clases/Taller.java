package examen.clases;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ort.tp1.tdas.implementaciones.ColaNodos;
import ort.tp1.tdas.interfaces.Cola;

public class Taller {
	private static final int MAX_TRABAJOS_DIARIOS = 50;
	private static float PRECIO_HORA = 3000;
	private static Scanner input  = new Scanner(System.in);
	private Servicio[] servicios;
	private ListaTrabajosPendientes trabajosPendientes;
	private ArrayList<Trabajo> trabajosRealizados;
	private Cola<Vehiculo> vehiculosEnPuerta;

	public Taller() {
		vehiculosEnPuerta = new ColaNodos<Vehiculo>(MAX_TRABAJOS_DIARIOS);
		trabajosPendientes = new ListaTrabajosPendientes();
		trabajosRealizados = new ArrayList<>();
		cargarServicios();
	}

	public void agregarVehiculoEnEspera(String patente, String marca, EstadoAirbag airbag) {
		try {
			agregarVehiculoEnEspera(new Auto(patente, marca, airbag));
		} catch (RuntimeException re) {
			System.out.println(re.getMessage());
		}
	}

	public void agregarVehiculoEnEspera(String patente, String marca, int cilindrada, boolean tieneLimitador) {
		try {
			agregarVehiculoEnEspera(new Moto(patente, marca, cilindrada, tieneLimitador));
		} catch (RuntimeException re) {
			System.out.println(re.getMessage());
		}
	}

	private void agregarVehiculoEnEspera(Vehiculo vehiculo) {
		vehiculosEnPuerta.add(vehiculo);
	}

	private void cargarServicios() {
		String[] nombresServicios = { "Cambio de Bateria", "Cambio Aceite y Filtro", "Alineacion y Balanceo",
				"Cambio amortiguadores", "Servicio completo" };
		float[] duracionEstimadaServicio = { 0.5f, 1, 1.5f, 2, 3 };
		servicios = new Servicio[nombresServicios.length];
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
		int[] cantidadPorServicios = new int[servicios.length];
		for (Trabajo trabajo : trabajosRealizados) {
			cantidadPorServicios[trabajo.getCodigo() - 1]++;
		}
		for (int i = 0; i < cantidadPorServicios.length; i++) {
			if (cantidadPorServicios[i] > 0) {
				System.out.println(servicios[i].getDesc() + ": " + cantidadPorServicios[i]);
			}
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
		Vehiculo vehiculo;
		while (!vehiculosEnPuerta.isEmpty()) {
			vehiculo = vehiculosEnPuerta.remove();
			System.out.println("Ingreso el VEHICULO " + vehiculo.getPatente());
			trabajosPendientes.add(crearTrabajo(vehiculo));
		}
	}

	public void procesarServicios() {
		Trabajo trabajo;
		while (!trabajosPendientes.isEmpty()) {
			trabajo = trabajosPendientes.removeAt(0);
			trabajo.aplicarPrecioHora(PRECIO_HORA);
			trabajosRealizados.add(trabajo);
		}
	}

	public void reportarTrabajosPendientes() {
		trabajosPendientes.reportar();
	}

	public void revisarVehiculosEnPuerta() {
		Vehiculo extra = new Moto("***", "", Integer.MAX_VALUE, true);
		vehiculosEnPuerta.add(extra);
		Vehiculo vehiculo = vehiculosEnPuerta.remove();
		System.out.println("Vehiculos que no pueden ingresar al taller ");
		while (vehiculo != extra) {
			if (!vehiculo.autoDiagnostico()) {
				System.out.println("El Vehiculo patente " + vehiculo.getPatente()
						+ " no cumple con los requisitos y es rechazado.");
			} else {
				vehiculosEnPuerta.add(vehiculo);
			}
			vehiculo = vehiculosEnPuerta.remove();
		}
	}

}