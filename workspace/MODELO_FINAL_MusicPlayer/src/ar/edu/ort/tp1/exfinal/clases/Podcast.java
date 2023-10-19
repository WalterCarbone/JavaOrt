package ar.edu.ort.tp1.exfinal.clases;

public class Podcast extends Item{

	public Podcast(String nombre, String artista, int anio) {
		super(nombre, artista, anio);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void reproducir() {
		System.out.println("Reproduciendo el podcast :" + this.getNombre() + " del artista :" + this.getArtista());
		
	}


	@Override
	public void detener() {
		// TODO Auto-generated method stub
		
	}

}
