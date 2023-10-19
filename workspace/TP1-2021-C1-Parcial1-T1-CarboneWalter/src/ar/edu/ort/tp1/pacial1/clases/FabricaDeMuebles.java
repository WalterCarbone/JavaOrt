package ar.edu.ort.tp1.pacial1.clases;

import java.util.ArrayList;

public class FabricaDeMuebles implements Mostrable {
	private String nombre;
	private ArrayList<Mueble> mueblesFabricados;

	public FabricaDeMuebles(String nombre) {
		setNombre(nombre);
		mueblesFabricados = new ArrayList<>();

	}

	private void setNombre(String nombre) {
		this.nombre = nombre;

	}

	public String getNombre() {
		return this.nombre;
	}

	public boolean fabricar(Mueble m) {
		boolean retorno = false;
		if (m != null) {
			mueblesFabricados.add(m);
			retorno = true;
		}
		return retorno;
	}

	public boolean seHaFabricado(String modelo) {
		boolean seHaFabricado = false;
		int i = 0;
		while (i < mueblesFabricados.size() && !modelo.equals(mueblesFabricados.get(i).getModelo())) {
			i++;
		}

		if (i < mueblesFabricados.size()) {
			seHaFabricado = true;
		}

		return seHaFabricado;
	}

	@Override
	public void mostrar() {
		int contMesas = 0;
		int contSillas = 0;
		int contSillones = 0;
		float total=0;

		for (Mueble mueble : mueblesFabricados) {
			if (mueble instanceof Mesa) {
				contMesas++;
				total+=mueble.calcularPrecioVenta();
			} else if (mueble instanceof Silla) {
				contSillas++;
				total+=mueble.calcularPrecioVenta();
			} else {
				contSillones++;
				total+=mueble.calcularPrecioVenta();
			}

		}
		System.out.println("Se han fabricado: "+ contMesas+" Mesas, "+contSillas+" Sillas, " + contSillones+" Sillones");
		System.out.println("La venta total fue: $" +total);
	}
}
