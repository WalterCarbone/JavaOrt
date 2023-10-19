package ejericio1;

public class Item {

	
	private Producto producto;
	private int cantidad;
	
	public Item(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	private void setProducto(Producto producto) {
		this.producto = producto;
	}

	private void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
