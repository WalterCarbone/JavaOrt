package tp5EJ4;

import java.util.ArrayList;

public class CircuitoATP {
	private String[] jugadores;
	private String[] torneos;
	private int[][] resultados;

	public CircuitoATP() {
		this.cargarData();
	}
	public void cargarData() {
		this.jugadores = new String []{"Pella", "Del Potro", "Schwartzman", "Mayer" ,"Delbonis"};
		this.torneos = new String[] { "Australia", "USOpen", "RolandGarros", "Wimbledon","Shangai"};
		this.resultados = new int[][] {	{1,3,4,1,3},
										{3,2,3,4,1},
										{2,1,5,5,2},
										{4,5,1,2,5},
										{5,4,2,3,4}};
		
				
	}
	public ArrayList<Jugador> procesarInfo() {
		ArrayList<Jugador> Jugadors = new ArrayList<>();
		for (int i = 0; i < jugadores.length; i++) {
			Jugadors.add(new Jugador(jugadores[i]));
			for (int j = 0; j < resultados[i].length; j++) {
				Jugadors.get(i).procesarResultado(resultados[i][j]);
			}
		}
		return Jugadors;
	}
	public String procesarTorneosJugador(String Jugador) {
		String competencias = "";
		int pos = buscoJugador(Jugador);
		if(pos!=-1){
			competencias=jugadores[pos]+" ";
			for (int i = 0; i < resultados[pos].length; i++) {
				competencias+=torneos[i]+":"+resultados[pos][i]+" ";
			}
		}
		return competencias;
	}
	public String obtenerResultadoJugador(String jugador, String torneo) {
		String resultado="";
		int posJugador=buscoJugador(jugador);
		int posTorneo=buscoTorneo(torneo);
		
		if(posJugador!=1 && posTorneo!=1){
			resultado="Resultado de " + jugadores[posJugador]+" en "+torneos[posTorneo]+": "+resultados[posJugador][posTorneo];
		}
		return resultado;
	}
	
	
	
	
	
	private int buscoJugador(String Jugador) {
		int posJugador = -1;
		int i=0;
		while (i<jugadores.length && !jugadores[i].equals(Jugador)){
			i++;
		}
		if(i<jugadores.length){
			posJugador=i;
		}
		return posJugador;
	}
	private int buscoTorneo(String torneo) {
		int posTorneo = -1;
		int i=0;
		while (i<torneos.length && !torneos[i].equals(torneo)){
			i++;
		}
		if (i<torneos.length){
			posTorneo=i;
		}
		
		return posTorneo;
	}
	public int procesarPeorPosTorneoJugador(String jugador) {
		int resultado=0;
		int pos=buscoJugador(jugador);
		
		if(pos!=-1){
			for (int i = 0; i < resultados[pos].length; i++) {
				if(resultados[pos][i]>resultado){
					resultado=resultados[pos][i];
				}
			}
		}
		return resultado;
	}
}
