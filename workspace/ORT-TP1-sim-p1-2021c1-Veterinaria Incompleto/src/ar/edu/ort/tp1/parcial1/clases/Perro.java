package ar.edu.ort.tp1.parcial1.clases;

public class Perro extends Mascota {
	private static final double MULT_ALIMENTACION = 0.05;
	private static final double PORC_DESC_PESO = -3;

	public Perro(String nombre, double peso, boolean vacunado, Estado estado) {
		super(nombre, peso, vacunado, estado);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void comer(double comida) {
		super.comer(comida, MULT_ALIMENTACION);
		
	}

	@Override
	public void defecar() {
		super.defecar(PORC_DESC_PESO);
		System.out.println("Ya fui al baño, recoge mis cosas");
		
	}

	// TODO COMPLETAR
}
