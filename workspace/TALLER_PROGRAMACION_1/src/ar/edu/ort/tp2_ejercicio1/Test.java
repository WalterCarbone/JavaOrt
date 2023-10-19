package ar.edu.ort.tp2_ejercicio1;



public class Test {

	public static void main(String[] args) {
	
		Persona p1;
		Hito h1;
		
		p1 = new Persona("Walter","Carbone");
		p1.agregarTelefono(4702, 1950,054, TipoDeLinea.FIJO);
		p1.agregarMail("wcarbone75@gmail.com");
		p1.agregarTelefono(11, 53397552, 54, TipoDeLinea.CELULAR);
		p1.agregarMacota("Giny","caniche");
		p1.agregarMacota("Magi","caniche");
		h1 = new Hito ("25/10/20", "Cumpleaños Walter");
		h1.agregarInvolucrados(p1);
		System.out.println(p1);
		System.out.println(h1);		
		

	}

}
