package ar.edu.ort.tp1.tp6Ej2;

import ar.edu.ort.tp1.tdas.interfaces.Cola;
import ar.edu.ort.tp1.tp6Ej2.clases.BarajaEspaniola;
import ar.edu.ort.tp1.tp6Ej2.clases.Comodin;
import ar.edu.ort.tp1.tp6Ej2.clases.Naipe;
import ar.edu.ort.tp1.tp6Ej2.clases.NaipeNumerado;

public class Ejercicio2 {

	public static void main(String[] args) {
		BarajaEspaniola mazo = new BarajaEspaniola(true);
		Cola<Naipe> monton = mazo.extraer(10);
		
		boolean hayComodines = revisar(monton);
		
		if (hayComodines) {
			System.out.println("Se encontraron comodines");
		} else {
			System.out.println("No se encontraron comodines");
		}
	}

	private static boolean revisar(Cola<Naipe> monton) {
		boolean hay = false;
		
		NaipeNumerado extra = new NaipeNumerado(0, BarajaEspaniola.PaloEspaniol.BASTOS);
		monton.add(extra);
		Naipe carta =monton.remove();
		
		while(!carta.equals(extra)){
			if(carta.getDescripcion().equals("Comodin")){
			hay=true;
			}
			monton.add(carta);
			System.out.println(carta);
			carta=monton.remove();
		}
		
		return hay;
	}

}