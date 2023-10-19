package ar.edu.ort.tp1.tp3Ej4;

import java.util.ArrayList;

public class Ticket implements Imprimible {
	private ArrayList<Electrodomestico> lElectrodomesticos;

	public Ticket() {
		lElectrodomesticos = new ArrayList<>();

	}

	public void imprimir() {
		double total = 0;
		if (lElectrodomesticos.size() > 0) {
			System.out.println("Ticket de venta");
			System.out.println("Articulos:");

			for (Electrodomestico e : lElectrodomesticos) {
				e.imprimir();
				total += e.getPrecio();
			}
			System.out.println("Total: $" + total);
		} else {
			System.out.println("El carrito de compras está vacio");
		}
	}

	public void agregarElectrodomestico(Electrodomestico e) {
		lElectrodomesticos.add(e);
	}
}
