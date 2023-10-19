package tp1_ejercicio1;

import java.util.ArrayList;

public class Grupo {

	private String nombre;
	private ArrayList<String> integrantes;

	public Grupo(String nombre) {

		setNombre(nombre);
		integrantes = new ArrayList<>();
	}

	public String getNombre() {

		return this.nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;

	}

	public int gertCantidadintegrantes() {
		return integrantes.size();
	}

	public void agregarIntegrante(String nombreIntegrante) {
		String aBuscar;
		aBuscar = buscarIntegrante(nombreIntegrante);
		if (aBuscar == null) {
			integrantes.add(nombreIntegrante);
			System.out.println("Alta OK");
		} else {
			System.out.println("Integrante existente");
		}

	}

	private String buscarIntegrante(String nombreIntegrante) {
		int i;
		String aBuscar;
		i = 0;
		aBuscar = null;
		while (i < integrantes.size() && !integrantes.get(i).equals(nombreIntegrante)) {
			i++;
		}
		if (i < integrantes.size()) {
			aBuscar = integrantes.get(i);
		}

		return aBuscar;
	}

	private int obtenerPosicionIntegrante(String nombreIntegrante) {
		int posicion;
		int i;
		i = 0;
		posicion = -1;

		while (i < integrantes.size() && !integrantes.get(i).equals(nombreIntegrante)) {
			i++;
		}
		if (i < integrantes.size()) {
			posicion = i;

		}

		return posicion;
	}

	public String obtenerIntegrante(int posicion) {
		String aBuscar;
		aBuscar = null;

		if (posicion >= 1 && posicion <= integrantes.size()) {
			aBuscar = integrantes.get(posicion - 1);
		}

		return aBuscar;
	}

	public String removerIntegrante(String nombreIntegrante) {
		String borrado;
		borrado = null;
		int posicion;
		posicion = obtenerPosicionIntegrante(nombreIntegrante);

		if (posicion != -1) {
			borrado = integrantes.remove(posicion);
		}

		return borrado;
	}
	
	private void mostrarIntegrantes(){
		System.out.println("La cantidad de integrantes es : " + integrantes.size());
		for(String miembro : integrantes){
			System.out.println(miembro + " - ");
		}
		
	}

	public void mostrar(){
		System.out.println("Nombre del grupo : " + this.getNombre() );
		mostrarIntegrantes();
	}
	
	public void vaciar(){
		integrantes.removeAll(integrantes);
	}
}
