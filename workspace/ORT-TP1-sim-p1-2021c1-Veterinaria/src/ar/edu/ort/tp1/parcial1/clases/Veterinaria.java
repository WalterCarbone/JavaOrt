package ar.edu.ort.tp1.parcial1.clases;

import java.util.ArrayList;

public class Veterinaria implements Mostrable {

	private static final String TXT_INGRESO = "Ingresando a %s a la veterinaria \n";
	private static final String TXT_CANTIDADES = "Han sido ingresados: %d conejos, %d gatos y %d perros\n";
	// TODO A completar
	private final String nombre;
	private final Doctor doctor;
	private final ArrayList<Mascota> animalesIngresados;

	public Veterinaria(String nombre, Doctor doctor) {
		// TODO A completar
		this.nombre = nombre;
		this.doctor = doctor;
		this.animalesIngresados = new ArrayList<Mascota>();
	}

	public void admitirMascota(Mascota mascota) {
		// TODO A completar
		if (mascota != null) {
			System.out.printf(TXT_INGRESO, mascota.getNombre());
			this.animalesIngresados.add(mascota);
		}
	}

	public Mascota buscarMascota(String nombreDeMascota) {
		// TODO A completar
		Mascota mascota = null;
		int idx = 0;

		while (mascota == null && idx < this.animalesIngresados.size()) {
			if (this.animalesIngresados.get(idx).getNombre().equals(nombreDeMascota)) {
				mascota = this.animalesIngresados.get(idx);
			}
			idx++;
		}

		return mascota;
	}

	public void vacunar() {
		// TODO A completar
		int cantidadVacunas = 0;
		for (Mascota mascota : animalesIngresados) {
			if (!mascota.estaVacunado()) {
				cantidadVacunas++;
				mascota.vacunar();
			}
		}

		System.out.println("Vacunas aplicadas: " + cantidadVacunas);
	}

	@Override
	public void mostrar() {
		// TODO A completar
		System.out.println("Veterinaria: " + nombre);
		System.out.println("Doctor de Turno: " + doctor.getNombre());

		int cantidadConejos = 0;
		int cantidadGatos = 0;
		int cantidadPerros = 0;

		for (Mascota mascota : animalesIngresados) {
			if (mascota instanceof Conejo) {
				cantidadConejos++;
			} else if (mascota instanceof Gato) {
				cantidadGatos++;
			} else {
				cantidadPerros++;
			}
		}

		System.out.printf(TXT_CANTIDADES, cantidadConejos, cantidadGatos,
				cantidadPerros);
	}
}
