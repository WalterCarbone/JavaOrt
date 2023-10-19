package trabajo_practico2;
import java.util.Scanner;


public class Ejercicio9 {
private static Scanner input=new Scanner(System.in);


	public static void main(String[] args) {
	double primero = calculo();
	double segundo = calculo();
	double tercero = calculo();
	double cuarto = calculo();
	double quinto = calculo();
	
	System.out.println(" El promedio del primer grupo es :" + primero);
	System.out.println(" El promedio del segundo grupo es :" + segundo);
	System.out.println(" El promedio del tercer grupo es :" + tercero);	
	System.out.println(" El promedio del cuarto grupo es :" + cuarto);
	System.out.println(" El promedio del quinto grupo es :" + quinto);
	
input.close();	
	}


	private static double calculo() {
		int num1;
		int num2;
		int num3;
		double prom;
		
		System.out.println("Ingrese primer valor entero :");
		num1=input.nextInt();
		System.out.println("Ingrese segundo valor entero :");
		num2=input.nextInt();
		System.out.println("Ingrese tercer valor entero :");
		num3=input.nextInt();

		return (prom = (num1+num2+num3)/3);
	}
	
	}



