package ar.edu.ort.thp.tp4.ej1;

public class Persona {
	private String dni;
	private String apellido;
	private String nombre;
	private String domicilio;

	/**
	 * Constructor parametrizado
	 * 
	 * @param dni
	 * @param apellido
	 * @param domicilio
	 * @param nombre
	 */
	public Persona(String dni, String apellido, String nombre, String domicilio) {
		setDni(dni);
		setNombre(nombre);
		setApellido(apellido);
		setDomicilio(domicilio);
	}

	/**
	 * @return El apellido de la Persona.
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @return El dni de la Persona.
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @return El domicilio de la Persona.
	 */
	public String getDomicilio() {
		return domicilio;
	}

	/**
	 * @return El nombre de la Persona.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param apellido El apellido de la Persona.
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @param dni El dni de la Persona.
	 */
	private void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @param domicilio El domicilio de la Persona.
	 */
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	/**
	 * @param nombre El nombre de la Persona.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", domicilio=" + domicilio
				+ "]";
	}

}