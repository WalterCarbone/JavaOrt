package ejemplo_parcial_concursoCocina;

public class Test {

	public static void main(String[] args) {
		Concurso miConcurso= new Concurso();
		Resultado result;
		result=miConcurso.agregarParticipante("14723980", "Agustina", "González");
		System.out.println(result);
		result=miConcurso.agregarParticipante("14723980", "Samantha", "Perez");
		System.out.println(result);
		result=miConcurso.agregarParticipante("36581454", "Damian", "Martínez");
		System.out.println(result);
		result=miConcurso.agregarParticipante("17606987", "Martina", "Luna");
		System.out.println(result);
		result=miConcurso.agregarParticipante("33887253", "Emilio", "Caxi");
		System.out.println(result);
		miConcurso.imprimirParticipantes();
		/*result=miConcurso.votar("123456789");
		System.out.println(result);
		result=miConcurso.votar("14723980");
		System.out.println(result);
		result=miConcurso.votar("36581454");
		System.out.println(result);
		result=miConcurso.votar("36581454");
		System.out.println(result);
		result=miConcurso.votar("36581454");
		System.out.println(result);
		result=miConcurso.votar("17606987");
		System.out.println(result);
		result=miConcurso.votar("33887253");
		System.out.println(result);
		result=miConcurso.votar("33887253");
		System.out.println(result);*/
		miConcurso.imprimirParticipantes();
		result=miConcurso.eliminarParticipante("17606987");
		System.out.println(result);
		result=miConcurso.eliminarParticipante("999987");
		System.out.println(result);
		miConcurso.imprimirParticipantes();
		miConcurso.mostrarGanador();
	}

}
