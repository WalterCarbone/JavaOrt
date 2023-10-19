package ar.edu.ort.tp1.exfinal.clases;

import edu.ort.tp1.u5.tda.nodos.ListaOrdenadaNodos;
//TODO A implementar Completa
public class ListaItemsPorNombre extends ListaOrdenadaNodos<String, Item> {

	@Override
	public double compare(Item item1, Item item2) {
		return item1.getNombre().compareTo(item2.getNombre());
	}

	@Override
	public int compareByKey(String clave, Item elemento) {

		return clave.compareTo(elemento.getNombre());
	}

}
