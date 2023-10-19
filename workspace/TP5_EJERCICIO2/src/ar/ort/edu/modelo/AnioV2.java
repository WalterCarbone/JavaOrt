package ar.ort.edu.modelo;

public class AnioV2 {

	private int[] dias;
	private int[] acum;

	public AnioV2() {
		super();
		this.dias = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		this.acum = new int[dias.length];
		setAcum();
	}

	private void setAcum() {
		for (int j = 1; j < acum.length; j++) {
			acum[j] = dias[j - 1] + acum[j - 1];
		}
	}

	public String getNombreDelMes(int mes) {
		
		
		
			return Meses.values()[mes-1].name();
}
}