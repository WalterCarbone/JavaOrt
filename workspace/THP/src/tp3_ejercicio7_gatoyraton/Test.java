package tp3_ejercicio7_gatoyraton;

public class Test {

	public static void main(String[] args) {
		boolean result;
		Raton r1=new Raton(100);
		Gato g1=new Gato(100);
		result=g1.alcanzar(80, r1);
		
		if (result){
			System.out.println("Alcanzó");
		}else{
			System.out.println("No alcanzó");
		}

	}

}
