package tp4_ejercicio4_drsueno;

import java.util.ArrayList;

import tp4_ejercicio3_musica.Usuario;

public class AgendaMedica {

	private String medico;
	private int cantTurnos;
	private ArrayList<Turno> listaTurnos;

	public AgendaMedica(String medico, int cant) {
		this.setMedico(medico);
		this.setCantTurnos(cant);
		listaTurnos = new ArrayList<>();

	}

	private Turno buscarTurno(int dni) {
		Turno turnoEncontrado = null;
		int i = 0;
		while (i < listaTurnos.size() && listaTurnos.get(i).getDni() != dni) {
			i++;
		}

		if (i < listaTurnos.size()) {
			turnoEncontrado = listaTurnos.get(i);
		}

		return turnoEncontrado;
	}

	public Resultado registrarTurno(int dni, String nombre, String apellido, String telefono) {
		Resultado estadoTurno;
		Turno buscoTurno;

		if (listaTurnos.size() == getCantTurnos()) {
			estadoTurno = Resultado.NO_HAY_MAS_TURNOS_DISPONIBLES;
		} else {
			buscoTurno = buscarTurno(dni);
			if (buscoTurno == null) {
				listaTurnos.add(new Turno(dni, nombre, apellido, telefono));
				estadoTurno = Resultado.TURNO_CONFIRMADO;
			} else {
				estadoTurno = Resultado.PACIENTE_PREVIAMENTE_CON_TURNO;
			}

		}

		return estadoTurno;
	}

	public void listarTurnos() {
		for (Turno t : listaTurnos) {
			System.out.println(t);
		}
	}

	public boolean darPresente(int dni) {
		boolean result = false;
		Turno miTurno;
		miTurno = buscarTurno(dni);
		if (miTurno != null) {
			miTurno.setPresente();
			result = true;
		}

		return result;
	}
	
	public boolean anularTurno(int dni){
		boolean pudoAnular=false;
		
		Turno miTurno;
		miTurno=buscarTurno(dni);
		if(miTurno!=null){
			listaTurnos.remove(miTurno);
			pudoAnular=true;
			
		}
		
		return pudoAnular;
	}

	public ArrayList<Turno>  obtenerAusentes(){
		ArrayList<Turno> listaAusentes= new ArrayList<>();
		
		
		for (Turno t : listaTurnos){
			if (t.getPresente()==false){
				listaAusentes.add(t);
			}
		}
		
		return listaAusentes;
	}
	 
	public int getCantTurnos() {
		return this.cantTurnos;
	}

	private void setMedico(String medico) {
		this.medico = medico;
	}

	private void setCantTurnos(int cant) {
		this.cantTurnos = cant;
	}

	@Override
	public String toString() {
		return "AgendaMedica [listaTurnos=" + listaTurnos + "]";
	}

	
}
