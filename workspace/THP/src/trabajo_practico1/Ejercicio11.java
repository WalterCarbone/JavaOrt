package trabajo_practico1;
import java.util.Scanner;

public class Ejercicio11 {
private static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Ingrese fecha (formato YYYYMMDD): ");
		String fecha=input.nextLine();
		
		System.out.println("Ingrese nombre del comprador: ");
		String comprador=input.nextLine();

		System.out.println("Ingrese producto solicitado: ");
		String producto=input.nextLine();	
		
		System.out.println("Cantidad solicitada: ");
		int cantidad=input.nextInt();
		
		System.out.println("Ingrese precio unitario: $");
		int precio=input.nextInt();
		
		System.out.println("\n" + "Fecha de compra: "+ fecha);
		System.out.println("Nombre del comprador: " + comprador);
		System.out.println("Producto solicitado: " + producto);
		System.out.println("Cantidad solicitada: " + cantidad);
		System.out.println("Precio unitario: $" + precio);
		System.out.println("Total a Pagar: $" + (cantidad * precio));
		
		input.close();
	}

}
