package ar.edu.ort.tp1.final3.clases;

public class ClienteCobre extends Cliente {
	public static final double DESCUENTO=0.90;
	public static final int MINIMO=200;

	public ClienteCobre(String nombre, int edad, double importe) {
		super(nombre, edad, importe);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double realizarDescuento(double precio) {
		
		if(tieneDescuento(precio)){
			precio=precio*DESCUENTO;
		}
		
				
		return precio;
	}

	@Override
	public boolean tieneDescuento(double precio) {
		boolean retorno=false;
		if(precio>=MINIMO){
			retorno=true;
		}
		
		return retorno;
	}

}
