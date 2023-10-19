package ar.edu.ort.tp1.exfinal.clases;
//TODO A implementar Completo
public class Podcast extends Item {

	public Podcast(String nombre, String artista, int anioLanzamiento) {
		super(nombre, artista, anioLanzamiento);
	}

	@Override
	public void reproducir() {
		//Polimorfismo
		System.out.println("Reproduciendo el podcast: " + this.getNombre() );
	}

	@Override
	public void detener() {
		System.out.println("Deteniendo el podcast: " + this.getNombre() );
	}
}