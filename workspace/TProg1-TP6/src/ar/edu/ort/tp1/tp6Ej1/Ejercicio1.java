package ar.edu.ort.tp1.tp6Ej1;

import ar.edu.ort.tp1.tdas.implementaciones.PilaNodos;
import ar.edu.ort.tp1.tdas.interfaces.Pila;
import ar.edu.ort.tp1.tp6Ej1.clases.FabricanteDePelotas;
import ar.edu.ort.tp1.tp6Ej1.clases.PelotaDeTenis;
import ar.edu.ort.tp1.tp6Ej1.clases.TuboPelotasDeTenis;
import ar.edu.ort.tp1.tp6Ej1.clases.PelotaDeTenis.EstadoPelota;

public class Ejercicio1 {

	public static void main(String[] args) {
		// Obtener un tubo de pelotas de tenis del Fabricante
		TuboPelotasDeTenis tuboDePelotas = FabricanteDePelotas.fabricarTubo();

		// Sacar una pelota del tubo, usara una vez y volverla la guardar.
		PelotaDeTenis pelota = tuboDePelotas.extraer();
		pelota.usar();
		tuboDePelotas.guardar(pelota);

		// Desarrollar el metodo nombrado a continuacion.
		// Debe quedar tal como estaba al recibirlo.
		listarContenidoTubo(tuboDePelotas);
	}

	private static void listarContenidoTubo(TuboPelotasDeTenis tuboDePelotas) {
		Pila<PelotaDeTenis> nuevas =new PilaNodos<>(3);
		Pila<PelotaDeTenis> usadas =new PilaNodos<>(3);
		Pila<PelotaDeTenis> gastadas =new PilaNodos<>(3);
		PelotaDeTenis pelota = new PelotaDeTenis();
		while (!tuboDePelotas.estaVacio()) {
			pelota = tuboDePelotas.extraer();
			if (pelota.getEstado().equals("NUEVA")) {
				nuevas.push(pelota);
				System.out.println(pelota);
			} else if (pelota.getEstado().equals("USADA")) {
				usadas.push(pelota);
				System.out.println(pelota);
			} else {
				gastadas.push(pelota);
				System.out.println(pelota);
			}
		}
		while(!nuevas.isEmpty()){
			tuboDePelotas.guardar(nuevas.pop());
		}
		while(!usadas.isEmpty()){
			tuboDePelotas.guardar(usadas.pop());
		}
		while(!gastadas.isEmpty()){
			tuboDePelotas.guardar(gastadas.pop());
		}
		
	}

}
