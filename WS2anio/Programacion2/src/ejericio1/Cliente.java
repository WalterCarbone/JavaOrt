package ejericio1;

public class Cliente {

	private int documento;
	private String nombre;
	
	
	public Cliente(int documento, String nombre) {
		super();
		this.documento = documento;
		this.nombre = nombre;
	}


	public int getDocumento() {
		return documento;
	}


	public String getNombre() {
		return nombre;
	}


	private void setDocumento(int documento) {
		this.documento = documento;
	}


	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
}
