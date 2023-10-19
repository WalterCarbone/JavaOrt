package ar.edu.ort.tp1.exfinal.clases;

import edu.ort.tp1.u5.tda.Cola;
import edu.ort.tp1.u5.tda.ListaOrdenada;
import edu.ort.tp1.u5.tda.Pila;
import edu.ort.tp1.u5.tda.nodos.ColaNodos;
import edu.ort.tp1.u5.tda.nodos.PilaNodos;

public class MusicPlayer implements Reproducible, Mostrable {

	private static final String ITEM_NO_PUEDE_SER_NULO = "El Item no puede ser nulo.";
	private static final String ITEM_YA_EXISTENTE = "El item ingresado ya existe en el reproductor";
	private static final String NOMBRE_NO_PUEDE_SER_NULO = "El  nombre no puede ser nulo";
	private static final String ITEM_NO_ENCONTRADO = "El item no fue encontrado";
	
	//TODO A implementar 
	private Cola<Item> playlist;
	private Pila<Item> ultimosReproducidos;
	private ListaOrdenada<String, Item> itemsDisponibles;
	private String nombre;

	public MusicPlayer(String nombre) {
		//TODO A implementar 
		this.nombre = nombre;
		this.itemsDisponibles = new ListaItemsPorNombre();
		this.ultimosReproducidos = new PilaNodos<Item>();
		this.playlist = new ColaNodos<Item>();
	}

	/**
	 * Agrega un item al listado de disponibles. este item, que se identifica con un
	 * nombre, no podrá estar repetido en la lista y tampoco podrá ser nulo.
	 * 
	 * @param item el Item a agregar.
	 */
	public void agregarItemDisponible(Item item) throws IllegalArgumentException {

		// Excepciones y uso listas
		//TODO A implementar 

		if (item == null) {
			throw new IllegalArgumentException(ITEM_NO_PUEDE_SER_NULO);
		}
		Item buscado = this.itemsDisponibles.search(item.getNombre());
		if (buscado != null) {
			throw new IllegalArgumentException(ITEM_YA_EXISTENTE);
		}

		this.itemsDisponibles.add(item);
	}

	public Item buscarItemPorNombre(String nombre)  throws IllegalArgumentException  {
		//TODO A implementar 
		if (nombre == null) {
			throw new IllegalArgumentException(NOMBRE_NO_PUEDE_SER_NULO);
		}
		return this.itemsDisponibles.search(nombre);
	}

	public void agregarPlaylist(Item item)   throws IllegalArgumentException {
		//TODO A implementar 
		if (item == null) {
			throw new IllegalArgumentException(ITEM_NO_ENCONTRADO);
		}
		this.playlist.add(item);
	}

	@Override
	public void reproducir() {
		//TODO A implementar 
		// Manejo colas

		System.out.println("Reproduciendo playlist");
		Item c = null;
		this.playlist.add(c);
		Item item = this.playlist.remove();
		while (item != c) {
			item.reproducir();
			actualizarUltimosReproducidos(item);
			playlist.add(item);
			item = this.playlist.remove();
		}
	}

	private void actualizarUltimosReproducidos(Item item) {
		//TODO A implementar 
		// Manejo de Pila
		Pila<Item> aux = new PilaNodos<Item>();
		Item buscado = null;
		while (!this.ultimosReproducidos.isEmpty() && buscado == null) {
			buscado = this.ultimosReproducidos.pop();
			if (buscado != item) {
				aux.push(buscado);
				buscado = null;
			}
		}
		while (!aux.isEmpty()) {
			this.ultimosReproducidos.push(aux.pop());
		}
		this.ultimosReproducidos.push(item);
	}

	@Override
	public void detener() {
		//TODO A implementar 
		System.out.println("No implementado, se detendrá la reproducción en curso.");
	}

	@Override
	public void mostrar() {
		//TODO A implementar 
		System.out.println("Reproductor: " + nombre);
		System.out.println("Reproducibles disponibles: ");
		for (Item item : itemsDisponibles) {
			System.out.println(item);
		}

		System.out.println("-----------------");
		System.out.println("Últimos escuchados:");
		mostrarUltimos();
	}

	private void mostrarUltimos() {
		//TODO A implementar 
		//Manejo de pila
		Pila<Item> aux = new PilaNodos<Item>();
		Item item = null;
		while (!this.ultimosReproducidos.isEmpty()) {
			item = this.ultimosReproducidos.pop();
			aux.push(item);
			System.out.println("- " + item);
		}
		while (!aux.isEmpty()) {
			this.ultimosReproducidos.push(aux.pop());
		}
		this.ultimosReproducidos.push(item);

	}
}
