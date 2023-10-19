import java.util.ArrayList;

public class Numero {

	private ArrayList<Integer> numeros;
	private int numero;

	public Numero() {
		numeros = new ArrayList<>();
		completar();

	}

	private void completar() {
	for (int i = 1; i <= 10; i++) {
	    numero = (int) (Math.random() * 100);
	    if (numeros.contains(numero)) {
	        i--;
	    } else {
	        numeros.add(numero);
	    }

	}
	}
	
	
	public void imprimir(){
		System.out.println("El listado es:");
		for (Integer n : numeros) {
		    System.out.print(n + ",");
		}
	}
}