package ar.edu.ort.tp1.final3.clases;

public class ClienteOro extends Cliente {

	private static final double DESCUENTO = 0.50;

	public ClienteOro(String nombre, int edad, double dinero) {
		super(nombre, edad, dinero);
	}

	@Override
	public double realizarDescuento(double precio) {
		return precio - (precio * DESCUENTO);
	}

	@Override
	public boolean tieneDescuento(double precio) {
		return true;
	}

}
