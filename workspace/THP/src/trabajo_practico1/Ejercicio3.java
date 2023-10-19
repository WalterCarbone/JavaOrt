package trabajo_practico1;
import java.util.Scanner;

public class Ejercicio3 {
private static Scanner input=new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Por favor ingrese su nombre: ");
		String nombre = input.nextLine();
		System.out.println("Hola "+ nombre + ", bienvenido");

	input.close();
	}

}
