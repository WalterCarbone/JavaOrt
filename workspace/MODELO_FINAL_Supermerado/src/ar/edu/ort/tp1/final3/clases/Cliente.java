package ar.edu.ort.tp1.final3.clases;

import edu.ort.tp1.u5.tda.Pila;
import edu.ort.tp1.u5.tda.nodos.PilaNodos;

public abstract class Cliente implements ClienteDescontable {
	private static final String NOMBRE_INVALIDO = "El nombre no puede ser nulo ni vacio";
	private static final String EDAD_INVALIDA="El cliente no puede ser menor de edad";
	private static final String IMPORTE_INVALIDO="El saldo no puede ser negativo";
	private static final String LIMITE_INVALIDO="La cantidad límite de este producto fue alcanzado";
	private static final int EDAD_MINIMA=18;
	private static final double IMPORTE_MINIMO=0;
	private static final int LIMITE_PRODUCTOS=2;
	
	
	private String nombre;
	private int edad;
	private double saldo;
	private Pila<Producto> carrito;

	public Cliente(String nombre, int edad, double importe) {
	
		setNombre(nombre);
		setEdad(edad);
		setSaldo(importe);
		carrito= new PilaNodos<Producto>();
	}

public String getNombre(){
	return this.nombre;
}

	private void setNombre(String nombre){
		if (nombre==null || nombre.isEmpty()){
		throw new IllegalArgumentException(NOMBRE_INVALIDO);
	}else{
		this.nombre = nombre;
	}
	}

	private void setEdad(int edad){
		if (edad <EDAD_MINIMA){
			throw new IllegalArgumentException(EDAD_INVALIDA);
		}else {
		 this.edad=edad;
		}
	}
	
	private void setSaldo(double importe){
		if (importe<IMPORTE_MINIMO){
			throw new IllegalArgumentException(IMPORTE_INVALIDO);
		}else{
			this.saldo=importe;
			}
	}	
	public void agregarProducto(Producto producto) {
		
		if(puedoAgregar(producto)){
			carrito.push(producto);
		}else{
			throw new IllegalArgumentException(LIMITE_INVALIDO);
		}
		
	}

	private boolean puedoAgregar(Producto buscado) {
		boolean retorno=false;
		int cont=0;
		Pila<Producto> aux= new PilaNodos<Producto>(); 
		
		while (!carrito.isEmpty() && cont<LIMITE_PRODUCTOS){
			Producto prod = carrito.pop();
			if (prod.getNombre().equals(buscado.getNombre())){
				cont++;
			}
			aux.push(prod);
		}
		
		while(!aux.isEmpty()){
			carrito.push(aux.pop());
		}
		if(cont<LIMITE_PRODUCTOS){
			retorno=true;
		}
		
		return retorno;
	}



	public boolean puedeComprar(double total) {
		boolean retorno=false;
		if(total<=this.saldo){
			retorno=true;
		}
		
		return retorno;
	}

	public Pila<Producto> getCarrito(){
		return this.carrito;
	}
}
