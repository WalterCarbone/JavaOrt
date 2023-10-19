package trabajo_practico1;
import java.util.Scanner;

public class Ejercicio9 {
	private static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Ingrese nombre: ");
		String nomb1 = input.nextLine();
		System.out.println("Ingrese capital aportado : $");
		double cap1=input.nextDouble();
		input.nextLine();
		
		
		System.out.println("Ingrese nombre: ");
		String nomb2 = input.nextLine();
		System.out.println("Ingrese capital aportado : $");
		double cap2=input.nextDouble();
		input.nextLine();
		
		System.out.println("Ingrese nombre: ");
		String nomb3 = input.nextLine();
		System.out.println("Ingrese capital aportado : $");
		double cap3=input.nextDouble();

		double total = cap1+cap2+cap3;
		
		System.out.println("Nombre: "+nomb1 + ", Capital aportado: $"+cap1+ ", Porcentaje del capital: %"+ ((cap1/total)*100)+", Monto total aportado: $" + total+"\n");
		System.out.println("Nombre: "+nomb2 + ", Capital aportado: $"+cap2+ ", Porcentaje del capital: %"+ ((cap2/total)*100)+", Monto total aportado: $" + total+"\n");
		System.out.println("Nombre: "+nomb3 + ", Capital aportado: $"+cap3+ ", Porcentaje del capital: %"+ ((cap3/total)*100)+", Monto total aportado: $" + total+"\n");
		input.close();
	
	}
	
}
