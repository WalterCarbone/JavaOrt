package trabajo_practico1;
import java.util.Scanner;
public class Ejercicio14 {
	private static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Ingrese la operación a realizar :");
		char operacion=input.next().charAt(0);
		
		if (operacion=='s' || operacion=='r' || operacion == 'm' || operacion=='d'){
			System.out.println("Ingrese primer número entero :");
			int num1=input.nextInt();
		
			System.out.println("Ingrese segundo número entero :");
			int num2=input.nextInt();
			
			switch(operacion){
				case 's':
					System.out.println("La suma es :" + (num1+num2));
					break;
				case 'r':
					System.out.println("La resta es :" + (num1-num2));
					break;
				case 'm':
					System.out.println("La multiplicación es :" + (num1*num2));
					break;	
				case 'd':	
					if (num2==0){
						System.out.println("No se puede dividir por cero");
						break;
					}
					else {
						System.out.println("La división es : "+ (num1/num2));
						break;
					}
		}
		}
			else{
				System.out.println("Operación inválida");
				
		
		
		
		}
		
		input.close();
	}

}
