package ar.edu.ort.tp1.tp3Ej4;

public class Televisor extends Electrodomestico {

	private int dimension;// En pulgadas
	private boolean esSmart;

	public Televisor() {
		dimension = 0;
		esSmart = false;
	}

	public Televisor(String marca, String modelo, int numeroSerie, int voltaje, boolean encendido, int precio,
			int dimension, boolean esSmart) {
		super(marca, modelo, numeroSerie, voltaje, encendido, precio);
		this.dimension = dimension;
		this.esSmart = esSmart;
	}

	@Override
	public String toString() {
		return "Televisor " + super.toString() + " dimension " + dimension + " pulgadas " + descripcionSmart() + ": $"
				+ getPrecio() + ".";
	}

	@Override
	public String getTipo() {
		return "Televisor";
	}

	public String descripcionSmart() {
		if (esSmart)
			return "smart";
		else
			return "sin smart";
	}

	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}

	public boolean isEsSmart() {
		return esSmart;
	}

	public void setEsSmart(boolean esSmart) {
		this.esSmart = esSmart;
	}

	public void imprimir() {
		System.out.println("Televisor " + descripcionSmart() + " " + getMarca() + " " + dimension + " pulgadas, modelo "
				+ getModelo() + ": $" + getPrecio() + ".");
	}
}