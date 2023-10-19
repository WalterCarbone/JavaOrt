package ar.edu.ort.tp1.tp6Ej4.clases;

import ar.edu.ort.tp1.tdas.implementaciones.ColaNodos;
import ar.edu.ort.tp1.tdas.interfaces.Cola;

public class CompaniaDeTransportes {
	private static int ultimoLegajo = 0;

	private ListaChoferes staff;
	private ListaVehiculos flota;
	private Cola<Vehiculo> viajesListos;

	// 1 - Crear las estructuras propuestas
	public CompaniaDeTransportes() {
		this.staff = new ListaChoferes();
		this.flota = new ListaVehiculos();
		this.viajesListos = new ColaNodos<>();
	}

	public void altaChofer(int dni, String nombre) {
		Chofer chofer = staff.search(dni);
		if (chofer != null) {
			throw new RuntimeException("Chofer existente!");
		}
		staff.add(new Chofer(dni, proximoLegajo(), nombre));
	}

	public Chofer bajaChofer(int dni) {
		Chofer chofer = staff.search(dni);
		if (chofer != null) {
			if (chofer.getVehiculo() == null)
				staff.remove(chofer);
			else
				throw new RuntimeException("No se puede despedir a un chofer en viaje!");
		}
		return chofer;
	}

	public void altaVehiculo(String patente, TipoVehiculo tipoVehiculo, double capacidadDeCarga) {
		Vehiculo vehiculo = flota.search(patente);
		if (vehiculo != null) {
			throw new RuntimeException("Vehiculo existente!");
		}
		flota.add(new Vehiculo(patente, tipoVehiculo, capacidadDeCarga));
	}

	private static int proximoLegajo() {
		return ++ultimoLegajo;
	}

	public void listarChoferes() {
		for (Chofer chofer : staff) {
			System.out.println(chofer);
		}
	}

	public void listarVehiculos() {
		for (Vehiculo vehiculo : flota) {
			System.out.println(vehiculo);
		}
	}

	// 2 - Asignar un vehiculo a un chofer (utilizando Excepciones)
	public void asignarVehiculo(String patenteVehiculo, int dniChofer) {
		if (patenteVehiculo == null || patenteVehiculo.isEmpty()) {
			throw new IllegalArgumentException("Debe ingresarse una patente");
		}
		Vehiculo vehiculo = flota.search(patenteVehiculo);
		if (vehiculo == null) {
			throw new RuntimeException("Vehiculo inexistente");
		} else if (vehiculo.getChoferACargo() != null) {
			throw new RuntimeException("Vehiculo con chofer asignado");
		}
		Chofer chofer = staff.search(dniChofer);
		if (chofer == null) {
			throw new RuntimeException("Chofer inexistente");
		}
		vehiculo.asignarChofer(chofer);
		chofer.asignarVehiculo(vehiculo);
	}

	// 3 - Asignar una carga (utilizando Excepciones) al vehiculo que más se
	// adapte al peso de la carga.
	// a - Vehiculo con conductor asignado.
	// b - No debe tener carga asignada.
	// c - Su capacidad debe ser mayor o igual al peso de la carga.
	// De todos los vehículos posibles debe quedarse con el menor de todos
	// ellos.
	//
	// Si se logra asignar la carga el vehiculo debe agregarse a la cola de
	// vehiculos listos para partir.
	public void asignarCarga(Carga carga) {
		System.out.println("\n*** ASIGNACION DE CARGA ***");
		if (carga == null) {
			throw new IllegalArgumentException("Debe ingresarse una carga");
		}
		System.out.printf("Carga a transportar: %s (%.2f kg)\n", carga.getDescripcion(), carga.getPeso());
		Vehiculo vehiculo = null;
		for (Vehiculo ve : flota) {
			if (ve.getCargaAsignada() == null && ve.getChoferACargo() != null
					&& ve.getCapacidadDeCarga() >= carga.getPeso()) {
				if (vehiculo == null || ve.getCapacidadDeCarga() < vehiculo.getCapacidadDeCarga()) {
					vehiculo = ve;
				}
			}
		}
		if (vehiculo != null) {
			vehiculo.asignarCarga(carga);
			viajesListos.add(vehiculo);
		} else {
			System.out.println("No hay vehiculo disponible");
		}
	}

	// 4 - Listar choferes libres (que no estan de viaje)
	public void listarChoferesLibres() {
		System.out.println("\n--- Choferes Libres ---");
		for (Chofer chofer : staff) {
			if (!chofer.ListoParaViajar()) {
				System.out.println(chofer.getDni() + " - " + chofer.getNombre());
			}
		}
	}

	// 5 - Listar los vehiculos listos para salir de viaje (la estructura debe
	// quedar en el orden inicial).
	public void listarVehiculosListosParaPartir() {
		Carga carga;
		Vehiculo centinela = new Vehiculo("----", TipoVehiculo.CAMION, Integer.MAX_VALUE);
		viajesListos.add(centinela);
		Vehiculo ve = viajesListos.remove();
		while (!ve.equals(centinela)) {
			carga = ve.getCargaAsignada();
			System.out.printf("\nEl vehiculo con patente %s esta listo para salir.", ve.getPatente());
			System.out.printf("\nEl conductor del vehiculo es %s y la carga asignada %s (%s Kg)\n",
					ve.getNombreChofer(), carga.getDescripcion(), carga.getPeso());
			viajesListos.add(ve);
			ve = viajesListos.remove();
		}
	}

}