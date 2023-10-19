package tp3_ejercicio3_tarjeta_de_credito;

public class TarjetaDeCredito {

	private String numero;
	private String titular;
	private double limiteDeCompra;
	private double acumuladoActual;

	public TarjetaDeCredito(String numero, String titular, double limiteDeCompra, double acum) {
		this.numero = numero;
		this.titular = titular;
		this.limiteDeCompra = limiteDeCompra;
		this.acumuladoActual = acum;
	}

	public String getNumero() {
		return this.numero;
	}

	public String getTitular() {
		return this.getTitular();
	}

	public double getLimiteDeCompra() {
		return this.limiteDeCompra;
	}

	public double getAcumuladoActual() {
		return acumuladoActual;
	}

	private void setNumero(String num) {
		this.numero = num;
	}

	private void setTitular(String titular) {
		this.titular = titular;
	}

	private void setLimiteDeCompra(double limite) {
		this.limiteDeCompra = limite;
	}

	@Override
	public String toString() {
		return "Número :" + numero + ", Titular : " + titular + ", Límite de compra :" + limiteDeCompra
				+ ", Acumulado :" + acumuladoActual ;
	}

	public double montoDiponible() {
		double disp = 0;
		disp = this.limiteDeCompra - this.acumuladoActual;

		if (disp < 0) {
			disp = 0;
		}
		return disp;
	}

	private boolean compraPosible(double valor) {
		boolean resp = false;
		if (valor <= this.montoDiponible()) {
			resp = true;
		}
		return resp;
	}
	
	public void actualizarLimite(double valor){
		double disp=0;
		this.setLimiteDeCompra(valor);
		if (this.montoDiponible()== 0){
			this.setLimiteDeCompra(0);
		}
		
		
	}
	
	private void acumularGastoActual(double importe){
		this.acumuladoActual=this.acumuladoActual+importe;
	}
	
	public boolean realizarCompra(double monto){
		boolean resp = false;
		boolean compra = compraPosible(monto);
		if (compra==true){
			resp=true;
			this.acumularGastoActual(monto);
			this.setLimiteDeCompra(this.getLimiteDeCompra()-monto);
		}
		return resp;
	}
	
}