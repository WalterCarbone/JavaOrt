package ar.edu.ort.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Torneo {

	private int cantJugadores;
	private String nombre;
	private int ganado;
	private int empatado;
	private int perdido;
	private int vallaInvicta;
	private int ganarMas4;
	private int empateMas3;
	private ArrayList<Equipo> equiposParticipantes;
	private ArrayList<Jornada> fechas;
	
	public Torneo(int cantJugadores, String nombre, int ganado, int empatado, int perdido, int vallaInvicta,
			int ganarMas4, int empateMas3) {
		super();
		setCantJugadores(cantJugadores);
		setNombre(nombre);
		setGanado(ganado);
		setEmpatado(empatado);
		setPerdido(perdido);
		setVallaInvicta(vallaInvicta);
		setGanarMas4(ganarMas4);
		setEmpateMas3(empateMas3);
		equiposParticipantes = new ArrayList<>();
		fechas = new ArrayList<>();
	}
	
	public int getCantJugadores() {
		return cantJugadores;
	}


	private void setCantJugadores(int cantJugadores) {
		this.cantJugadores = cantJugadores;
	}


	public String getNombre() {
		return nombre;
	}


	private void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getGanado() {
		return ganado;
	}


	private void setGanado(int ganado) {
		this.ganado = ganado;
	}


	public int getEmpatado() {
		return empatado;
	}


	private void setEmpatado(int empatado) {
		this.empatado = empatado;
	}


	public int getPerdido() {
		return perdido;
	}


	private void setPerdido(int perdido) {
		this.perdido = perdido;
	}


	public int getVallaInvicta() {
		return vallaInvicta;
	}


	private void setVallaInvicta(int vallaInvicta) {
		this.vallaInvicta = vallaInvicta;
	}


	public int getGanarMas4() {
		return ganarMas4;
	}


	private void setGanarMas4(int ganarMas4) {
		this.ganarMas4 = ganarMas4;
	}


	public int getEmpateMas3() {
		return empateMas3;
	}


	private void setEmpateMas3(int empateMas3) {
		this.empateMas3 = empateMas3;
	}

	
	public void agregarEquipoAtorneo(Equipo e){
		equiposParticipantes.add(e);
	}
	
	public void agregarJornadaAtorneo (String fecha){
		fechas.add(new Jornada(fecha));
	}
	
	public void mostarFechas(){
		System.out.println("Equipo Local"+" Equipo Visitante"+ " Goles local" + " Goles Visitante" + " Fecha");
		for (Jornada jornada : fechas) {
			System.out.println(jornada.getFecha());
			jornada.imprimirPartidos();
			
		}
	}

	public  void mostrarTabla(){
		System.out.println("Torneo de futbol " + this.cantJugadores);
		System.out.println("Tabla de posiciones al cabo de " + fechas.size() +" fechas");
		for (Equipo equipo : equiposParticipantes) {
		System.out.println(equipo);
			
		}

	
	
	}
	

	
	
	
}
