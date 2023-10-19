package ar.edu.ort.modelo;

public class Licuadora extends Producto {

	private int potencia;
	private int cantVelocidades;

	public Licuadora(String marca, String modelo, int nroSerie, int voltaje, int potencia, int cantVelocidades,double precio) {
		super(marca, modelo, nroSerie, voltaje, precio);
	
		setPotencia(potencia);
		setCantVelocidades(cantVelocidades);
		
	}


	@Override
	public String toString() {
		return "Licuadora " + " Marca: " + getMarca() + " Modelo: " + getModelo() ;
	}





	@Override
	public void imprimir() {
		System.out.println("Licuadora " + getMarca() + " Modelo: " + getModelo() + " Potencia " + potencia +"wts  Velocidades: "+ cantVelocidades+" Precio $"+getPrecio());
		
	}


	private void setPotencia(int potencia) {
		this.potencia = potencia;
	}


	private void setCantVelocidades(int cantVelocidades) {
		this.cantVelocidades = cantVelocidades;
	}

}
