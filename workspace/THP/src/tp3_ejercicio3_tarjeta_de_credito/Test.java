package tp3_ejercicio3_tarjeta_de_credito;

public class Test {

	public static void main(String[] args) {

		// public TarjetaDeCredito(String numero, String titular, double
		// limiteDeCompra, double acum)
		double limite = 10000;
		double acumulado = 0;
		double compra = 4000;
		
		double limite2 = 3000;
		
		
		TarjetaDeCredito t1 = new TarjetaDeCredito("41556", "Juan Perez", limite, acumulado);

		System.out.println(t1 + "\n");
		System.out.println("Compra de $" + compra);
		procesarCompra(compra,t1);
		System.out.println(t1);
	
		t1.actualizarLimite(limite2);
		//System.out.println(t1);
		System.out.println("******************************");
		System.out.println("Se actualiza límite a $" + limite2);
		System.out.println("*******************************");
		System.out.println("Compra de $" + compra);
		procesarCompra(compra,t1);
		System.out.println("*****************************");
		System.out.println(t1);
		
	}

	private static void procesarCompra(double compra, TarjetaDeCredito t1) {
		boolean resp;
		resp = t1.realizarCompra(compra);
		if (resp == true) {
			System.out.println("Compra aprobada");
			//System.out.println(t1);
		} else {
			System.out.println("Compra denegada");
			//System.out.println(t1);
		}

		
	}

}
