package ar.edu.ort.tp1.final3.clases;

import edu.ort.tp1.u5.tda.nodos.ListaOrdenadaNodos;

public class ListaCompraPorPrecio extends ListaOrdenadaNodos<Integer, Compra> {

	// ordernar por Precio
	@Override
	public double compare(Compra dato1, Compra dato2) {
		return dato1.getPrecio() - dato2.getPrecio();
	}

	/*
	 * ordernar por ID
	 * 
	 * @Override public int compare(Compra dato1, Compra dato2) { return
	 * dato1.getId() - dato2.getId(); }
	 */

	@Override
	public int compareByKey(Integer clave, Compra elemento) {
		return clave - elemento.getId();
	}

}
