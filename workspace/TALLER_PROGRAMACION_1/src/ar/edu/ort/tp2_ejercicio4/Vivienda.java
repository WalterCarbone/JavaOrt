package ar.edu.ort.tp2_ejercicio4;

import java.util.ArrayList;

public class Vivienda {

	private int numero;
	private Direccion direccion;
	private ArrayList<Persona> personas;
	private ArrayList<Mueble> muebles;
	
	
	public Vivienda (int numero,String calle,int altura,int piso,String depto){
		setNumero(numero);
		direccion = new Direccion (calle,altura,piso,depto);
		personas = new ArrayList<>();
		muebles = new ArrayList<>();
	}
	
	
	private void setNumero(int numero){
		this.numero=numero;
	}
	
	public int getNumero(){
		return this.numero;
	}
	
	public void agregarPersona (String nombre,String apellido,int edad){
		personas.add(new Persona(nombre,apellido,edad));
	}
	
		
	public void agregarMueble (String nombre,String material,String color){
		muebles.add(new Mueble(nombre,material,color));
	}


	@Override
	public String toString() {
		return "Vivienda " + numero + "\nDirección: " + direccion + "\nPersonas: " + personas + "\nMuebles:"
				+ muebles;
	}
	
	
	
}
