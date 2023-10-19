package ar.edu.ort.tp1.final3.clases;

public class Compra {

	private static int cantidadCompras;
	private int id;
	private double precio;
	private boolean descuento;
	private Cliente cliente;

	public Compra(double precio, Cliente cliente, boolean descuento) {
		this.id = cantidadCompras;
		
		this.precio=precio;
		this.cliente=cliente;
		this.descuento=descuento;
		cantidadCompras = cantidadCompras + 1;
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", precio=" + precio + ", descuento=" + descuento + ", cliente=" + cliente.getNombre() + "]";
	}

private static int getCantidadCompras() {
		return cantidadCompras;
	}

	public int getId() {
		return id;
	}

	public double getPrecio() {
		return precio;
	}

	private boolean isDescuento() {
		return descuento;
	}

	private Cliente getCliente() {
		return cliente;
	}

	

	
}
