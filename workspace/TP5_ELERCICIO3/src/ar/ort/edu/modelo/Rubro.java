package ar.ort.edu.modelo;

public class Rubro {

	private static final int TOTAL_MESES = 12;
	private String nombre;
	private double[] gastosPorMes;

	public Rubro(String nombre) {
		this.nombre = nombre;
		inicializadorGastos();
	}

	private void inicializadorGastos() {
		 gastosPorMes = new double[TOTAL_MESES];
	}

	public void agregarGasto(MES mes, double importe) {
		gastosPorMes[mes.ordinal()] = importe;
	}

	public String getNombre() {
		return this.nombre;
	}
	


	public double getTotalGastos(MES mes) {
		return gastosPorMes[mes.ordinal()];
	}
}
