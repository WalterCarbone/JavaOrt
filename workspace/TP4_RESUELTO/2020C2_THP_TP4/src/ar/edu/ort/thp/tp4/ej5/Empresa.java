package ar.edu.ort.thp.tp4.ej5;

import java.util.ArrayList;

public class Empresa {

	private String nombre;
	private ArrayList<Carrera> carreras;

	/**
	 * Constructor de Empresa
	 * 
	 * @param nombre
	 */
	public Empresa(String nombre) {
		setNombre(nombre);
		carreras = new ArrayList<>();
	}

	/**
	 * setter de nombre
	 * 
	 * @param nombre
	 */
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * getter de nombre
	 * 
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Busca una carrera, recibiendo una fecha como parámetro.
	 * 
	 * @param fecha
	 * @return Carrera si la encuentra en la lista o null de no lograrlo
	 */
	private Carrera buscarCarrera(String fecha) {
		Carrera carrera = null;
		int i = 0;

		while (carrera == null && i < carreras.size()) {
			if (carreras.get(i).getFecha() == fecha) {
				carrera = carreras.get(i);
			} else {
				i++;
			}
		}
		return carrera;
	}

	/**
	 * Agrega una carrera a la lista de carreras
	 * 
	 * @param fecha
	 * @param hora
	 * @param dificultad
	 * @return boolean - Confirmación de acción
	 */
	public boolean agregarCarrera(String fecha, String hora, Dificultad dificultad) {
		boolean pudeAgregar = false;

		if (buscarCarrera(fecha) == null) {
			carreras.add(new Carrera(fecha, hora, dificultad));
			pudeAgregar = true;
		}

		return pudeAgregar;
	}

	/**
	 * Crea y devuelve una lista con la cantidad de pilotos que participaron en cada
	 * una de las fecha de las carreras.
	 * 
	 * @return ArrayList de InfoCarrera
	 */
	public ArrayList<InfoCarrera> informeResumidoPorCarrera() {
		ArrayList<InfoCarrera> infoCarreras;
		infoCarreras = new ArrayList<>();

		for (Carrera carrera : carreras) {
			infoCarreras.add(carrera.obtenerInfoCarrera());
		}

		return infoCarreras;
	}

	/**
	 * Agrega un piloto a la carrera con fecha recibida como parámetro
	 * 
	 * @param nombre
	 * @param dni
	 * @param fecha
	 * @return boolean - Confirmación de acción
	 */
	public boolean agregarPilotoACarrera(String nombre, String dni, String fecha) {

		boolean pudoAgregar = false;
		Carrera carrera;
		carrera = buscarCarrera(fecha);

		if (carrera != null) {
			pudoAgregar = carrera.agregarPiloto(nombre, dni);
		}
		return pudoAgregar;
	}
	
	@Override
	public String toString() {
		return "Empresa [nombre=" + nombre + ", carreras=" + carreras + "]";
	}
}
