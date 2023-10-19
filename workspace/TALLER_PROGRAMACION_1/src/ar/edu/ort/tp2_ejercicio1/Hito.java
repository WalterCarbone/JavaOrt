package ar.edu.ort.tp2_ejercicio1;

import java.util.ArrayList;

public class Hito {

	private String fecha;
	private String descripcion;
	ArrayList<Persona> involucrados;
	
	public Hito (String fecha, String descripcion){
		setFecha(fecha);
		setDescripcion(descripcion);
		involucrados = new ArrayList<>();
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
public void agregarInvolucrados (Persona p){
		involucrados.add(p);
}

@Override
public String toString() {
	return "Hito : " + descripcion + ", fecha:" + fecha + ", involucrados=" + involucrados;
}
	
	
}
