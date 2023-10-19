package examen.clases;

import ort.tp1.tdas.implementaciones.ListaOrdenadaNodos;

public class ListaTrabajosPendientes extends ListaOrdenadaNodos<Integer, Trabajo> implements Reportable{

	@Override
	public int compare(Trabajo dato1, Trabajo dato2) {
				
		return dato1.getCodigo()-dato2.getCodigo();
	}

	@Override
	public int compareByKey(Integer codigo, Trabajo elemento) {
		
		return codigo-elemento.getCodigo();
	}

	@Override
	public void reportar() {
		for (Trabajo trabajos : this) {
			System.out.println(trabajos);
		}
		
	}

}
