package tp4_ejercicio4_drsueno;

public class Turno {

	private int dni;
	private String nombre;
	private String apellido;
	private String telefono;
	private boolean presente;
	

	public Turno (int dni,String nombre, String apellido,String telefono){
		this.setDni(dni);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setTelefono(telefono);
		this.presente=false;
		}
	
	
	
	
	
	public int getDni(){
		return this.dni;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public String getApellido(){
		return this.apellido;
	}
	
	public String getTelefono(){
		return this.telefono;
	}
	
	public boolean getPresente(){
		return this.getPresente();
	}
	
	private void setDni(int dni){
		this.dni=dni;
	}
	
	private void setNombre(String nombre){
		this.nombre=nombre;
	}
	
	private void setApellido(String apellido){
		this.apellido=apellido;
	}
	
	private void setTelefono(String telefono){
		this.telefono=telefono;
	}
	
	public void setPresente (){
		this.presente=true;
	}





	@Override
	public String toString() {
		return "DNI:" + dni + "- Nombre:" + nombre + "- Apellido:" + apellido + "- Telefono:" + telefono
				+ "- Presente." + presente ;
	}
	
}
