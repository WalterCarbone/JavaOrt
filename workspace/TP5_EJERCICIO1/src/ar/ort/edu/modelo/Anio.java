package ar.ort.edu.modelo;

import java.util.Arrays;

public class Anio {

	private String[] meses;  //
	private int[] dias ; //{ 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private int[] acum;//0 31
	
	
	public Anio() {
		super();
		this.meses= new String[] { "Enero", "Febrero", "Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
		this.dias= new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		this.acum=new int[dias.length] ;
		
		setAcum();

	}

	@Override
	public String toString() {
		return "Anio [acum=" + Arrays.toString(acum) + "]";
	}

	public String getNombreDelMes(int mes) {

		return meses[mes - 1];

	}
public int getAcum(int a){
	return acum[a];
}
	
	public int diasTranscurridos(int numeroMes) {
		int total = 0;
		for (int i = 0; i < (numeroMes-1); i++) {
			total += dias[i];

		}

		return total;

	}
	
	public int dias2(int numeroMes){
		return acum[numeroMes];
	}
	
	
private void setAcum(){
	
		 for (int j = 1; j < acum.length; j++) {
			 acum[j]= dias[j-1]+acum[j-1];
			
		}
	}
}