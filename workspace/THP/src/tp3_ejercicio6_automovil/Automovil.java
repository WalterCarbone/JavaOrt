package tp3_ejercicio6_automovil;

public class Automovil {

	private String marca;
	private String modelo;
	private String patente;
	private double capacidadTanque;
	private double cantidadDeCombustible;
	private double rendimientoPorLitro;
	private static final double MIN_TANQ = 0;
	private static final double MIN_RENDIMIENTO = 0;
	private static final double MIN_CARGA = 0;
	private double capacidadViaje;

	public Automovil(String marca, String modelo, String patente, double capacidadTanque) {
		setMarca(marca);
		setModelo(modelo);
		setPatente(patente);
		setCapacidadTanque(capacidadTanque);
	}

	private void setMarca(String marca) {
		this.marca = marca;
	}

	private void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	private void setCapacidadTanque(double capacidadTanque) {
		if (capacidadTanque >= MIN_TANQ) {
			this.capacidadTanque = capacidadTanque;
		} else {
			this.capacidadTanque = MIN_TANQ;
		}
	}

	private void setCantidadDeCombustible(double cant) {
		this.cantidadDeCombustible = cant;
	}

	public void setRendimientoPorLitro(double rendimiento) {
		if (rendimiento >= MIN_RENDIMIENTO) {
			this.rendimientoPorLitro = rendimiento;
		} else {
			this.rendimientoPorLitro = MIN_RENDIMIENTO;
		}
	}

	public String getMarca() {
		return this.marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public String getPatente() {
		return this.patente;
	}

	public double getCapacidadTanque() {
		return this.capacidadTanque;
	}

	public double getCantidadDeCombustible() {
		return this.cantidadDeCombustible;
	}

	public double getRendimientoPorLitro() {
		return this.rendimientoPorLitro;
	}

	public boolean pocoCombustible() {
		boolean alerta = false;
		if (this.getCantidadDeCombustible() < (this.getCapacidadTanque() * 0.15)) {
			alerta = true;
		}
		return alerta;
	}

	private double espacioDisponible() {
		double espacio = 0;
		espacio = (this.getCapacidadTanque() - this.getCantidadDeCombustible());
		return espacio;
	}

	public boolean cargarCombustible(double carga) {
		boolean resp = false;
		if (carga <= MIN_CARGA || carga > espacioDisponible()) {
			System.out.println("No se realizó la carga");
		} else {
			this.setCantidadDeCombustible(this.getCantidadDeCombustible() + carga);
			resp = true;
			this.actCapacidadViaje();
		}
		return resp;
	}

	public double consumirCombustible(double kmArecorrer) {
		double consumoViaje=0;
		double viajado=0;
		consumoViaje = (kmArecorrer / this.getRendimientoPorLitro());	
		
		if(kmArecorrer<=capacidadViaje){
			this.setCantidadDeCombustible(this.getCantidadDeCombustible()-consumoViaje);
			actCapacidadViaje();
			viajado=kmArecorrer;
		}else{
			this.setCantidadDeCombustible(0);
			
			viajado=capacidadViaje;
			actCapacidadViaje();
			
		}
		
	
		return viajado;
	}

	public double viajar(double kmviaje) {

		double recorrido = this.consumirCombustible(kmviaje);

		return recorrido;

	}

	private void actCapacidadViaje() {
		this.capacidadViaje = this.getRendimientoPorLitro() * this.getCantidadDeCombustible();

	}

	@Override
	public String toString() {
		return "Automovil [marca=" + marca + ", modelo=" + modelo + ", patente=" + patente + ", capacidadTanque="
				+ capacidadTanque + ", cantidadDeCombustible=" + cantidadDeCombustible + ", rendimientoPorLitro="
				+ rendimientoPorLitro + ", pocoCombustible()=" + pocoCombustible() + ", capacidadViaje=" + capacidadViaje + "]";
	}

}
