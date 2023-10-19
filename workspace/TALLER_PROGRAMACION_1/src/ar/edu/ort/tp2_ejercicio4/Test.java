package ar.edu.ort.tp2_ejercicio4;

public class Test {

	public static void main(String[] args) {
		Vivienda v1;
		v1 = new Vivienda(1, "Obligado", 2935, 10, "A");
		v1.agregarPersona("Walter","Carbone", 45);
		v1.agregarPersona("Gisela","Daus", 34);
		v1.agregarMueble("Mesa", "madera", "marrón");
		v1.agregarMueble("Silla", "plástico", "blanco");
		System.out.println(v1);	
	}

}
