package tp3_ejercicio7_gatoyraton;

public class Gato {

	private int energia;
	private static final int CONSUMO=1;
	
	public Gato (int seteo){
		setEnergia(seteo);
	}
	
	private void setEnergia (int seteo){
		this.energia=seteo;
	}
	
	public int getEnergia(){
		return this.energia;
	}
	
	private int potencial(){
		int pot=0;
		pot=this.getEnergia()/CONSUMO;
		return pot;
	}
	
	
	public boolean alcanzar(int distancia, Raton r1){
		boolean alcanzo=false;
		int total=0;
		total=r1.getPotencial()+distancia;
		
		if (this.potencial()>=total){
			alcanzo=true;
		}
		return alcanzo;
	}
	
}
