package ar.edu.ort.tp1.exfinal.clases;

public abstract class Item implements Reproducible {
	//TODO A implementar 
	private String nombre;
	private String artista;
	private int anioLanzamiento;
	
	
	
	//TODO A implementar 
	public Item(String nombre, String artista, int anioLanzamiento) {
		this.nombre = nombre;
		this.artista = artista;
		this.anioLanzamiento = anioLanzamiento;
	}

	//TODO A implementar 
	public String getNombre() {
		return nombre;
	}
	//TODO A implementar 
	@Override
	public String toString() {
		return getClass().getSimpleName() + " [nombre=" + nombre + ", artista=" + artista + ", anioLanzamiento=" + anioLanzamiento + "]";
	}
}
