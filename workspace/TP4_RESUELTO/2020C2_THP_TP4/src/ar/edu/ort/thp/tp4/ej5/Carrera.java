package ar.edu.ort.thp.tp4.ej5;

import java.util.ArrayList;

public class Carrera {

	private String fecha;
	private String hora;
	private Dificultad dificultad;
	private ArrayList<Piloto> pilotos;

	/**
	 * Constructor de Carrera
	 * 
	 * @param fecha
	 * @param hora
	 * @param dificultad
	 */
	public Carrera(String fecha, String hora, Dificultad dificultad) {
		setFecha(fecha);
		setHora(hora);
		setDificultad(dificultad);
		pilotos = new ArrayList<>();
	}

	/**
	 * Agrega un piloto a la carrera
	 * 
	 * @param nombre
	 * @param dni
	 * @return boolean - Confirmación de acción
	 */
	public boolean agregarPiloto(String nombre, String dni) {
		return pilotos.add(new Piloto(nombre, dni));
	}

	/**
	 * Debe crear y devolver una lista de aquellos pilotos que hayan realizado
	 * al menos 10 vueltas, y cuyo promedio de tiempo no supere al promedio
	 * enviado por parámetro.
	 * 
	 * @param promedio
	 * @return ArrayList de Piloto
	 */
	public ArrayList<Piloto> buscarPilotosPorDebajoDe(double promedio) {
		ArrayList<Piloto> pilotosPorDebajo;
		pilotosPorDebajo = new ArrayList<>();

		for (Piloto piloto : pilotos) {

			if (piloto.getCantidadVueltas() >= 10 && piloto.calcularPromedio() <= promedio) {
				pilotosPorDebajo.add(piloto);
			}
		}

		return pilotosPorDebajo;
	}

	/**
	 * getter de dificultad
	 * 
	 * @return
	 */
	public Dificultad getDificultad() {
		return dificultad;
	}

	/**
	 * getter de fecha
	 * 
	 * @return
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * getter de hora
	 * 
	 * @return
	 */
	public String getHora() {
		return hora;
	}

	/**
	 * Muestra por pantalla el nombre y dni del piloto con menor promedio.
	 */
	public void mostrarMenorPromedio() {
		Piloto pilotoMenor = null;
		double menorPromedio = Double.MAX_VALUE;
		double promedio;

		for (Piloto piloto : pilotos) {

			promedio = piloto.calcularPromedio();

			if (promedio < menorPromedio) {
				pilotoMenor = piloto;
				menorPromedio = promedio;
			}
		}
		System.out.println("El piloto con menor promedio es " + pilotoMenor);
	}

	public InfoCarrera obtenerInfoCarrera() {
		return new InfoCarrera(fecha, pilotos.size());
	}

	/**
	 * setter de dificultad
	 * 
	 * @param dificultad
	 */
	private void setDificultad(Dificultad dificultad) {
		this.dificultad = dificultad;
	}

	/**
	 * setter de fecha
	 * 
	 * @param fecha
	 */
	private void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * setter de hora
	 * 
	 * @param hora
	 */
	private void setHora(String hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return "Carrera [fecha=" + fecha + ", hora=" + hora + ", dificultad=" + dificultad + "]";
	}
}
