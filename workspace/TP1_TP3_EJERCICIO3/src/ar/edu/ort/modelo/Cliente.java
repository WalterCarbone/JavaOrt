package ar.edu.ort.modelo;

public class Cliente {

	@Override
	public String toString() {
		return "Cliente :" + apeNom + ", CUIT:" + cuit ;
	}

	private String cuit;
	private String apeNom;
	
	public Cliente (String apeNom,String cuit){
		this.cuit=cuit;
		this.apeNom=apeNom;
	}
}

