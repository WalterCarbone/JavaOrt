package ar.edu.ort.tp2_ejercicio1;

import java.util.ArrayList;

public class Persona {

	private String nombre;
	private String apellido;
	ArrayList<NumeroTelefonico> telefonos;
	ArrayList<EMail> mails;
	private ArrayList<Mascota> mascotas;

	public Persona(String nombre, String apellido) {
		setNombre(nombre);
		setApellido(apellido);
		telefonos = new ArrayList<>();
		mails = new ArrayList<>();
		mascotas = new ArrayList<>();
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void agregarTelefono(int caract, int numAbonado, int codPais, TipoDeLinea tipo) {
		telefonos.add(new NumeroTelefonico(caract, numAbonado, codPais, tipo));
	}

	public void agregarMail(String mail) {
		mails.add(new EMail(mail));
	}
	
	public void agregarMacota(String nombre, String tipo){
		mascotas.add(new Mascota(nombre,tipo));
	}

	@Override
	public String toString() {
		return  apellido +","+ nombre + "\nTelefonos:" + telefonos + "\nMails=" + mails
				+ "\nMascotas:" + mascotas;
	}

}
