package tp4_ejercicio2_edificio;

public class Test {

	public static void main(String[] args) {
		Edificio alvear = new Edificio ("Libertador", 1);
		
		//alvear.listarUnidades();
		alvear.habitarUnidad(1, "2497", "Walter");
		alvear.listarUnidades();
		alvear.listarMorosos();
		alvear.agregarDeuda(1, 100);
		alvear.listarMorosos();
		alvear.agregarDeuda(1, 50);
		alvear.listarMorosos();
		alvear.cancelarDeuda(1, 50);
		//alvear.listarUnidades();
	alvear.listarMorosos();
	alvear.cancelarDeuda(1, 10);
	alvear.listarUnidades();
	alvear.listarMorosos();
	alvear.cancelarDeuda(1, 90);
	alvear.listarMorosos();
	alvear.listarUnidades();
	}

}
