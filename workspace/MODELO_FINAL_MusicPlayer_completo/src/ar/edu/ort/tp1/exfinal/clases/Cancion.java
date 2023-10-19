package ar.edu.ort.tp1.exfinal.clases;

//TODO A implementar Completa
public class Cancion extends Item {

	public Cancion(String nombre, String artista, int anioLanzamiento) {
		super(nombre, artista, anioLanzamiento);
	}

	@Override
	public void reproducir() {
		// Polimorfismo
		System.out.println("Reproduciendo la Canción: " + this.getNombre());
	}

	@Override
	public void detener() {
		System.out.println("Deteniendo la Canción: " + this.getNombre());
	}
}
