package ar.edu.ort.tp1.tp3Ej5;

public class TorneoFutbol5 extends TorneoFutbol {

	public TorneoFutbol5() {
	}

	@Override
	public String getTipo() {
		return "Torneo de futbol 5";
	}

	@Override
	public int puntajePartidoGanado() {
		return 2;
	}

	@Override
	public int puntajePartidoPerdido() {
		return 0;
	}

	@Override
	public int puntajeVallaInvicta() {
		return 0;
	}

	@Override
	public int puntajeGanador4Goles() {
		return 1;
	}

	@Override
	public int puntajeEmpateMas3Goles() {
		return 2;
	}
}