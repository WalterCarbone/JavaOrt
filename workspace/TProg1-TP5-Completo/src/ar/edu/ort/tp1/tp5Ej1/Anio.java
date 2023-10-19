package ar.edu.ort.tp1.tp5Ej1;

public class Anio {
	private String[] meses;
	private int[] cantidadDiasMes;

	public Anio() {
		this.cantidadDiasMes = new int[]{0,31,59,90,120,151,181,212,243,273,304,334};
		this.meses = new String[]{"ENERO","FEREBRO","MARZO","ABRIL","MAYO","JUNIO","JULIO","AGOSTO","SEPTIEMBRE","OCTUBRE","NOVIEMBRE","DICIEMBRE"};
	}
		
	public String getNombreMes(int numeroMes) {
		if (numeroMes <= 12 && numeroMes > 0){
			return meses[numeroMes-1];
		}else{
			return null;
		}
	}
	
	public int diasTranscurridos(int numeroMes){
		int result = 0;
		result = this.cantidadDiasMes[numeroMes-1];
		return result;
	}
}
