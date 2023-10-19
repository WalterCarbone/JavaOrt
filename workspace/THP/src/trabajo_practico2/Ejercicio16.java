package trabajo_practico2;
import java.util.Scanner;




public class Ejercicio16 {
	private static Scanner input=new Scanner(System.in);
	//CONSTANTES
	public static final String OPCION1 = "clasico";
	public static final String OPCION2 = "celiaco";
	public static final String OPCION3 = "kosher";
	public static final String OPCION4 = "light";
	public static final double PRECIO1 = 300;
	public static final double PRECIO2 = 310;
	public static final double PRECIO3 = 430;
	public static final double PRECIO4 = 290;
	public static final double PRECIOBEBIDAS = 30;
	public static final int MINIMO = 0;
	public static final String END= "fin";
	public static char YES = 's';
	public static char NO = 'n';
	
	//MENSAJES
	public static final String BIENVENIDA = "Bienvenido! ¿Desea calcular el precio total del catering para su fiesta? ";
	public static final String MSJERROR = "Ingreso incorrecto.";
	public static final String MSJSALIDA = "Fin de proceso.";
	public static final String MSJERRORQINVITADOS = "Error. Ha ingresado más cantidad de platos que invitados.";
	public static final String MSJQINVITADOS = "Ingrese la cantidad total de invitados :";
	public static final String MSJMENUINVITADOS = "Ingrese la cantidad de invitados que eligieron el menu ";
	public static final String MSJOPCIONES = "Ingrese tipo de menú (";
	
	
	
	public static void main(String[] args) {
	int cantTotalInvitados;
	int cantInvitadosOpcion1;
	int cantInvitadosOpcion2;
	int cantInvitadosOpcion3;
	int cantInvitadosOpcion4;
	int acumuladoInvitados;
	int verificoInvitados;
	char ingreso;
	String menu;
	
	cantTotalInvitados = 0;
	cantInvitadosOpcion1 = 0;
	cantInvitadosOpcion2 = 0;
	cantInvitadosOpcion3 = 0;
	cantInvitadosOpcion4 = 0;
	acumuladoInvitados=0;

	verificoInvitados=0;
	
	ingreso= validoCar(YES,NO,BIENVENIDA,MSJERROR);
	if(ingreso !=NO){
		cantTotalInvitados = validoEntMayorCero(MINIMO,MSJQINVITADOS,MSJERROR);
	menu = validoOpciones(OPCION1,OPCION2,OPCION3,OPCION4,END,MSJOPCIONES,MSJERROR);	
	
	while (!menu.equals(END) && (acumuladoInvitados<cantTotalInvitados)){ 
		switch(menu){
		case OPCION1: 
		verificoInvitados = controlCubiertosMenu(cantTotalInvitados, acumuladoInvitados,MSJMENUINVITADOS,OPCION1,MSJQINVITADOS,MSJERRORQINVITADOS);
		acumuladoInvitados = acumuladoInvitados+verificoInvitados;
		cantInvitadosOpcion1 = cantInvitadosOpcion1+verificoInvitados;
		break;
		case OPCION2:
		verificoInvitados = controlCubiertosMenu(cantTotalInvitados, acumuladoInvitados,MSJMENUINVITADOS,OPCION2,MSJQINVITADOS,MSJERRORQINVITADOS);
		acumuladoInvitados = acumuladoInvitados+verificoInvitados;
		cantInvitadosOpcion2 = cantInvitadosOpcion2+verificoInvitados;
		break;	
		case OPCION3:
		verificoInvitados = controlCubiertosMenu(cantTotalInvitados, acumuladoInvitados,MSJMENUINVITADOS,OPCION3,MSJQINVITADOS,MSJERRORQINVITADOS);
		acumuladoInvitados = acumuladoInvitados+verificoInvitados;
		cantInvitadosOpcion3 = cantInvitadosOpcion3+verificoInvitados;
		break;			 			
		case OPCION4:
		verificoInvitados = controlCubiertosMenu(cantTotalInvitados, acumuladoInvitados,MSJMENUINVITADOS,OPCION4,MSJQINVITADOS,MSJERRORQINVITADOS);
		acumuladoInvitados = acumuladoInvitados+verificoInvitados;
		cantInvitadosOpcion4 = cantInvitadosOpcion4+verificoInvitados;
		break;		
		}		
		menu = validoOpciones(OPCION1,OPCION2,OPCION3,OPCION4,END,MSJOPCIONES,MSJERROR);	
	}
	muestroTotalInvitados(cantTotalInvitados);
	muestroInvitadosporMenu(OPCION1,OPCION2,OPCION3,OPCION4,cantInvitadosOpcion1,cantInvitadosOpcion2,cantInvitadosOpcion3,cantInvitadosOpcion4,PRECIO1,PRECIO2,PRECIO3,PRECIO4);
	muestroCostosTotales(cantInvitadosOpcion1,cantInvitadosOpcion2,cantInvitadosOpcion3,cantInvitadosOpcion4,PRECIO1,PRECIO2,PRECIO3,PRECIO4,PRECIOBEBIDAS);
	System.out.println(MSJSALIDA);
	}
	else{
		System.out.println(MSJSALIDA);
	}

	
	input.close();	
	}
		
		
		





// FUNCION QUE MUESTRA LOS TOTALES
	private static void muestroCostosTotales(int cantInvitadosOpcion1, int cantInvitadosOpcion2,
			int cantInvitadosOpcion3, int cantInvitadosOpcion4, double precio12, double precio22, double precio32,
			double precio42, double preciobebidas2) {
	double bebidas=0;
	double comida =0;
	comida=(cantInvitadosOpcion1 * precio12)+(cantInvitadosOpcion2*precio22)+(cantInvitadosOpcion3*precio32)+(cantInvitadosOpcion4*precio42);
	bebidas = (cantInvitadosOpcion1+cantInvitadosOpcion2+cantInvitadosOpcion3+cantInvitadosOpcion4)*preciobebidas2;
	System.out.println("El costo de comida es de $" + comida);
	System.out.println("El costo de bebida es de $" + bebidas);
	System.out.println("El costo total es de $" + (comida+bebidas));
	
	}









