package ar.edu.ort.tp1.final3.clases;

public class Compra {

	private static int cantidadCompras;
	private int id;
	private double precio;
	private Cliente cliente;
	private Boolean descuento;

	public Compra(double precio, Cliente cliente, boolean descuento) {
		this.id = cantidadCompras;
		this.precio = precio;
		this.cliente = cliente;
		this.descuento = descuento;
		cantidadCompras = cantidadCompras + 1;
	}

	public int getId() {
		return id;
	}

	public double getPrecio() {
		return precio;
	}

	public void mostrarTicket() {
		System.out.println("Compra [id=" + id + ", precio=" + precio + ", cliente=" + cliente.getNombre()
				+ ", descuento=" + descuento + "]");
	}

}
