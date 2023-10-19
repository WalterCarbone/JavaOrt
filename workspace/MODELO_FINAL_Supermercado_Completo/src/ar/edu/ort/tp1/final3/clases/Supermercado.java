package ar.edu.ort.tp1.final3.clases;

import edu.ort.tp1.u5.tda.Cola;
import edu.ort.tp1.u5.tda.ListaOrdenada;
import edu.ort.tp1.u5.tda.Pila;
import edu.ort.tp1.u5.tda.nodos.ColaNodos;
import edu.ort.tp1.u5.tda.nodos.PilaNodos;

public class Supermercado {

	private static final String SALDO_INSUFICIENTE = "El saldo no es suficiente para realizar esta compra";
	private static final String TIPO_CLIENTE_NO_ENCONTRADO = "El tipo de cliente que ha ingresado no se encuentra disponible";

	private ListaOrdenada<Integer, Compra> listaCompraPorPrecio;
	private Cola<Cliente> filaClientes;

	public Supermercado() {
		this.filaClientes = new ColaNodos<>();
		listaCompraPorPrecio = new ListaCompraPorPrecio();
	}

	public Cliente crearCliente(Clientes tipo, String nombre, int edad, double dinero) {
		Cliente cliente = null;

		try {
			switch (tipo) {
			case COBRE:
				cliente = new ClienteCobre(nombre, edad, dinero);
				break;
			case PLATA:
				cliente = new ClientePlata(nombre, edad, dinero);
				break;
			case ORO:
				cliente = new ClienteOro(nombre, edad, dinero);
				break;
			case DIAMANTE:
				throw new IllegalArgumentException(TIPO_CLIENTE_NO_ENCONTRADO);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return cliente;
	}

	public void agregarAlCarrito(Cliente cliente, Producto producto) {
		if (cliente != null) {
			try {
				cliente.agregarProducto(producto);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	public void agregarAFila(Cliente cliente) {
		if (cliente != null) {
			filaClientes.add(cliente);
		}
	}

	public void atenderCaja() {
		Cliente clienteAux;
		while (!filaClientes.isEmpty()) {
			clienteAux = filaClientes.remove();
			try {
				this.realizarCompra(clienteAux);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void realizarCompra(Cliente cliente) {
		double total = this.verPrecioCarrito(cliente.getcarrito());
		total = cliente.realizarDescuento(total);
		if (cliente.puedeComprar(total)) {
			listaCompraPorPrecio.add(new Compra(total, cliente, cliente.tieneDescuento(total)));
		} else {
			throw new IllegalArgumentException(SALDO_INSUFICIENTE);
		}
	}

	public double verPrecioCarrito(Pila<Producto> carrito) {
		double total = 0;
		Pila<Producto> carritoAux = new PilaNodos<Producto>();
		;
		Producto productoAux;
		while (!carrito.isEmpty()) {
			productoAux = carrito.pop();
			total = total + productoAux.getPrecio();
			carritoAux.push(productoAux);
		}

		while (!carritoAux.isEmpty()) {
			carrito.push(carritoAux.pop());
		}

		return total;
	}

	public void mostrarCompras() {
		for (int i = 0; i < listaCompraPorPrecio.size(); i++) {
			listaCompraPorPrecio.get(i).mostrarTicket();
		}
	}

}
