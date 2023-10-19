package ar.edu.ort.modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Ticket implements Imprimible{
	
	private static Scanner input = new Scanner(System.in);
	private Cliente cli;
	private ArrayList<Producto> catalogo;
	private ArrayList<Producto> compras;
	

	public Ticket(Cliente cli) {
		this.cli=cli;
		catalogo = new ArrayList<>();
	}
int i =
	public void comprarProducto() {
		int opcion = Integer.MAX_VALUE;
		compras = new ArrayList<>();
		mostrarCatalogo();
		opcion = input.nextInt();

		while (opcion != 0) {
			mostrarDetalle(catalogo.get(opcion - 1));
			mostrarCatalogo();
			opcion = input.nextInt();
			input.nextLine();
		}
		imprimir();
		input.close();
	}

	/*private void imprimirTicket(java.util.ArrayList<Producto> ticket) {
		double total = 0;
		if (ticket.size() > 0) {
			System.out.println("Ticket de venta");
			System.out.println("Detalle");
			for (Producto producto : ticket) {
				System.out.println(producto.getClass().getSimpleName() + " " + producto.getMarca() + ", modelo "
						+ producto.getModelo() + " " + producto + " ,precio $" + producto.getPrecio());
				total += producto.getPrecio();
			}
			System.out.println("Total $" + total);

		} else {
			System.out.println("No se registraron compras");
		}

	}*/

	private void mostrarDetalle(Producto producto) {
		char conf;

		System.out.println("***********************");
		System.out.println("Detalle de producto:");
		producto.imprimir();
		System.out.println("Confirma la compra (s/n): ");
		conf = input.next().charAt(0);
		
		if (conf == 's') {
			compras.add(producto);
		}
	}

	public void agregarProducto(Producto producto) {
		catalogo.add(producto);
	}

	private void mostrarCatalogo() {
		int indice = 1;
		System.out.println("CATALOGO DE PRODUCTOS");
		System.out.println("*********************");
		for (Producto p : catalogo) {
			System.out.println(
					(indice) + " - " + p);
			indice++;
		}
		System.out.println("\n0 para terminar la compra.");

	}

	@Override
	public void imprimir() {
		double total = 0;
		if (compras.size() > 0) {
			System.out.println("Ticket de venta");
			System.out.println(cli);
			System.out.println("Detalle");
			for (Producto producto : compras) {
				producto.imprimir();
				total += producto.getPrecio();
			}
			System.out.println("Total $" + total);

		} else {
			System.out.println("No se registraron compras");
		}
		
	}


}
