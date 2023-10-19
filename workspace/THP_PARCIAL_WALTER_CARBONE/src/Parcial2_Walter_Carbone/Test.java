package Parcial2_Walter_Carbone;

public class Test {

	public static void main(String[] args) {
	ResultadoReservaBoletos result;
		
		
	Vuelo miVuelo= new Vuelo("AA3313",180);
	result=miVuelo.reservarAsiento(11111, 1234, Clase.PRIMERA);
	System.out.println(result);
	result=miVuelo.reservarAsiento(22222, 561234, Clase.PRIMERA);
	System.out.println(result);
	result=miVuelo.reservarAsiento(33333, 123434, Clase.TURISTA);
	System.out.println(result);
	result=miVuelo.reservarAsiento(44444, 124534, Clase.TURISTA);
	System.out.println(result);
	result=miVuelo.reservarAsiento(55555, 1666234, Clase.BUSINESS);
	System.out.println(result);
	result=miVuelo.reservarAsiento(11111, 1234, Clase.PRIMERA);
	System.out.println(result);
	miVuelo.mostrarMontoRecaudadoDeClase(Clase.PRIMERA);
	miVuelo.mostrarMontoRecaudadoDeClase(Clase.BUSINESS);
	miVuelo.mostrarMontoRecaudadoDeClase(Clase.TURISTA);
	miVuelo.listarAsientosReservados();
	result=miVuelo.anularReserva(55555);
	System.out.println(result);
	result=miVuelo.anularReserva(99999);
	System.out.println(result);
	miVuelo.mostrarMontoRecaudadoDeClase(Clase.BUSINESS);
	miVuelo.listarAsientosReservados();
	
	
	}

}
