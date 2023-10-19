package ar.edu.ort.tp1.tp6Ej2.clases;

public class NaipeNumerado implements Naipe {

	@Override
	public String toString() {
		return numero + " de " + palo ;
	}

	private int numero;
	private Palo palo;

	public NaipeNumerado(int numero, Palo palo) {
		this.setNumero(numero);
		this.setPalo(palo);
	}

	@Override
	public String getDescripcion() {
		return String.format("[%s de %s]", numero, palo);
	}

	public int getNumero() {
		return numero;
	}

	public Palo getPalo() {
		return palo;
	}

	private void setNumero(int numero) {
		this.numero = numero;
	}

	private void setPalo(Palo palo) {
		this.palo = palo;
	}

}