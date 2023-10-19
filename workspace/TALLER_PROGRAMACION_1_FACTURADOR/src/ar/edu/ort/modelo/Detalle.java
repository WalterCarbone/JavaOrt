package ar.edu.ort.modelo;

public class Detalle {
	
	private int cantidad;
	private Producto producto;
	
	public Detalle(int cantidad, Producto producto) {
		super();
		this.cantidad = cantidad;
		this.producto = producto;
	}
	
	public double devolverTotal(){
		return producto.getPrecioVenta()*cantidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public Producto getProducto() {
		return producto;
	}
	

}
