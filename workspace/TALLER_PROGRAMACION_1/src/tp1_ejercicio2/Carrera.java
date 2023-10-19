package tp1_ejercicio2;

import java.util.ArrayList;

public class Carrera {

	private String especialidad;
	private ArrayList<Atleta> corredores;
	private ArrayList<Atleta> ganadores;
	private double tiempo = Double.MAX_VALUE;

	public Carrera(String esp) {

		setEspecialidad(esp);
		corredores = new ArrayList<>();
		ganadores = new ArrayList<>();

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
			if (a.getTiempo() == tiempo) {
				ganadores.add(a);
			}
			if (a.getTiempo() < tiempo) {
				ganadores.removeAll(ganadores);
				ganadores.add(a);
				tiempo = a.getTiempo();
			}

		}
	}
	
	public void mostrarGanador(){
		System.out.println("Especialidad : " + this.getEspecialidad());
		if(ganadores.size()>1){
			System.out.println("Los ganadores son :");
		}else{
		System.out.println("El ganador es :");
	}
		for (Atleta g : ganadores) {
			System.out.println(g);
		}
		
	}
	
	public String getEspecialidad(){
		return this.especialidad;
	}
}
