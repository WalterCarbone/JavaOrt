package ar.edu.ort.tp1.tp3Ejercicio05.incompleto;

public class Equipo {
	
	private String  nombre;
	private int		puntos;

	public Equipo() {
		nombre 	= "sin definir";
		puntos 	= 0;
	}
	
	public Equipo(String nombre, int puntos) {
		this.nombre = nombre;
		this.puntos = puntos;
	}

	@Override
	public String toString() {
		return nombre + ": " + puntos + " puntos";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos += puntos;
	}
}
