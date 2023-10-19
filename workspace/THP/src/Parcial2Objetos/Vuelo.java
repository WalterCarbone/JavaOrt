package Parcial2Objetos;

import java.util.ArrayList;

public class Vuelo {

	private String vuelo;
	private int cantAsientos;
	private double totalRecaudado;
	private static final double REC_INI = 0;
	private static final int MINIMO = 1;
	private static final int MAXIMO = 6;

	private ArrayList<Asiento> asientosReservados;

	public Vuelo(String vuelo, int cantidad) {
		this.setVuelo(vuelo);
		this.setCantAsientos(cantidad);
		totalRecaudado = REC_INI;
		asientosReservados = new ArrayList<>();
	}

	public ResultadoReserva reservarAsiento(int dni, int telefono, Clase clase, String fila, int numero) {
		ResultadoReserva result = null;
		Asiento aBuscar = null;
		boolean dist = false;

		if (asientosReservados.size() == this.cantAsientos) {
			result = ResultadoReserva.ERROR_AVION_COMPLETO;
		} else {
			aBuscar = buscarAsientoReservado(fila, numero);
			if (aBuscar != null) {
				result = ResultadoReserva.ERROR_YA_TIENE_UN_PASAJE;
			} else {
				dist = verDistanciamiento(fila, numero);
				if (dist == true) {
					asientosReservados.add(new Asiento(dni, telefono, clase, fila, numero));
					result = ResultadoReserva.RESERVA_CONFIRMADA;
					// totalRecaudado = totalRecaudado + aBuscar.getPrecio();
				} else {
					result = ResultadoReserva.ERROR_EL_ASIENTO_DE_AL_LADO_ESTA_OCUPADO;
				}
			}
		}

		return result;
	}

	private double obtenerAcumuladoPorClase(Clase clase) {
		double acum = 0;
		for (Asiento a : asientosReservados) {
			if (a.getClase() == clase) {
				acum = acum + a.getPrecio();
			}
		}
		return acum;
	}

	public void mostrarMontoRecaudadoDeClase(Clase clase) {
		double acum = 0;

		if (asientosReservados.size() == 0) {
			System.out.println("No hay asientos reservados en ninguna clase");

		} else {
			acum = obtenerAcumuladoPorClase(clase);
			if (acum > 0) {
				System.out.println("El monto recuadado hasta el momento en la clase " + clase + " es :$" + acum);
			} else {
				System.out.println("No hay asientos reservados para la clase " + clase);
			}
		}
	}

	private Asiento buscarAsientoReservado(String fila, int numero) {
		int i = 0;
		Asiento aBuscar = null;

		while (i < asientosReservados.size() && (!asientosReservados.get(i).getFila().equals(fila)
				|| asientosReservados.get(i).getNumero() != numero)) {
			i++;
		}

		if (i < asientosReservados.size()) {
			aBuscar = asientosReservados.get(i);
		}

		return aBuscar;

	}

	private boolean verDistanciamiento(String fila, int numero) {
		boolean distanciamiento = false;
		Asiento aBuscarI = null;
		Asiento aBuscarD = null;

		aBuscarI = buscarIzquierda(fila, numero);
		aBuscarD = buscarDerecha(fila, numero);

		if (aBuscarI == null && aBuscarD == null) {
			distanciamiento = true;
		}

		return distanciamiento;
	}

	private Asiento buscarIzquierda(String fila, int numero) {
		Asiento aIzq = null;

		if (numero > MINIMO) {
			aIzq = buscarAsientoReservado(fila, (numero-1));
		}

		return aIzq;
	}

	private Asiento buscarDerecha(String fila, int numero) {
		Asiento aDer = null;

		if (numero < MAXIMO) {
			aDer = buscarAsientoReservado(fila, (numero+1));
		}

		return aDer;
	}

	public String getVuelo() {
		return this.vuelo;
	}

	public int getCantAsientos() {
		return this.cantAsientos;
	}

	public double getTotalRecaudado() {
		return this.totalRecaudado;
	}

	private void setCantAsientos(int cantidad) {
		this.cantAsientos = cantidad;
	}

	private void setVuelo(String vuelo) {
		this.vuelo = vuelo;
	}

	@Override
	public String toString() {
		return "Vuelo [vuelo=" + vuelo + ", cantAsientos=" + cantAsientos + ", totalRecaudado=" + totalRecaudado
				+ ", asientosReservados=" + asientosReservados + "]";
	}

}
