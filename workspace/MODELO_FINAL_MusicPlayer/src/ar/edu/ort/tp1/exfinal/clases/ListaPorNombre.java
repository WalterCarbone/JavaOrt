package ar.edu.ort.tp1.exfinal.clases;

import edu.ort.tp1.u5.tda.nodos.ListaOrdenadaNodos;

public class ListaPorNombre extends ListaOrdenadaNodos<String,Item>{

	@Override
	public double compare(Item dato1, Item dato2) {
	
		return dato1.getNombre().compareTo(dato2.getNombre());
	}

	@Override
	public int compareByKey(String clave, Item dato) {
		
		return clave.compareTo(dato.getNombre());
	}

}
