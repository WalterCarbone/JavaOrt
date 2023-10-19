package trabajo_practico2;
import java.util.Scanner;

public class Ejercicio15 {
	private static Scanner input=new Scanner(System.in);
	// CONSTANTES //
	public static final int PISO = 10001;
	public static final int TECHO = 99999;
	public static final int FIN = 0;
	public static final int PISODUR = 0;
	public static final int CORTELLAMADAMENOR = 6;
	public static final char TIPO1 ='a';
	public static final char TIPO2 ='b';
	public static final char TIPO3 ='c';
	public static final double PRECIOMINUTOA = 2; // en Pesos
	public static final double PRECIOMINUTO1B = 5; // en Pesos
	public static final double PRECIOMINUTO2B = 1.5; // en Pesos
	public static final int TOPEMINUTOSPRECIOB = 5; // en minutos
	public static final double PRECIOMINUTOC = 1 ; // en pesos
	public static final double  PRECIOMAXC= 10 ; // en pesos
	//MENSAJES
	public static final String MSJINGRESOCLI = "Ingrese el código de cliente ";
	public static final String MSJINGRESOABONO = "Ingrese el tipo de abono ";
	public static final String MSJINGRESODUR = "Ingrese la duración de la llamada";
	public static final String MSJERROR = "Error. Dato ingresado inválido.";
	public static final String MSJSALIDA = "Fin de proceso.";
	public static final String MSJTOTALACUM = "El importe recaudado por el abono ";
	public static final String MSJLLAMLARGA = "La duración en minutos de la llamada más larga fue de ";
	public static final String MSJLLAMMENORCORTE = "La cantidad de llamadas de menos de ";
	public static final String MSJPROMEDIO = "El precio promedio por llamada fue de $";
	
	public static void main(String[] args) {
		double acumuladoTipo1;
		double acumuladoTipo2;
		double acumuladoTipo3;
		int llamadaMasLarga;
		int cantLlamadasMenorCorte;
		int contadorLlamada;
		int codCli;
		int duracion;
		char abono;
		
		acumuladoTipo1 = 0;
		acumuladoTipo2 = 0;
		acumuladoTipo3 = 0;
		llamadaMasLarga = 0;
		cantLlamadasMenorCorte = 0;
		contadorLlamada = 0;
		codCli = 0;
		duracion = 0;
		
		
		codCli = validoEnt(PISO,TECHO,FIN,MSJINGRESOCLI,MSJERROR);
		
		while (codCli!=FIN){
			duracion = validoEntMayorCero(PISODUR,MSJINGRESODUR,MSJERROR);
			abono = validoChar (TIPO1,TIPO2,TIPO3, MSJINGRESOABONO,MSJERROR);
		switch(abono){
		case TIPO1 : acumuladoTipo1 = acumuladoTipo1+ (duracion * PRECIOMINUTOA);
					 break;
		case TIPO2 : if (duracion>TOPEMINUTOSPRECIOB){
					 	acumuladoTipo2 = acumuladoTipo2 + (duracion * PRECIOMINUTO1B);	
					 }
					else{
						acumuladoTipo2 = acumuladoTipo2 + (duracion * PRECIOMINUTO2B);
					}
					break;
		case TIPO3 : if ((duracion*PRECIOMINUTOC) > PRECIOMAXC){
						acumuladoTipo3 = acumuladoTipo3 + PRECIOMAXC;
					}
					else{
						acumuladoTipo3 = acumuladoTipo3 + (duracion * PRECIOMINUTOC);		
					}
					break;
		}
		
		if (duracion > llamadaMasLarga){
			llamadaMasLarga = duracion;
		}
		
		if (duracion < CORTELLAMADAMENOR){
			cantLlamadasMenorCorte++;
		}
		
		contadorLlamada ++;
		codCli = validoEnt(PISO,TECHO,FIN,MSJINGRESOCLI,MSJERROR);
		
		}
		
		if (contadorLlamada == 0){
			System.out.println(MSJSALIDA);
		}
		
	//SALIDAS
		muestroAcumuladoporTipo(TIPO1,TIPO2, TIPO3, acumuladoTipo1,acumuladoTipo2,acumuladoTipo3,MSJTOTALACUM);
		muestroLlamadaMasLarga(MSJLLAMLARGA,llamadaMasLarga);
		muestroCantMenorCorte(cantLlamadasMenorCorte,MSJLLAMMENORCORTE,CORTELLAMADAMENOR);
		muestroPrecioPromedio(acumuladoTipo1+acumuladoTipo2+acumuladoTipo3,contadorLlamada,MSJPROMEDIO);
		
		
		
		
		

	input.close();	
	}


	private static void muestroPrecioPromedio(double d, int contadorLlamada, String msjpromedio2) {
		// TODO Auto-generated method stub
		double prom = 0;
		prom = (double) d / contadorLlamada;
		System.out.println(msjpromedio2 + prom);
	}


	private static void muestroCantMenorCorte(int cantLlamadasMenorCorte, String msjllammenorcorte2,
			int cortellamadamenor2) {
	System.out.println(msjllammenorcorte2 + cortellamadamenor2 + " minutos fue :"+cantLlamadasMenorCorte);
	}


	private static void muestroLlamadaMasLarga(String msjllamlarga2, int llamadaMasLarga) {
		System.out.println(msjllamlarga2 + llamadaMasLarga);
	}


	private static void muestroAcumuladoporTipo(char tipo12, char tipo22, char tipo32, double acumuladoTipo1,
			double acumuladoTipo2, double acumuladoTipo3, String msjtotalacum2) {
		System.out.println(msjtotalacum2 + tipo12 + " fue $" + acumuladoTipo1);
		System.out.println(msjtotalacum2 + tipo22 + " fue $" + acumuladoTipo2);
		System.out.println(msjtotalacum2 + tipo32 + " fue $" + acumuladoTipo3);		
	}


	private static char validoChar(char tipo12, char tipo22, char tipo32, String msjingresoabono2, String msjerror2) {
		char ab;
		System.out.println(msjingresoabono2 +"("+tipo12+"/"+tipo22+"/"+tipo32+") :");
		ab= Character.toLowerCase(input.next().charAt(0));
		while(ab!=tipo12 && ab!=tipo22 && ab!=tipo32){
			System.out.println(msjerror2);
			System.out.println(msjingresoabono2 +"("+tipo12+"/"+tipo22+"/"+tipo32+") :");
			ab= Character.toLowerCase(input.next().charAt(0));
		}
		return ab;
	}


	private static int validoEntMayorCero(int pisodur2, String msjingresodur2, String msjerror2) {
		int dur;
		dur = 0;
		System.out.println(msjingresodur2+" (mayor a "+pisodur2+") : ");
		dur = input.nextInt();
		while (dur <= pisodur2){
			System.out.println(msjerror2);
			System.out.println(msjingresodur2+" (mayor a "+pisodur2+") : ");
			dur = input.nextInt();
		}
		return dur;
	}


	private static int validoEnt(int piso2, int techo2, int fin2, String msjingresocli2, String msjerror2) {
		int codCli = 0;
		
		System.out.println(msjingresocli2 + "("+piso2+"-"+techo2+").Para finalizar ingrese '"+fin2+"' :");
		codCli = input.nextInt();
		while ((codCli<piso2 || codCli>techo2) && codCli != fin2){
			System.out.println(msjerror2);
			System.out.println(msjingresocli2 + "(entre "+piso2+" y "+techo2+"). Para finalizar ingrese '"+fin2+"' :");
			codCli = input.nextInt();
		}
		return codCli;
	}


}
