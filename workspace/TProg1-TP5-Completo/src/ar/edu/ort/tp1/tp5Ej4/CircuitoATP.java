package ar.edu.ort.tp1.tp5Ej4;

import java.util.ArrayList;

public class CircuitoATP {

	private String[] jugadores;
	private String[] torneos;
	private int[][] resultados;

	public CircuitoATP() {
		this.cargarData();
	}
	public void cargarData() {
		this.jugadores = new String[] { "Pella", "Del Potro", "Schwartzman", "Mayer", "Delbonis" };
		this.torneos = new String[] { "Australia", "USOpen", "RolandGarros", "Wimbledon","Shangai"};
		this.resultados = new int[][] {	{1,3,4,1,3},
										{3,2,3,4,1},
										{2,1,5,5,2},
										{4,5,1,2,5},
										{5,4,2,3,4}};
		
				
	}
	public ArrayList<Jugador> procesarInfo() {
		ArrayList<Jugador> Jugadores = new ArrayList<>();
		String c;
		Jugador p = null;
		for (int i = 0; i < resultados.length; i++) {
			c = jugadores[i];
			p = new Jugador(c);
			for (int j = 0; j < resultados[i].length; j++) {
				p.procesarResultado(resultados[i][j]);
			}
			Jugadores.add(p);
		}
		return Jugadores;
	}
	public String procesarTorneosJugador(String Jugador) {
		String competencias = "";
		int posJugador = buscoJugador(Jugador);
		
		if (posJugador > -1) {
			for (int j = 0; j < resultados[posJugador].length; j++)
				competencias += torneos[j] + ":" + resultados[posJugador][j] + "  ";
		}
		return competencias;
	}
	public String obtenerResultadoJugador(String jugador, String torneo) {
		int posJugador = buscoJugador(jugador);
		int posTorneo = buscoTorneo(torneo);
		String salida = "";
		if (posJugador > -1 && posTorneo > -1) {
			salida = "Resultado de "+jugador+" en "+torneos[posTorneo] + ":"+resultados[posJugador][posTorneo] + "  ";
		}
		return salida;
	}
	private int buscoJugador(String Jugador) {
		int posJugador = -1;
		int i = 0;
		
		while (i < jugadores.length && posJugador == -1){
			if (jugadores[i].equals(Jugador))
				posJugador = i;
			else
				i++;
		}
		return posJugador;
	}
	private int buscoTorneo(String torneo) {
		int posTorneo = -1;
		int i = 0;
		while (i < torneos.length && posTorneo == -1) {
			if (torneos[i].equals(torneo))
				posTorneo = i;
			else
				i++;
		}
		return posTorneo;
	}
	public int procesarPeorPosTorneoJugador(String jugador) {
		int posJugador = 0;
		int peor=-999;
		posJugador = buscoJugador(jugador);
		if (posJugador > -1) {
			for (int j = 0; j < resultados[posJugador].length; j++)
				if(resultados[posJugador][j]>peor)peor=resultados[posJugador][j];
		}
		return peor;
	}
}
