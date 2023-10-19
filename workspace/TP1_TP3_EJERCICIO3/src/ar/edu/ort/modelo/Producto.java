package ar.edu.ort.modelo;

public abstract class Producto implements Imprimible {
	private String marca;
	private String modelo;
	private int nroSerie;
	private int voltaje;
	private boolean encendido;
	private double precio;
	
	
	public Producto(String marca, String modelo, int nroSerie,int voltaje, double precio) {
		setMarca(marca);
		setModelo(modelo);
		setNroSerie(nroSerie);
		setVoltaje(voltaje);
		setEncendido(false);		
		setPrecio(precio);
	}


	private void setNroSerie(int nroSerie) {
		this.nroSerie = nroSerie;
	}


	private void setVoltaje(int voltaje) {
		this.voltaje = voltaje;
	}


	private void setEncendido(boolean encendido) {
		this.encendido = encendido;
	}


	private int getNroSerie() {
		return nroSerie;
	}


	private int getVoltaje() {
		return voltaje;
	}


	private boolean isEncendido() {
		return encendido;
	}


	protected void setMarca(String marca) {
		this.marca = marca;
	}


	protected void setModelo(String modelo) {
		this.modelo = modelo;
	}


	protected void setPrecio(double precio) {
		this.precio = precio;
	}


	public String getMarca() {
		return marca;
	}


	public String getModelo() {
		return modelo;
	}

	public double getPrecio() {
		return precio;
	}
	
	
	
	

}
