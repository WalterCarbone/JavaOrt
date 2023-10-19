package ar.edu.ort.modelo;

public class Televisor extends Producto {

	private int dimension;
	private String esSmart;
		
	public Televisor(String marca, String modelo, int nroSerie, int voltaje,int dimension, String esSmart,double precio) {
		super(marca, modelo, nroSerie, voltaje, precio);
		setDimension(dimension);
		setEsSmart(esSmart);
		
	}

	
	
	private void setDimension(int dimension) {
		this.dimension = dimension;
	}



	private void setEsSmart(String esSmart) {
		this.esSmart = esSmart;
	}



	@Override
	public String toString() {
		return  "Televisor" + " Marca: " + getMarca() + " Modelo: " + getModelo();
	}

	

	@Override
	public void imprimir() {
		System.out.println("Televisor " + getMarca() + " Modelo: " + getModelo() + dimension+" pulgadas " + " SmartTv: "+ esSmart+" Precio $"+getPrecio());
		
	}

}
