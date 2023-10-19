package ar.edu.ort.thp.tp4.ej5;

public class Vuelta {

	private int tiempo;

	/**
	 * Constructor de Vuelta
	 * 
	 * @param tiempo
	 */
	public Vuelta(int tiempo) {
		setTiempo(tiempo);
	}

	/**
	 * setter de tiempo
	 * 
	 * @param tiempo
	 */
	private void setTiempo(int tiempo) {
		this.tiempo = tiempo;
	}

	/**
	 * getter de tiempo
	 * 
	 * @return
	 */
	public int getTiempo() {
		return tiempo;
	}

	@Override
	public String toString() {
		return "Vuelta [tiempo=" + tiempo + "]";
	}

}
