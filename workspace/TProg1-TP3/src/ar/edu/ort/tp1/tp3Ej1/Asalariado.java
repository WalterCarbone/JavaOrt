package ar.edu.ort.tp1.tp3Ej1;

public class Asalariado extends Empleado {
	private float sueldo;

	public Asalariado() {
		this.sueldo = 0;
	}

	public Asalariado(String nombre, int edad, float sueldo) {
		super(nombre, edad);
		this.sueldo = sueldo;
	}

	@Override
	public String toString() {
		return super.toString() + "Asalariado [sueldo=" + sueldo + "]";
	}

	public float calcularPago() {
		return sueldo;
	}
}
