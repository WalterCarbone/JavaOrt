package tp3_ejercicio1_persona;

import java.util.ArrayList;

public class Agenda {
	private ArrayList<Persona> personas;

	public Agenda() {
		personas = new ArrayList<>();
	}

	public boolean agregarPersona(String nomb, String ape, String dire, String nro) {
		boolean pudoAgregar = false;
		Persona personaAbuscar;
		personaAbuscar = buscarPersona(nro);

		if (personaAbuscar == null) {
			Persona persona = new Persona(nomb, ape, dire, nro);
			personas.add(persona);
			//System.out.println(Resultados.OPERACION_EXITOSA.getMsj());
			pudoAgregar = true;

		} else {
			//System.out.println(Resultados.USUARIO_EXISTENTE.getMsj());
		}

		return pudoAgregar;
	}

	private Persona buscarPersona(String nro) {
		Persona personaAbuscar = null;
		int i = 0;
		while ((i < this.personas.size() && !this.personas.get(i).getDni().equals(nro))) {
			i++;
		}

		if (i < this.personas.size()) {
			personaAbuscar = this.personas.get(i);
		}
		return personaAbuscar;
	}

	public String removerPersona(String dni) {
		String pudoBorrar = null;
		Persona personaAborrar;
		personaAborrar = this.buscarPersona(dni);
		if (personaAborrar != null) {
			personas.remove(personaAborrar);
			pudoBorrar = "SI";
		}

		return pudoBorrar;
	}

	public boolean modificarDomicilio(String dni, String dom) {
		boolean modif;
		Persona personaAmodificar;
		personaAmodificar = this.buscarPersona(dni);

		if (personaAmodificar != null) {
			personaAmodificar.setDireccion(dom);
			modif = true;
		} else {
			modif = false;
		}

		return modif;
	}

	public void listarPersonas() {
		System.out.println("*****   LISTADO DE PERSONAS    *****");
		for (Persona p : this.personas) {
			// System.out.println(i);
			System.out.println("Nombre:" + p.getNombre() + " Apellido:" + p.getApellido() + " Domicilio:"
					+ p.getDireccion() + " DNI:" + p.getDni());
		}

	}

}
