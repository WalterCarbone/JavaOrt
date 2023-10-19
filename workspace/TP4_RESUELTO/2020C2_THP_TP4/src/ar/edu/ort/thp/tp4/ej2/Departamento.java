package ar.edu.ort.thp.tp4.ej2;

public class Departamento {
	private int numero;
	private String dni;
	private String nombre;
	private double deuda;

	/**
	 * Constructor de Departamento
	 * 
	 * @param numero
	 */
	public Departamento(int numero) {
		setNumero(numero);
		setDni("");
		setNombre("");
		actualizarDeuda(0);
	}

	/**
	 * Si la unidad esta vacia agrega los datos del nuevo ocupante.
	 * 
	 * @param dniTitular
	 *            Nro de documento del titular.
	 * @param nombreTitular
	 *            nombre del Titular.
	 * @return Un booleano que indica si se pudo habitar (debe estar previamente
	 *         vacio).
	 */
	public boolean habitar(String dniTitular, String nombreTitular) {
		boolean pudo = false;
		if (dni.isEmpty() && nombre.isEmpty()) {
			setDni(dniTitular);
			setNombre(nombreTitular);
			pudo = true;
		}
		return pudo;
	}

	/**
	 * LIbera la unidad vaciando los datos del ex vecino.
	 * @return un string con los datos del ex vecino concatenados.
	 */
	public String deshabitar() {
		String ex = dni + " - " + nombre;
		setDni("");
		setNombre("");
		return ex;
	}

	/**
	 * @param importe
	 *            El monto adeudado por el departamento. Si es negativo es saldo
	 *            a favor.
	 */
	public void actualizarDeuda(double importe) {
		this.deuda += importe;
	}

	public boolean esMoroso() {
		return deuda > 0;
	}

	/**
	 * @return El saldo del departamento
	 */
	public double getDeuda() {
		return deuda;
	}

	/**
	 * @return El dni del titular del departamento
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @return El nombre del titular del departamento
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @return El número de departamento
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param dni
	 *            El dni del titular del departamento
	 */
	private void setDni(String dni) {
		this.dni = dni;
	}

	/**
	 * @param nombre
	 *            El nombre del titular del departamento
	 */
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @param numero
	 *            El número de departamento
	 */
	private void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Departamento [numero=" + numero + ", dni=" + dni + ", nombre=" + nombre + ", saldo=" + deuda + "]";
	}

}
