package Parcial2_Walter_Carbone;

import java.util.ArrayList;

public class Vuelo {
	private static final double REC_INI = 0;
	private String numero;
	private int cantAsientos;
	private double montoRecaudado;
	private ArrayList<Asiento> asientosReservados;

	public Vuelo(String numero, int cantAsientos) {
		setNumero(numero);
		setCantAsientos(cantAsientos);
		montoRecaudado = REC_INI;
		asientosReservados = new ArrayList<>();

	}

	public ResultadoReservaBoletos reservarAsiento(int dni, int telefono, Clase clase) {
		Asiento aReservar;
		ResultadoReservaBoletos result;

		if (asientosReservados.size() == this.getCantAsientos()) {
			result = ResultadoReservaBoletos.ERROR_AVION_COMPLETO;
		} else {

			aReservar = buscarAsientoReservado(dni);
			if (aReservar == null) {
				asientosReservados.add(new Asiento(dni, telefono, clase));
				result = ResultadoReservaBoletos.RESERVA_CONFIRMADA;
			} else {
				result = ResultadoReservaBoletos.ERROR_YA_TIENE_UN_PASAJE;
			
		}
		}
		return result;
	}

	private Asiento buscarAsientoReservado(int dni) {
		Asiento miAsiento = null;
		int i = 0;
		while (i < asientosReservados.size() && asientosReservados.get(i).getPasajero().getDni() != dni) {
			i++;
		}
		if (i < asientosReservados.size()) {
			miAsiento = asientosReservados.get(i);
		}

		return miAsiento;
	}

	public ResultadoReservaBoletos anularReserva(int dni) {
		ResultadoReservaBoletos result;
		Asiento aBorrar;
		aBorrar = buscarAsientoReservado(dni);
		if (aBorrar != null) {
			asientosReservados.remove(aBorrar);
			result = ResultadoReservaBoletos.SE_HA_ANULADO_LA_RESERVA_CON_EXITO;
		} else {
			result = ResultadoReservaBoletos.NO_EXISTE_UNA_RESERVA_CON_ESE_DNI;
		}

		return result;
	}

	private double obtenerAcumuladoPorClase(Clase clase) {
		double acumulado = 0;

		for (Asiento a : asientosReservados) {
			if (a.getClase() == clase) {
				acumulado = acumulado + a.getPrecio();
			}
		}

		return acumulado;
	}

	public void mostrarMontoRecaudadoDeClase(Clase clase) {
		double recaudado = 0;
		if (asientosReservados.size() == 0) {
			System.out.println("No hay asientos reservados en ninguna clase.");
		} else {
			recaudado = obtenerAcumuladoPorClase(clase);
			if (recaudado > 0) {
				System.out.println("El monto acumulado hasta el momento en la clase " + clase + " es :$" + recaudado);
			} else {
				System.out.println("No hay asientos reservados para la clase " + clase);
			}
		}
	}

	public void listarAsientosReservados() {
		System.out.println("La cantidad de asientos reservados es: " + asientosReservados.size());
		for (Asiento a : asientosReservados) {
			System.out.println(a);
		}
	}

	private void setNumero(String numero) {
		this.numero = numero;
	}

	private void setCantAsientos(int cant) {
		this.cantAsientos = cant;
	}

	public int getCantAsientos() {
		return this.cantAsientos;
	}

	public String getNumero() {
		return this.numero;
	}

	@Override
	public String toString() {
		return "Vuelo Número:" + numero + ", Cantidad de asientos" + cantAsientos + ", Monto recuadado $"
				+ montoRecaudado + ", Asientos reservados" + asientosReservados;
	}

}
