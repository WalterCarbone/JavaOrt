package ar.edu.ort.tp1.exfinal.clases;

public abstract class Item implements Reproducible {
	private String nombre;
	private String artista;
	private int anioLanzamiento;
	
	public Item(String nombre,String artista,int anio){
		setNombre(nombre);
		setArtista(artista);
		setAnioLanzamiento(anio);
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		String a = getClass().getSimpleName();
		return a + " nombre:" + this.nombre + ", artista:" + this.artista + ", año Lanzamiento:" + this.anioLanzamiento + "]";
	}

	public String getArtista() {
		return artista;
	}

	public int getAnioLanzamiento() {
		return anioLanzamiento;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private void setArtista(String artista) {
		this.artista = artista;
	}

	private void setAnioLanzamiento(int anioLanzamiento) {
		this.anioLanzamiento = anioLanzamiento;
	}
	
	
}
