package ar.edu.ort.tp1.tp3Ej5;

import java.util.ArrayList;

public abstract class TorneoFutbol {
	private ArrayList<Jornada> jornadas;
	private ArrayList<Equipo> equipos;

	public TorneoFutbol() {
		jornadas = new ArrayList<Jornada>();
		equipos = new ArrayList<Equipo>();
	}

	public void agregarJornada(Jornada jornada) {
		jornadas.add(jornada);
	}

	public void eliminarJornada(Jornada jornada) {
		jornadas.remove(jornada);
	}

	public void agregarEquipo(Equipo equipo) {
		equipos.add(equipo);
	}

	public void eliminarEquipo(Equipo equipo) {
		equipos.remove(equipo);
	}

	public void finalizarJornada(Jornada jornada) {
		// valido si existe
		if (jornadas.contains(jornada)) {
			ArrayList<Partido> partidos = jornada.getPartidos();
			for (int i = 0; i < partidos.size(); i++) {
				calcularPuntos(partidos.get(i));
			}
		}
	}

	public void mostrarTabla() {
		System.out.println(getTipo());
		System.out.println("Tabla de posiciones al cabo de " + String.valueOf(jornadas.size()) + " fechas:");
		for (Equipo item : equipos) {
			System.out.println(item);
		}
	}

	public abstract String getTipo();

	public void calcularPuntos(Partido partido) {
		int puntosLocal = 0;
		int puntosVisitante = 0;
		int golesEquipoLocal = partido.getGolesEquipoLocal();
		int golesEquipoVisitante = partido.getGolesEquipoVisitante();

		if (golesEquipoLocal > golesEquipoVisitante)// Si gana el local
		{
			puntosLocal += puntajePartidoGanado();
			puntosVisitante += puntajePartidoPerdido();
			if (golesEquipoVisitante == 0)// Si no le convirtieron goles al local
				puntosLocal += puntajeVallaInvicta();
			if ((golesEquipoLocal - golesEquipoVisitante) > 4)// Si el local convirtio mas de 4 goles
				puntosLocal += puntajeGanador4Goles();
		} else {
			if (golesEquipoLocal == golesEquipoVisitante) {// Si empatan
				puntosLocal = puntajePartidoEmpatado();
				puntosVisitante = puntajePartidoEmpatado();
				if (golesEquipoLocal > 3) {// Si empatan por mas de 3 goles
					puntosLocal += puntajeEmpateMas3Goles();
					puntosVisitante += puntajeEmpateMas3Goles();
				}
			} else {// Si gana el visitante
				puntosVisitante += puntajePartidoGanado();
				puntosLocal += puntajePartidoPerdido();
				if (golesEquipoLocal == 0)// Si no le convirtieron goles al visitante
					puntosVisitante += puntajeVallaInvicta();
				if ((golesEquipoVisitante - golesEquipoLocal) > 4)
					// Si el visitante convirtio mas de 4 goles
					puntosVisitante += puntajeGanador4Goles();
			}
		}

		partido.getEquipoLocal().setPuntos(puntosLocal);
		partido.getEquipoVisitante().setPuntos(puntosVisitante);
	}

	public abstract int puntajePartidoGanado();

	public int puntajePartidoEmpatado() {
		return 1;
	}

	public abstract int puntajePartidoPerdido();

	public abstract int puntajeVallaInvicta();

	public abstract int puntajeGanador4Goles();

	public abstract int puntajeEmpateMas3Goles();

}