package ejercicio_tipo_parcial;

import java.util.ArrayList;

public class Tema {
	private static final  int MIN_REPROD=0;
	private String titulo;
	private String autor;
	private int anio;
	private Genero genero;
	private int cantReproducciones;
	
	public Tema(String titulo,String autor, int anio, Genero genero){
		this.setTitulo(titulo);
		this.setAutor(autor);
		this.setAnio(anio);
		this.setGenero(genero);
		this.cantReproducciones=MIN_REPROD;
		
	}
	
	
	
	
	public void agregarReproduccion (){
		this.setCantReproducciones();
	}
	
	private void setCantReproducciones(){
		this.cantReproducciones=this.getCantReproducciones()+1;
	}
	private void setTitulo(String titulo){
		this.titulo=titulo;
	}
	
	private void setAutor (String autor){
		this.autor=autor;
		}
	
	private void setAnio (int anio){
		this.anio=anio;
	}
	
	private void setGenero (Genero genero){
		this.genero=genero;
	}
	
	public String getTitulo(){
		return this.titulo;
	}
	
	public String getAutor(){
		return this.autor;
	}
	
	public int getAnio(){
		return this.anio;
	}
	
	public Genero getGenero(){
		return this.genero;
	}
	
	public int getCantReproducciones(){
		return this.cantReproducciones;
	}




	@Override
	public String toString() {
		return "Tema:" + titulo + ". Autor:" + autor + ". Año:" + anio + ". Genero:" + genero
				+ ". Cantidad de reproducciones:" + cantReproducciones;
	}
	
	
}
