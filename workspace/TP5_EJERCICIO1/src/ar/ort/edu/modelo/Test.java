package ar.ort.edu.modelo;

public class Test {
static String mes;
static int dias;
static int ds;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Anio a = new Anio();

mes=a.getNombreDelMes(10);
System.out.println(mes);
dias=a.diasTranscurridos(3);
System.out.println(dias);
System.out.println(a);

ds=a.dias2(3);
System.out.println(ds);
	}

}
