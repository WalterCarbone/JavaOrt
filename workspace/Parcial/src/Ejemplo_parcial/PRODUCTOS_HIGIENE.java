package Ejemplo_parcial;
import java.util.Scanner;



public class PRODUCTOS_HIGIENE {
	private static Scanner input=new Scanner(System.in);
	
	private static final int COD_1 = 1;
	private static final String NOM_1 ="Barbijo descartable";
	private static final double PRECIO_1 = 50;
	private static final int COD_2 = 2;
	private static final String NOM_2 ="Barbijo reutilizable";
	private static final double PRECIO_2 = 150;
	private static final int COD_3 = 3;
	private static final String NOM_3 ="Máscara facial protectora";
	private static final double PRECIO_3 = 100;
	private static final int COD_4 = 4;
	private static final String NOM_4 ="Alcohol en gel de 500ml";
	private static final double PRECIO_4 = 200;
	public static final int FIN =0;
	public static double COSTO_ENVIO = 100;
	public static double ENVIO_LIBRE = 2000;
	public static double MIN_BONIF = 4000;
	public static int DESCUENTO = 5;
	public static String ING_S="s";
	public static String ING_N="n";
	public static int PROD_MIN=1;
	public static int PROD_MAX=10;

	
	// MENSAJES
	public static final String BIENVENIDA = "***************************************\n"
											+"Hola, bienvenida/o al sistema de ventas\n"
											+"***************************************\n";
	public static final String MSJ_CARGA ="¿Desea cargar una nueva venta ["+ING_S+"/"+ING_N+"]? :"; 
	public static final String MSJ_MENU="Listado de productos\n"
									   +"--------------------\n"
										+COD_1 + " - " + NOM_1 + ": $" + PRECIO_1+"\n"
										+COD_2 + " - " + NOM_2 + ": $" + PRECIO_2+"\n"
										+COD_3 + " - " + NOM_3 + ": $" + PRECIO_3+"\n"
										+COD_4 + " - " + NOM_4 + ": $" + PRECIO_4+"\n"
										+FIN + " - Termina la carga de la venta.\n"
										+"Ingrese el código de producto :";
	public static final String MSJ_CANT="Ingrese la cantidad del producto (entre "+PROD_MIN+" y " + PROD_MAX +") :";
	
	public static final String MSJ_ERROR="Error. Dato ingresado inválido.";
	
	
	
	public static void main(String[] args) {
	String carga;
	double factDiaria;
	int cant;
	int contVentas;
	int codigo;
	int contVtasSinPromo;
	double impBrutoMasCara;
	int cantVtasMasCara;
	double envio;
	double montoVta;
	double desc;
	double anterior;
	factDiaria =0;
	contVentas=0;
	contVtasSinPromo=0;
	impBrutoMasCara=0;
	cantVtasMasCara=0;
	montoVta=0;
	codigo=0;
	cant=0;
	envio=0;
	desc=0;
	anterior =0;
	
	System.out.println(BIENVENIDA);
	
	carga=validoCarga();
	
	while (carga.equals(ING_S)){
		codigo = validoCodigo();
		while (codigo!=FIN){
			cant= ingreseNumeroMinMax(MSJ_CANT,PROD_MIN,PROD_MAX);
			montoVta = montoVta+obtengoVenta(codigo,cant);
			codigo = validoCodigo();
		}
		if (montoVta<=ENVIO_LIBRE){
			envio = COSTO_ENVIO;
		}else{
			envio =0;
		}
		if (montoVta>MIN_BONIF){
			desc = ((montoVta*DESCUENTO)/100)*(-1);
		}else {
			contVtasSinPromo++;
		}
		muestroResumenCompra(montoVta,envio,desc);
		factDiaria=factDiaria + montoVta;
		contVentas++;
		if (montoVta==impBrutoMasCara){
			cantVtasMasCara++;
		} else if (montoVta>impBrutoMasCara){
			impBrutoMasCara = montoVta;
			cantVtasMasCara =0;
			cantVtasMasCara ++;
			
		}
		carga=validoCarga();
	}
	
	if (contVentas >0){
		muestroTotalDia(factDiaria);
		muestroPromedioVta(factDiaria,contVentas);
		muestroPorcVtasSinPromo(contVtasSinPromo,contVentas);
		muestroMasCara(impBrutoMasCara,cantVtasMasCara);
	}else{
		System.out.println("No se registraron ventas");
	}
	input.close();
	}
	
