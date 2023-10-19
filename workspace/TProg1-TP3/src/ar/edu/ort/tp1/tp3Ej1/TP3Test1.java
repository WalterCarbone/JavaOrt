package ar.edu.ort.tp1.tp3Ej1;

public class TP3Test1 {

	public static void main(String[] args) {
		Asalariado a = new Asalariado("Jose", 30, 10000);
		SubContratado s = new SubContratado("Carlos", 23, 50, 100);
		
		System.out.println(a.getClass().getSimpleName() + " " + a.getNombre() + " gana:"+a.calcularPago());
		System.out.println(s.getClass().getSimpleName() + " " + a.getNombre() + " gana:"+s.calcularPago());
	}
}
