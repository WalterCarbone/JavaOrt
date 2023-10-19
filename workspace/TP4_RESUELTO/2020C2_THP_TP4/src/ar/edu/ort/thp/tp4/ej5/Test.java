/*
La empresa “CorreCaminos” se dedica a la organización de carreras de kartings. De cada carrera se sabe la fecha y hora, la dificultad de la carrera (PRINCIPIANTE, AVANZADO o AS DEL VOLANTE) y todos los pilotos que participaron.
De cada piloto se sabe su apellido y su dni. Así mismo, cada piloto posee una lista con las vueltas que realizó (no todos los pilotos completan la totalidad de la carrera y puede ser que deban abandonar antes porque algún problema mecánico, algún accidente, etc).
De cada vuelta se sabe el tiempo obtenido en segundos.
Tomando en cuenta el enunciado descrito, realizá:
La explotación del método buscarCarrera de la clase Empresa, que recibiendo como parámetro una fecha, debe devolver una instancia de la Carrera encontrada o null en caso de no existir.
La explotación del método calcularPromedio de la clase Piloto, que debe calcular el promedio de tiempo de dicho piloto entre todas las vueltas que haya realizado.
La explotación del método buscarPilotosPorDebajoDe de la clase Carrera, que recibe como parámetro un valor que representa un promedio de tiempo y debe crear y devolver una lista de aquellos pilotos que hayan realizado al menos 10 vueltas y cuyo promedio de tiempo no supere al promedio enviado por parámetro.
La explotación del método mostrarMenorPromedio de la clase Carrera que no recibe ningún parámetro y debe mostrar por pantalla el nombre y dni del piloto con menor promedio.
La explotación del método pilotosPorCarrera de la clase Empresa que no recibe ningún parámetro y debe crear y devolver una lista con la cantidad de pilotos que participaron en cada una de las fecha de las carreras.

Crear la clase Test, instanciar un objeto Empresa y probar todos los métodos públicos que solicita la consigna. Realizá todas las clases, enumeradores y métodos privados que consideres necesarios a la hora de resolver el ejercicio. 
 */

package ar.edu.ort.thp.tp4.ej5;

public class Test {

	final static String NOMBRE_EMPRESA = "CorreCaminos";

	public static void main(String[] args) {

		Empresa empresa;
		empresa = new Empresa(NOMBRE_EMPRESA);

		System.out.println("Agendando carreras...");
		System.out.println(empresa.agregarCarrera("05/07/2020", "11:00", Dificultad.AS_DEL_VOLANTE));
		System.out.println(empresa.agregarCarrera("05/08/2020", "14:00", Dificultad.PRINCIPIANTE));
		System.out.println(empresa.agregarCarrera("10/08/2020", "19:00", Dificultad.AVANZADO));

		System.out.println("Agregando pilotos a carreras...");
		empresa.agregarPilotoACarrera("Schumacher", "12345", "10/08/2020");
		empresa.agregarPilotoACarrera("Raikkonen", "99999", "05/07/2020");
		empresa.agregarPilotoACarrera("Alonso", "44444", "10/08/2020");
		empresa.agregarPilotoACarrera("Fangio", "00001", "05/07/2020");
		empresa.agregarPilotoACarrera("Vettel", "12345", "05/08/2020");
		System.out.println(empresa.agregarPilotoACarrera("Del Potro", "12345", "00/00/0000"));

		System.out.println("Información de cantidad de pilotos por carrera:");
		for (InfoCarrera info : empresa.informeResumidoPorCarrera()) {
			System.out.println(info);
		}
	}

}
