package ar.edu.ort.tp1.tp3Ej1;

public class SubContratado extends Empleado {
	private float cantHoras;
	private float precioHora;

	public SubContratado() {
		this.cantHoras = 0;
		this.precioHora = 0;
	}

	public SubContratado(String nombre, int edad, float cantHoras, float precioHora) {
		super(nombre, edad);
		this.cantHoras = cantHoras;
		this.precioHora = precioHora;
	}

	@Override
	public String toString() {
		return super.toString() + " SubContratado [cantHoras=" + cantHoras + ", precioHora=" + precioHora + "]";
	}

	public float calcularPago() {
		return precioHora * cantHoras;
	}
}
