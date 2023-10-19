package ar.edu.ort.modelo;

import java.util.ArrayList;

public class Factura extends DocumentoLegal {

	private ArrayList<Detalle> detalles;
	


	
	public Factura(Cliente cliente, Empresa empresa, String fechaEmision, int nro) {
		super(cliente, empresa, fechaEmision, nro);
		detalles = new ArrayList<>();
	}




	public void agregarProducto(int cant,Producto prod){
		detalles.add(new Detalle(cant,prod));
		this.total=this.total+(cant*prod.getPrecioVenta());
	}




	@Override
	public String getTipoDocumento() {
		
		return getClass().getSimpleName();
	}




	@Override
	public void imprimirDetalle() {
		System.out.println("Cant   Descripcion         Precio Unitario      SubTotal");
		for (Detalle d : detalles) {
			System.out.println(d.getCantidad()+"         " + d.getProducto().getNombre()+"            "+d.getProducto().getPrecioVenta()+"               "+(d.getCantidad()*d.getProducto().getPrecioVenta()));
			
			
		}
		
	}
	
	

}
