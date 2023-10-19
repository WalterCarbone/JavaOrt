package ar.edu.ort.tp1.tp3Ej5;

import java.util.ArrayList;

public class Jornada {

	private ArrayList<Partido> partidos;
	private int fecha;// 1,2...n

	public Jornada() {
		partidos = new ArrayList<Partido>();
		fecha = 0;
	}

	public Jornada(int fecha) {
		partidos = new ArrayList<Partido>();
		this.fecha = fecha;
	}

	public void agregarPartido(Partido partido) {
		partidos.add(partido);
	}

	public void eliminarPartido(Partido partido) {
		partidos.remove(partidos);
	}

	public ArrayList<Partido> getPartidos() {
		return partidos;
	}

	public int getFecha() {
		return fecha;
	}

	public void setFecha(int fecha) {
		this.fecha = fecha;
	}
}