package tp4_ejercicio3_musica;

public class Test {

	public static void main(String[] args) {
		Aplicacion app = new Aplicacion("miApp");
		boolean primera;
		boolean usuario;
		Resultados result;
		System.out.println("ALTA de 3 canciones OK y 1 error");
		primera =app.altaCancion("EnterSadman", "Metallica", "Heavy", 6);
		System.out.println(primera);
		primera=app.altaCancion("Satisfaction", "Rolling Stones", "Rock", 4);
		System.out.println(primera);
		primera=app.altaCancion("El 38", "Divididos", "Rock", 33);
		System.out.println(primera);
		primera=app.altaCancion("El 38", "Divididos", "Clasica", 8);
		System.out.println(primera);
		System.out.println("********************************");
		System.out.println("ALTA de 3 users OK y 1 error");
		usuario=app.altaUsuario("wal", "carbone", 45, Categorias.GRATUITO);
		System.out.println(usuario);
		usuario=app.altaUsuario("gi", "daus", 33, Categorias.PREMIUM);
		System.out.println(usuario);
		usuario=app.altaUsuario("juan@hotmail", "juani", 13, Categorias.REGISTRADO);
		System.out.println(usuario);
		usuario=app.altaUsuario("wal@hotmail", "fusi", 15, Categorias.GRATUITO);
		System.out.println(usuario);
		System.out.println("********************************");
		result=app.escucharCancion("gi", "El 38", "Divididos");
		System.out.println(result);
		result=app.escucharCancion("gi", "El 38", "Divididos");
		System.out.println("********************************");
		app.listarCanciionesPorUsuario("gi");
		System.out.println("********************************");
		app.listarUsuarios();
	}
}
