/*
 * Para desarrollar las funcionalidades solicitadas en este ejercicio debes incorporar y modificar
 * la estructura de la clase Persona del TP3 para agregarle el atributo dni, de solo lectura, que
 * servira como campo identificador de cada persona.
 * Ademas agregale un constructor parametrizado que inicialice todos los atributos a partir de los valores recibidos por parametro. 
 * 
 * Define la clase Agenda, la cual guarda internamente una coleccion de Personas.
 * Estos son sus metodos:
 * - Constructor parametrizado y público que instancia el ArrayList.
 * - Metodo privado buscarPersona() que busca en la coleccion la persona con el dni recibido por parametro.
 *   Si la encuentra la devuelve, sino devuelve null.
 * - Metodo publico agregarPersona() que recibe por parametro todos los datos necesarios para registrar una persona;
 *   si no existe la persona con el dni recibido crea una nueva instancia de Persona con todos los datos recibidos y
 *   la agrega a la coleccion. Devuelve un booleano indicando si la accion se pudo realizar o no.
 * - Metodo publico removerPersona() que si encuentra en la coleccion una persona con el dni recibido por parametro
 *   la extrae y la devuelve. Cuando no la encuentra devuelve null.
 * - Metodo publico modificarDomicilio() que recibe por parametro un dni y un domicilio. Si encuentra en la lista a
 *   la persona con ese dni modifica su domicilio con el recibido por parametro. Retorna un booleano indicando si la
 *   operacion fue exitosa o no.
 * - Metodo publico listarPersonas() que emite por pantalla en formato de listado a cada persona encontrada en la
 *   coleccion (con sus respectivos atributos).
 *   
 * Crear la clase Test con su funcion main(). En esta funcion se creara una instancia de la clase Agenda.
 * Se pide por lo menos comprobar el correcto funcionamiento de los 4 metodos a desarrollar citados previamente
 * en los siguientes casos: agregar 3 personas, eliminacion no exitosa, eliminacion exitosa, modificacion de direccion
 * no exitosa, modificacion de direccion satisfactoria y listado de personas.
 */

package ar.edu.ort.thp.tp4.ej1;

public class Test {

	public static void main(String[] args) {

		// Creamos e instanciamos nuestro objeto de tipo Agenda
		Agenda agenda;
		agenda = new Agenda();

		agenda.listarPersonas();

		System.out.println("*Alta de personas a la agenda*");
		System.out.println(agenda.agregarPersona("99999999", "Gonzalez", "Ignacio", "Cordoba 5443"));
		System.out.println(agenda.agregarPersona("32341111", "Messi", "Lionel", "Santa Fe 3221"));
		System.out.println(agenda.agregarPersona("12345678", "Suarez", "Nicolás", "Yatay 240"));

		System.out.println("*Intentamos agregar a otra persona con mismo dni que Suarez Nicolás a la agenda*");
		System.out.println(agenda.agregarPersona("12345678", "Gomez", "Nicolás", "Carlos Pellegrini 350"));

		System.out.println("*Intentamos eliminar una persona de la agenda con un dni no registrado*");
		System.out.println(agenda.removerPersona("22222222"));

		System.out.println("*Intentamos eliminar una persona de la agenda con un dni registrado*");
		System.out.println(agenda.removerPersona("12345678"));

		System.out.println("*Modificar dirección no exitoso*");
		System.out.println(agenda.modificarDomicilio("444444444", "Carlos Gardel 120"));

		System.out.println("*Modificar dirección exitoso*");
		System.out.println(agenda.modificarDomicilio("32341111", "Callao 540"));

		agenda.listarPersonas();

	}

}
