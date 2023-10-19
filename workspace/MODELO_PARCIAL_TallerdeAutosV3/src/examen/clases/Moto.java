package examen.clases;

public class Moto extends Vehiculo {
	private static final int CILINDRADA_MINIMA = 125;
	private int cilindrada;
	private boolean limitador;

	public Moto(String patente, String marca, int cilindrada, boolean limitador) {
		super(patente, marca);
		this.limitador=limitador;
		setCilindrada(cilindrada);
	}

	public boolean tieneLimitador() {
		return limitador;
	}

	@Override
	public boolean autoDiagnostico() {
		return limitador;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) throws IllegalArgumentException {
		if(cilindrada>0){
		this.cilindrada = cilindrada;
		}else{
			throw new IllegalArgumentException("Cilindrada inválida");
		}
	}

}