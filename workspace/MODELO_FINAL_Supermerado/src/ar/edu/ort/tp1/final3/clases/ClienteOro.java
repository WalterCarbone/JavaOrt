package ar.edu.ort.tp1.final3.clases;

public class ClienteOro extends Cliente {
private static final double DESCUENTO=0.50;
private static final int MINIMO=0;
	
	public ClienteOro(String nombre, int edad, double importe) {
		super(nombre, edad, importe);
		
	}

	@Override
	public double realizarDescuento(double precio) {
		
		if(tieneDescuento(precio)){
			precio=precio-(precio*DESCUENTO);
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