	private static void muestroInvitadosporMenu(String opcion12, String opcion22, String opcion32, String opcion42,
			int cantInvitadosOpcion1, int cantInvitadosOpcion2, int cantInvitadosOpcion3, int cantInvitadosOpcion4,
			double precio12, double precio22, double precio32, double precio42) {
		System.out.println(opcion12 +": " + cantInvitadosOpcion1 + " $"+ precio12);
		System.out.println(opcion22 +": " + cantInvitadosOpcion2 + " $"+ precio22);
		System.out.println(opcion32 +": " + cantInvitadosOpcion3 + " $"+ precio32);
		System.out.println(opcion42 +": " + cantInvitadosOpcion4 + " $"+ precio42);
	}









	private static void muestroTotalInvitados(int cantTotalInvitados) {
		System.out.println("Usted ha invitado "+cantTotalInvitados+ " personas.");
		
	}





	private static int controlCubiertosMenu(int cantTotalInvitados, int acumuladoInvitados,
			String msjmenuinvitados2, String opcion12, String msjqinvitados2, String msjerrorqinvitados2) {
		int invitados = 0;
		System.out.println(msjmenuinvitados2 + opcion12 + " :");
		invitados = input.nextInt();
		input.nextLine();
		while ((acumuladoInvitados+invitados) > cantTotalInvitados){
			System.out.println(msjerrorqinvitados2);
			System.out.println(msjmenuinvitados2 + opcion12 + " :");
			invitados = input.nextInt();
			input.nextLine();
		}
		return invitados;
	}




	private static String validoOpciones(String opcion12, String opcion22, String opcion32, String opcion42,
			String end2, String msjopciones2, String msjerror2) {
		String menu;
		System.out.println(msjopciones2 + opcion12 +"/"+opcion22+"/"+opcion32+"/"+opcion42+")."+end2+" para finalizar) :");
		menu = input.nextLine();
		while(!menu.equals(opcion12) && !menu.equals(opcion22) && !menu.equals(opcion32) && !menu.equals(opcion42) && !menu.equals(end2)){
			System.out.println(msjerror2);
			System.out.println(msjopciones2 + opcion12 +"/"+opcion22+"/"+opcion32+"/"+opcion42+")."+end2+" para finalizar) :");
			menu = input.nextLine();
		}
		
		return menu;
	}


	private static int validoEntMayorCero(int minimo2, String msjqinvitados2, String msjerror2) {
		int total = 0;
		System.out.println(msjqinvitados2);
		total = input.nextInt();
		input.nextLine();
		while (total <= minimo2){
			System.out.println(msjerror2);
			System.out.println(msjqinvitados2);
			total = input.nextInt();
			input.nextLine();
		}
		return total;
	}


	private static char validoCar(char yES2, char nO2, String bienvenida2, String msjerror2) {
		char rta;
		System.out.println(bienvenida2 + "(" + yES2 + "/" + nO2 + ") :");
		rta=Character.toLowerCase(input.next().charAt(0));
			while (rta !=yES2 && rta!=nO2){
			System.out.println(msjerror2);
			System.out.println(bienvenida2 + "(" + yES2 + "/" + nO2 + ") :");
	rta=Character.toLowerCase(input.next().charAt(0));
		}
		return rta;
	}

}
