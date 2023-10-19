package ar.edu.ort.tp1.tp3Ej2;

import ar.edu.ort.tp1.tp3Ej1.SubContratado;

public class Vendedor extends SubContratado {
	private float porcentaje;

	public Vendedor() {
		porcentaje = 0.0f;
	}

	public Vendedor(String nombre, int edad, float cantHoras, float precioHora, float porcentaje) {
		super(nombre, edad, cantHoras, precioHora);
		this.porcentaje = porcentaje;
	}

	@Override
	public float calcularPago() {
		float pago = super.calcularPago() + super.calcularPago() * porcentaje / 100;
		return pago;
	}

}
