package tp4_ejercicio3_musica;

import java.util.ArrayList;

public class Aplicacion {

	private ArrayList<Usuario> baseUsuarios;
	private ArrayList<Cancion> biblioteca;
	private String nombre;

	public Aplicacion(String nombre) {
		this.setNombre(nombre);
		baseUsuarios = new ArrayList<>();
		biblioteca = new ArrayList<>();
	}

	public boolean altaUsuario(String mail, String apellido, int edad, Categorias categoria) {
		boolean pudoAlta = false;
		Usuario user;
		user = buscarUsuario(mail);
		if (user == null) {
			baseUsuarios.add(new Usuario(mail,apellido,edad,categoria));
			pudoAlta=true;
		} else {
			//System.out.println(Resultados.USUARIO_EXISTENTE);
		}

		return pudoAlta;
	}

	public void listarUsuarios() {
		for (Usuario u : baseUsuarios) {
			System.out.println(u);
		}
	}

	public void listarCanciionesPorUsuario(String mail) {
		Usuario user;
		user = this.buscarUsuario(mail);
		if (user != null) {
			user.listarCanciones(user);

		} else {
			System.out.println(Resultados.USUARIO_INEXISTENTE);
		}

	}

	public Resultados escucharCancion(String mail, String tema, String autor) {
		Resultados result = null;
		Usuario user;
		Cancion cancion;
		user = this.buscarUsuario(mail);
		if (user == null) {
			result = Resultados.USUARIO_INEXISTENTE;
		} else {
			cancion = this.buscarCancion(tema, autor);
			if (cancion == null) {
				result = Resultados.CANCION_INEXISTENTE;
			} else {
				if (user.getCategoria() == Categorias.PREMIUM) {
					result = Resultados.CANCION_ESCUCHADA;
					user.ingresarCancion(cancion);
				} else {
					if (cancion.esRestringida(cancion)) {
						result = Resultados.CANCION_NO_DISPONIBLE;
					} else {
						if (user.getTemasPorDia() > 50) {
							result = Resultados.LIMITE_ALCANZADO;
						}
					}
				}
			}
		}

		return result;
	}

	public boolean altaCancion(String nombre, String autor, String genero, int diasPublicada) {
		boolean pudoAgregar = false;
		Cancion temaABuscar;
		temaABuscar = buscarCancion(nombre, autor);
		if (temaABuscar == null) {
			Cancion cancion = new Cancion(nombre, autor, genero,  diasPublicada);
			
			biblioteca.add(cancion);
			pudoAgregar = true;
		} else {
			// System.out.println(Resultados.CANCION_EXISTENTE);
		}

		return pudoAgregar;
	}

	private Usuario buscarUsuario(String mail) {
		Usuario userEncontrado = null;
		int i = 0;
		while (i < baseUsuarios.size() && baseUsuarios.get(i).getMail()!=mail) {
			i++;
		}

		if (i < baseUsuarios.size()) {
			userEncontrado = baseUsuarios.get(i);
		}

		return userEncontrado;
	}

	private Cancion buscarCancion(String nombre, String autor) {
		Cancion cancionEncontrada = null;
		int i = 0;
		while (i < biblioteca.size() && cancionEncontrada ==null){
				if(biblioteca.get(i).getNombre()== nombre && biblioteca.get(i).getAutor()==autor) {
					cancionEncontrada=biblioteca.get(i);
				}else {
					i++;
				}
		}

		return cancionEncontrada;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
