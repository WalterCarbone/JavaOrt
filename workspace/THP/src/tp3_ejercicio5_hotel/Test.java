package tp3_ejercicio5_hotel;

public class Test {

	public static void main(String[] args) {
	
		
		Hotel h1 = new Hotel("Hilton", "CABA", 200);
		Hotel h2 = new Hotel("Astoria", "MDQ",150,100,10);
		
		testearHotel(h1.getHabitacionesTotales(),h1.getHabitacionesOcupadas(),h1.getHabitacionesReservadas(), h1);
		testearHotel(h2.getHabitacionesTotales(),h2.getHabitacionesOcupadas(),h2.getHabitacionesReservadas(),h2);
		
		
		
	}

	private static void testearHotel(int habitacionesTotales, int habitacionesOcupadas, int habitacionesReservadas, Hotel hotel) {
		boolean resp1;
		boolean resp2;
		boolean resp3;
		boolean resp4;
		boolean resp5;
		boolean resp6;
		boolean resp7;
		
		System.out.println("Estado inicial " + hotel.getNombre());
		System.out.println(hotel);
		resp1=hotel.ocuparHabitaciones(201, false);
		mostrarResultado("ocupar sin reserva",201,resp1,hotel);
		resp2=hotel.ocuparHabitaciones(30, false);
		mostrarResultado("ocupar sin reserva",30,resp2, hotel);
		resp3=hotel.reservarHabitaciones(50);
		mostrarResultado("reservar",50,resp3, hotel);
		resp4=hotel.desocuparHabitaciones(200);
		mostrarResultado("liberar",200,resp4,hotel);
		resp5=hotel.ocuparHabitaciones(30, true);
		mostrarResultado("ocupar con reserva",30,resp5,hotel);
		resp6=hotel.ocuparHabitaciones(30, true);
		mostrarResultado("ocupar con reserva",30,resp6,hotel);
		resp7=hotel.desocuparHabitaciones(40);
		mostrarResultado("liberar",50,resp7,hotel);
	}

	private static void mostrarResultado(String accion,  int cant, boolean respuesta, Hotel hotel) {
		if (respuesta){
			System.out.println("Se pudo "+accion+" "+cant+" habitaciones");
		}else{
			System.out.println("No se pudo "+accion+" "+cant+" habitaciones");
		}
		System.out.println(hotel);
	}


}
