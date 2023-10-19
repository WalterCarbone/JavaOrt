package trabajo_practico2;
import java.util.Scanner;

public class Ejercicio14 {
	private static Scanner input=new Scanner(System.in);
	public static final int VIAJESLIBRES = 2;
	public static final int ABONO = 8500;
	public static final int VADICIONAL = 100;
	public static final double DESCUENTO = 0.9;
	public static final int PROMO = 30;
	public static final int PISO = 0;
	public static final int TECHO = 1000;
	public static final int END = 99999;
	public static final String MSJEMPRESA = "Ingrese el nombre del cliente : ";
	public static final String MSJVIAJES = "Ingrese la cantidad de viajes adicionales (";
	public static final String MSJERROR = "Error. Dato ingresado inválido";
	public static final String MSJSALIDA = "Fin de proceso. Gracias.";
	
			
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cantEmpresas;
		double acumFacturacion;
		double facturaMasCara;
		double promedioPagado;
		double facturacion;
		int adicionales;
		String empresa;
		
		adicionales = 0;
		cantEmpresas = 0;
		acumFacturacion = 0;
		facturacion = 0;
		promedioPagado = 0;
		facturaMasCara = Double.MIN_VALUE;
		
		// INGRESO CLIENTE Y VIAJES ADICIONALES
		empresa=ingresoEmpresa(MSJEMPRESA);
		adicionales=validoEnt(MSJVIAJES,PISO,TECHO,END,MSJERROR);
		while(adicionales != END){
			facturacion = calculoFactura(ABONO,VADICIONAL,PROMO,DESCUENTO,adicionales);
			muestroFactura (empresa,facturacion);
			
			if (facturacion > facturaMasCara){
				facturaMasCara = facturacion;
			}
			
			acumFacturacion = acumFacturacion + facturacion;
			cantEmpresas ++;
			
			empresa=ingresoEmpresa(MSJEMPRESA);
			adicionales=validoEnt(MSJVIAJES,PISO,TECHO,END,MSJERROR);
		}
		
		if (adicionales != END){
			promedioPagado = calculoPromedio(acumFacturacion, cantEmpresas);
			muestroPromedioPagado(promedioPagado);
			muestroMayorFactura(facturaMasCara);			
		}
		else{
			muestroSalida(MSJSALIDA);
		}

	}






	private static void muestroFactura(String empresa, double facturacion) {
		System.out.println("La empresa " + empresa + " debe abonar $" + facturacion);		
	}

	private static void muestroSalida(String msjsalida2) {
		System.out.println(msjsalida2);	
	}


	private static void muestroMayorFactura(double facturaMasCara) {
		System.out.println("La mayor factura es por un total de $" + facturaMasCara);
	}

	private static void muestroPromedioPagado(double promedioPagado) {
		System.out.println("El promedio pagado por empresa en el pasado mes fue de $" + promedioPagado);		
	}

	private static double calculoPromedio(double acumFacturacion, int cantEmpresas) {
		double prom;
		prom = 0;
		prom = acumFacturacion/cantEmpresas;
		return prom;
	}

	private static double calculoFactura(int abono2, int vadicional2, int promo2, double descuento2, int adicionales) {
		double fact ;
		fact = 0;
		if (adicionales > promo2){
			fact = (abono2+ adicionales*vadicional2)* descuento2;
		}
		else {
			fact = abono2 + adicionales * vadicional2;
		}
		
		return fact;
	}



	private static int validoEnt(String msjviajes2, int piso2, int techo2, int end2, String msjerror2) {
		int adic;
		System.out.println(msjviajes2 + piso2 + " - " + TECHO + "). Para salir ingrese " + END + " : ");
		adic = input.nextInt();
		while ((adic<PISO || adic >TECHO) && adic !=END){
			System.out.println(msjerror2);
			System.out.println(msjviajes2 + piso2 + " - " + TECHO + "). Para salir ingrese " + END + " : ");
			adic = input.nextInt();
			input.nextLine();
			
		}
		return adic;
	}


	private static String ingresoEmpresa(String msjempresa2) {
		String empresa;
		System.out.println(msjempresa2);
		empresa = input.nextLine();
		return empresa;
	}








}
