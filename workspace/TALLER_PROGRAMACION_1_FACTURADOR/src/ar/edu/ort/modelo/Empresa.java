package ar.edu.ort.modelo;

public class Empresa {

	private CategoriaIva categoriaIva;
	private String cuit;
	private String direccion;
	private String nombre;

	public Empresa(CategoriaIva categoriaIva, String cuit, String direccion, String nombre) {
		super();
		this.categoriaIva = categoriaIva;
		this.cuit = cuit;
		this.direccion = direccion;
		this.nombre = nombre;
	}

	public CategoriaIva getCategoriaIva() {
		return categoriaIva;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
