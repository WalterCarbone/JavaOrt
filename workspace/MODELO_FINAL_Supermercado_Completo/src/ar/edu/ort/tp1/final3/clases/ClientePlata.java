package ar.edu.ort.tp1.final3.clases;

public class ClientePlata extends Cliente {

	private static final double DESCUENTO = 0.20;
	private static final double COMPRA_MINIMA = 300;

	public ClientePlata(String nombre, int edad, double dinero) {
		super(nombre, edad, dinero);
	}

	@Override
	public double realizarDescuento(double precio) {
		if (precio >= COMPRA_MINIMA) {
			precio = precio - (precio * DESCUENTO);
		}
		return precio;
	}

	@Override
	public boolean tieneDescuento(double precio) {
		if (precio >= COMPRA_MINIMA) {
			return true;
		}
		return false;
	}

}
