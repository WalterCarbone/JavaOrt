package ejericio1;

import java.util.ArrayList;

public class Factura extends Comprobante {


private double total;
private Cliente cliente;
private ArrayList<Item> items;
private static String comp="F";
	
 public Factura(Fecha fecha) {
		super(comp, fecha);	
				
		this.total=0;
		items = new ArrayList<>();
		
		
	}
 

public void altaCliente(Cliente cli){
	 this.cliente=cli;
 }


 public void altaProducto(Item item){
	 items.add(item);
	 this.total+=item.getCantidad()*item.getProducto().getPrecioUnitario();
 }
 

public int getNro() {
	return super.getNro();
}


public double getTotal() {
	return total;
}


public Cliente getCliente() {
	return cliente;
}


public ArrayList<Item> getItems() {
	return items;
}
 
 
 
}
