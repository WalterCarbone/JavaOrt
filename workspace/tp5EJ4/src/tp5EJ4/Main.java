package tp5EJ4;

import java.util.ArrayList;

public class Main {
public static ArrayList<Jugador> player;
public static int i=-1;
public static String cadena;
public static String cadena2;

	public static void main(String[] args) {
		player=new ArrayList<>();
		CircuitoATP atp=new CircuitoATP();
		player=atp.procesarInfo();
		for (Jugador jugador : player) {
			System.out.println(jugador);
		}
		cadena=atp.procesarTorneosJugador("Delbonis");
		System.out.println(cadena);
		cadena2=atp.obtenerResultadoJugador("Schwartzman", "RolandGarros");
		System.out.println(cadena2);
		i=atp.procesarPeorPosTorneoJugador("Pella");
		System.out.println("El peor resultado de Pella es " + i);

				

	}

}
