package trabajo_practico1;
import java.util.Scanner;
public class Ejercicio13 {
	private static final int HORA=16;
	private static final int EXTRA=20;
	private static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sueldo=0;
		System.out.println("Ingrese la cantidad de horas trabajadas en la semana :");
		int horasTrabajadas=input.nextInt();
		if (horasTrabajadas>40){
			sueldo=((40*HORA)+(horasTrabajadas-40)*EXTRA);
			System.out.println("El salario es : $"+ sueldo);
		}
		else {
			sueldo=(horasTrabajadas*HORA);
			System.out.println("El salario es : $"+ sueldo);
		}
	
		input.close();
	}

}
