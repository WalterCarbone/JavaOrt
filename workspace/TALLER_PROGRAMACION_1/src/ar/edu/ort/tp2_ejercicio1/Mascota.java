package ar.edu.ort.tp2_ejercicio1;

public class Mascota {
	private String nombreMascota;
	private String tipoMascota;

	public Mascota(String nombre, String tipo) {

		setNombreMascota(nombre);
		setNombreTipo(tipo);
	}

	private void setNombreTipo(String tipo) {
		this.tipoMascota = tipo;

	}

	private void setNombreMascota(String nombre) {
		this.nombreMascota = nombre;

	}

	public String getNombreMascota() {
		return this.nombreMascota;
	}

	public String getTipoMascota() {
		return this.tipoMascota;
	}

	@Override
	public String toString() {
		return  "\n"+nombreMascota +", "+  tipoMascota ;
	}

}
