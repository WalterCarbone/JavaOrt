package ar.edu.ort.tp1.ortmarket.modelo;

import ar.edu.ort.tp1.tdas.implementaciones.ListaOrdenadaNodos;

public class ListaDeClientesPorCuit extends ListaOrdenadaNodos<String, Cliente> {

	@Override
	public int compare(Cliente cliente1, Cliente cliente2) {
		return cliente1.getCuit().compareTo(cliente2.getCuit());
	}

	@Override
	public int compareByKey(String clave, Cliente cliente) {
		return clave.compareTo(cliente.getCuit());
	}

}