	private static void muestroMasCara(double impBrutoMasCara, int cantVtasMasCara) {
		System.out.println("Mayor importe bruto :$" + impBrutoMasCara);
		System.out.println("Cantidad de veces que se dio ese importe :" + cantVtasMasCara);
		
	}

	private static void muestroPorcVtasSinPromo(int contVtasSinPromo, int contVentas) {
		double porc =0;
		porc = contVtasSinPromo *100/contVentas;
		System.out.println("Porcentaje de ventas sin promociones :" + porc + "%");
	}

	private static void muestroPromedioVta(double factDiaria, int contVentas) {
		double prom=0;
		prom =(factDiaria/contVentas);
		System.out.println("El importe promedio por venta es $" + prom);
	}

	private static void muestroTotalDia(double factDiaria) {
		System.out.println("El total facturado diario en el día es $" + factDiaria);
		
	}

	private static void muestroResumenCompra(double montoVta, double envio, double desc) {
		double total=0;
		String env;
		if (envio==0){
			env="BONIFICADO";
		}else {
			env="$"+String.valueOf(envio);
		}
		total = montoVta + desc;
		System.out.println("\nRESUMEN DE DE COMPRA :\n");
		System.out.println("Importe bruto : $" + montoVta);
		System.out.println("El costo de envío es :" + env);
		System.out.println("Descuentos aplicados : $" + desc);
		System.out.println("IMPORTE TOTAL DE LA VENTA $" + (montoVta+envio+desc));
		
		
	}

	private static String validoCarga() {
		String rta;
		rta = ingreseTexto(MSJ_CARGA);
		while(!rta.equals(ING_S)&& !rta.equals(ING_N)){
			System.out.println(MSJ_ERROR);
			rta=ingreseTexto(MSJ_CARGA);
		}
		return rta;
	}

	private static int validoCodigo() {
		int cod=0;
		cod = ingreseNumero(MSJ_MENU);
		while (cod!=COD_1 && cod!=COD_2 && cod!=COD_3 && cod!=COD_4 && cod!=FIN){
			System.out.println(MSJ_ERROR);
			cod = ingreseNumero(MSJ_MENU);
		}
		
		return cod;
	}

	private static double obtengoVenta(int codigo, int cant) {
		double vta=0;
		switch(codigo){
		case COD_1:
			vta = PRECIO_1 * cant;
			break;
		case COD_2:
			vta = PRECIO_2 * cant;
			break;
		case COD_3:
			vta = PRECIO_3 * cant;
			break;
		case COD_4:
			vta = PRECIO_4 * cant;
			break;
		}
		return vta;
	}

	private static int ingreseNumeroMinMax(String msj, int min, int max) {
		int num=0;
		System.out.println(msj);
		num = input.nextInt();
		input.nextLine();
		while (num < min || num > max){
			System.out.println(MSJ_ERROR);
			System.out.println(msj);
			num = input.nextInt();
			input.nextLine();
		}
		return num;
	}


	
	
	public static int ingreseNumero(String msj){
		int num;
		System.out.println(msj);
		num = input.nextInt();
		input.nextLine();
		return num;
	}
	
	public static String ingreseTexto(String msj){
		String texto;
		do{
			System.out.println(msj);
			texto = input.nextLine().toLowerCase();
		}while(texto.equals(""));
		
		return texto;
	}

}
