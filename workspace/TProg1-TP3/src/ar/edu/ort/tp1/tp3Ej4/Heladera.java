package ar.edu.ort.tp1.tp3Ej4;

public class Heladera extends Electrodomestico {

	private int capacidad;// Capacidad en litros
	private boolean esNoFrost;

	public Heladera() {
		capacidad = 0;
		esNoFrost = false;
	}

	public Heladera(String marca, String modelo, int numeroSerie, int voltaje, boolean encendido, int precio,
			int capacidad, boolean esNoFrost) {
		super(marca, modelo, numeroSerie, voltaje, encendido, precio);
		this.capacidad = capacidad;
		this.esNoFrost = esNoFrost;
	}

	@Override
	public String toString() {
		return "Heladera " + super.toString() + " capacidad " + capacidad + " litros " + descripcionNoFrost() + ": $"
				+ getPrecio() + ".";
	}

	public void imprimir() {
		System.out.println("Heladera " + getMarca() + ", modelo " + getModelo() + ", " + descripcionNoFrost()
				+ ", capacidad " + capacidad + " litros: $" + getPrecio() + ".");
	}

	@Override
	public String getTipo() {
		return "Heladera";
	}

	public String descripcionNoFrost() {
		if (esNoFrost)
			return "no frost";
		else
			return "sin no frost";
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public boolean EsNoFrost() {
		return esNoFrost;
	}

	public void setEsNoFrost(boolean esNoFrost) {
		this.esNoFrost = esNoFrost;
	}
}