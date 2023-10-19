package tp1.tp4.tj3;

import java.time.Year;
import java.util.Scanner;

public class Ej3 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		LectorEnteros lector = new LectorEnteros(input);
		
		int nacimiento = lector.pedir("Ingrese un año de nacimiento:");
		
		int fallecimiento = lector.pedir("Ingrese fecha de facellimiento: ", nacimiento, Year.now().getValue());
		
		System.out.println("La fecha de nacimiento es: "+nacimiento);
		System.out.println("La fecha de fallecimiento es es: "+fallecimiento);
		input.close();
	}
}
