package tp3_ejercicio1_persona;

public class Test {

	public static void main(String[] args) {

		Agenda agenda = new Agenda();
		boolean resultado;
		String borro;
		boolean cambio;

		resultado = agenda.agregarPersona("Walter", "Carbone", "Obligado", "123");

		verifico(resultado);

		resultado = agenda.agregarPersona("Gisela", "Daus", "Guayaquil", "12323");
		verifico(resultado);

		resultado = agenda.agregarPersona("Perez", "Juan", "Cabildo 12345", "12358");
		verifico(resultado);

		agenda.listarPersonas();
		
		System.out.println("Eliminacion no exitosa");
		borro=agenda.removerPersona("1");
		verif(borro);
		agenda.listarPersonas();
		System.out.println("Eliminacion  exitosa");
		borro=agenda.removerPersona("12358");
		verif(borro);
		
		agenda.listarPersonas();
		System.out.println("Cambio domicilo no exitoso");
		cambio=agenda.modificarDomicilio("12358", "callao");
		verifico(cambio);
		agenda.listarPersonas();
		System.out.println("Cambio domicilo  exitoso");
		cambio=agenda.modificarDomicilio("12323", "callao");
		
		agenda.listarPersonas();
		
		
	}

	private static void verif(String borro) {
		if (borro !=null){
			System.out.println(Resultados.OPERACION_EXITOSA.getMsj());
		}else{
			System.out.println(Resultados.USUARIO_INEXISTENTE.getMsj());
		}
		
	}

	private static void verifico(boolean resultado) {
		if (resultado) {
			System.out.println(Resultados.OPERACION_EXITOSA.getMsj());
		} else {
			System.out.println(Resultados.USUARIO_INEXISTENTE.getMsj());
		}

	}

}
