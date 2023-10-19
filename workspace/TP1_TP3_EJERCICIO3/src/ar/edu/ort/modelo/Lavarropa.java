package ar.edu.ort.modelo;

public class Lavarropa extends Producto {

	private int cargaMax;
	private String esAutomatico;

	public Lavarropa(String marca, String modelo, int nroSerie, int voltaje, int cargaMax, String esAutom,double precio) {
		super(marca, modelo, nroSerie, voltaje, precio);
		
		setCargaMax(cargaMax);
		setEsAutomatico(esAutom);
		

	}

	
	private void setCargaMax(int cargaMax) {
		this.cargaMax = cargaMax;
	}


	private void setEsAutomatico(String esAutomatico) {
		this.esAutomatico = esAutomatico;
	}


	private int getCargaMax() {
		return cargaMax;
	}

	private String getEsAutomatico() {
		return esAutomatico;
	}

	@Override
	public String toString() {
		return "Lavarropa :" + " Marca: " + getMarca() + " Modelo: " + getModelo() ;
	}


	@Override
	public void imprimir() {
	System.out.println("Lavarropa " + getMarca() + " Modelo: " + getModelo() + " Automático " + esAutomatico +" Carga máxima: "+ cargaMax+" Kg "+" Precio $"+getPrecio());
	}

}
