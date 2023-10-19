package ar.edu.ort.tp2_ejercicio4;

public class Direccion {

	
	private String calle;
	private int altura;
	private int piso;
	private String depto;
	
	
	public Direccion (String calle, int altura, int piso, String depto){
		setCalle(calle);
		setAltura(altura);
		setPiso(piso);
		setDepto(depto);
		
	}	
	


	public String getCalle() {
		return calle;
	}

	private void setCalle (String calle){
		this.calle=calle;
	}



	public int getAltura() {
		return altura;
	}


	private void setAltura(int altura) {
		this.altura = altura;
	}


	public int getPiso() {
		return piso;
	}


	private void setPiso(int piso) {
		this.piso = piso;
	}


	public String getDepto() {
		return depto;
	}


	private void setDepto(String depto) {
		this.depto = depto;
	}



	@Override
	public String toString() {
		return  calle  +" "+ altura +" "+  piso +" "+ depto;
	}
	
}
