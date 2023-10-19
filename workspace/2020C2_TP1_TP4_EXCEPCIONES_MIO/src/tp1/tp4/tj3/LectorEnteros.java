package tp1.tp4.tj3;

import java.util.Scanner;

public class LectorEnteros {
	private static final String MENSAJE_ERROR_SCANNER_NULL = "Debe recibirse un Scanner.";
	private static final String MENSAJE_CARGA_ENTERO = "Ingrese un numero entero cualquiera";
	private static final String MENSAJE_FUERA_DE_RANGO = "El valor ingresado esta fuera del rango aceptable";

	private Scanner scanner;

	public LectorEnteros(Scanner scanner) {// Constructor- Si es null
											// ILLEGALARGUMENTEXCEPTION
		setScanner(scanner);

	}

	private int cargar(String mensaje) {
		System.out.println(mensaje);
		return Integer.parseInt(scanner.nextLine());
	}

	private void setScanner(Scanner scanner) {
		if (scanner == null) {
			throw new IllegalArgumentException(MENSAJE_ERROR_SCANNER_NULL);
		} else {
			this.scanner = scanner;
		}
	}

	public int pedir(String mensaje) {
		boolean continuar = true;
		int valor = 0;

		while (continuar) {
			try {
				valor = cargar(mensaje);
				continuar = false;
			} catch (NumberFormatException e) {
				System.out.println(MENSAJE_CARGA_ENTERO);
			}
		}

		return valor;
	}

	public int pedir(String mensaje, int limiteA, int limiteB) {
		RangoDeEnteros rango = new RangoDeEnteros(limiteA, limiteB);
		int nro = 0;
		boolean continuar = true;
		while (continuar) {
			nro = pedir(mensaje + " entre " + limiteA + " y " + limiteB);
			if (!rango.incluye(nro)) {
				System.out.println(MENSAJE_FUERA_DE_RANGO);
			} else {
				continuar = false;
			}

		}

		return nro;
	}

	public int pedir(String mensaje, RangoDeEnteros rangoValido) {
		// TODO implementar
		return 0;
	}
}
