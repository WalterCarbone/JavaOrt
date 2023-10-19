package ejercicio_tipo_parcial;

import java.util.ArrayList;

public class Usuario {

	private String idUsuario;
	private String Nombre;
	private ArrayList<Tema> listaTemas;

	public Usuario(String id, String nombre) {
		this.setIdUsuario(id);
		this.setNombre(nombre);
		listaTemas = new ArrayList<>();

	}

	public Resultado agregarTema(String titulo, String autor, int anio, Genero genero) {
		Resultado pudoAgregar;
		Tema temaAgregar;
		temaAgregar = buscarTemaPorTitulo(titulo);
		if (temaAgregar == null) {
			listaTemas.add(new Tema(titulo, autor, anio, genero));
			pudoAgregar = Resultado.TEMA_AGREGADO;
		} else {
			pudoAgregar = Resultado.TEMA_EXISTENTE;
		}

		return pudoAgregar;
	}

	public void listarTema(Genero genero) {

		for (Tema t : listaTemas) {
			if (t.getGenero() == genero) {
				System.out.println(t);
			}
		}
	}

	public void temaMasReproducido(Genero genero){
		int max=0;
		Tema masReproducido=null;
		
		for (Tema t : listaTemas) {
			if (t.getGenero().equals(genero)) {
				if(t.getCantReproducciones()>max){
					masReproducido=t;
					max=t.getCantReproducciones();
				}
			}
				
			}
		if(max>0){
		System.out.println("El tema m�s reproducido del genero " + genero + " es:");
		System.out.println(masReproducido);
		}else{
			System.out.println("El tema m�s reproducido del genero " + genero + " es:");
			System.out.println("No hubo reproducciones para este genero");
		}
	}
	
	
	
	
	public Resultado reproducirTema(String titulo) {
		Resultado pudoReproducir;
		Tema temaReproducir;
		temaReproducir = buscarTemaPorTitulo(titulo);
		if (temaReproducir != null) {
			temaReproducir.agregarReproduccion();
			pudoReproducir = Resultado.REPRODUCCION_EFECTUADA;
		} else {
			pudoReproducir = Resultado.TEMA_INEXISTENTE;
		}

		return pudoReproducir;
	}

	private Tema buscarTemaPorTitulo(String titulo) {
		Tema temaEncontrado = null;
		int i = 0;
		while (i < listaTemas.size() && titulo != listaTemas.get(i).getTitulo()) {
			i++;
		}
		if (i < listaTemas.size()) {
			temaEncontrado = listaTemas.get(i);
		}

		return temaEncontrado;
	}

	private void setIdUsuario(String id) {
		this.idUsuario = id;
	}

	private void setNombre(String nombre) {
		this.Nombre = nombre;
	}

	@Override
	public String toString() {
		return "Usuario: " + idUsuario + ". Nombre:" + Nombre;
	}
	

}
