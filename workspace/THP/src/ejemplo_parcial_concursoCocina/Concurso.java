package ejemplo_parcial_concursoCocina;

import java.util.ArrayList;

public class Concurso {

	private static final String nombreConcurso = "Quarantine Bakers";
	private String nombre;
	private ArrayList<Participante> listaParticipantes;

	public Concurso() {
		this.nombre = nombreConcurso;
		listaParticipantes = new ArrayList<>();
	}

	public Resultado agregarParticipante(String dni, String nombre, String apellido) {
		Resultado result;
		Participante miParticipante;
		miParticipante = this.buscarParticipante(dni);

		if (miParticipante == null) {
			listaParticipantes.add(new Participante(dni, nombre, apellido));
			result = Resultado.SE_AGREGO_PARTICIPANTE;
		} else {
			result = Resultado.YA_EXISTIA_UN_PARTICIPANTE_CON_ESE_DNI;
		}

		return result;
	}
	
	
	public void mostrarGanador(){
		int maxVotos=0;
		Participante ganador =null;
		
		for (Participante g : listaParticipantes){
			if(g.getPuntaje()>maxVotos){
				ganador=g;
				maxVotos=g.getPuntaje();
			}
		}
		if(maxVotos>0){
			System.out.println("EL GANADOR ES:");
			System.out.println(ganador);
		}else{
			System.out.println("No hubo ganador");
		}
	}
	
	public void cantParticipantes(){
		System.out.println("La cantidad de participantes es: " + this.listaParticipantes.size());
	}

	public void imprimirParticipantes(){
		for (Participante p: listaParticipantes){
			System.out.println(p);
		}
	}
	
	public Resultado votar(String dni){
	Resultado pudoVotar;
	Participante aVotar;
	
	aVotar=buscarParticipante(dni);
	
	if(aVotar!=null){
		aVotar.sumarVoto();
		System.out.println(aVotar.getNombre() + " " + aVotar.getApellido());
		pudoVotar=Resultado.VOTO_CORRECTO;
	}else{
		pudoVotar=Resultado.VOTO_INVALIDO_DNI_INEXISTENTE;
	}
	
	
	
	
	return pudoVotar;	
	}
	
	
	
	
	
	
	public Resultado eliminarParticipante(String dni) {
		Resultado pudoEliminar;
		Participante participanteAborrar;
		participanteAborrar = buscarParticipante(dni);
		if (participanteAborrar != null) {
			listaParticipantes.remove(participanteAborrar);
			pudoEliminar = Resultado.SE_ELIMINO_PARTICIPANTE;
		} else {
			pudoEliminar = Resultado.NO_SE_PUDO_ELIMINAR_PARTICIPANTE_CON_ESE_DNI;
		}

		return pudoEliminar;
	}

	private Participante buscarParticipante(String dni) {
		Participante miParticipante = null;
		int i = 0;

		while (i < listaParticipantes.size() && !listaParticipantes.get(i).getDni().equals(dni)) {
			i++;
		}

		if (i < listaParticipantes.size()) {
			miParticipante = listaParticipantes.get(i);
		}

		return miParticipante;
	}

}
