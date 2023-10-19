package ejericio1;

public class Test {

	public static void main(String[] args) {
		
		Producto p1 = new Producto(1, "Monitor", 10450);
		Producto p2 = new Producto(2, "Teclado", 5600);
		Cliente c1=new Cliente(1, "Walter");
		Fecha hoy= new Fecha(23, 8, 2021);
		Factura f1=new Factura(hoy);
		
		f1.altaCliente(c1);
		f1.altaProducto(new Item(p1, 1));
		f1.altaProducto(new Item(p2, 2));
		
		System.out.println(f1.getNro());
		System.out.println(f1.getTipo());
		System.out.println(f1.getTotal());
		
		
		Factura f2=new Factura(hoy);
		
	System.out.println(f2.getNro());
	System.out.println(f2.getTipo());
	System.out.println(f2.getTotal());
	}
}

