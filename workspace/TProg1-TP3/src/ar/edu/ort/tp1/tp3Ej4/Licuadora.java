package ar.edu.ort.tp1.tp3Ej4;

public class Licuadora extends Electrodomestico {

	private int potencia;// En watts
	private int cantidadVelocidades;

	public Licuadora() {
		potencia = 0;
		cantidadVelocidades = 3;
	}

	public Licuadora(String marca, String modelo, int numeroSerie, int voltaje, boolean encendido, int precio,
			int potencia, int cantidadVelocidades) {
		super(marca, modelo, numeroSerie, voltaje, encendido, precio);
		this.potencia = potencia;
		this.cantidadVelocidades = cantidadVelocidades;
	}

	@Override
	public String toString() {
		return "Licuadora " + super.toString() + " potencia " + potencia + " watts " + cantidadVelocidades
				+ " velocidades" + ": $" + getPrecio() + ".";
	}

	@Override
	public String getTipo() {
		return "Licuadora";
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public int getCantidadVelocidades() {
		return cantidadVelocidades;
	}

	public void setCantidadVelocidades(int cantidadVelocidades) {
		this.cantidadVelocidades = cantidadVelocidades;
	}

	public void imprimir() {
		System.out.println("Licuadora " + getMarca() + ", potencia " + potencia + " watts " + cantidadVelocidades
				+ " velocidades" + ": $" + getPrecio() + ".");
	}
}