package ar.edu.ort.modelo;

public class Partido {

	private Equipo local;
	private Equipo visitante;
	private int golesLocal;
	private int golesVisitante;
	
	
	
	public Partido(Equipo local, Equipo visitante, int golesLocal, int golesVisitante) {
		super();
		setLocal(local);
		setVisitante(visitante);
		setGolesLocal(golesLocal);
		setGolesVisitante(golesVisitante);
	}



	@Override
	public String toString() {
		return  local + " " + visitante + " " + golesLocal
				+ " " + golesVisitante ;
	}



	private void setLocal(Equipo local) {
		this.local = local;
	}



	private void setVisitante(Equipo visitante) {
		this.visitante = visitante;
	}



	private void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}



	private void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
	}



	public Equipo getLocal() {
		return local;
	}



	public Equipo getVisitante() {
		return visitante;
	}



	public int getGolesLocal() {
		return golesLocal;
	}



	public int getGolesVisitante() {
		return golesVisitante;
	}
	
	
	
	
	
}
