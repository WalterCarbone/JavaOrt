package tp1_ejercicio3;



public class Test {

	public static void main(String[] args) {
		Carrera miCarrera;

		miCarrera = new Carrera("Maraton");
		miCarrera.agregarCorredor("Walter", 8.3);
		miCarrera.agregarCorredor("Adrian", 12.36);
		miCarrera.agregarCorredor("Roman", 28.4);
		miCarrera.agregarCorredor("Pedro", 12.36);
		miCarrera.agregarCorredor("Juan", 8.3);
		miCarrera.agregarCorredor("Sergio", 8.2);
		miCarrera.mostrarGanador();

	}

}
