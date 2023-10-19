package ar.edu.ort.test;

import ar.edu.ort.modelo.Cliente;
import ar.edu.ort.modelo.Heladera;
import ar.edu.ort.modelo.Lavarropa;
import ar.edu.ort.modelo.Licuadora;
//import ar.edu.ort.modelo.Negocio;
import ar.edu.ort.modelo.Televisor;
import ar.edu.ort.modelo.Ticket;

public class Test {

	public static void main(String[] args) {

		Cliente cliente = new Cliente("Walter Carbone", "20-24963720-4");

		Televisor p1 = new Televisor("Samsung", "F90", 100987, 220, 60, "Si", 50000);
		Lavarropa p2 = new Lavarropa("Drean", "Blue", 1548784, 220, 5, "Si", 30000);
		Heladera p3 = new Heladera("Gaffa", "Grande", 477, 220, 30, "No", 25500);
		Licuadora p4 = new Licuadora("Liliana", "Fast", 77745, 110, 75, 10, 3000);
		Ticket miTicket = new Ticket(cliente);
		miTicket.agregarProducto(p1);
		miTicket.agregarProducto(p2);
		miTicket.agregarProducto(p3);
		miTicket.agregarProducto(p4);
		miTicket.comprarProducto();
		
	}

}
