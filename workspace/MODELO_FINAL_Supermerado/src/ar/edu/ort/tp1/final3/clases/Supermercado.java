package ar.edu.ort.tp1.final3.clases;

import edu.ort.tp1.u5.tda.Cola;
import edu.ort.tp1.u5.tda.ListaOrdenada;
import edu.ort.tp1.u5.tda.Pila;
import edu.ort.tp1.u5.tda.nodos.ColaNodos;
import edu.ort.tp1.u5.tda.nodos.PilaNodos;

public class Supermercado {

	private static final String TIPO_CLIENTE_NO_ENCONTRADO = "El tipo de cliente que ha ingresado no se encuentra disponible";
	private static final String SALDO_INSUFICIENTE= "Saldo insuficiente";
	private Cola<Cliente> fila;
	private ListaOrdenada<Integer,Compra> listado;
	
	
	
	public Supermercado() {
		fila = new ColaNodos<Cliente>();
		listado = new ListaCompraPorPrecio();
		
	}


	public Cliente crearCliente(Clientes tipo, String nombre, int edad, double dinero) {
		Cliente retorno=null;
		switch (tipo) {
		case COBRE:
			 try{
				 retorno=new ClienteCobre(nombre, edad, dinero);
				 
			 }catch (RuntimeException e) {
				System.out.println(e.getMessage());
			}		
			break;

		case PLATA:
			try {
				retorno=new ClientePlata(nombre, edad, dinero);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		
		case ORO:
			try {
				retorno=new ClienteOro(nombre, edad, dinero);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		default:
			System.out.println(TIPO_CLIENTE_NO_ENCONTRADO);
			break;
		}
		return retorno;
	}

	public void agregarAlCarrito(Cliente cliente, Producto producto) {
		if(cliente!=null){
		try {
			cliente.agregarProducto(producto);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		}
		
	}

	public void agregarAFila(Cliente cliente) {
		if(cliente!=null){
			fila.add(cliente);
		}
	}

	public void atenderCaja() {
		while(!fila.isEmpty()){
		
			try {
		
				realizarCompra(fila.remove());
			
			
			} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		}
	}

	public void realizarCompra(Cliente cliente) {
		double total = verPrecioCarrito(cliente.getCarrito());
		total = cliente.realizarDescuento(total);
		if(cliente.puedeComprar(total)){
			listado.add(new Compra(total, cliente, (cliente.tieneDescuento(total))));
		}else{
			throw new IllegalArgumentException(SALDO_INSUFICIENTE);
		}
		
	}

	public double verPrecioCarrito(Pila<Producto> carrito) {
		double total=0;
		
		Pila<Producto> aux = new PilaNodos<Producto>();
		Producto prod;
		while(!carrito.isEmpty()){
			prod=carrito.pop();
			total=total+prod.getPrecio();
			aux.push(prod);
			
		}
		
		while(!aux.isEmpty()){
			carrito.push(aux.pop());
		}
		
		return total;
	}

	public void mostrarCompras() {
		for (Compra compra : listado) {
			System.out.println(compra);
		}
	}

}
