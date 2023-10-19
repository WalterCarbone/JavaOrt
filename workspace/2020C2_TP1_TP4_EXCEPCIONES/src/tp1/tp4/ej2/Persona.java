package tp1.tp4.ej2;

import java.time.Year;

import tp1.tp4.tj3.RangoDeEnteros;

public class Persona   {
	private final RangoDeEnteros RANGO_NRO_DOCUMENTO = new RangoDeEnteros(1000000, 99999999);
	protected static final int VALOR_AUN_VIVE = -9999;
	private String nombreCompleto;
	private int anioNacimiento;
	private int anioFallecimiento;
	private int anioActual;
	private int dni;

	public Persona (int dni, String nombreCompleto, int anioNacimiento)  {
		this.setNombreCompleto(nombreCompleto);
		this.setAnioNacimiento(anioNacimiento);
		this.setDni(dni);
		this.setAnioFallecimiento(VALOR_AUN_VIVE);
		this.setAnioActual();
	}

	public Persona(int dni, String nombreCompleto, int anioNacimiento, int anioFallecimiento) {
		this(dni, nombreCompleto, anioNacimiento);
		this.setAnioFallecimiento(anioFallecimiento);
	}

	private void setNombreCompleto(String nombreCompleto) throws IllegalArgumentException {
		if (nombreCompleto == null) {
			throw new IllegalArgumentException("Campo Requerido, no puede ser nulo");
		}
		this.nombreCompleto = nombreCompleto;
	}

	private void setDni(int dni) throws IllegalArgumentException {
		if (!RANGO_NRO_DOCUMENTO.incluye(dni)) {
			throw new IllegalArgumentException("dni fuera del rango valido");
		}
		this.dni = dni;
	}

	private void setAnioNacimiento(int anioNacimiento) {
		this.anioNacimiento = anioNacimiento;
	}

	private void setAnioFallecimiento(int anioFallecimiento) {
		this.anioFallecimiento = anioFallecimiento;
	}

	private void setAnioActual() {
		this.anioActual = Year.now().getValue();
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public int getAnioNacimiento() {
		return anioNacimiento;
	}

	public int getAnioFallecimiento() {
		return anioFallecimiento;
	}

	public int getDni() {
		return dni;
	}

	public boolean vive() {
		return anioFallecimiento == VALOR_AUN_VIVE;
	}

	@Override
	public String toString() {
		return "Persona [nombreCompleto=" + nombreCompleto + ", anioNacimiento=" + anioNacimiento
				+ ", anioFallecimiento=" + anioFallecimiento + ", anioActual=" + anioActual + "]";
	}

}
