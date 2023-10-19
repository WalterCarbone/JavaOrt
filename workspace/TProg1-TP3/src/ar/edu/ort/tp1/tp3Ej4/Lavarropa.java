package ar.edu.ort.tp1.tp3Ej4;

public class Lavarropa extends Electrodomestico {

	private int cargaMaxima;
	private boolean esAutomatico;

	public Lavarropa() {
		cargaMaxima = 0;
		esAutomatico = false;
	}

	public Lavarropa(String marca, String modelo, int numeroSerie, int voltaje, boolean encendido, int precio,
			int cargaMaxima, boolean esAutomatico) {
		super(marca, modelo, numeroSerie, voltaje, encendido, precio);
		this.cargaMaxima = cargaMaxima;
		this.esAutomatico = esAutomatico;
	}

	@Override
	public String toString() {
		return "Lavarropa " + super.toString() + " carga maxima " + cargaMaxima + " kgs " + descripcionAutomatico()
				+ ": $" + getPrecio() + ".";
	}

	@Override
	public String getTipo() {
		return "Lavarropa";
	}

	public String descripcionAutomatico() {
		if (esAutomatico)
			return "automatico";
		else
			return "semi automático";
	}

	public int getCargaMaxima() {
		return cargaMaxima;
	}

	public void setCargaMaxima(int cargaMaxima) {
		this.cargaMaxima = cargaMaxima;
	}

	public boolean isEsAutomatico() {
		return esAutomatico;
	}

	public void setEsAutomatico(boolean esAutomatico) {
		this.esAutomatico = esAutomatico;
	}

	public void imprimir() {
		System.out.println("Lavarropas " + getMarca() + " " + descripcionAutomatico() + ", carga máxima " + cargaMaxima
				+ "kg, modelo " + getModelo() + ": $" + getPrecio() + ".");
	}

}