package tp4_ejercicio4_drsueno;

public class Test {

	public static void main(String[] args) {
		AgendaMedica agenda = new AgendaMedica("Dr Sueño",3);
		Resultado result;
		Boolean p;
		Turno listado;
		
		System.out.println("Registro 1 turno ok");
		result=agenda.registrarTurno(24, "walter", "Carbone", "32323-2323");
		System.out.println(result);
		System.out.println("Registro 2 turno ok");
		result=agenda.registrarTurno(45, "juan", "perez", "322323323-2323");
		System.out.println(result);
		System.out.println("Registro 3 turno ok");
		result=agenda.registrarTurno(4235, "gisela", "daus", "2323");
		System.out.println(result);
		System.out.println("LISTA DE TURNOS");
		agenda.listarTurnos();
		System.out.println("1 presente ok");
		p=agenda.darPresente(24);
		System.out.println(p);
		System.out.println("2 presente ok");
		p=agenda.darPresente(45);
		System.out.println(p);
		System.out.println("3 presente error");
		p=agenda.darPresente(4);
		System.out.println(p);
		System.out.println("LISTA DE TURNOS");
		agenda.listarTurnos();
		System.out.println("Registro 1 turno ERROR");
		result=agenda.registrarTurno(42, "walter", "Carbone", "32323-2323");
		System.out.println(result);
		System.out.println("Anulo 1 turno OK" );
		p=agenda.anularTurno(45);
		System.out.println(p);
		System.out.println("LISTA DE TURNOS");
		agenda.listarTurnos();
		System.out.println("Registro 1 turno ERROR");
		result=agenda.registrarTurno(24, "walter", "Carbone", "32323-2323");
		System.out.println(result);
	
		System.out.println(agenda.obtenerAusentes());
		
	}

}
