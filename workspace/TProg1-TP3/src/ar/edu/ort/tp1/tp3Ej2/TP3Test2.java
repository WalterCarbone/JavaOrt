package ar.edu.ort.tp1.tp3Ej2;

public class TP3Test2 {

	public static void main(String[] args) {
		Vendedor v = new Vendedor("Pedro", 25,100,200,5);
		Vendedor v2 = new Vendedor("Maria", 30,100,200,10);
		
		System.out.println(v.getClass().getSimpleName() + " 1 " + v.getNombre() + " gana:"+v.calcularPago());
		System.out.println(v2.getClass().getSimpleName() + " 2 " + v2.getNombre() + " gana:"+v2.calcularPago());		
	}
}