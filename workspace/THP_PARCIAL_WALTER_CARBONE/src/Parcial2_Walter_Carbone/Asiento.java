package Parcial2_Walter_Carbone;

public class Asiento {

	private Pasajero pasajero;
	private Clase clase;
	private double precio;
	private static final double PRECIO_TURISTA=50000;
	private static final double PRECIO_BUSINESS=100000;
	private static final double PRECIO_PRIMERA=150000;
	
	public Asiento (int dni ,int telefono, Clase clase){
		pasajero = new Pasajero(dni,telefono);
		setClase(clase);
		setPrecioSegunClase(clase);
		
	}
	
	
	
	
	public Pasajero getPasajero(){
		return this.pasajero;
	}
	
	public Clase getClase(){
		return this.clase;
	}
	
	public double getPrecio(){
		return this.precio;
	}
	
	private void setClase(Clase clase){
		this.clase=clase;
	}
	
	private void setPrecioSegunClase (Clase clase){
		switch(clase){
			case TURISTA:
				this.precio=PRECIO_TURISTA;
				break;
			case BUSINESS:
				this.precio=PRECIO_BUSINESS;
				break;
			case PRIMERA:
				this.precio=PRECIO_PRIMERA;
		}
	}




	@Override
	public String toString() {
		return "Boleto pasajero=" + pasajero + ", clase=" + clase + ", precio=" + precio;
	}
	
	
}
