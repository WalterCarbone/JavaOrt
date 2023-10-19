package ar.edu.ort.modelo;

import java.util.ArrayList;

public class Jornada {

	private String fecha;
	private ArrayList<Partido> listaPartidos;
	private Partido p1;

	public Jornada(String fecha) {
		setFecha(fecha);
		listaPartidos = new ArrayList<>();

	}

	private void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getFecha() {
		return this.fecha;
	}

	public void imprimirPartidos(){
		for (Partido partido : listaPartidos) {
			System.out.println(partido);
		}
	}
	public void agregarPartido(Equipo local, Equipo visitante, int golesLocal, int golesVisitante) {
		p1 = new Partido(local, visitante, golesLocal, golesVisitante);
		listaPartidos.add(p1);
	}

	public void actualizarPuntos(int ganado, int empatado, int perdido, int vallaInvicta, int ganarMas4,
			int empateMas3) {
		for (Partido partido : listaPartidos) {

			if (partido.getGolesLocal() > partido.getGolesVisitante()) {
				partido.getLocal().actualizarPuntos(ganado);
				partido.getVisitante().actualizarPuntos(perdido);
				if(partido.getGolesVisitante()==0){
					partido.getLocal().actualizarPuntos(vallaInvicta);
				}
				if(partido.getGolesLocal()>4){
					partido.getLocal().actualizarPuntos(ganarMas4);
				}
			}else if(partido.getGolesLocal()<partido.getGolesVisitante()){
				partido.getVisitante().actualizarPuntos(ganado);
				partido.getLocal().actualizarPuntos(perdido);
				if (partido.getGolesLocal()==0){
					partido.getVisitante().actualizarPuntos(vallaInvicta);
				}
				if (partido.getGolesVisitante()>4){
					partido.getVisitante().actualizarPuntos(ganarMas4);
				}else {
					if(partido.getGolesLocal()>3){
						partido.getLocal().actualizarPuntos(empatado+empateMas3);
						partido.getVisitante().actualizarPuntos(empatado+empateMas3);
					}else{
						partido.getLocal().actualizarPuntos(empatado);
						partido.getVisitante().actualizarPuntos(empatado);
					}
				}
			}
			

		}
	}
}
