package ar.edu.ort.tp1.tp3Ej4;

import java.util.ArrayList;
import java.util.Scanner;

public class TP3Test4 {

	public static void main(String[] args) {
		Cliente c = new Cliente("Diaz, Bruno", "20-22222222-6");

		ArrayList<Electrodomestico> productos = new ArrayList<Electrodomestico>();
		productos.add(new Heladera("Whirlpool", "H2745", 23332, 220, false, 14999, 250, true));
		productos.add(new Televisor("Philips", "49PGFS", 6565454, 220, false, 14370, 49, true));
		productos.add(new Lavarropa("Drean", "CONCEPT 5.05", 334242, 220, false, 6799, 6, false));
		productos.add(new Licuadora("Braun", "K34", 12320343, 220, false, 7000, 300, 5));

		Scanner entradaEscaner = new Scanner(System.in);
		int opcion = 0;
		String entradaTeclado = "";
		boolean fin = false;

		do {
			System.out.println("Seleccione el numero del producto producto deseado (0 para terminar):");
			for (int i = 0; i < productos.size(); i++) {
				System.out.println((i + 1) + ") Tipo: " + productos.get(i).getTipo() + "\tMarca: "
						+ productos.get(i).getMarca() + "\tModelo: " + productos.get(i).getModelo());
			}
			opcion = entradaEscaner.nextInt();
			entradaEscaner.nextLine();
			if (opcion == 0) {
				fin = true;
			} else {
				System.out.println(productos.get(opcion - 1).toString());
				System.out.println("¿Confirma la selección del producto? (S para confirmar y N para salir)");
				entradaTeclado = entradaEscaner.nextLine();
				if (entradaTeclado.equals("S"))
					c.agregarProducto(productos.get(opcion - 1));
			}
		} while (!fin);
		c.imprimirTicket();
		entradaEscaner.close();
	}
}
