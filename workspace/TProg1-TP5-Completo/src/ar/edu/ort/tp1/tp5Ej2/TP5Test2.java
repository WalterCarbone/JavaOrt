package ar.edu.ort.tp1.tp5Ej2;

import ar.edu.ort.tp1.tp5Ej2.AnioV2;

public class TP5Test2 {

	public static void main(String[] args) {		
		AnioV2 a2 = new AnioV2();
		
		System.out.println("Listado de Meses");
		for (int i = 0; i < a2.getMeses().length; i++) {
			System.out.println(a2.getMeses()[i]);
		}
		
		System.out.println();
		System.out.println("Obtener Nombre de un mes:");
		System.out.println(a2.getNombreMes(12));
		System.out.println(a2.getNombreMes(5));
		System.out.println("------------------");
		System.out.println(MESES.values()[3].name());
		System.out.println(MESES.values().length);
		System.out.println("han transcurrido: "+(a2.diasTranscurridos(9)+14)+" dias");
	}
}
