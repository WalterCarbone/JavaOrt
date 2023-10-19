package tp3_ejercicio4_cafetera;

public class Cafetera {

	private int capacidadMaxima;
	private int cantidadActual;

	public Cafetera() {
		this.capacidadMaxima = 1000;
		this.cantidadActual = 0;
	}

	public Cafetera(int max, int act) {
		this.capacidadMaxima = max;
		this.cantidadActual = act;
	}

	public int getCapacidadMaxima() {
		return this.capacidadMaxima;
	}

	public int getCantidadActual() {
		return this.cantidadActual;
	}

	private void setCapacidadMaxima(int max) {
		if (max < 250) {
			this.capacidadMaxima = 250;
		} else {
			this.capacidadMaxima = max;
		}
	}

	private void setCantidaddActual(int act) {
		if (act < 0) {
			System.out.println("Error, no puede ser menor a cero");
		} else if (act > this.capacidadMaxima) {
			System.out.println("Error, no puede ser  mayor a la capacidad máxima");
		} else {
			this.cantidadActual = act;
		}
	}

	private void llenar() {
		this.setCantidaddActual(getCapacidadMaxima());
	}

	private void vaciar() {
		this.setCantidaddActual(0);
	}

	private void servirTaza(int taza) {
		if (this.getCantidadActual() == 0) {
			System.out.println("MAQUINA SIN CAFE");
		} else if (taza > this.getCantidadActual()) {
			System.out.println("Solo se puede servir : " + (taza - this.getCantidadActual()));
			vaciar();
		} else {
			System.out.println("Se sirve el café.");
			this.setCantidaddActual(getCantidadActual() - taza);

		}
	}

	

	private void agregarCafe(int cant) {
		if (this.getCapacidadMaxima() > this.cantidadActual + cant) {
			System.out.println("Se agrega de cafe");
			this.setCantidaddActual(getCantidadActual() + cant);
		} else {
			System.out.println("Se devuelven : " + (this.getCantidadActual() + cant - this.getCapacidadMaxima()));
			llenar();
		}
	}

	public void testearCafetera(int taza, int cafe) {
		System.out.println("Sirviendo la capacidad de taza : " + taza);
		this.servirTaza(taza);
		System.out.println("** VACIAR CAFETERA **");
		this.vaciar();
		System.out.println("** Agregar la cantidad de cafe : " + cafe);
		this.agregarCafe(cafe);
		System.out.println("** LLENAR CAFETERA **");
		this.llenar();
		System.out.println(" * * *  FIN DE TEST  * * *\n");
	}

	@Override
	public String toString() {
		return "Capacidad máxima :" + capacidadMaxima + " \nCapacidad actual :" + cantidadActual;
	}

}
