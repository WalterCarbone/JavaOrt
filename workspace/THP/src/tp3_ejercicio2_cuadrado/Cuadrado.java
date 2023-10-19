package tp3_ejercicio2_cuadrado;

public class Cuadrado {
	private int lado;

	public Cuadrado(int valor) {
		this.lado = valor;
	}

	public void setLado(int valor) {
		this.lado = valor;
	}

	public int getLado() {
		return this.lado;

	}

	public int perimetro() {

		int perimetro = this.getLado() * 4;
		return perimetro;
	}

	public int superficie() {
		int valor = this.getLado();
		int superficie = valor * valor;
		return superficie;
	}

	@Override
	public String toString () {
	return "Cuadrado [lado=" + lado + ", perimetro()=" +
	perimetro() + ", superficie()=" + superficie() + "]" ;
	}

	
}
