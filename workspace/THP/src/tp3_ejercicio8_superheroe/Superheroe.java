package tp3_ejercicio8_superheroe;

public class Superheroe {

	private String nombre;
	private int fuerza;
	private int resistencia;
	private int superpoderes;
	private static final int MIN = 0;
	private static final int MAX = 100;

	public Superheroe(String nombre, int fuerza, int resist, int superp) {
		setNombre(nombre);
		setFuerza(fuerza);
		setResistencia(resist);
		setSuperpoderes(superp);
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public int getFuerza() {
		return this.fuerza;
	}

	public int getResistencia() {
		return this.resistencia;
	}

	public int getSuperpoderes() {
		return this.superpoderes;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private void setFuerza(int fuerza) {
		int valor = validoNumero(fuerza);
		this.fuerza = valor;
	}

	private void setResistencia(int resist) {
		int valor = validoNumero(resist);
		this.resistencia = valor;
	}

	private void setSuperpoderes(int superp) {
		int valor = validoNumero(superp);
		this.superpoderes = valor;
	}

	private int validoNumero(int valor) {
		if (valor < MIN) {
			valor = MIN;
		}
		if (valor > MAX) {
			valor = MAX;
		}
		return valor;
	}

	public String competir(Superheroe h2) {
		int puntos = 0;
		String resultado;
		if (this.getFuerza() > h2.getFuerza()) {
			puntos++;
		} else if (this.getFuerza()< h2.getFuerza()){
			puntos--;
		}

		if (this.getResistencia() > h2.getResistencia()) {
			puntos++;
		} else if (this.getResistencia()< h2.getResistencia()){
			puntos--;
		}

		if (this.getSuperpoderes() > h2.getSuperpoderes()) {
			puntos++;
		} else if (this.getSuperpoderes()< h2.getSuperpoderes()){
			puntos--;
		}

		if (puntos > 0) {
			resultado = this.getNombre();
		} else if (puntos == 0) {
			resultado = "EMPATE";
		} else {
			resultado = h2.getNombre();
		}

		return resultado;
	}

	@Override
	public String toString() {
		return  nombre + " * Fuerza= " + fuerza + " * Resistencia= " + resistencia + " * Superpoderes= "
				+ superpoderes;
	}

}
