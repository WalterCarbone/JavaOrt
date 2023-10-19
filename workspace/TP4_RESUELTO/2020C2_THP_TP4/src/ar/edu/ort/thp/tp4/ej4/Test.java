/*
 * El Dr Sueño quiere un programa que le permita manejar la agenda de turnos del día siguiente.
	Los mismos se asignan por orden de llegada, pero solo otorga una cantidad limitada de números, la cual se debe pasar por parámetro al constructor de la agenda.
	El programa debe permitir registrar turnos de pacientes. De cada Paciente se conocen los siguientes datos: Nombre, apellido, teléfono, dni y género. 
	Además de contener la información de quien se inscribió en la consulta, cada Turno cuenta con un atributo de presencia (booleano, que indica si el paciente se presentó al turno que reservó o no). 
	Se pide crear los siguientes métodos en las clases que correspondan:
	Método privado buscarPaciente(): Devuelve si existe, un paciente de la lista de turnos dado un DNI recibido por parámetro. De lo contrario retorna null. 
	Método público registrarTurno(): Dado un Nombre, apellido, teléfono, dni y género, crea un Turno para dicho Paciente y lo se agrega a la agenda de turnos. Además, retornará como resultado la confirmación del registro. Tener en cuenta que si se cumple alguno de los siguientes casos, el turno no se agregará a la lista, retornando el respectivo estado:
	El médico no tiene más turnos 
	El paciente (dni) ya tenía previamente un turno asignado en la lista
	Manejar el retorno de este método con un enumerador.
	Método público listarTurnos(): Mostrará por pantalla la cantidad de turnos asignados hasta el momento y los datos de cada turno (incluye visualizar los datos de los pacientes)
	Método público darPresente(): Dado un dni recibido por parámetro, si existe un turno de algún paciente en la lista con ese dni lo marca como presente. Retorna un booleano indicando si pudo o no realizar la acción. 
	Método público anularTurno(): Dado un dni recibido por parámetro, quita el turno de la lista si encuentra al paciente. Retorna un booleano indicando si pudo o no realizar la acción. 
	Método público listarAusentes(): Retorna un ArrayList de elementos Paciente, con aquellos/as pacientes que no estuvieron presentes para los turnos que solicitaron.  
	
	Crear una instancia de la clase AgendaMedica en la función main() de la clase Test y probar todos los métodos públicos definidos. 

 */

package ar.edu.ort.thp.tp4.ej4;

import java.util.ArrayList;

public class Test {

	final static int CANTIDAD_TURNOS = 5;

	public static void main(String[] args) {

		AgendaMedica agendaMedica;
		agendaMedica = new AgendaMedica(CANTIDAD_TURNOS);

		System.out.println("*Registro de turnos*");
		System.out.println(agendaMedica.registrarTurno(11111111, "Gonzalez", "Francisco", "4122-3333"));
		System.out.println(agendaMedica.registrarTurno(11111111, "Gonzalez", "Francisco", "4122-3333"));
		System.out.println(agendaMedica.registrarTurno(22222222, "Juarez", "Juana", "4344-5666"));
		System.out.println(agendaMedica.registrarTurno(33333333, "Gimenez", "Florencia", "1333-3333"));
		System.out.println(agendaMedica.registrarTurno(44444444, "Gonzalez", "Pablo", "2222-2222"));
		System.out.println(agendaMedica.registrarTurno(55555555, "Sabbatini", "Gabriela", "15 2233-2222"));
		System.out.println(agendaMedica.registrarTurno(66666666, "Elultimo", "Juan", "15 2233-2211"));

		agendaMedica.listarTurnos();

		System.out.println("*Dar el Presente*");
		System.out.println(agendaMedica.darPresente(11111111));
		System.out.println(agendaMedica.darPresente(44444444));

		System.out.println("*Anulaciones de turnos*");
		System.out.println(agendaMedica.anularTurno(0));
		System.out.println(agendaMedica.anularTurno(22222222));
		System.out.println(agendaMedica.anularTurno(55555555));

		System.out.println("*Pacientes ausentes*");
		ArrayList<Paciente> pacientesAusentes = agendaMedica.obtenerAusentes();
		if (pacientesAusentes.size() > 0) {
			for (Paciente paciente : pacientesAusentes) {
				System.out.println(paciente);
			}
		} else {
			System.out.println("No hubo pacientes ausentes");
		}

	}

}
