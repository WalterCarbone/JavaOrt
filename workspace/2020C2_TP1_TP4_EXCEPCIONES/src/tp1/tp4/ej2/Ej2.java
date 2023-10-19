package tp1.tp4.ej2;

import java.util.Scanner;

import tp1.tp4.tj3.LectorEnteros;
import tp1.tp4.tj3.RangoDeEnteros;

public class Ej2 {
	final static RangoDeEnteros RANGO_NRO_DOCUMENTO = new RangoDeEnteros(1000000, 99999999);
	final static RangoDeEnteros RANGO_ANIO_NACIMIENTO = new RangoDeEnteros(1900, 2021);

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		LectorEnteros lector = new LectorEnteros(input);
		Alumno alu = null;
		int dni = 0;
		int anioNacimiento = 0;
		String nombreCompleto;

		while (alu == null) {
			nombreCompleto = pedirString("Ingrese el nombre completo", input);
			dni = pedirNro("Ingrese dni:", input, lector, RANGO_NRO_DOCUMENTO);
			anioNacimiento = pedirNro("Ingrese anio nacimiento", input, lector, RANGO_ANIO_NACIMIENTO);
			
			alu = new Alumno(dni, nombreCompleto, anioNacimiento);
			
		
		}
		input.close();
		System.out.println(alu.toString());

		if (alu.vive()) {
			System.out.println("La persona vive");
		} else {
			System.out.println("La persona no vive");
		}
	}

	private static String pedirString(String mensaje, Scanner scanner) {
		System.out.println(mensaje);
		return scanner.nextLine();
	}

	private static int pedirNro(String mensaje, Scanner s, LectorEnteros l, RangoDeEnteros r) {
		boolean continuar = true;
		int nro = 0;
		while (continuar) {
			try {
				nro = l.pedir(mensaje, r);
				continuar = false;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return nro;
	}

}