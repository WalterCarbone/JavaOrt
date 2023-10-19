package tp3_ejercicio8_superheroe;

public class Test {

	public static void main(String[] args) {
		Superheroe h1=new Superheroe("Superman",90,75,70);
		Superheroe h2=new Superheroe("Batman",95,70,70);
		System.out.println(h1);
		System.out.println("				VS");
		System.out.println(h2);
		System.out.println("Ganador :" + h1.competir(h2));

	}

}
