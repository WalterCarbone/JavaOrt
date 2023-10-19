package ar.edu.ort.thp.tp4.ej5;

import java.util.ArrayList;

public class Piloto {

	private String nombre;
	private String dni;
	private ArrayList<Vuelta> vueltas;

	/**
	 * Constructor de Piloto
	 */
	public Piloto(String nombre, String dni) {
		setNombre(nombre);
		setDni(dni);
		vueltas = new ArrayList<>();
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
	 * setter de dni
	 * 
	 * @param dni
	 */
	private void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * getter de nombre
	 * 
	 * @return
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Calcula el promedio de tiempo del piloto, entre todas las vueltas que haya
	 * realizado
	 * 
	 * @return Promedio (double)
	 */
	public double calcularPromedio() {

		int sumaTotal = 0;

		for (Vuelta vuelta : vueltas) {
			sumaTotal += vuelta.getTiempo();
		}
		return Matematica.obtenerPromedio(sumaTotal, vueltas.size());
	}

	/**
	 * Obtiene la cantidad de vueltas que realizó el piloto
	 * 
	 * @return
	 */
	public int getCantidadVueltas() {
		return vueltas.size();
	}

	@Override
	public String toString() {
		return "Piloto [nombre=" + nombre + ", dni=" + dni + "]";
	}
}
