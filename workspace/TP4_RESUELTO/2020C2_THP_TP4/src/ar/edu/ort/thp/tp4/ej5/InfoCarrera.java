package ar.edu.ort.thp.tp4.ej5;

public class InfoCarrera {

	private String fecha;
	private int cantidad_pilotos;
	
	/**
	 * Constructor de InfoCarrera
	 * @param fecha
	 * @param cantidad_pilotos
	 */
	public InfoCarrera(String fecha, int cantidad_pilotos) {
		setFecha(fecha);
		setCantidadPilotos(cantidad_pilotos);
	}
	
	/**
	 * setter de fecha
	 * @param fecha
	 */
	private void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * getter de fecha
	 * @return
	 */
	public String getFecha() {
		return fecha;
	}
	
	/**
	 * setter de cantidad_pilotos
	 * @param fecha
	 */
	private void setCantidadPilotos(int cantidad_pilotos) {
		this.cantidad_pilotos = cantidad_pilotos;
	}

	/**
	 * getter de fecha
	 * @return
	 */
	public int getCantidadPilotos() {
		return cantidad_pilotos;
	}

	@Override
	public String toString() {
		return "InfoCarrera [fecha=" + fecha + ", cantidad_pilotos=" + cantidad_pilotos + "]";
	}
	
	
}
