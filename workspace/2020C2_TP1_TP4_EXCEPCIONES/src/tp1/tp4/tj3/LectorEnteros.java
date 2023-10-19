package tp1.tp4.tj3;

import java.util.Scanner;

public class LectorEnteros {
	private static final String MENSAJE_ERROR_SCANNER_NULL = "Debe recibirse un Scanner.";
	private static final String MENSAJE_CARGA_ENTERO = "Ingrese un numero entero cualquiera";
	private static final String MENSAJE_FUERA_DE_RANGO = "El valor ingresado esta fuera del rango aceptable";

	private Scanner scanner;

	public LectorEnteros(Scanner scanner) {

		this.setScanner(scanner);
	}
	
	private void setScanner(Scanner scanner) {
		if (scanner == null) {
			throw new IllegalArgumentException(MENSAJE_ERROR_SCANNER_NULL);
		}
		this.scanner = scanner;
	}

	private int cargar(String mensaje) {
		System.out.println(mensaje);
		return Integer.parseInt(scanner.nextLine());
	}
	
	public int pedir(String mensaje) {
		int nro=0;
		boolean continuar=true;
		
		while (continuar) {
			try {
				nro=cargar(mensaje);
				continuar = false;
			} catch (NumberFormatException e) {
				System.out.println(MENSAJE_CARGA_ENTERO);
			}
		}
		return nro;
	}

	public int pedir(String mensaje, int limiteA, int limiteB) {
		boolean continuar = true;
		int nro = 0;
		RangoDeEnteros r = new RangoDeEnteros(limiteA, limiteB);
		while (continuar) {
			nro = pedir(mensaje + " entre " + limiteA + " y " + limiteB);
			if (!r.incluye(nro)) {
				System.out.println(MENSAJE_FUERA_DE_RANGO);
			} else {
				continuar = false;
			}
		}
		return nro;
	}

	public int pedir(String mensaje, RangoDeEnteros rangoValido) throws Exception {
		int numero = pedir(mensaje);
		if (!rangoValido.incluye(numero)) {
			throw new Exception(MENSAJE_FUERA_DE_RANGO);
		}
		return numero;
	}
}
