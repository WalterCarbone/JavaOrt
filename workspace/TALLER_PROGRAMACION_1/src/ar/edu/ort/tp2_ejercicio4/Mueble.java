package ar.edu.ort.tp2_ejercicio4;

public class Mueble {

	private String nombre;
	private String material;
	private String color;
	
	public Mueble (String nombre, String material, String color){
		setNombre(nombre);
		setMaterial(material);
		setColor(color);
	}
	
	private void setNombre(String nombre){
		this.nombre=nombre;
	}
	private void setMaterial(String material){
		this.material=material;
	}
	private void setColor(String color){
		this.color=color;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	public String getMaterial(){
		return this.material;
	}
	public String getColor(){
		return this.color;
	}

	@Override
	public String toString() {
		return "\n"+ nombre + " de " + material + ", color " + color;
	}
	
	
}
