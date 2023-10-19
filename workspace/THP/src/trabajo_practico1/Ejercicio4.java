package trabajo_practico1;
import java.util.Scanner;

public class Ejercicio4 {
	private static Scanner input=new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Por favor ingrese 1er número entero");
		int num1 = input.nextInt();
		System.out.println("Por favor ingrese 2do número entero");
		int num2 = input.nextInt();
		System.out.println("La suma entre " + num1 + " y " + num2 + " da como resultado " + (num1 + num2));
		
		
		input.close();
		

	}

}
