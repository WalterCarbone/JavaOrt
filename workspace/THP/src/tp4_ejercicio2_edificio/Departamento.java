package tp4_ejercicio2_edificio;

public class Departamento {
	private int unidad;
	private String dni;
	private String propietario;
	private int deuda;
	private String estado;

	public Departamento(int unidad, String dni, String propietario, int deuda, String estado, int cant) {
		setUnidad(unidad, cant);
		setDni(dni);
		setPropietario(propietario);
		setEstado(estado);

	}




	@Override
	public String toString() {
		return "Unidad nro:" + unidad + " .Propietario:" + propietario + " .DNI:" + dni + " .Deuda:" + deuda
				+ " .Estado=" + estado;
	}

	public String getPropietario() {
		return this.propietario;
	}

	public String getDni() {
		return this.dni;
	}

	public int getUnidad() {
		return this.unidad;
	}

	public int getDeuda() {
		return this.deuda;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setDeuda(int deuda) {
		this.deuda = deuda;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setUnidad(int unidad, int cantidad) {
		this.unidad = unidad;
		/*
		 * if (unidad < cantidad) { this.unidad = unidad; } else {
		 * System.out.println(Resultados.UNIDAD_MAYOR.getMsj()); }
		 */
	}

}
