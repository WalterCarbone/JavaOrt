package ar.edu.ort.tp1.tp5Ej3;

public class Rubro {
	
	private final int TOTAL_MESES = MES.values().length;
	private String nombre;
	private double[] gastosPorMes;
	
	public Rubro(String nombre) {
		this.nombre = nombre;
		inicializarGastos();
	}
	
	private void inicializarGastos(){ 
		gastosPorMes = new double[TOTAL_MESES]; 
	}
	
	public void agregarGastos(MES mes, double gastos){
		gastosPorMes[mes.ordinal()] += gastos;
	}
	
	public String getNombre(){ 
		return nombre; 
	}
	
	public double getTotalGastos(MES mes){ 
		return gastosPorMes[mes.ordinal()];
	}
}