package tp1_ejercicio3;

public class Atleta {

	private String nombre;
	private double tiempo;

	public Atleta(String nom, double tiempo) {
		setNombre(nom);
		setTiempo(tiempo);
	}

	private void setNombre(String nom) {
		this.nombre = nom;
	}

	private void setTiempo(double tiempo){
		this.tiempo=tiempo;
	}
	public String getNombre(){
		return this.nombre;
	}
	
	public double getTiempo(){
		return this.tiempo;
	}

	@Override
	public String toString() {
		return "Nombre : " + nombre + " - Tiempo : " + tiempo ;
	}
	
}
