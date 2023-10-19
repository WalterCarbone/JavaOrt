package trabajo_practico2;
import java.util.Scanner;

public class Ejercicio4 {
	private static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int num1;
int num2;
int cont1;
do{
	System.out.println("Ingrese 1er número (menor o igual que el segundo) : ");
	num1 = input.nextInt();
	System.out.println("Ingrese 2do número: ");
	num2 = input.nextInt();
	
}while (num1 > num2);

System.out.println("Secuencia incluyéndolos:");
for (cont1=num1;cont1<(num2+1);cont1++)
System.out.println(cont1);

System.out.println("Secuencia excluyéndolos:");
for (cont1=(num1+1);cont1<num2;cont1++)
	System.out.println(cont1);

input.close();
		}	
	
	
}
