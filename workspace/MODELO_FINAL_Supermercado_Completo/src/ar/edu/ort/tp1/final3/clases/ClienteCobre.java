package ar.edu.ort.tp1.final3.clases;

public class ClienteCobre extends Cliente {

	// Pueden ir como final, como atributo o hardcodeado
	private static final double DESCUENTO = 0.10;
	private static final double COMPRA_MINIMA = 200;

	public ClienteCobre(String nombre, int edad, double dinero) {
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
