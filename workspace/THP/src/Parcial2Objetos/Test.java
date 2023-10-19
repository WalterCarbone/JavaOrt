package Parcial2Objetos;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResultadoReserva resul;
		Vuelo miVuelo = new Vuelo("AA3313",180);
		
		resul=miVuelo.reservarAsiento(111,123,Clase.PRIMERA,"A",1);
		System.out.println(resul);
		resul=miVuelo.reservarAsiento(22,123,Clase.TURISTA,"F",6);
		System.out.println(resul);
		resul=miVuelo.reservarAsiento(33,123,Clase.PRIMERA,"A",3);
		System.out.println(resul);
		resul=miVuelo.reservarAsiento(34,123,Clase.TURISTA,"F",4);
		System.out.println(resul);
		resul=miVuelo.reservarAsiento(1341,123,Clase.PRIMERA,"A",2);
		System.out.println(resul);
		miVuelo.mostrarMontoRecaudadoDeClase(Clase.PRIMERA);
		miVuelo.mostrarMontoRecaudadoDeClase(Clase.BUSINESS);
		miVuelo.mostrarMontoRecaudadoDeClase(Clase.TURISTA);
		
	}

}
