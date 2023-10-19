package ar.ort.edu.modelo;

import java.util.ArrayList;

import org.omg.CORBA.ExceptionList;

public class GastoAnual {

	private ArrayList<Rubro> rubros;

	public GastoAnual() {
		rubros = new ArrayList<>();
	}

	public void agregarGasto(MES mes, String nombreRubro, double importe) {
		Rubro miRubro = null;
		if (importe <= 0) {
			throw new IllegalArgumentException("El importe ingresado es menor o igual que cero");
		} else {
			miRubro = obtenerRubro(nombreRubro);
			miRubro.agregarGasto(mes, importe);

		}

	}

	private Rubro obtenerRubro(String nombreRubro) {
		Rubro aDevolver = buscarRubro(nombreRubro);

		if (aDevolver == null) {
			aDevolver = new Rubro(nombreRubro);
			rubros.add(aDevolver);
		}
		return aDevolver;
	}

	private Rubro buscarRubro(String nombreRubro) {
		Rubro aDevolver = null;
		boolean encontro = false;
		int i = 0;
		while (i < rubros.size() && encontro == false) {
			if (rubros.get(i).getNombre().equals(nombreRubro)) {
				aDevolver = rubros.get(i);
				encontro = true;
			} else {
				i++;
			}

		}
		return aDevolver;
	}

	public double gastoAcumulado(MES mes) {

		double aDevolver = 0;
		for (Rubro r : rubros) {
			aDevolver += r.getTotalGastos(mes);
		}
		return aDevolver;
	}

	public double gastoAcumulado(String nombreRubro) {
		double aDevolver = 0;
		int i = 0;
		while (i < rubros.size() && rubros.get(i) != buscarRubro(nombreRubro)) {
			i++;
		}
		if (i < rubros.size()) {
			for (int j = 0; j < 12; j++) {
				aDevolver += rubros.get(i).getTotalGastos(MES.values()[j]);
			}
		} else {
			aDevolver = -1;
		}
		return aDevolver;
	}

	private double[][] consolidadoDeGastos() {

		double[][] matriz = new double[12][rubros.size()];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = rubros.get(j).getTotalGastos(MES.values()[i]);
			}
		}
		return matriz;
	}

	public void informarConsumosPorMes() {

		double[][] gastos = consolidadoDeGastos();

		for (int i = 0; i < gastos.length; i++) {
			System.out.println("MES : " + MES.values()[i]);
			for (int j = 0; j < gastos[i].length; j++) {
				System.out.println("Rubro : " + rubros.get(j).getNombre());
				System.out.println("Importe $" + rubros.get(j).getTotalGastos(MES.values()[i]));
			}
			System.out.println("Total de gastos de " + MES.values()[i] + " $" + gastoAcumulado(MES.values()[i]));

		}
	}

	public void informarPromedioMensualPorRubro() {
		double suma = 0;
		for (Rubro rubro : rubros) {

			for (int i = 0; i < MES.values().length; i++) {
				suma += rubro.getTotalGastos(MES.values()[i]);
			}
			System.out.println("Promedio Mensual de " + rubro.getNombre() + " es $" + (suma/MES.values().length));

		}

	}
	public void informarMesMayorConsumo(){
	//Calcula y muestra nombre e importe acumulado del mes con mayor consumo total (puede ser uno o más de uno).
		double[][] gastos = consolidadoDeGastos();
		double mayor=-1;
		ArrayList<MES> mesesMax = new ArrayList<>();
		
		for (int i = 0; i < MES.values().length; i++) {
			if(gastoAcumulado(MES.values()[i])==mayor){
				mesesMax.add(MES.values()[i]);
			}else if (gastoAcumulado(MES.values()[i])>mayor){
				mesesMax.removeAll(mesesMax);
				mesesMax.add(MES.values()[i]);
				mayor=gastoAcumulado(MES.values()[i]);
			}
		}
		

		System.out.println("El/los mes/es con mayor/res gastos : ");
		for (MES mes : mesesMax) {
			System.out.println(mes);
			
		}
		System.out.println("Con un total $" + mayor);
		
	}

}
