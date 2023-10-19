package ejemplo_parcial_2;
import java.util.Scanner;

public class Ejemplo_parcial_Paquetes {
	private static Scanner input=new Scanner(System.in);
	// DECLARACION DE CONSTANTES 
	public static final int NRO_PAQ1= 1;
	public static final int NRO_PAQ2= 2;
	public static final int NRO_PAQ3= 3;
	public static final int NRO_PAQ4= 4;
	public static final int FIN= 0;
	public static final int TOTAL_PAQUETE = 4;
	public static final String NOM_PAQ1= "BRASIL";
	public static final String NOM_PAQ2= "CARIBE";
	public static final String NOM_PAQ3= "DISNEY";
	public static final String NOM_PAQ4= "EUROPA";
	public static final double PRECIO_PAQ1= 6000;
	public static final double PRECIO_PAQ2= 15000;
	public static final double PRECIO_PAQ3= 35000;
	public static final double PRECIO_PAQ4= 70000;
	public static final String PAQ_EN_PROMO= NOM_PAQ3;
	public static final int NRO_PAQ_PROMO = NRO_PAQ3;
	
	
	//MENSAJES
	public static final String MSJBIENVENIDA= "Bienvenido! \n";
	public static final String MSJDESTINOS="*** Destinos y precios ***";
	public static final String MSJFIN="TERMINA CARGA";
	public static final String MSJPROMO="Atención: precio promocional a ";
	public static final String MSJINGPAQ="Elija el paquete que desea adquirir :";
	public static final String MSJINGPASJ="Ingrese el nombre del cliente :";
	public static final String MSJINGCANT="Ingrese la cantidad de pasajeros :";
	public static final String MSJERROR="Error. El dato ingresado es inválido";
	
	

	public static void main(String[] args) {
	//DECLARACION E INICIALIZACION DE VARIABLES
		int nro_Paq;
		String nombre;
		int cant_Pasajeros;
		int cant_Paq;
		double rec_Diaria;
		double paq_Mayor;
		int cant_Paq_Promo;
		double monto;
		String nombre_Paquete;
		String nom_Paq_Mayor;
		String nom_Cliente_Mayor;
		int cont_Pasajeros;
		
		
		nro_Paq=0;
		cant_Pasajeros = 0;
		cant_Paq = 0;
		rec_Diaria = 0;
		paq_Mayor = 0;
		cant_Paq_Promo = 0;
		monto = 0;
		nom_Paq_Mayor = " ";
		nom_Cliente_Mayor = " ";
		cont_Pasajeros = 0;
		
		System.out.println(MSJBIENVENIDA);
		
		muestroDestinos();
		
		System.out.println(MSJINGPAQ);
		nro_Paq = validoEntero(FIN,TOTAL_PAQUETE,MSJINGPAQ,MSJERROR);
		while (nro_Paq > FIN){
			nombre_Paquete = (String) obtengo_Nonbre(nro_Paq);
			
			System.out.println(MSJINGPASJ);
			nombre = validoTxt("No ha ingresado el nombre del cliente");
			cant_Pasajeros = validoPositivo(MSJINGCANT,MSJERROR);
			
			monto = calculoMonto(nro_Paq,cant_Pasajeros);
						
			cant_Paq ++;
			rec_Diaria = rec_Diaria + monto;
			cont_Pasajeros = cont_Pasajeros + cant_Pasajeros;
			
			if (monto>paq_Mayor){
				paq_Mayor = monto;
				nom_Paq_Mayor = nombre_Paquete;
				nom_Cliente_Mayor = nombre;
			}
			
			if (nro_Paq == NRO_PAQ_PROMO){
				cant_Paq_Promo ++;
				
			}
			
			imprimoPaquete("Destino del paquete: ","Cantidad de pasajeros: ", "Monto total del paquete: $", nro_Paq,cant_Pasajeros,monto);
			monto=0;
			muestroDestinos();
			System.out.println(MSJINGPAQ);
			nro_Paq = validoEntero(FIN,TOTAL_PAQUETE,MSJINGPAQ,MSJERROR);
			
		}
		
		if (cant_Paq > 0){
			muestroTotalPaquetesDiarios("El total de paquetes vendidos hoy :",cant_Paq);
			muestroTotalRecaudado("El total recaudado : $",rec_Diaria);
			muestroPaqMayorMonto("El paquete de mayor monto: ", nom_Paq_Mayor," por $",paq_Mayor," a nombre de : ", nom_Cliente_Mayor);
			muestroPromedio("Monto promedio invertido por pasajero :$", rec_Diaria,cont_Pasajeros);
			muestroPromoVendidas("Cantidad de paquetes vendidos a",PAQ_EN_PROMO,cant_Paq_Promo,cant_Paq );
		} else {
			System.out.println("No se registraron ventas en el día de hoy.");
		}
		
		
		input.close();
		

	}





