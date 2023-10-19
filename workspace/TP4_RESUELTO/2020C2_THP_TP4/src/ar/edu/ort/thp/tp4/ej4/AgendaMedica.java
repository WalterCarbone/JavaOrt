package ar.edu.ort.thp.tp4.ej4;

import java.util.ArrayList;

public class AgendaMedica {

	private ArrayList<Turno> turnos;
	private int cantidadTurnos;

	/**
	 * Constructor de AgendaMedica
	 * 
	 * @param cantidadTurnos
	 */
	public AgendaMedica(int cantidadTurnos) {
		turnos = new ArrayList<>();
		setCantidadTurnos(cantidadTurnos);
	}

	/**
	 * Dado un dni recibido por parámetro, quita el turno de la lista si
	 * encuentra al paciente. Retorna un booleano indicando si pudo o no
	 * realizar la acción.
	 * 
	 * @param dni
	 * @return
	 */
	public boolean anularTurno(int dni) {
		boolean pudeAnular = false;
		Turno turno = buscarTurno(dni);

		if (turno != null) {
			pudeAnular = turnos.remove(turno);
		}

		return pudeAnular;
	}

	/**
	 * Recibe por parámetro un dni. Retorna un objeto de tipo Turno de encontrar
	 * el mismo en el listado general de turnos. De lo contrario devuelve null.
	 * 
	 * @param dni
	 *            El dni del paciente a buscar
	 * @return Turno o null
	 */
	private Turno buscarTurno(int dni) {
		Turno turnoABuscar = null;
		int i = 0;

		while (turnoABuscar == null && i < turnos.size()) {

			if (turnos.get(i).mismoPaciente(dni)) {
				turnoABuscar = turnos.get(i);
			} else {
				i++;
			}
		}
		return turnoABuscar;
	}

	/**
	 * Dado un dni recibido por parámetro, si existe un turno de algún paciente
	 * en la lista con ese dni lo marca como presente. Retorna un booleano
	 * indicando si pudo o no realizar la acción.
	 * 
	 * @param dni
	 * @return
	 */
	public boolean darPresente(int dni) {
		boolean pudeDarPresente = false;
		Turno turno = buscarTurno(dni);

		if (turno != null) {
			turno.darPresente();
			pudeDarPresente = true;
		}

		return pudeDarPresente;
	}

	/**
	 * Mostrará por pantalla la cantidad de turnos asignados hasta el momento y
	 * los datos de cada turno (incluye visualizar los datos de los pacientes)
	 */
	public void listarTurnos() {
		if (turnos.size() > 0) {
			System.out.println("Cantidad de turnos asignados hasta el momento: " + turnos.size());
			for (Turno turno : turnos) {
				System.out.println(turno);
			}
		} else {
			System.out.println("No hay turnos asignados");
		}
	}

	/**
	 * Retorna un ArrayList de elementos Paciente, con aquellos/as pacientes que
	 * no estuvieron presentes para los turnos que solicitaron.
	 * 
	 * @return
	 */
	public ArrayList<Paciente> obtenerAusentes() {
		ArrayList<Paciente> pacientes = new ArrayList<>();

		for (Turno turno : turnos) {
			if (!turno.estaPresente()) {
				pacientes.add(turno.getPaciente());
			}
		}
		return pacientes;

	}

	/**
	 * Método público registrarTurno(): Dado un Nombre, apellido, teléfono, dni
	 * y género, crea un Turno para dicho Paciente y lo se agrega a la agenda de
	 * turnos. Además, retornará como resultado la confirmación del registro.
	 * Tener en cuenta que si se cumple alguno de los siguientes casos, el turno
	 * no se agregará a la lista, retornando el respectivo estado: El médico no
	 * tiene más turnos El paciente (dni) ya tenía previamente un turno asignado
	 * en la lista Manejar el retorno de este método con un enumerador.
	 * 
	 * @param dni
	 * @param apellido
	 * @param nombre
	 * @param domicilio
	 * @param genero
	 * @return
	 */
	public ResultadoRegistracion registrarTurno(int dni, String apellido, String nombre, String telefono) {

		ResultadoRegistracion resultado = ResultadoRegistracion.ERROR_TURNOS_COMPLETOS;

		if (turnos.size() < cantidadTurnos) {
			if (buscarTurno(dni) == null) {
				Paciente paciente = new Paciente(dni, apellido, nombre, telefono);
				turnos.add(new Turno(paciente));
				resultado = ResultadoRegistracion.TURNO_CONFIRMADO;
			} else {
				resultado = ResultadoRegistracion.ERROR_YA_TIENE_TURNO;
			}
		}

		return resultado;
	}

	/**
	 * @param cantidadTurnos
	 *            La cantidad de turnos disponibles
	 */
	private void setCantidadTurnos(int cantidadTurnos) {
		this.cantidadTurnos = cantidadTurnos;
	}

}