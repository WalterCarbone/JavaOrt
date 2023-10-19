package ar.edu.ort.modelo;

public class Producto {

	private int codigo;
	private String nombre;
	private double precioUnitario;
	private double precioVenta;

	public Producto(int codigo, String nombre, double precioUnitario, double precioVenta) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precioUnitario = precioUnitario;
		this.precioVenta = precioVenta;
	}

	
	public double getPrecioVenta(){
		return this.precioVenta;
	}


	public String getNombre() {
		return nombre;
	}



	
	
}
