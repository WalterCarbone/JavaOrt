package trabajo_practico1;
import java.util.Scanner;

public class Ejercicio7 {
	private static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		
		System.out.println("Ingrese 1er n�mero : ");
		int num1 = input.nextInt();
		
		System.out.println("Ingrese 2do n�mero : ");
		int num2 = input.nextInt();
		
		System.out.println("Ingrese 3er n�mero : ");
		int num3 = input.nextInt();
		
		if (num1>num2 && num1>num3){
			System.out.println("El mayor n�mero es :" + num1);
		}
		else if ( num2>num1 && num2>num3){
			System.out.println("El mayor n�mero es :" +num2);
		}
		else if (num3>num1 && num3>num2){
			System.out.println("El mayor n�mero es : " + num3);
		}
		else
			System.out.println("Los n�meros son iguales");
		input.close();
		
	}

}
