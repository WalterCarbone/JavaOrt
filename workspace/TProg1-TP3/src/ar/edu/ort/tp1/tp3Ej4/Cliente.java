package ar.edu.ort.tp1.tp3Ej4;

public class Cliente {
	private String apenom;
	private String cuil;
	private Ticket ticket;

	public Cliente(String apenom, String cuil) {
		this.apenom = apenom;
		this.cuil = cuil;
		ticket = new Ticket();
	}

	public void agregarProducto(Electrodomestico e) {
		ticket.agregarElectrodomestico(e);
	}

	public void imprimirTicket() {
		System.out.println("Cliente: " + apenom + " - CUIL: " + cuil);
		ticket.imprimir();
	}
}
