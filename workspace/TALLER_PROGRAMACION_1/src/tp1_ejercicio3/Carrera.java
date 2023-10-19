package tp1_ejercicio3;

import java.util.ArrayList;

public class Carrera {

	private String especialidad;
	private ArrayList<Atleta> corredores;
	private ArrayList<Atleta> primeros;
	private ArrayList<Atleta> segundos;
	private ArrayList<Atleta> terceros;

	private double primero = Double.MAX_VALUE;
	private double segundo = Double.MAX_VALUE;
	private double tercero = Double.MAX_VALUE;

	public Carrera(String esp) {

		setEspecialidad(esp);
		corredores = new ArrayList<>();
		primeros = new ArrayList<>();
		segundos = new ArrayList<>();
		terceros = new ArrayList<>();

	}

	public void agregarCorredor(String nombre, double tiempo) {
		corredores.add(new Atleta(nombre, tiempo));
	}

	public void mostrarCorredores() {
		for (Atleta a : corredores) {
			System.out.println(a);
		}
	}

	private void setEspecialidad(String esp) {
		this.especialidad = esp;
	}

	public void calcularGanador() {
		for (Atleta a : corredores) {
			if (a.getTiempo() < primero) {
				tercero = segundo;
				segundo = primero;
				primero = a.getTiempo();
			} else if (a.getTiempo() > primero && a.getTiempo() < segundo) {
				tercero = segundo;
				segundo = a.getTiempo();
			} else if (a.getTiempo() > segundo && a.getTiempo() < tercero) {
				tercero = a.getTiempo();

			}

		}

	}

	public void completarPodio() {
		for (Atleta c : corredores) {
			if (c.getTiempo() == primero) {
				primeros.add(c);

			} else if (c.getTiempo() == segundo) {
				segundos.add(c);
			} else if (c.getTiempo() == tercero) {
				terceros.add(c);
			}

		}

	}

	public void mostrarGanador() {
		calcularGanador();
		completarPodio();
		System.out.println("Especialidad : " + this.getEspecialidad());
		System.out.println("Primer Puesto");
		System.out.println("-------------");
		for (Atleta p : primeros) {
			System.out.println(p);
		}
		System.out.println("Segundo Puesto");
		System.out.println("-------------");
		for (Atleta s : segundos) {
			System.out.println(s);
		}
		System.out.println("Tercer Puesto");
		System.out.println("-------------");
		for (Atleta t : terceros) {
			System.out.println(t);
		}
	}

	public String getEspecialidad() {
		return this.especialidad;
	}
}
