package ejemplo_parcial_3;
import java.util.Scanner;


public class Parilla {
	private static Scanner input=new Scanner(System.in);
	//DECLARACION DE CONSTANTES
	public static final int CAPACIDAD= 2;
	public static final String COD_EFE= "EFE";
	public static final String NOM_EFE= "Efectivo";
	public static final int REC_EFE= 0;
	public static final String COD_DEB= "DEB";
	public static final String NOM_DEB= "Débito";
	public static final double REC_DEB = 0.05;
	public static final String COD_CRE= "CRE";
	public static final String NOM_CRE= "Tarjeta de crédito";
	public static final double MENU = 1200;
	public static final int MAX_COM = 4;
	public static final int CUOTA_MIN = 1;
	public static final int CUOTA_MAX = 12;
	
	//MENSAJES
	public static final String BIENVENIDA= "Bienvienido a restaurant VIP";
	public static final String ING_COMENSALES = "Ingrese la cantidad de comensales (entre 1 y " + MAX_COM + ") : ";
	public static final String MSJ_ERROR= "Error.Dato ingresado inválido.";
	public static final String MSJ_MEDIO_PAGO= "** MEDIOS DE PAGO ** \n"+ COD_EFE + " : "+ NOM_EFE + "\n"
																		 + COD_DEB + " : " + NOM_DEB + "\n"
																		 + COD_CRE + " : " + NOM_CRE + "\n"
																		 + "Ingrese el  medio de pago :";
	public static final String MSJ_CANT_CUOTAS = "Ingrese la cantidad de cuotas (entre " + CUOTA_MIN + " y " + CUOTA_MAX + ") :";
	
	public static void main(String[] args) {
		// Variables
	double costoMesa;
	int cuotas;
	String medioPago;
	double mayorCosto;
	String mayorMedioPago;
	int comensales;
	int contComensales;
	double recargo;

	costoMesa=0;
	cuotas=0;
	mayorCosto = Double.MIN_VALUE;
	comensales =0;
	contComensales = 0;
	recargo = 0;
	mayorMedioPago ="";
	
	for (int i=0; i<CAPACIDAD; i++){
		System.out.println("Mesa N° " + i);
		
		comensales = ingreseNumero(ING_COMENSALES);
		while (comensales<1 || comensales>MAX_COM){
			System.out.println(MSJ_ERROR);
			comensales = ingreseNumero(ING_COMENSALES);			
		}
	
		medioPago= ingreseTexto(MSJ_MEDIO_PAGO);
		while (!medioPago.equals(COD_EFE) && !medioPago.equals(COD_DEB) && !medioPago.equals(COD_CRE)){
			System.out.println(MSJ_ERROR);
			medioPago= ingreseTexto(MSJ_MEDIO_PAGO);
		}
		recargo = calculorecargo(medioPago);
		costoMesa = (comensales * MENU) + (comensales * MENU * recargo);
		if (costoMesa>mayorCosto){
			mayorCosto=costoMesa;
			mayorMedioPago = medioPago;
		}
		contComensales++;
		muestroCostoMesa(costoMesa);
		
	}		
	muestroMayorCosto(mayorCosto,mayorMedioPago);
	muestroPromedio(contComensales);
	
	input.close();
	}
	// FUNCIONES
	
	
	
	
private static void muestroPromedio(int contComensales) {
		double prom =0;
		prom = contComensales / CAPACIDAD;
		System.out.println("El promedio de comensales por mesa es de " + prom);
		
	}




private static void muestroMayorCosto(double mayorCosto, String mayorMedioPago) {
		String msj = "El mayor costo final registrado fue de $" + mayorCosto +". Abonado en ";
		switch(mayorMedioPago){
		case COD_EFE:
			System.out.println(msj + NOM_EFE);
		break;
		case COD_DEB:
			System.out.println(msj + NOM_DEB);
		break;
		case COD_CRE:
			System.out.println(msj + NOM_CRE);
		break;	
		}
	}




private static void muestroCostoMesa(double costoMesa) {
	System.out.println("El costo de la mesa es de $" + costoMesa);
		
	}




private static double calculorecargo(String medioPago) {
		double rec = 0;
		int cuotas = 0;
		switch(medioPago){
		case COD_EFE:
			rec = REC_EFE;
		break;
		
		case COD_DEB:
			rec = REC_DEB;
		break;
		case COD_CRE:
			cuotas = ingreseNumero(MSJ_CANT_CUOTAS);
			while (cuotas < CUOTA_MIN || cuotas > CUOTA_MAX){
				System.out.println(MSJ_ERROR);
				cuotas = ingreseNumero(MSJ_CANT_CUOTAS);
			}
			rec = recargoSegunCuotas(cuotas);
		break;	
		}
		return rec;
	}



	



	private static double recargoSegunCuotas(int cuotas) {
		double rec =0;
		double tasa = 1.03;
		rec = (Math.pow(tasa, cuotas)-1)*100;
		return rec;
	}
	private static int recargoCuotas(int cuotas) {
	// TODO Auto-generated method stub
	return 0;
}




	public static String ingreseTexto(String msj){
		String texto;
		do{
			System.out.println(msj);
			texto = input.nextLine().toUpperCase();
		}while(texto.equals(""));
		
		return texto;
	}
	
	public static int ingreseNumero(String msj){
		int num;
		System.out.println(msj);
		num = input.nextInt();
		input.nextLine();
		return num;
	}
}
