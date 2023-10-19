package ar.edu.ort.tp1.exfinal.clases;

import edu.ort.tp1.u5.tda.Cola;
import edu.ort.tp1.u5.tda.ListaOrdenada;
import edu.ort.tp1.u5.tda.Pila;
import edu.ort.tp1.u5.tda.nodos.ColaNodos;
import edu.ort.tp1.u5.tda.nodos.ListaOrdenadaNodos;
import edu.ort.tp1.u5.tda.nodos.PilaNodos;

public class MusicPlayer implements Reproducible, Mostrable {

	private static final String ITEM_NO_PUEDE_SER_NULO = "El Item no puede ser nulo.";
	private static final String ITEM_YA_EXISTENTE = "El item ingresado ya existe en el reproductor";
	private static final String NOMBRE_NO_PUEDE_SER_NULO = "El  nombre no puede ser nulo";
	private static final String ITEM_NO_ENCONTRADO = "El item no fue encontrado";
	private ListaOrdenada<String, Item> itemsDisponibles;
	private Cola<Item> playlist;
	private Pila<Item> ultimosReproducidos;

	// TODO A implementar Atributos faltantes
	private String nombre;

	public MusicPlayer(String nombre) {
		setNombre(nombre);
		itemsDisponibles = new ListaPorNombre();
		playlist = new ColaNodos<Item>();
		ultimosReproducidos = new PilaNodos<Item>();

	}

	private void setNombre(String nombre) {
		this.nombre = nombre;

	}

	public void agregarItemDisponible(Item item) throws IllegalArgumentException {
		Item buscado = null;
		if (item == null) {
			throw new IllegalArgumentException(ITEM_NO_PUEDE_SER_NULO);
		} else {
			buscado = buscarItemPorNombre(item.getNombre());
			if (buscado == null) {
				itemsDisponibles.add(item);
			} else {
				throw new IllegalArgumentException(ITEM_YA_EXISTENTE);
			}
		}

	}

	public Item buscarItemPorNombre(String nombre) throws IllegalArgumentException {
		Item buscado = null;
		if (nombre == null) {
			throw new IllegalArgumentException(NOMBRE_NO_PUEDE_SER_NULO);
		} else {
			buscado = itemsDisponibles.search(nombre);
		}

		return buscado;
	}

	public void agregarPlaylist(Item item) throws IllegalArgumentException {

		if (item == null) {
			throw new IllegalArgumentException(ITEM_NO_ENCONTRADO);
		} else {

			playlist.add(item);
		}

	}

	@Override
	public void detener() {

		System.out.println("No implementado, se detendrá la reproducción en curso.");
	}

	@Override
	public void mostrar() {
		System.out.println("Reproductor :" + this.nombre);
		System.out.println("Reproducciones disponibles:");
		imprimirItemsDisponibles();
		System.out.println("Ultimos escuchados:");
		imprimirUltimosEscuchados();

	}

	private void imprimirUltimosEscuchados() {
		Pila<Item> pilaAux = new PilaNodos<Item>();
		Item item = null;
		while (!ultimosReproducidos.isEmpty()) {
			item = ultimosReproducidos.pop();
			System.out.println(item);
			pilaAux.push(item);
		}

		while (!pilaAux.isEmpty()) {
			ultimosReproducidos.push(pilaAux.pop());
		}
	}

	private void imprimirItemsDisponibles() {
		for (Item item : itemsDisponibles) {
			System.out.println(item);
		}

	}

	@Override
	public void reproducir() {
		Cancion centinela = new Cancion("xxx", "xxx", 0);
		Item aux = null;
		System.out.println("Reproduciendo la PlayList");
		playlist.add(centinela);
		aux = playlist.remove();
		while (aux != centinela) {
			aux.reproducir();
			actualizarUltimoReproducido(aux);
			playlist.add(aux);
			aux = playlist.remove();
		}

	}

	private void actualizarUltimoReproducido(Item item) {
		Pila<Item> pilaAux = new PilaNodos<Item>();
		Item buscado = null;
		while (!ultimosReproducidos.isEmpty() && buscado == null) {
			buscado = ultimosReproducidos.pop();
			if (buscado != item) {
				pilaAux.push(buscado);
				buscado = null;
			}
		}
		
		while (!pilaAux.isEmpty()){
			ultimosReproducidos.push(pilaAux.pop());
		}
		ultimosReproducidos.push(item);
	}

}
