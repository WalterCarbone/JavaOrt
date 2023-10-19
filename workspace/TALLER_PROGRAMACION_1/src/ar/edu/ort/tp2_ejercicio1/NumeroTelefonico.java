package ar.edu.ort.tp2_ejercicio1;

public class NumeroTelefonico {



	private int caracteristica;
	private int numeroDeAbonado;
	private int codigoDePais;
	private TipoDeLinea tipoLinea;

	public NumeroTelefonico(int caract, int numAbonado, int codPais, TipoDeLinea tipo) {
		setCaracteristica(caract);
		setNumeroAbonado(numAbonado);
		setCodigoDePais(codPais);
		setTipoDeLinea(tipo);
	}

	public String getValor() {
		String valor;
		valor = null;
		valor = "(+" + getCodigoDePais() + ") " + getCaracteristica() + "-" + getNumeroDeAbonado();
		return valor;
	}

	private void setTipoDeLinea(TipoDeLinea tipo) {
		this.tipoLinea = tipo;

	}

	private void setCaracteristica(int caract) {
		this.caracteristica = caract;
	}

	private void setNumeroAbonado(int numAbonado) {
		this.numeroDeAbonado = numAbonado;
	}

	private void setCodigoDePais(int codPais) {
		this.codigoDePais = codPais;
	}

	public int getNumeroDeAbonado() {
		return numeroDeAbonado;
	}

	public void setNumeroDeAbonado(int numeroDeAbonado) {
		this.numeroDeAbonado = numeroDeAbonado;
	}

	public int getCaracteristica() {
		return caracteristica;
	}

	public int getCodigoDePais() {
		return codigoDePais;
	}

	public TipoDeLinea getTipoDeLinea() {
		return this.tipoLinea;
	}

	@Override
	public String toString() {
		return    "\n"+tipoLinea + " : " + codigoDePais + "-"
				+ caracteristica + "-" + numeroDeAbonado;
	}

}
