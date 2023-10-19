package Parcial2Objetos;

public class Pasajero {

	private int dni;
	private int telefono;

	public Pasajero(int dni, int telefono) {
		this.setDni(dni);
		this.setTelefono(telefono);
	}

	public int getDni() {
		return this.dni;
	}

	public int getTelefono() {
		return this.telefono;
	}

	private void setDni(int dni) {
		this.dni = dni;
	}

	private void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Pasajero Dni:" + dni + ". Telefono:" + telefono ;
	}

	
}
