package ejericio1;

public abstract class Comprobante {
	private String tipo;
	private Fecha fecha;
	private static int nro=1;
	
	public Comprobante(String tipo, Fecha fecha) {
		this.tipo=tipo;
		this.fecha=fecha;
		Comprobante.nro=nro++;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	public int getNro(){
		return this.nro;
	}
	

	
	
}
