package tp3_ejercicio4_cafetera;

public class Test {

	public static void main(String[] args) {
		Cafetera c1= new Cafetera();
		Cafetera c2 = new Cafetera (500,0);
		Cafetera c3 = new Cafetera (750,500);
System.out.println(c1);
c1.testearCafetera(300, 800);
System.out.println(c2);
c2.testearCafetera(500, 600);
System.out.println(c3);
c3.testearCafetera(250, 250);
	}

}
