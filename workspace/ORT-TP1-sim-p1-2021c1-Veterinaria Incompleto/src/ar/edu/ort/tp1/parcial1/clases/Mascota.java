package ar.edu.ort.tp1.parcial1.clases;

public abstract class Mascota implements Animal {

	private static final String MSG_COM_FELIZ = " dice: He comido demasiado";
	private static final String MSG_COM_HAMBRIENTO = " dice: Muchas gracias tenía hambre";
	private static final String MSG_COM_ENFERMO = " dice: No tenía mucha hambre, pero gracias";

	private static final int CIEN = 100;
	private String nombre;
	private double peso;
	private boolean vacunado;
	private Estado estado;

	public Mascota(String nombre, double peso, boolean vacunado, Estado estado) {
		setNombre(nombre);
		setPeso(peso);
		setVacunado(vacunado);
		setEstado(estado);
	}

	// TODO Completar

	// TODO Completar
	/**
	 * Alimenta a las mascotas de forma general. Si su estado es hambiento
	 * estará feliz y dara las gracias ya que tenía hambre Si su estado es
	 * feliz, se enfermará e indicará que comio demasiado. si estaba enfermo,
	 * dara las gracias, pero seguirá enfermo. además actualizará el peso
	 * sumando al actual la multiplicación entre la cantidad de comida recibida
	 * y un multiplicador. Finalmente indicará su estado
	 * 
	 * @param comida
	 * @param multiplicador
	 */
	protected void comer(double comida, double multiplicador) {
		Estado est = this.estado;
		if (est == Estado.HAMBRIENTO) {
			System.out.println(this.nombre + MSG_COM_HAMBRIENTO);
			this.estado = Estado.FELIZ;
		} else if (est == Estado.FELIZ) {
			System.out.println(this.nombre + MSG_COM_FELIZ);
			this.estado = Estado.ENFERMO;
		} else {
			System.out.println(this.nombre + MSG_COM_ENFERMO);

		}
		System.out.println("El estado de " + this.getNombre() +" es: " +this.estado.getDescripcion());

	}
	
	protected void defecar(double valor){
	
		actualizarPeso(valor);
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPeso() {
		return peso;
	}

	private void setPeso(double peso) {
		this.peso = peso;
	}

	public boolean getVacunado() {
		return vacunado;
	}

	private void setVacunado(boolean vacunado) {
		this.vacunado = vacunado;
	}

	public Estado getEstado() {
		return estado;
	}

	private void setEstado(Estado estado) {
		this.estado = estado;
	}

	public void actualizarPeso(double porcentaje) {
		this.peso += peso * porcentaje / CIEN;
	}
	
	public void vacunar(){
		this.vacunado=true;
	}

	@Override
	public String toString() {
		return "Mascota [nombre=" + nombre + ", peso=" + peso + ", vacunado=" + vacunado + ", estado=" + estado + "]";
	}

}
