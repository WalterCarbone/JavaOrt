package ejercicio_tipo_parcial;

public class Test {

	public static void main(String[] args) {
		Usuario ortMusic = new Usuario ("1212","Walter");
		Resultado result;
		System.out.println("Cuenta :");
		System.out.println(ortMusic);
		result=ortMusic.agregarTema("Despacito", "Luis Fonci",2018,Genero.POP_LATINO);
		System.out.println(result);
		result=ortMusic.agregarTema("Bailando", "Enrique Iglesias",2014,Genero.POP_LATINO);
		System.out.println(result);
		result=result=ortMusic.agregarTema("La bicicleta", "Carlos Vives",2017,Genero.POP_LATINO);
		System.out.println(result);
		result=ortMusic.agregarTema("Despacito", "Luis Fonci",2018,Genero.POP_LATINO);
		System.out.println(result);
		result=ortMusic.agregarTema("Creo", "Fito Paez",2092,Genero.ROCK);
		System.out.println(result);
		result=ortMusic.agregarTema("Nueva noche Fria", "CJS",2003,Genero.ROCK);
		System.out.println(result);
		result=ortMusic.agregarTema("Ya non sos igual", "2minutos",1994,Genero.POP_LATINO);
		System.out.println(result);
		System.out.println("**********REPRODUCCION***************");
		result=ortMusic.reproducirTema("Despacito");
		System.out.println(result);
		result=ortMusic.reproducirTema("Genteque no");
		System.out.println(result);
		result=ortMusic.reproducirTema("Bailando");
		System.out.println(result);
		result=ortMusic.reproducirTema("Despacito");
		System.out.println(result);
		/*result=ortMusic.reproducirTema("Creo");
		System.out.println(result);*/
		System.out.println("*************LISTADO TEMAS*********");
		ortMusic.listarTema(Genero.ROCK);
		ortMusic.listarTema(Genero.POP_LATINO);
		System.out.println("*************TEMAS MaS REPRODUCIDO*********");
		ortMusic.temaMasReproducido(Genero.POP_LATINO);
		ortMusic.temaMasReproducido(Genero.ROCK);	
	}

}
