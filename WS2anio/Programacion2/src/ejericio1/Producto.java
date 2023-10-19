package ejericio1;

public class Producto {

	private int codigo;
	private String descripcion;
	private double precioUnitario;
	
	public Producto(int codigo, String descripcion, double precioUnitario) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	private void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	private void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	private void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	
	
	
}
