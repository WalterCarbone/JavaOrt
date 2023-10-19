package trabajo_practico1;
import java.util.Scanner;

public class Ejercicio5 {
	private static Scanner input=new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Por favor ingrese 1er número entero");
		int num1 = input.nextInt();
		System.out.println("Por favor ingrese 2do número entero");
		int num2 = input.nextInt();
		
		if (num2 == 0){
			System.out.println("No se puede divir por cero.");
		}
		else {
			System.out.println(num1 + " / " +  num2 + " = " + (num1 / num2));
			
		}
		
		
		
		input.close();
		

	}

}
