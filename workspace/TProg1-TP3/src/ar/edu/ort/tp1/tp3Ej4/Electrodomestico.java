package ar.edu.ort.tp1.tp3Ej4;

public abstract class Electrodomestico implements Imprimible {

	private String marca;
	private String modelo;
	private int numeroSerie;
	private int voltaje;
	private boolean encendido;
	private int precio;

	public Electrodomestico() {
		marca = "Sin definir";
		modelo = "Sin definir";
		numeroSerie = 0;
		voltaje = 220;
		encendido = false;
		precio = 0;
	}

	public Electrodomestico(String marca, String modelo, int numeroSerie, int voltaje, boolean encendido, int precio) {
		this.marca = marca;
		this.modelo = modelo;
		this.numeroSerie = numeroSerie;
		this.voltaje = voltaje;
		this.encendido = encendido;
		this.precio = precio;
	}

	@Override
	public String toString() {
		return marca + ", modelo " + modelo;
	}

	public abstract String getTipo();

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(int numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public int getVoltaje() {
		return voltaje;
	}

	public void setVoltaje(int voltaje) {
		this.voltaje = voltaje;
	}

	public void encender() {
		if (!encendido)
			encendido = true;
		else
			encendido = false;
	}

	public boolean estaEncendido() {
		return encendido;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
}