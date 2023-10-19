package trabajo_practico2;
import java.util.Scanner;


public class Ejercicio10 {
private static Scanner input=new Scanner(System.in);
public static final int FIN=0;
public static final int PISO=0;
public static final int TECHO=60;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int hora=0;
int minuto=0;
int segundo=0;
int numCorred=0;
int cantCorred =0;
double sumSeg=0;
int cantMenorHora=0;
int totalSeg=0;
double mejorTiempo=999999999;
int mejorCorred=0;
int horaSeg = 3600;


System.out.println("Ingrese número de corredor (" + FIN + " para terminar): ");
numCorred= input.nextInt();
while (numCorred != 0){
	System.out.println("Ingrese las horas del corredor N° "+ numCorred +" (mayor a "+ PISO +") :");
	hora=input.nextInt();
	System.out.println("Ingrese los minutos del corredor N° "+ numCorred +" (entre "+ PISO +" y "+TECHO+") :");
	minuto=input.nextInt();
	System.out.println("Ingrese los segundos del corredor N° "+ numCorred +" (entre "+ PISO +" y "+TECHO+") :");
	segundo=input.nextInt();
	
	totalSeg=devolverSegundos(hora,minuto,segundo);
	if (totalSeg < mejorTiempo){
		mejorTiempo = totalSeg;
		mejorCorred = numCorred;
	}
	
	sumSeg=sumSeg + totalSeg;
	
	if (totalSeg<horaSeg ){
		cantMenorHora++;
	}
	
	cantCorred++;
	totalSeg = 0;
	
	System.out.println("Ingrese número de corredor (" + FIN + " para terminar): ");
	numCorred= input.nextInt();
	
}

if (cantCorred !=0){
	muestroGanador(mejorCorred);
	muestroPromSeg(sumSeg,cantCorred);
	muestroPorcentaje(cantMenorHora,cantCorred);
	System.out.println("Fin de proceso");
}
	else{
		System.out.println("Fin de proceso");
	}


		
input.close();


	}

	private static void muestroPorcentaje(int cantMenorHora, int cantCorred) {
		// TODO Auto-generated method stub

		double porcent = (cantMenorHora*100  /cantCorred);
		System.out.println("El porcentaje de corredores que realizaron la carrera en menos de una hora, fue del "+ porcent + "%");
	}

	private static void muestroPromSeg(double sumSeg, int cantCorred) {
		double prom=0;
		prom =sumSeg/cantCorred;
		System.out.println("El promedio en segundos de los corredores fue de : " + prom + " segundos.");
	}
	

	private static void muestroGanador(int mejorCorred) {
		// TODO Auto-generated method stub
	System.out.println("El ganador de la carrera fue el corredor N°" + mejorCorred);	
	
	}

	private static int devolverSegundos(int hora, int minuto, int segundo) {
		// TODO Auto-generated method stub
		int totalSegundos=0;
		totalSegundos=segundo+(minuto*60)+(hora*3600);
		return totalSegundos;
	}

}
