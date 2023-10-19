package ar.edu.ort.tp1.final2.clases;

import edu.ort.tp1.u5.tda.Cola;
import edu.ort.tp1.u5.tda.ListaOrdenada;
import edu.ort.tp1.u5.tda.Pila;
import edu.ort.tp1.u5.tda.nodos.ColaNodos;
import edu.ort.tp1.u5.tda.nodos.PilaNodos;

public class CentroBuceoAvanzado {

	private static final String BUCEO_INVALIDO = "Buceo Invalido";
	private static final int CANTIDAD_BUCEOS = 10;

	private String nombre;
	private Pila<String> erroresDeReserva;
	private ListaOrdenada<Integer, Buceo> buceosDisponibles;
	private Cola<Buzo> buzosRegistrados;
	private int[][] cantidadBuceosPorMes;

	public CentroBuceoAvanzado(String nombre) {
		this.nombre = nombre;
		this.erroresDeReserva = new PilaNodos<>();
		this.buzosRegistrados = new ColaNodos<>();
		buceosDisponibles = new ListaBuceosPorId();
		cantidadBuceosPorMes = new int[CANTIDAD_BUCEOS][Mes.values().length];

	}

	public void registrarBuceo(Buzo buzo, Integer idBuceo) {
		if (buzo == null) {
			erroresDeReserva.push("Buzo invalido");
		} else {
			Buceo buceo = buscarBuceoPorID(idBuceo);
			if (buceo == null) {
				erroresDeReserva.push(BUCEO_INVALIDO);
			} else {
				if (buzo.habilitado(buceo.getProfundidad())) {
					buzosRegistrados.add(buzo);
					buzo.agregarABitacora(buceo);
				}else{
					erroresDeReserva.push("Buzo no Habilitado por profundidad");
				}

			}
		}

	}

	public void agregarBuceo(Buceo buceo, Mes mes) {
		buceosDisponibles.add(buceo);
		cantidadBuceosPorMes[buceo.getId() - 1][mes.ordinal()]++;

	}

	private Buceo buscarBuceoPorID(Integer idBuceo) {

		return this.buceosDisponibles.search(idBuceo);
	}

	public void listarErroresCronologico() {
		System.out.println("Mostrando errores en forma cronologica");
		Pila<String> aux = new PilaNodos();
		String error;
		while (!erroresDeReserva.isEmpty()) {
			error = erroresDeReserva.pop();
			System.out.println(error);
			aux.push(error);
		}
		while (!aux.isEmpty()) {
			erroresDeReserva.push(aux.pop());
		}
	}

	public void mostrarCantidadDeBuceosPorBuzoRegistrado() {
		BuzoTecnico centinela=new BuzoTecnico("xxx", "nacionalidad", 22);
		buzosRegistrados.add(centinela);
		Buzo buzo = buzosRegistrados.remove();
		while(buzo!=centinela){
			System.out.println(buzo+" realizó : "+buzo.cantidadDeEventos()+" buceos");
			buzosRegistrados.add(buzo);
			buzo = buzosRegistrados.remove();
		}

	}

	public void mostrarCantidadDeReservasPorMes() {
		System.out.println("------------------");
		System.out.println("Cantidad de buceos por Mes");
		for (int idMes = 0; idMes < Mes.values().length; idMes++) {
			int suma = 0;
			for (int i = 0; i < CANTIDAD_BUCEOS; i++) {
				suma += cantidadBuceosPorMes[i][idMes];
			}
			System.out.printf("La cantidad de buceos del mes de %s es %d\n",Mes.values()[idMes],suma);
		}

	}
}
