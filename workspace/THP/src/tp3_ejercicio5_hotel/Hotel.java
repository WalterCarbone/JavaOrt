package tp3_ejercicio5_hotel;

public class Hotel {

	private String nombre;
	private String localidad;
	private int habitacionesTotales;
	private int habitacionesOcupadas;
	private int habitacionesReservadas;
	private static final int MIN_HAB = 1;
	private static final int MIN_RESERV = 0;
	private static final int MIN_OCUP = 0;

	public Hotel(String nombre, String localidad, int totalhab) {

		setNombre(nombre);
		setLocalidad(localidad);
		setHabitacionesTotales(totalhab);
	}

	public Hotel(String nombre, String localidad, int totalhab, int totalocup, int totalreserv) {

		setNombre(nombre);
		setLocalidad(localidad);
		setHabitacionesTotales(totalhab);
		setHabitacionesOcupadas(totalocup);
		setHabitacionesReservadas(totalreserv);

	}

	public String getNombre() {
		return this.nombre;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public int getHabitacionesTotales() {
		return this.habitacionesTotales;
	}

	public int getHabitacionesOcupadas() {
		return this.habitacionesOcupadas;
	}

	public int getHabitacionesReservadas() {
		return this.habitacionesReservadas;
	}

	public void setNombre(String nomb) {
		this.nombre = nomb;
	}

	private void setLocalidad(String loc) {
		this.localidad = loc;
	}

	private void setHabitacionesTotales(int habitaciones) {
		if (habitaciones >= MIN_HAB) {
			this.habitacionesTotales = habitaciones;
		} else {
			this.habitacionesTotales = MIN_HAB;
		}
	}

	private void setHabitacionesReservadas(int reserv) {
		if (reserv >= MIN_RESERV) {
			this.habitacionesReservadas = reserv;
		} else {
			this.habitacionesReservadas = MIN_RESERV;
		}
	}

	private void setHabitacionesOcupadas(int ocup) {
		if (ocup >= MIN_OCUP) {
			this.habitacionesOcupadas = ocup;
		} else {
			this.habitacionesOcupadas = MIN_OCUP;
		}
	}

	public int cantidadHabitacionesLibres() {

		return this.getHabitacionesTotales() - this.getHabitacionesOcupadas();
	}

	public int disponibilidad() {
		int disp = 0;
		disp = this.getHabitacionesTotales() - this.getHabitacionesOcupadas() - this.getHabitacionesReservadas();
		return disp;
	}

	public boolean ocuparHabitaciones(int cant, boolean valid) {
		boolean resp = false;

		if (valid == true) {
			if (cant <= this.getHabitacionesReservadas()) {
				ocuparConReserva(cant);
				resp = true;
			}
		} else {
			if (cant <= (disponibilidad())) {
				ocuparSinReserva(cant);
				resp = true;
			}

		}
		return resp;
	}

	private void ocuparSinReserva(int cant) {
		this.setHabitacionesOcupadas(getHabitacionesOcupadas() + cant);

	}

	private void ocuparConReserva(int cant) {
		this.setHabitacionesOcupadas(getHabitacionesOcupadas() + cant);
		this.setHabitacionesReservadas(getHabitacionesReservadas() - cant);

	}

	public boolean desocuparHabitaciones(int cant) {
		boolean resp;

		if (this.getHabitacionesOcupadas() >= cant) {
			this.setHabitacionesOcupadas(getHabitacionesOcupadas() - cant);
			resp = true;
		} else {
			resp = false;
		}
		return resp;
	}

	public boolean reservarHabitaciones(int cant) {
		boolean resp = false;
		if (cant <= disponibilidad()) {
			habitacionesReservadas += cant;
			this.setHabitacionesReservadas(this.getHabitacionesReservadas() + cant);
			resp = true;
		} else {
			resp = false;
		}
		return resp;
	}

	@Override
	public String toString() {
		return String.format("Hotel %s %s [habitaciones=%d, ocupadas=%d, reservadas=%d, libres=%s, disponibles=%d]",
				nombre, localidad, habitacionesTotales, habitacionesOcupadas, habitacionesReservadas,
				cantidadHabitacionesLibres(), disponibilidad());
	}
}
