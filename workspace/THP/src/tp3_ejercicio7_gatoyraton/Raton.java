package tp3_ejercicio7_gatoyraton;

public class Raton {

	private int energia;
	private static final int CONSUMO=2;
	
	public Raton(int seteo){
		setEnergia(seteo);
	}
	
	private void setEnergia(int seteo){
		this.energia=seteo;
	}
	public int getEnergia(){
		return this.energia;
	}
	
	public int getPotencial(){
		int pot=0;
		pot=this.getEnergia()/CONSUMO;
		return pot;
	}
	
}
