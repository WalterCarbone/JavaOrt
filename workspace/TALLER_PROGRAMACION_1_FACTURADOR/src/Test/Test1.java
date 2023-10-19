package Test;

import java.util.ArrayList;

import ar.edu.ort.modelo.CategoriaIva;
import ar.edu.ort.modelo.Cliente;
import ar.edu.ort.modelo.DocumentoLegal;
import ar.edu.ort.modelo.Empresa;
import ar.edu.ort.modelo.Factura;
import ar.edu.ort.modelo.Motivo;
import ar.edu.ort.modelo.NotaDeCredito;
import ar.edu.ort.modelo.Producto;

public class Test1 {

	public static void main(String[] args) {
		ArrayList<DocumentoLegal> comprobantes = new ArrayList<>();

		Empresa miEmpresa = new Empresa(CategoriaIva.RESPONSABLE_INSCRIPTO, "30-50000421-1", "Cabildo 4200",
				"Empresa ABC SA");
		Cliente cli1 = new Cliente(CategoriaIva.EXENTO, "20-24963720-4", "Obligado 2935", "Walter Carbone", 1);
		Producto p1 = new Producto(20, "Mouse", 1000, 1100);
		Producto p2 = new Producto(25, "Teclado",3000, 3100);
		Producto p3 = new Producto(35, "Monitor",5000, 6000);
		Factura f1 = new Factura(cli1, miEmpresa, "11/4/2021", 1);
		f1.agregarProducto(1, p1);
		f1.agregarProducto(2, p2);
		f1.agregarProducto(1, p3);
		comprobantes.add(f1);
		Motivo m1 = new Motivo(100, "Promocion");

		NotaDeCredito nc1 = new NotaDeCredito(cli1, miEmpresa, "11/4/2021", 1, m1, 100);
		comprobantes.add(nc1);

		for (DocumentoLegal comp : comprobantes) {
			System.out.println(comp.getEmpresa().getCuit() + " " + comp.getEmpresa().getNombre()+" "+comp.getTipoDocumento() + " " + comp.getLetra() + " Nro: " + comp.getNro() + " Total $"
					+ comp.getTotal());
			System.out.println("-----------------------------");


		}

		imprimirDetalle(comprobantes);

	}

	public static void imprimirDetalle(ArrayList<DocumentoLegal> comprobantes) {
		System.out.println("Impresion de comprobante");
		for (DocumentoLegal comp : comprobantes) {
			comp.imprimirDetalle();
		}

	}

}
