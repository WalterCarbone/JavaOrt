package ar.edu.ort.tp1.parcial1.clases;

public abstract class Mascota implements Animal {

	private static final String MSG_COM_FELIZ = " dice: He comido demasiado";
	private static final String MSG_COM_HAMBRIENTO = " dice: Muchas gracias tenía hambre";
	private static final String MSG_COM_ENFERMO = " dice: No tenía mucha hambre, pero gracias";

	private static final int CIEN = 100;


	// TODO Completar
	private final String nombre;
	private double peso;
	private boolean vacuna;
	private Estado estado;

	public Mascota(String nombre, double peso, boolean vacuna, Estado estado) {
		this.nombre = nombre;
		this.peso = peso;
		this.vacuna = vacuna;
		this.estado = estado;
	}

	// TODO Completar
	/**
	 * Alimenta a las mascotas de forma general. Si su estado es hambiento estará
	 * feliz y dara las gracias ya que tenía hambre Si su estado es feliz, se
	 * enfermará e indicará que comio demasiado. si estaba enfermo, dara las gracias, pero seguirá enfermo.
	 * además actualizará el peso sumando al actual la multiplicación entre la cantidad de comida recibida y un multiplicador.
	 * Finalmente indicará su estado
	 * 
	 * @param comida
	 * @param multiplicador
	 */
	protected void comer(double comida, double multiplicador) {
		Estado estado = this.estado;

		if (this.estado == Estado.HAMBRIENTO) {
			System.out.println(this.getNombre() + MSG_COM_HAMBRIENTO);
			estado = Estado.FELIZ;
		} else if (this.estado == Estado.FELIZ) {
			System.out.println(this.getNombre() + MSG_COM_FELIZ);
			estado = Estado.ENFERMO;
		} else if (this.estado == Estado.ENFERMO) {
			System.out.println(this.getNombre() + MSG_COM_ENFERMO);
		}

		this.setEstado(estado);
		this.peso += comida * multiplicador;
		System.out.println("El estado de " + this.getNombre() + " es: " + this.getEstado().getDescripcion());

	}

	public String getNombre() {
		return nombre;
	}

	public void actualizarPeso(double porcentaje) {
		this.peso += peso * porcentaje / CIEN;
	}

	public boolean estaVacunado() {
		return vacuna;
	}

	private Estado getEstado() {
		return estado;
	}

	private void setEstado(Estado estado) {
		this.estado = estado;
	}

	public void vacunar() {
		vacuna = true;
	}
}
