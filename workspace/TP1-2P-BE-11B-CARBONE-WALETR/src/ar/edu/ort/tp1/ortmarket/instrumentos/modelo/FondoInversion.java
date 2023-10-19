package ar.edu.ort.tp1.ortmarket.instrumentos.modelo;

import java.util.Iterator;

import ar.edu.ort.tp1.ortmarket.modelo.ListaInstrumentosPorCodigo;

public class FondoInversion extends InstrumentoFinanciero {

	private int nroCuotaPartes;
	private ListaInstrumentosPorCodigo instrumentos;

	public FondoInversion(String codigo, String nombre, String emisor, int nroCuotaPartes) {
		super(codigo, nombre, emisor);
		this.nroCuotaPartes = nroCuotaPartes;
		this.instrumentos = new ListaInstrumentosPorCodigo();
	}

	public void agregarInstrumento(InstrumentoFinanciero instrumentoFinanciero) {
		instrumentos.add(instrumentoFinanciero);
	}

	@Override
	public double obtenerCotizacion() {
		double cotizacion = 0;
		for (InstrumentoFinanciero instrumentoFinanciero : instrumentos) {
			cotizacion+=instrumentoFinanciero.obtenerCotizacion();
		}
		if(this.nroCuotaPartes>0){
			cotizacion=cotizacion/this.nroCuotaPartes;
		}else{
			cotizacion=0;
		}
	
		return cotizacion;
	}

}
