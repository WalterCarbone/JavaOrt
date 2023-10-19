package ar.edu.ort.tp1.tp6Ej3.clases;

import java.util.Scanner;

public class Saludador {

	private Diccionario diccionario;
	private String idioma;
	private Scanner input;
	
	public Saludador(String idioma) {
		input = new Scanner(System.in);
		diccionario = new Diccionario();		
		cargarDiccionario(diccionario);
		elegirIdioma(idioma);
	}

	private void cargarDiccionario(Diccionario diccionario) {
		// Agregado de los idiomas que se van a usar
		diccionario.agregarIdioma("ES", "Espanol");
		diccionario.agregarIdioma("EN", "English");
		
		// Agregado de los terminos para los dos idiomas
		diccionario.agregarTermino("ES", "IDIOMA_INVALIDO", "El idioma elegido es invalido.");
		diccionario.agregarTermino("EN", "IDIOMA_INVALIDO", "The selected language is invalid.");
		diccionario.agregarTermino("ES", "BIENVENIDA", "¡Hola!");
		diccionario.agregarTermino("EN", "BIENVENIDA", "Hello!");
		diccionario.agregarTermino("ES", "PEDIR_NOMBRE", "Ingresa tu nombre por favor: ");
		diccionario.agregarTermino("EN", "PEDIR_NOMBRE", "Enter your name, please: ");
		diccionario.agregarTermino("ES", "MENSAJE", "¡Que lindo nombre!");
		diccionario.agregarTermino("EN", "MENSAJE", "What a pretty name!");
		diccionario.agregarTermino("ES", "DESPEDIDA", "¡Adios %s! ¡Que tengas un buen dia!");
		diccionario.agregarTermino("EN", "DESPEDIDA", "Good bye %s! Have a nice day!");
	}

	public void elegirIdioma(String idioma) {
		if (diccionario.idiomaValido(idioma)) {
			this.idioma = idioma;
		} else {
			throw new RuntimeException(diccionario.obtenerTermino(this.idioma, "IDIOMA_INVALIDO"));
		}
	}

	public void run() {
		String nombre;
		System.out.println(diccionario.obtenerTermino(idioma, "BIENVENIDA"));
		System.out.print(diccionario.obtenerTermino(idioma, "PEDIR_NOMBRE"));
		nombre = input.nextLine();
		System.out.println(diccionario.obtenerTermino(idioma, "MENSAJE"));
		System.out.printf(diccionario.obtenerTermino(idioma, "DESPEDIDA"), nombre);
		System.out.println();
	}

}
