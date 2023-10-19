package tp4_ejercicio3_musica;

import java.util.ArrayList;

public class Usuario {
	private String mail;
	private String apellido;
	private int edad;
	private int temasPorDia;
	private Categorias categoria;
	private ArrayList<Cancion> cancionesEscuchadas;
	
	
	public Usuario (String mail, String apellido, int edad, Categorias categoria){
		this.setMail(mail);
		this.setApellido(apellido);
		this.setEdad(edad);
		this.setCategoria(categoria);
		this.setTemasPorDia(0);
		
		
		cancionesEscuchadas = new ArrayList<>();
		
	}
	
	public void ingresarCancion(Cancion escuchada){
		cancionesEscuchadas.add(escuchada);
		escuchada.agregarVecesEscuchada();
		this.setTemasPorDia(getTemasPorDia()+1);
	}
	
	private void setMail(String mail){
		this.mail=mail;
	}
	
	public void listarCanciones(Usuario user){
		for(Cancion x: cancionesEscuchadas){
	           System.out.println(x);
	}
	}
	
	@Override
	public String toString() {
		return "Usuario [mail=" + mail + ", apellido=" + apellido + ", edad=" + edad + ", temasPorDia=" + temasPorDia
				+ ", categoria=" + categoria + ", cancionesEscuchadas=" + cancionesEscuchadas + "]";
	}

	private void setApellido (String apellido){
		this.apellido=apellido;
	}
	
	private void setEdad (int edad){
		this.edad=edad;
	}
	
	private void setCategoria (Categorias categoria){
		this.categoria=categoria;
	}
	
	private void setTemasPorDia(int cant){
		this.temasPorDia=cant;
	}
	
	public String getMail(){
		return this.mail;
	}
	
	public int getTemasPorDia(){
		return this.temasPorDia;
	}
	
	public String getApellido(){
		return this.apellido;
	}
	
	public int getEdad(){
		return this.edad;
	}
	
	public Categorias getCategoria(){
		return this.categoria;
	}
	
}