	private static void muestroPromoVendidas(String leyenda, String paqEnPromo, int cant_Paq_Promo, int cant_Paq) {
		double porc = 0;
		porc = (cant_Paq_Promo * 100)/ cant_Paq;
		System.out.println(leyenda + paqEnPromo + " (" + porc + "%)");
		
	}





	private static void muestroPromedio(String leyenda, double rec_Diaria, int cont_Pasajeros) {
		double prom = 0;
		prom = rec_Diaria / cont_Pasajeros;
		System.out.println(leyenda + prom);
	}





	private static void muestroPaqMayorMonto(String leyenda1, String nom_Paq_Mayor, String leyenda2, double paq_Mayor,
			String leyenda3, String nom_Cliente_Mayor) {
		System.out.println(leyenda1 + nom_Paq_Mayor + leyenda2 + paq_Mayor + leyenda3 + nom_Cliente_Mayor);
		
	}





	private static void muestroTotalRecaudado(String leyenda, double rec_Diaria) {
		System.out.println(leyenda + rec_Diaria);
		
	}





	private static void muestroTotalPaquetesDiarios(String leyenda, int cant_Paq) {
		System.out.println(leyenda  + cant_Paq);
		
	}





	private static Object obtengo_Nonbre(int nro_Paq) {
		String paq;
		paq ="";
		switch (nro_Paq){
		case NRO_PAQ1: paq= NOM_PAQ1;
		break;
		case NRO_PAQ2: paq= NOM_PAQ2;
		break;
		case NRO_PAQ3: paq= NOM_PAQ3;
		break;
		case NRO_PAQ4: paq= NOM_PAQ4;
		break;
		}
		
		return paq;
	}





	private static void imprimoPaquete(String destino, String cantidad, String leyenda_monto, int nro_Paq, int cant_Pasajeros,
			double monto) {
		// TODO Auto-generated method stub
		switch(nro_Paq){
		case(NRO_PAQ1):System.out.println(destino + NOM_PAQ1);
						System.out.println(cantidad + cant_Pasajeros);
						System.out.println(leyenda_monto + monto);
		break;
		case(NRO_PAQ2):System.out.println(destino + NOM_PAQ2);
						System.out.println(cantidad + cant_Pasajeros);
						System.out.println(leyenda_monto + monto);
		break;
		case(NRO_PAQ3):System.out.println(destino + NOM_PAQ3);
						System.out.println(cantidad + cant_Pasajeros);
						System.out.println(leyenda_monto + monto);
		break;
		case(NRO_PAQ4):System.out.println(destino + NOM_PAQ4);
						System.out.println(cantidad + cant_Pasajeros);
						System.out.println(leyenda_monto + monto);
		break;
							
		}
		System.out.println(" ");
	}





	private static double calculoMonto(int nro_Paq, int cant_Pasajeros) {
		double monto = 0;
		switch (nro_Paq){
		case NRO_PAQ1: monto = PRECIO_PAQ1 * cant_Pasajeros;
		break;
		case NRO_PAQ2: monto = PRECIO_PAQ2 * cant_Pasajeros;
		break;
		case NRO_PAQ3: monto = PRECIO_PAQ3 * cant_Pasajeros;
		break;
		case NRO_PAQ4: monto = PRECIO_PAQ4 * cant_Pasajeros;
		break;
			
		}
		
		return monto;
	}





	private static int validoPositivo(String leyenda, String error) {
		int cant = 0;
		System.out.println(leyenda);
		cant = input.nextInt();
		input.nextLine();
		while (cant < 0){
			System.out.println(error);
			System.out.println(leyenda);
			cant = input.nextInt();
			input.nextLine();
		}
		return cant;
	}


	private static String validoTxt(String leyenda) {
		String rta;
		rta = input.nextLine();
		while (rta.equals("")){
			System.out.println(leyenda);
			System.out.println(MSJINGPASJ);
			rta = input.nextLine();
		}
		return rta;
	}

	private static int validoEntero(int minimo, int maximo, String leyenda, String error) {
		int ingreso = 0;
		ingreso = input.nextInt();
		input.nextLine();
		while (ingreso < minimo || ingreso > maximo){
			System.out.println(error);
			System.out.println(leyenda);
			ingreso = input.nextInt();	
			input.nextLine();
		}
		return ingreso;
	}

	private static void muestroDestinos() {
		System.out.println(MSJDESTINOS);
		System.out.println(NRO_PAQ1 + " - " + NOM_PAQ1 + "($" + PRECIO_PAQ1 + ")");
		System.out.println(NRO_PAQ2 + " - " + NOM_PAQ2 + "($" + PRECIO_PAQ2 + ")");				
		System.out.println(NRO_PAQ3 + " - " + NOM_PAQ3 + "($" + PRECIO_PAQ3 + ")");
		System.out.println(NRO_PAQ4 + " - " + NOM_PAQ4 + "($" + PRECIO_PAQ4 + ")");
		System.out.println(FIN + " - " + MSJFIN);
		System.out.println(MSJPROMO + PAQ_EN_PROMO);
	}

}
