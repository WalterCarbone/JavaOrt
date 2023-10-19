package Ejemplo_parcial;
import java.util.Scanner;


public class Ejemplo_Monotributo {
	private static Scanner input=new Scanner(System.in);
	public static final String COD_NAC="ARGEN";
	public static final int EDAD_MIN = 18;
	public static final int EDAD_MAX = 65;
	public static final int REC_MIN = 2;
	public static final String CAT1 ="A";
	public static final String CAT2="B";
	public static final int FINAL = 0;
	
	//MENSAJES
	public static final String BIENVENIDA = " *** SISTEMA IFE ***";
	public static final String MSJ_ING_CUIT ="Ingrese el número de CUIT (" + FINAL + " para salir) : ";
	public static final String MSJ_ING_NAC="Ingrese la nacionalidad : ";
	public static final String MSJ_ANOS_REC="Ingrese los años de recidiencia : ";
	public static final String MSJ_ING_EDAD ="Ingrese la edad : ";
	
	public static void main(String[] args) {
		int cuit;
		String nac;
		int anos_rec;
		int edad;
		String categ;
		boolean preAprob;
		int contSolic;
		int edadMenor;
		int codigo;
		int contAprob;
		
		cuit=0;
		anos_rec=0;
		edad=0;
		preAprob=false;
		contSolic=0;
		edadMenor=Integer.MAX_VALUE;
		codigo = 9;
		contAprob =0;
		
		System.out.println(BIENVENIDA);
		cuit = ingreseNumero(MSJ_ING_CUIT);
		while (cuit != FINAL){
		
		nac = ingreseTexto(MSJ_ING_NAC);
		anos_rec = ingreseNumero(MSJ_ANOS_REC);
		edad = ingreseNumero(MSJ_ING_EDAD);
		categ = getCateg(cuit);
		//System.out.println("CATEG " + categ);
		preAprob= Afip(cuit);
		//System.out.println("PREAPROB " + preAprob);
		codigo = Aprobado(categ,preAprob,nac,anos_rec,edad);
		contSolic++;
		if (codigo ==0){
			contAprob++;
			if (edad <edadMenor){
				edadMenor = edad;
			}
		}
		muestroResultado(codigo);
		cuit = ingreseNumero(MSJ_ING_CUIT);
		}
		if (contSolic >0){
			muestroPorcentajes(contAprob,contSolic);
			if(contAprob>0)
			muestroMenorEdad(edadMenor);
		}else{
		System.out.println("No se registraron solicitudes");
		}
	input.close();	
	}

	
	
	private static void muestroMenorEdad(int edadMenor) {
		System.out.println("La edad menosr de las solicitudes aprobadas fue " + edadMenor + " años.");
		
	}



	private static void muestroPorcentajes(int contAprob, int contSolic) {
		double porc =0;
		porc = contAprob*100 /contSolic;
		System.out.println("El porcentaje de solicitudes aprobadas fue del " + porc + "%.");
	}



	private static void muestroResultado(int codigo) {
		String msj ="Su solicitud fue ";
		switch (codigo){
		case 0:
			System.out.println(msj + "APROBADA");
		break;
		case 1:
			System.out.println(msj + "DENEGADA por ser la categoría errónea.");
		break;
		case 2:
			System.out.println(msj + "DENEGADA por no ser pre-aprobado por AFIP.");
		break;
		case 3:
			System.out.println(msj + "DENEGADA por no tener la residencia suficiente.");
		break;
		case 4:
			System.out.println(msj + "DENEGADA por estar la edad fuera de rango.");
	}
	}	
		


	private static int Aprobado(String categ, boolean preAprob, String nac, int anos_rec, int edad) {
		int ret = 9;
		if(!categ.equals(CAT1)&& !categ.equals(CAT2)){
			ret = 1;
		}else if (preAprob == false){
			ret = 2;
		}else if (!nac.equals(COD_NAC) && anos_rec<=REC_MIN){
			ret = 3;
		}else if (edad<EDAD_MIN || edad>EDAD_MAX){
			ret = 4;
		}else {
			ret = 0;
		}
		
		return ret;
	}



	private static boolean Afip(int cuit) {
		boolean ret =false;
		int rest = 0;
		rest = cuit%2;
		if (rest==0){
			ret = true;
		}
				
		return ret;
	}



	private static String getCateg(int cuit) {
		String categ;
		int rest =0;
		rest = cuit%4;
		switch (rest){
		case 0: 
			categ="A";
		break;
		case 1:
			categ="B";
		break;
		case 2:
			categ="C";
		break;
		default :
			categ="D";
		}
		return categ;
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
