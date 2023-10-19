package ar.edu.ort.tp1.final3.clases;

import edu.ort.tp1.u5.tda.Pila;
import edu.ort.tp1.u5.tda.nodos.PilaNodos;

public abstract class Cliente implements ClienteDescontable {

	private static final String EDAD_INVALIDA = "El cliente no puede ser menor de edad";
	private static final String SALDO_INVALIDO = "El saldo no puede ser negativo";
	private static final String NOMBRE_INVALIDO = "El nombre no puede ser nulo ni vacio";
	private static final String LIMITE_PRODUCTO = "La cantidad limite de este producto fue alcanzada";

	private String nombre;
	private int edad;
	private double dinero;
	private Pila<Producto> carrito;

	public Cliente(String nombre, int edad, double dinero) {
		setNombre(nombre);
		setEdad(edad);
		setDinero(dinero);
		this.carrito = new PilaNodos<Producto>();
	}

	private void setNombre(String nombre) {
		if (nombre == null || nombre.isEmpty()) {
			throw new IllegalArgumentException(NOMBRE_INVALIDO);
		}
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	private void setDinero(double dinero) {
		if (dinero < 0) {
			throw new IllegalArgumentException(SALDO_INVALIDO);
		}
		this.dinero = dinero;
	}

	public double getDinero() {
		return dinero;
	}

	private void setEdad(int edad) {
		if (edad < 18) {
			throw new IllegalArgumentException(EDAD_INVALIDA);
		}
		this.edad = edad;

	}

	public int getEdad() {
		return edad;
	}

	public Pila<Producto> getcarrito() {
		return carrito;
	}

	public void agregarProducto(Producto producto) {
		Pila<Producto> carritoAuxiliar = new PilaNodos<Producto>();
		Producto productoAuxiliar = null;
		int contador = 1;

		while (!carrito.isEmpty() && contador < 3) {
			productoAuxiliar = carrito.pop();
			if (productoAuxiliar.getNombre().equals(producto.getNombre())) {
				contador++;
			}
			carritoAuxiliar.push(productoAuxiliar);
		}

		while (!carritoAuxiliar.isEmpty()) {
			productoAuxiliar = carritoAuxiliar.pop();
			carrito.push(productoAuxiliar);
		}

		if (contador < 3) {
			carrito.push(producto);
		} else {
			throw new IllegalArgumentException(LIMITE_PRODUCTO);
		}
	}

	public boolean puedeComprar(double total) {
		return total <= this.getDinero();
	}

}
