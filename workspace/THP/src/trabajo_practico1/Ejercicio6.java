package trabajo_practico1;
import java.util.Scanner;

public class Ejercicio6 {
	private static Scanner input=new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Ingrese un valor entero mayor a cero : ");
		int num1 = input.nextInt();
		
		if ((num1%2)==0){
			System.out.println("El número es par.");
		}
		else{
			System.out.println("El número es impar.");
			
		}
		
		input.close();
		
	}

}
