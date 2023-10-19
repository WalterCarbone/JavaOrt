package Ejemplo_parcial;
import java.util.Scanner;



public class Aseguradora {
	private static Scanner input=new Scanner(System.in);
	public static final char COD_AUTO ='A';
	public static final String NOM_AUTO="Auto";
	public static final double COSTO_AUTO = 1000;
	public static final char COD_CAM ='C';
	public static final String NOM_CAM="Camioneta";
	public static final double COSTO_CAM = 1500;
	public static final char COD_MOTO ='M';
	public static final String NOM_MOTO="Moto";
	public static final double COSTO_MOTO = 800;
	public static final int ANT_MIN = 0;
	public static final int ANT_MAX = 30;
	public static final int RECARGO = 5;
	public static final int MIN_VEH=2;
	public static final int MAX_VEH=10;
	public static final int ANT_MAYOR = 5;
	
	
	//MENSAJES
	public static final String BIENVENIDA = "Bienvenido al sistemas de Seguros Lolita";
	public static final String MSJ_ING ="Ingrese la cantidad de vehículos a ingresara (entre  " + MIN_VEH + " y " + MAX_VEH +") : ";
	public static final String MSJ_NOMBRE ="Ingrese el nombre del cliente : ";
	public static final String MSJ_ERROR ="Error. Dato ingresado inválido.";
	public static final String MSJ_ANTIG="Ingrese la antigüedad del vehículo (entre " + ANT_MIN + " y " + ANT_MAX +" años) : ";
	public static final String MSJ_TIPO="** Tipos de vahículos *** \n"
										+COD_AUTO + "-"+NOM_AUTO+ " Costo $" + COSTO_AUTO+"\n"
										+COD_CAM + "-"+NOM_CAM+ " Costo $" + COSTO_CAM+"\n"
										+COD_MOTO + "-"+NOM_MOTO+ " Costo $" + COSTO_MOTO+"\n"
										+"Ingrese tipo de vehículo :";
	
	
	public static void main(String[] args) {
		String nombre;
		int vehiculos;
		double costoMensual;
		int contVehic;
		int contCam;
		int antig;
		int antigProm;
		char tipoVehic;
		double vehicMayorCosto;
		char vehicMayorTipo;
		int vehicMayorAnos;
		double precio;
		int totalVehiculos;
		
		totalVehiculos=0;
		antigProm=0;
		precio =0;
		vehiculos =0;
		costoMensual = 0;
		contVehic =0;
		contCam = 0;
		antig = 0;
		vehicMayorCosto = Integer.MIN_VALUE;
		vehicMayorAnos = Integer.MIN_VALUE;
		vehicMayorTipo='z';
		
		System.out.println(BIENVENIDA);
		nombre = ingreseTexto(MSJ_NOMBRE);
		vehiculos = ingreseNumero(MSJ_ING);
		while(vehiculos<MIN_VEH || vehiculos>MAX_VEH){
			System.out.println(MSJ_ERROR);
			vehiculos = ingreseNumero(MSJ_ING);
		}
		for (int i=1;i<vehiculos+1;i++){
			System.out.println("Vehículo N°" + i);
			tipoVehic = ingreseChar(MSJ_TIPO);	
			antig = ingreseNumero(MSJ_ANTIG);
			while (antig< ANT_MIN || antig>ANT_MAX){
				System.out.println(MSJ_ERROR);
				antig = ingreseNumero(MSJ_ANTIG);
				}
			
						
			precio = obtengoPrecio(tipoVehic,antig);
			costoMensual = costoMensual + precio;
			if (antig > ANT_MAYOR){
				contVehic++;
			}
			if (tipoVehic =='C'){
				contCam++;
			}
			antigProm=antigProm+antig;
			if (precio>vehicMayorCosto){
				vehicMayorCosto = precio;
				vehicMayorTipo=tipoVehic;
				vehicMayorAnos=antig;
			}
			totalVehiculos++;
		}
		muestroResultados(nombre,costoMensual,contVehic,contCam,antigProm,vehicMayorCosto,vehicMayorTipo,vehicMayorAnos,totalVehiculos);
		
	input.close();	
	}

	
	
	
	private static void muestroResultados(String nombre, double costoMensual, int contVehic, int contCam, int antigProm,
			double vehicMayorCosto, char vehicMayorTipo, int vehicMayorAnos, int totalVehiculos) {
		double porc =0;
		int ant =0;
		String nom;
		ant = antigProm/totalVehiculos;
		porc =contCam*100/totalVehiculos;
		nom = obtengoNombre(vehicMayorTipo);
		System.out.println("Empresa : " + nombre);
		System.out.println("Costo mensual a abonar $" + costoMensual);
		System.out.println("La cantidad de vehículos cuya antigüedad es mayor a " + ANT_MAYOR + " años es :" + contVehic);
		System.out.println("El porcentaje de camionetas es "+ porc + "%");
		System.out.println("La antigüedad promedio de todos los vehículos es " + ant + " años.");
		System.out.println("El vehículo más costoso es " + nom + " .Cuyo costo es $" + vehicMayorCosto + " y su antigüedad es " + vehicMayorAnos + " años.");
		
		
		
	}




	private static String obtengoNombre(char vehicMayorTipo) {
		String nom;
		nom ="";
		switch(vehicMayorTipo){
		case 'A':
			nom ="Auto";
			break;
		case 'C':
			nom = "Camioneta";
			break;
		case 'M':
			nom = "Moto";
			break;
		}
		return nom;
	}




	private static double obtengoPrecio(char tipoVehic, int antig) {
		double precio=0;
		switch(tipoVehic){
			case 'A':
				precio = COSTO_AUTO + (COSTO_AUTO * RECARGO * antig)/100;
				break;
			case 'C':
				precio = COSTO_CAM +(COSTO_CAM * RECARGO *antig)/100;
				break;
			case 'M':
				precio = COSTO_MOTO +(COSTO_MOTO * RECARGO * antig)/100;
		}
		return precio;
	}


	private static char ingreseChar(String msj) {
		char txt;
		System.out.println(msj);
		txt = Character.toUpperCase(input.next().charAt(0));
		while (txt!=COD_AUTO && txt!=COD_CAM && txt!=COD_MOTO){
			System.out.println(MSJ_ERROR);
			System.out.println(msj);
			txt = Character.toUpperCase(input.next().charAt(0));
			
		}
		
		
		return txt;
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
			texto = input.nextLine(); // OJO!!! TODO A MAYUSCULAS
		}while(texto.equals(""));
		
		return texto;
	}
	
	
}
