package ar.edu.ort.tp1.tp3Ejercicio05.incompleto;

public class Partido {

	private Equipo 	equipoLocal;
	private Equipo 	equipoVisitante;
	private int 	golesEquipoLocal;
	private int		golesEquipoVisitante;
	
	public Partido() {
		equipoLocal				= null;
		equipoVisitante 		= null;
		golesEquipoLocal		= 0;
		golesEquipoVisitante	= 0;
	}

	public Partido(Equipo equipoLocal, Equipo equipoVisitante, int golesEquipoLocal, int golesEquipoVisitante) {
		this.equipoLocal 			= equipoLocal;
		this.equipoVisitante 		= equipoVisitante;
		this.golesEquipoLocal 		= golesEquipoLocal;
		this.golesEquipoVisitante 	= golesEquipoVisitante;
	}

	public Equipo getEquipoLocal() {
		return equipoLocal;
	}

	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}

	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}

	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}

	public int getGolesEquipoLocal() {
		return golesEquipoLocal;
	}

	public void setGolesEquipoLocal(int golesEquipoLocal) {
		this.golesEquipoLocal = golesEquipoLocal;
	}

	public int getGolesEquipoVisitante() {
		return golesEquipoVisitante;
	}

	public void setGolesEquipoVisitante(int golesEquipoVisitante) {
		this.golesEquipoVisitante = golesEquipoVisitante;
	}

}