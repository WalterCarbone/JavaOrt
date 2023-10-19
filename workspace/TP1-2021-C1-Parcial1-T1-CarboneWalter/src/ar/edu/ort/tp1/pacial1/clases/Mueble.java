package ar.edu.ort.tp1.pacial1.clases;

public abstract class Mueble implements Mostrable {
	//TODO A completar
	private String modelo;
	private float costoBase;
	private float porcentajeGanancia;
	public  static final String MESJ="Fabricando el mueble:";

	public Mueble(String modelo, float costoBase, float porcentajeGanancia) {
		setModelo(modelo);
		setCostoBase(costoBase);
		setPorcentajeGanancia(porcentajeGanancia);
		mostrar();
	}

	//TODO A completar Métodos Faltantes
	
	private void setModelo(String modelo){
		this.modelo=modelo;
	}
	
	public String getModelo(){
		return this.modelo;
	}
	
	private void setCostoBase(float costoBase){
		this.costoBase=costoBase;
	}
	
	private void setPorcentajeGanancia(float porcentajeGanancia){
		this.porcentajeGanancia=porcentajeGanancia;
	}
	
	public float calcularPrecioVenta() {
		float precioVenta=0;
		precioVenta=calcularPrecioCosto()*porcentajeGanancia;
		
		return precioVenta;
	}

	protected abstract float calcularPrecioCosto();

	protected float getCostoBase() {
		return costoBase;
	}

	public boolean modeloCorrecto(String modelo) {
	
		return modelo == this.modelo;
	}
	

	

}
