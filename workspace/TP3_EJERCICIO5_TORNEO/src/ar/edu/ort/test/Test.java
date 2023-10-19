package ar.edu.ort.test;

import ar.edu.ort.modelo.Equipo;
import ar.edu.ort.modelo.Jornada;
import ar.edu.ort.modelo.Torneo;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Equipo boca=new Equipo("Boca");
		Equipo river=new Equipo("River");
		Equipo velez=new Equipo("Velez");
		Equipo sanLorenzo=new Equipo("San Lorenzo");
		Equipo racing=new Equipo("Racing");
		Equipo independiente=new Equipo("Independiente");
		
		Torneo futbol8 = new Torneo(8, "Futbol 8", 3, 1, 1, 1, 0, 1);
		futbol8.agregarEquipoAtorneo(independiente);
		futbol8.agregarEquipoAtorneo(boca);
		futbol8.agregarEquipoAtorneo(river);
		futbol8.agregarEquipoAtorneo(sanLorenzo);
		futbol8.agregarEquipoAtorneo(velez);
		futbol8.agregarEquipoAtorneo(racing);
		Jornada j1 = new Jornada("1");
		j1.agregarPartido(boca, sanLorenzo, 5, 4);
		j1.agregarPartido(river, racing, 1, 2);
		j1.agregarPartido(velez, independiente, 2, 6);
		futbol8.agregarJornadaAtorneo("1");
		j1.actualizarPuntos(futbol8.getGanado(), futbol8.getEmpatado(), futbol8.getPerdido(), futbol8.getVallaInvicta(),futbol8.getGanarMas4(), futbol8.getEmpateMas3());
		Jornada j2 = new Jornada("2");
		j2.agregarPartido(boca, river, 4, 3);
		j2.agregarPartido(sanLorenzo, independiente, 3, 0);
		j2.agregarPartido(racing, velez, 5, 1);
		futbol8.agregarJornadaAtorneo("2");
		j2.actualizarPuntos(futbol8.getGanado(), futbol8.getEmpatado(), futbol8.getPerdido(), futbol8.getVallaInvicta(),futbol8.getGanarMas4(), futbol8.getEmpateMas3());
		Jornada j3 = new Jornada("3");
		j3.agregarPartido(boca, velez, 6, 6);
		j3.agregarPartido(sanLorenzo, river, 3, 1);
		j3.agregarPartido(racing, independiente, 2, 4);
		j3.actualizarPuntos(futbol8.getGanado(), futbol8.getEmpatado(), futbol8.getPerdido(), futbol8.getVallaInvicta(),futbol8.getGanarMas4(), futbol8.getEmpateMas3());
		futbol8.agregarJornadaAtorneo("3");
		Jornada j4 = new Jornada("4");
		j4.agregarPartido(boca, racing, 0, 0);
		j4.agregarPartido(river, independiente, 1, 2);
		j4.agregarPartido(sanLorenzo, velez, 4, 4);
		futbol8.agregarJornadaAtorneo("4");
		j4.actualizarPuntos(futbol8.getGanado(), futbol8.getEmpatado(), futbol8.getPerdido(), futbol8.getVallaInvicta(),futbol8.getGanarMas4(), futbol8.getEmpateMas3());
		Jornada j5 = new Jornada("5");
		j5.agregarPartido(boca, independiente, 2, 1);
		j5.agregarPartido(river, velez, 2, 5);
		j5.agregarPartido(sanLorenzo, racing, 0, 3);
		futbol8.agregarJornadaAtorneo("5");
		j5.actualizarPuntos(futbol8.getGanado(), futbol8.getEmpatado(), futbol8.getPerdido(), futbol8.getVallaInvicta(),futbol8.getGanarMas4(), futbol8.getEmpateMas3());
		
		futbol8.mostrarTabla();
		futbol8.mostarFechas();
	}

}
