package ar.edu.ort.tp1.parcial1.clases;

import java.lang.invoke.SwitchPoint;
import java.util.ArrayList;

public class Veterinaria implements Mostrable {

	private static final String TXT_INGRESO = "Ingresando a %s a la veterinaria \n";
	private static final String TXT_CANTIDADES = "Han sido ingresados: %d conejos, %d gatos y %d perros\n";
	private String nombre;
	private Doctor doctor;
	private ArrayList<Mascota> animalesIngresados;
	// TODO A completar

	public Veterinaria(String nombre, Doctor doctor) {
		setNombre(nombre);
		setDoctor(doctor);
		animalesIngresados = new ArrayList<>();

		/*
		 * switch (key) { case value:
		 * 
		 * break;
		 * 
		 * default: break; }
		 * 
		 * System.out.println();
		 */
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	private void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public void admitirMascota(Mascota mascota) {
		if (mascota != null) {
			animalesIngresados.add(mascota);
			System.out.printf(TXT_INGRESO, mascota.getNombre());
		}
	}

	public Mascota buscarMascota(String nombreDeMascota) {
		int cont = 0;
		Mascota buscada = null;
		while (cont < animalesIngresados.size() && !nombreDeMascota.equals(animalesIngresados.get(cont).getNombre())) {
			cont++;
		}
		if (cont < animalesIngresados.size()) {
			buscada = animalesIngresados.get(cont);
		}

		return buscada;
	}

	public void vacunar() {
		int cont = 0;
		for (Mascota mascota : animalesIngresados) {
			if (mascota.getVacunado() == false) {
				mascota.vacunar();
				cont++;
			}

		}
		System.out.println("Vacunas aplicadas : " + cont);
	}

	@Override
	public void mostrar() {
		int cant_gatos = 0;
		int cant_perros = 0;
		int cant_conejos = 0;
		System.out.println("Veterinaria: " + this.getNombre());
		System.out.println("Doctor de turno: " + doctor.getNombre());

		for (Mascota mascota : animalesIngresados) {
			if (mascota instanceof Conejo) {
				cant_conejos++;
			} else if (mascota instanceof Perro) {
				cant_perros++;
			} else {
				cant_gatos++;
			}

		}
		System.out.printf(TXT_CANTIDADES, cant_conejos, cant_gatos, cant_perros);
	}

}
