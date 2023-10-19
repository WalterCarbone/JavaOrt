package ar.edu.ort.tp1.tp5Ej2;

public class AnioV2 {
	private int[] cantidadDiasMes;

	public AnioV2() {
		this.cantidadDiasMes = new int[]{0,31,59,90,120,151,181,212,243,273,304,334}; 
	}
	
	public String[] getMeses() {
		String[] meses = new String [MESES.values().length];
		for (int i=0; i<meses.length; i++) {
			meses[i] = MESES.values()[i].name();
		}		
		return meses;
	}
	
	public String getNombreMes(int numeroMes) {
		return MESES.values()[numeroMes-1].name();
	}
	
	public int diasTranscurridos(int numeroMes){
		int result = 0;
		result = cantidadDiasMes[numeroMes-1];
		return result;
	}

}
