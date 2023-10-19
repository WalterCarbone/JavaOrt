package tp1.tp4.ej2;

public class Alumno extends Persona {

	private int numeroLegajo;

	public Alumno(int dni, String nombreCompleto, int anioNacimiento)throws IllegalArgumentException {
			super(dni, nombreCompleto, anioNacimiento);
			if(!nombreCompleto.isEmpty()){
			this.setNumeroLegajo(dni);
		}else{
			throw new IllegalArgumentException("Erro");
		}
		
		
	}

	private void setNumeroLegajo(int numeroLegajo) {
		this.numeroLegajo = numeroLegajo;
	}

	public int getNumeroLegajo() {
		return numeroLegajo;
	}

	@Override
	public String toString() {
		return super.toString() + "Alumno [numeroLegajo=" + numeroLegajo + "]";
	}

}
