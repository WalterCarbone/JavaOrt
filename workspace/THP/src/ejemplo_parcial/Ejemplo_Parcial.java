package ejemplo_parcial;
import java.util.Scanner;


public class Ejemplo_Parcial {
private static Scanner input=new Scanner(System.in);
// DEFINICION DE CONSTANTES QUE ME DAN
public static final int FINDIA = 0;
public static final int MINVENTA = 1;
public static final char CIERREVENTA = 'n';
public static final String PROD1 = "medialuna";
public static final String PROD2 = "chipa";
public static final String PROD3 = "rosca";
public static final String PROD4 = "alfajor";
public static double PRECIO1 = 30;
public static double PRECIO2 = 50;
public static double PRECIO3 = 350;
public static double PRECIO4 = 70;


// MENSAJES 
public static final String MSJBIENV = "Bienvendido!";
public static final String MSJLISTAPRECIOS = "Los producto ofrecidos son :";
public static final String MSJINGRESO = "Ingrese el DNI del cliente. Para terminar ingrese  ";
public static final String MSJINGPROD = "Ingrese producto : ";
public static final String MSJINGCANT = "Ingrese cantidad : ";
public static final String MSJERROR = "ERROR.Dato inválido";
public static final String MSJCONTINUAVTA ="¿Desea cargar otro producto (s/n) :";
public static final String MSJCIERREVTA = "El importe total de la compra es :$";
public static final String MSJINGFIN = "Ingreso finalizado";
public static final String MSJTOTALVTAS = "Cantidad de ventas realizadas en el dia :";
public static final String MSJRECDIARIA = "Recaudacion total diaria :$";
public static final String MSJPROM = "Venta promedio";
public static final String MSJMEJORCPA = "Importe y DNI cliente mejor compra : $";

public static void main(String[] args) {
	
// DEFINICION DE VARIABLES e INICIALIZACION
	int dni;
	int ingreso;
	int cantUnidades;
	int contVtas;
	double totalVta;
	double ventaProm;
	double mayorImporte;
	int dniMayorImporte;
	double recaudacion;
	String prod;
	char rta;
	
	dni = 0;
	ingreso = 0;
	cantUnidades = 0;
	contVtas = 0;
	totalVta = 0;
	ventaProm = 0;
	mayorImporte = 0;
	dniMayorImporte = 0;
	recaudacion =0;
	muestrError(dni);
	
	System.out.println(MSJBIENV);
	System.out.println(MSJINGRESO + FINDIA + " : ");
	
	ingreso = input.nextInt();
	dni = validoEnteroMayCero(ingreso,MSJINGRESO,FINDIA,MSJERROR);
	input.nextLine();

	while (dni != 0){
		muestroProductos(MSJLISTAPRECIOS,PROD1,PRECIO1,PROD2,PRECIO2,PROD3,PRECIO3,PROD4,PRECIO4);
		
		do{
		prod=validoProducto(MSJINGPROD,MSJINGCANT,MSJERROR,PROD1,PROD2,PROD3,PROD4);
		cantUnidades = validoEntero(MINVENTA,MSJINGCANT,MSJERROR);
		switch(prod){
		case PROD1:
			totalVta =totalVta+  calculoVenta(cantUnidades,PRECIO1);
			break;
		case PROD2:
			totalVta = totalVta + calculoVenta(cantUnidades,PRECIO2);
			break;
		case PROD3:
			totalVta = totalVta + calculoVenta(cantUnidades,PRECIO3);
			break;
		case PROD4:
			totalVta = totalVta + calculoVenta(cantUnidades,PRECIO4);
			break;
		}
		
				
		if (totalVta > mayorImporte){
			mayorImporte = totalVta;
			dniMayorImporte = dni;
			
		}
		System.out.println(MSJCONTINUAVTA);
		rta =Character.toLowerCase(input.next().charAt(0));
		input.nextLine();
		}while( rta!=CIERREVENTA);
		
		contVtas ++;
		recaudacion = recaudacion+ totalVta;
		imprimoVta(MSJCIERREVTA,totalVta);
		totalVta =0;
		System.out.println(MSJINGRESO + FINDIA + " : ");
		ingreso = input.nextInt();
		dni = validoEnteroMayCero(ingreso,MSJINGRESO,FINDIA,MSJERROR);
		input.nextLine();
	}
	
	System.out.println(MSJINGFIN);
	muestroCantVtas(MSJTOTALVTAS,contVtas);
	muestroRecDiaria(MSJRECDIARIA,recaudacion);
	muestroPromDiario(MSJPROM, contVtas,recaudacion);
	muestroMejorCompra(MSJMEJORCPA,mayorImporte,dniMayorImporte);
	
	
	
	
	input.close();
	}








private static void muestrError(int dni) {
	System.out.println(PROD4);
}








private static void muestroMejorCompra(String msjmejorcpa2, double mayorImporte, int dniMayorImporte) {
System.out.println(msjmejorcpa2 + mayorImporte + " - " + dniMayorImporte);
	
}



private static void muestroPromDiario(String msjprom2, int contVtas, double recaudacion) {
	double prom;
	prom = (recaudacion/contVtas);
	System.out.println(msjprom2 + prom);
}



private static void muestroRecDiaria(String msjrecdiaria2, double recaudacion) {
	System.out.println(msjrecdiaria2 + recaudacion);
	
}


private static void muestroCantVtas(String msjtotalvtas2, int contVtas) {
	System.out.println(msjtotalvtas2 + contVtas);
	
}


private static void imprimoVta(String msjcierrevta2, double totalVta) {
System.out.println(msjcierrevta2 + totalVta);
}




private static double calculoVenta(int cantUnidades, double precio) {
	double vta = 0;
	vta = cantUnidades * precio;
	return vta;
}



private static int validoEntero(int minventa, String msjingcant, String msjerror) {
	int cantidad = 0;
	System.out.println(msjingcant);
	cantidad = input.nextInt();
	input.nextLine();
	while(cantidad <minventa){
		System.out.println(msjerror);
		System.out.println(msjingcant);
		cantidad = input.nextInt();
		input.nextLine();
	}
	return cantidad;
}


private static String validoProducto(String msjingprod, String msjingcant, String msjerror, String prod1,
		String prod2, String prod3, String prod4) {
	String prod;
	System.out.println(msjingprod);
	prod=input.nextLine();
	while (!prod.equals(prod1) && !prod.equals(prod2) && !prod.equals(prod3) && !prod.equals(prod4)){
		System.out.println(msjerror);
		System.out.println(msjingprod);
		prod=input.nextLine();
	}
	
	return prod;
}




private static void muestroProductos(String msjlistaprecios, String prod1, double precio1, String prod2,
		double precio2, String prod3, double precio3, String prod4, double precio4) {
	System.out.println(msjlistaprecios);
	System.out.println(prod1 + "  " + "$" + precio1 );
	System.out.println(prod2 + "  " + "$" + precio2 );
	System.out.println(prod3 + "  " + "$" + precio3 );
	System.out.println(prod4 + "  " + "$" + precio4 );
	
}



private static int validoEnteroMayCero(int ingreso, String msjingreso, int findia, String msjerror) {
	while (ingreso<0){
		
		System.out.println(msjerror);
		System.out.println(MSJINGRESO + FINDIA + " : ");
		ingreso = input.nextInt();
	}
	return ingreso;
}

}
