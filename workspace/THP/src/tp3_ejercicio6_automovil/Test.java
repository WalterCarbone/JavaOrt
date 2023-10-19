package tp3_ejercicio6_automovil;

public class Test {

	public static void main(String[] args) {
		double v1=0;
		double v2=0;
		Automovil a1 = new Automovil("Ford","Fiesta","ABCD123",40);
		System.out.println(a1);
		System.out.println("SETEO RENDIMIENTO POR LITRO EN 10");
		a1.setRendimientoPorLitro(10);
		System.out.println(a1);
		System.out.println("LLENO EL TANQUE CON 20");
		a1.cargarCombustible(20);
		System.out.println(a1);
		
		
		v1=a1.viajar(180);
		System.out.println("INTENTO VIAJAR 180 km Y VIAJO " + v1 + " km" );		
		System.out.println(a1);
		v2=a1.viajar(50);
		System.out.println("INTENTO VIAJAR 50 KM Y VIAJO " + v2 + " km");
		System.out.println(a1);

	}

}
