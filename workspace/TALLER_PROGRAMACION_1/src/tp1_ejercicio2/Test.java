package tp1_ejercicio2;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Carrera miCarrera;

		miCarrera = new Carrera("Maraton");
		miCarrera.agregarCorredor("Walter", 8.3);
		miCarrera.agregarCorredor("Adrian", 12.36);
		miCarrera.agregarCorredor("Roman", 28.4);
		miCarrera.agregarCorredor("Pedro", 12.36);
		miCarrera.mostrarCorredores();
		miCarrera.calcularGanador();
		miCarrera.mostrarGanador();

	}

}
