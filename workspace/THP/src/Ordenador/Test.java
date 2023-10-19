package Ordenador;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int cant;
		int valor;
		int aux;
		int segundo;
		int z;
		valor = 0;
		z = 1;
		cant = 0;
		
		segundo = 0;

		boolean ordenado = false;
		int tamano;

		ArrayList<Integer> nro = new ArrayList<>();

		System.out.println("Cantidad de numeros :");
		cant = input.nextInt();

		for (int i = 0; i < cant; i++) {
			System.out.println("Ingrese valor :");
			valor = input.nextInt();
			nro.add(valor);

		}
		for (Integer i : nro) {
			System.out.println(i);
		}
		tamano = nro.size();

		while (z<tamano && !ordenado) {
			z++;
			ordenado=true;
			for (int i=0;i==(tamano-z);i++){
				
				if (nro.get(i)> nro.get(i+1)){
					ordenado=false;
					aux=nro.get(i);
					nro.set(i, nro.get(i+1));
					nro.set(i+1, aux);
				}
			}
			
			
			
		}

		for (Integer i : nro) {
			System.out.println(i);
		}
		input.close();
	}

}
