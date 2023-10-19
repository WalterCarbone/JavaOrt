package ar.edu.ort.modelo;

public class Heladera extends Producto  {

	private int capacidad;
	private String esNoFrost;
	
	public Heladera(String marca, String modelo, int nroSerie, int voltaje,int capacidad, String esNoFrost,double precio) {
		super(marca, modelo, nroSerie, voltaje, precio);
		setCapacidad(capacidad);
		setEsNoFrost(esNoFrost);
		
	}


	
	private int getCapacidad() {
		return capacidad;
	}



	private void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}



	private String getEsNoFrost() {
		return esNoFrost;
	}



	private void setEsNoFrost(String esNoFrost) {
		this.esNoFrost = esNoFrost;
	}



	@Override
	public String toString() {
		return "Heladera " +  " Marca: " + getMarca() + " Modelo: " + getModelo() ;
	}

	@Override
	public void imprimir() {
		System.out.println("Heladera " + getMarca() + " Modelo: " + getModelo() + " NoFrost " + esNoFrost+" Capacidad: "+ capacidad+" litros "+" Precio $"+getPrecio());
		
	}

	

	
	
}

