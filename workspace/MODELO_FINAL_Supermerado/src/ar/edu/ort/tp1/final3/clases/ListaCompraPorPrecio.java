package ar.edu.ort.tp1.final3.clases;

import edu.ort.tp1.u5.tda.nodos.ListaOrdenadaNodos;

public class ListaCompraPorPrecio extends ListaOrdenadaNodos<Integer,Compra>{


	@Override
	public double compare(Compra compra1, Compra compra2) {
		
		return compra1.getPrecio()-compra2.getPrecio();
	}

	@Override
	public int compareByKey(Integer clave, Compra elemento) {
	
		return clave-elemento.getId();
	}

}
