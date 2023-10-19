package ar.edu.ort.modelo;

public class Cliente {

	private CategoriaIva categoriaIva;
	private String cuit;
	private String direccion;
	private String nombre;
	private int nroCliente;

	public Cliente(CategoriaIva categoriaIva, String cuit, String direccion, String nombre, int nroCliente) {
		super();
		this.categoriaIva = categoriaIva;
		this.cuit = cuit;
		this.direccion = direccion;
		this.nombre = nombre;
		this.nroCliente = nroCliente;
	}

	public CategoriaIva getCategoriaIva() {
		return categoriaIva;
	}
}
