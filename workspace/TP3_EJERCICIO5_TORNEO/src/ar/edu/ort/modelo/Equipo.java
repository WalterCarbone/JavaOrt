package ar.edu.ort.modelo;

public class Equipo {

	private String nombre;
	private int puntos;

	public Equipo(String nombre) {
		super();
		setNombre(nombre);
		this.puntos = 0;
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPuntos() {
		return puntos;
	}

	
	
	public void actualizarPuntos(int puntos){
		this.puntos+=puntos;
	}

	@Override
	public String toString() {
		return  nombre +" "+ puntos + " puntos";
	}

}
