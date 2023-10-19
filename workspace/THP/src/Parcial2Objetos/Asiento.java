package Parcial2Objetos;

public class Asiento {
	private Pasajero pasajero;
	private Clase clase;
	double precio;
	private String fila;
	private int numero;
	private static final double PRECIO_PRIMERA = 150000;
	private static final double PRECIO_BUSINESS = 100000;
	private static final double PRECIO_TURISTA = 50000;

	public Asiento(int dni, int telefono, Clase clase, String fila, int numero) {
		pasajero = new Pasajero(dni, telefono);
		this.setClase(clase);
		setPrecioSegunClase(clase);
		this.setFila(fila);
		this.setNumero(numero);
	}

	public Clase getClase() {
		return this.clase;
	}

	public double getPrecio() {
		return this.precio;
	}

	public String getFila() {
		return this.fila;
	}

	public int getNumero() {
		return this.numero;
	}

	private void setClase(Clase clase) {
		this.clase = clase;
	}

	private void setFila(String fila) {
		this.fila = fila;
	}

	private void setNumero(int numero) {
		this.numero = numero;
	}

	private void setPrecioSegunClase(Clase clase) {

		switch (clase) {
		case PRIMERA:
			this.precio = PRECIO_PRIMERA;
			break;
		case BUSINESS:
			this.precio = PRECIO_BUSINESS;
			break;
		case TURISTA:
			this.precio = PRECIO_TURISTA;
		}

	}

	@Override
	public String toString() {
		return "Asiento del pasajero:" + pasajero + ". Clase:" + clase + ". Precio:" + precio + ". Fila:" + fila
				+ ". Numero=" + numero ;
	}

	
	
}
