package ejemplo_parcial_concursoCocina;

public class Participante {

	private String dni;
	private String nombre;
	private String apellido;
	private int puntaje;
	private static final int PUNTAJE_INICIAL=0;
	
	public Participante (String dni,String nombre, String apellido){
	
		this.setDni(dni);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.puntaje=PUNTAJE_INICIAL;
}
	
	
	public void sumarVoto(){
		this.puntaje=this.getPuntaje()+1;
	}
	
	private void setDni(String dni){
		this.dni=dni;
	}
	
	private void setNombre(String nombre){
		this.nombre=nombre;
	}
	
	private void setApellido(String apellido){
		this.apellido=apellido;
	}
	
	public String getDni(){
		return this.dni;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public String getApellido(){
		return this.apellido;
	}
	
	public int getPuntaje(){
		return this.puntaje;
	}


	@Override
	public String toString() {
		return "Participante DNI:" + dni + ". Nombre:" + nombre + ". Apellido:" + apellido + ". Puntaje:" + puntaje;
	}


	
	
}
