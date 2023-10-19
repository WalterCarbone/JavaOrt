package Clases;

import java.util.ArrayList;

public class Droide {

	private String nombre;
	private ArrayList<Pieza> piezas;
	private ArrayList<Droide> rotos;
	private boolean sano;
	public Droide(String nombre, boolean sano) {
		super();
		this.nombre = nombre;
		this.sano=sano;
		piezas=new ArrayList<>();
		rotos=new ArrayList<>();
		this.rotos = rotos;
	}
	
	public void agregarPieza(Pieza p){
		piezas.add(p);
	}
	
	public void agregarRoto(Droide d){
		rotos.add(d);
	}

	public void listarRotos(){
		for (Droide droide : rotos) {
			System.out.println(droide);
		}
	}
	
	@Override
	public String toString() {
		return "Droide [nombre=" + nombre + ", sano=" + sano + "]";
	}
 	
}
