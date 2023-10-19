package ar.ort.edu.modelo;



public class Test {

	public static void main(String[] args) {
		GastoAnual gastoAnual = new GastoAnual();
	
		
		
		
		gastoAnual.agregarGasto(MES.ENERO, "administracion", 1500);
		gastoAnual.agregarGasto(MES.ENERO, "tecnico", 150);
		gastoAnual.agregarGasto(MES.FEBRERO, "tecnico", 500);
		gastoAnual.agregarGasto(MES.MARZO, "comercial", 750);
		gastoAnual.agregarGasto(MES.ABRIL, "funcional", 200);
		gastoAnual.agregarGasto(MES.MAYO, "comercial", 7500);
		gastoAnual.agregarGasto(MES.JUNIO, "administracion", 7500);
		gastoAnual.agregarGasto(MES.JULIO, "funcional", 50);
		gastoAnual.agregarGasto(MES.AGOSTO, "funcional", 300);
		gastoAnual.agregarGasto(MES.SEPTIEMBRE, "tecnico", 500);
		gastoAnual.agregarGasto(MES.OCTUBRE, "comercial", 300);
		gastoAnual.agregarGasto(MES.NOVIEMBRE, "administracion", 1000);
		gastoAnual.agregarGasto(MES.DICIEMBRE, "comercial", 400);
	
	
		System.out.println("Gasto del rubro tecnico: "+gastoAnual.gastoAcumulado("tecnico"));
		System.out.println("Gasto del rubro administracion: "+gastoAnual.gastoAcumulado("administracion"));
		System.out.println("Gasto del rubro comercial: "+gastoAnual.gastoAcumulado("comercial"));
		System.out.println("Gasto del rubro funcional: "+gastoAnual.gastoAcumulado("funcional"));
		gastoAnual.informarConsumosPorMes();
		gastoAnual.informarPromedioMensualPorRubro();
		gastoAnual.informarMesMayorConsumo();

	}

}
