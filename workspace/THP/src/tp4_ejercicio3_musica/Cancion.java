package tp4_ejercicio3_musica;

public class Cancion {

	private String nombre;
	private String autor;
	private String genero;
	private int diasPublicada;
	private int vecesEscuchada;
	private static final int TOPE_REPRODUCCIONES = 1000;
	private static final int SEMANA=7;
	
	public Cancion (String nombre,String autor,String genero, int diasPublicada){
		this.setNombre(nombre);
		this.setAutor(autor);
		this.setGenero(genero);
		this.setDiasPublicada(diasPublicada);
		this.setVecesEscuchada(0);
	}
	
	
	public void agregarVecesEscuchada(){
		this.setVecesEscuchada(this.getVecesEscuchada()+1);
	}
	
	@Override
	public String toString() {
		return "Cancion [nombre=" + nombre + ", autor=" + autor + ", genero=" + genero + ", diasPublicada="
				+ diasPublicada + ", vecesEscuchada=" + vecesEscuchada + "]";
	}


	public boolean esRestringida(Cancion tema){
		boolean esRestringida=false;
		if(tema.getDiasPublicada()<SEMANA && tema.getVecesEscuchada()<TOPE_REPRODUCCIONES){
			esRestringida=true;
		}
		
		
		
		
		
		return esRestringida;
	}
	
	private void setNombre(String nombre){
		this.nombre=nombre;
	}
	
	private void setAutor(String autor){
		this.autor=autor;
	}
	
	private void setGenero(String genero){
		this.genero=genero;
	}
	
	private void setDiasPublicada(int diasPublicada){
		this.diasPublicada=diasPublicada;
	}
	
	private void setVecesEscuchada (int vecesEscuchada){
		this.vecesEscuchada=vecesEscuchada;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public String getAutor(){
		return this.autor;
	}
	
	public String getGenero(){
		return this.genero;
	}
	
	public int getDiasPublicada(){
		return this.diasPublicada;
	}
	
	public int getVecesEscuchada(){
		return this.vecesEscuchada;
	}
	
}
