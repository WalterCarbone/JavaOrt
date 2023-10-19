package Parcial_Walter_Carbone;
import java.util.Scanner;


public class COVID_ORT {
	private static Scanner input=new Scanner(System.in);
	//CONSTANTES
	public static final String SINT1 ="Fiebre";
	public static final String SINT2="Tos";
	public static final String SINT3="Dolor de garganta";
	public static final int EDADCORTE = 40;
	public static final String ING_S="S";
	public static final String ING_N="N";
	public static final int MINDOC=0;
	public static final int MAXEDAD=120;
	public static final int MINEDAD=0;
	public static final int FIN=0;
	
	
	//MENSAJES
	public static final String BIENVENIDA="Bienvenido al sistema COVID-ORT";
	public static final String MSJ_ING_DNI="Por favor ingresar el DNI ( para salir ingrese " + MINDOC +") :";
	public static final String MSJ_ING_EDAD="Por favor ingrese la edad (mayor a " + MINEDAD+") :";
	public static final String MSJ_SINT1="¿Tiene " + SINT1 + "(" + ING_S + "/"+ ING_N + ")? : ";
	public static final String MSJ_SINT2="¿Tiene " + SINT2 + "(" + ING_S + "/"+ ING_N + ")? : ";
	public static final String MSJ_SINT3="¿Tiene " + SINT3 + "(" + ING_S + "/"+ ING_N + ")? : ";
	
	public static final String MSJ_ERROR="Error. Dato ingresado inválido";
	
	public static void main(String[] args) {
		// VARIABLES
		int nroDoc;
		int edad;
		int contPacientes;
		int contPositivos;
		int cantMaxCont;
		int contContacto;
		int contTotalPosit;
		String telef;
		String portador;
		String resp1;
		String resp2;
		String resp3;
		String nomCont;
		
		contTotalPosit=0;
		contContacto=0;
		nroDoc=0;
		edad=0;
		contPacientes=0;
		contPositivos=0;
		cantMaxCont=0;
		
		System.out.println(BIENVENIDA);
			
		nroDoc=validoDoc(MINDOC);
	
		
		while(nroDoc !=FIN){
			
			edad=ingreseNumeroMinMax(MSJ_ING_EDAD,MINEDAD,MAXEDAD);
			resp1= ingreseTexto(MSJ_SINT1);
			resp2= ingreseTexto(MSJ_SINT2);
			resp3= ingreseTexto(MSJ_SINT3);
			portador = posibleCovid(edad,resp1,resp2,resp3);
			
			if (portador.equals("POSITIVO")){
				System.out.println("Ingrese nombre de contacto (deje en blanco si no tiene ninguno) : ");
				nomCont= input.nextLine();
				while (!nomCont.equals("")){
					System.out.println("Ingrese el teléfono del contacto :");
					telef = input.nextLine();
					contContacto++;
					contTotalPosit++;
					System.out.println("Ingrese nombre de contacto (deje en blanco si no tiene ninguno) : ");
					nomCont= input.nextLine();
					
				}
				contPositivos++;
				}
			if (contContacto > cantMaxCont){
				cantMaxCont = contContacto;
			}
			contPacientes++;
			muestroResumen(nroDoc,edad,portador,contContacto);
			contContacto =0;
			nroDoc=validoDoc(MINDOC);
		}
	
	if (contPacientes>0){	
	muestroTotalPacientes(contPacientes);
	muestroPorcPositivos(contPositivos,contPacientes);
	muestroCantMaxContactos(cantMaxCont);
	muestroPromedio(contTotalPosit,contPositivos);
	
	}else {
		System.out.println("No se registraron estudios.");
	}
	
	
	input.close();
	}

	



	private static String posibleCovid(int edad, String resp1, String resp2, String resp3) {
		String resp = "NEGATIVO";
		
		if(edad<=EDADCORTE && resp1.equals(ING_S) ){
			if(resp2.equals(ING_S) || resp3.equals(ING_S)){
			resp = "POSITIVO";
			
		}
		}
			
		if (edad>EDADCORTE){
			
			if(resp1.equals(ING_S) ||  resp2.equals(ING_S) || resp3.equals(ING_S)){
			 resp = "POSITIVO";
		}
		}
			return resp;
	}





	private static void muestroPromedio(int contTotalPosit, int contPositivos) {
		double prom=0;
		prom = contTotalPosit/contPositivos;
		System.out.println("El promedio de contactos por cada positivo es : " + prom);
	}





	private static void muestroCantMaxContactos(int cantMaxCont) {
		System.out.println("La cantidad máxima de contactos informados por un solo paciente : " +cantMaxCont );
		
	}





	private static void muestroPorcPositivos(int contPositivos, int contPacientes) {
		double porc=0;
		porc=contPositivos*100/contPacientes;
		System.out.println("Porcentaje de resultados positivos es :" + porc + "%");
	}





	private static void muestroTotalPacientes(int contPacientes) {
		System.out.println("Total de pacientes testeados :" + contPacientes);
		
	}





	private static int validoDoc(int min) {
		int nro=0;
		System.out.println(MSJ_ING_DNI);
		nro = input.nextInt();
		input.nextLine();
		while(nro<min){
			System.out.println(MSJ_ERROR);
			System.out.println(MSJ_ING_DNI);
			nro = input.nextInt();
			input.nextLine();
		}
		return nro;
	}





	private static void muestroResumen(int nroDoc, int edad, String portador, int contContacto) {
		
		if (portador.equals("POSITIVO")){
			System.out.println("DNI: " + nroDoc + " -- Edad : " + edad + " - POSITIVO. Cantidad de contactos : " + contContacto);
		}else{
			System.out.println("DNI: " + nroDoc + " -- Edad : " + edad + " - NEGATIVO");
		}
		
	}





	public static String ingreseTexto(String msj){
		String texto;
		do{
			System.out.println(msj);
			texto = input.nextLine().toUpperCase();
		}while(texto.equals(""));
		
		return texto;
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
	
}
