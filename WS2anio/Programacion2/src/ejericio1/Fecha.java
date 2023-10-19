package ejericio1;

public class Fecha {

	
	private int dia;
	private int mes;
	private int anio;
	public Fecha(int dia, int mes, int anio) {
		super();
		this.dia = dia;
		this.mes = mes;
		this.anio = anio;
	}
	private void setDia(int dia) {
		this.dia = dia;
	}
	private void setMes(int mes) {
		this.mes = mes;
	}
	private void setAnio(int anio) {
		this.anio = anio;
	}
	public int getDia() {
		return dia;
	}
	public int getMes() {
		return mes;
	}
	public int getAnio() {
		return anio;
	}
	
	
	
}
