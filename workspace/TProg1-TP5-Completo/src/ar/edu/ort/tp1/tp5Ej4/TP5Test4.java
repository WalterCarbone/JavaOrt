package ar.edu.ort.tp1.tp5Ej4;

import java.util.ArrayList;

public class TP5Test4 {

	public static void main(String[] args) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
    	CircuitoATP circuito = new CircuitoATP();
    	ArrayList<Jugador> jugadores=circuito.procesarInfo();
    	
    	System.out.println("Resultado final campeonato");
    	for(Jugador a:jugadores){
    		System.out.println(a.toString());
    	}
    	System.out.println("Delbonis: "+ circuito.procesarTorneosJugador("Delbonis"));
		System.out.println(circuito.obtenerResultadoJugador("Schwartzman","RolandGarros"));
		System.out.println("Peor Resultado de Pella en el a�o: "+ circuito.procesarPeorPosTorneoJugador("Pella"));
	}

}
