package trabajo_practico1;
import java.util.Scanner;
public class Ejercicio12 {
	private static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Ingrese el puntaje del 1er dado ");
		int dado1=input.nextInt();
		System.out.println("Ingrese el puntaje del 2do dado ");
		int dado2=input.nextInt();
		System.out.println("Ingrese el puntaje del 3er dado ");
		int dado3=input.nextInt();
		
		if (dado1==6 && dado2==6 && dado3==6){
			System.out.println("Excelente ");
			
		}
		else if ((dado1==6 && dado2==6) ||(dado1==6 && dado3==6) || (dado2==6 && dado3==6) ){
			System.out.println("Muy bien ");
		}
		
		else if (dado1==6 || dado2==6 || dado3==6){
			System.out.println("Regular ");
		}
		
		else if (dado1!=6 && dado2!=6 && dado3!=6){
			System.out.println("Insuficiente");
		}
		input.close();
	}

}
