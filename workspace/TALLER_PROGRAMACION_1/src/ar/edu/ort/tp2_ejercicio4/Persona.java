package ar.edu.ort.tp2_ejercicio4;

public class Persona {

	private String nombre;
	private String apellido;
	private int edad;
	
	
	public Persona (String nom,String ape, int edad){
		setNombre(nom);
		setApellido(ape);
		setEdad(edad);
	}
	
	
	private void setNombre(String nom){
		this.nombre=nom;
	}
	
	private void setApellido(String ape){
		this.apellido=ape;
	}
	
	private void setEdad(int edad){
		this.edad=edad;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public String getApellido(){
		return this.apellido;
	}
	
	public int getEdad(){
		return this.edad;
	}


	@Override
	public String toString() {
		return "\n"+nombre + " " + apellido + ", edad : " + edad + " años";
	}
	
	
}
