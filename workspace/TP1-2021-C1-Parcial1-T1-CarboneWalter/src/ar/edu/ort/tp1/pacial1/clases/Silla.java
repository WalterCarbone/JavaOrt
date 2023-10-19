package ar.edu.ort.tp1.pacial1.clases;

public class Silla extends Mueble {
	private static final int COEFICIENTE_SILLA = 3;
	private long alto;
	private MaterialSilla matSilla;
	private float multiplicador;

	public Silla(String modelo, float costoBase, float porcentajeGanancia, long alto, MaterialSilla material) {
		super(modelo, costoBase, porcentajeGanancia);
		this.alto=alto;
		setMatSilla(material);
		System.out.println("Print alto:" + alto);
		System.out.println("Print multiplicador" + multiplicador);
	}

	private void setAlto(long alto) {
		this.alto = alto;
	}

	public long getAlto() {
		return this.alto;
	}

	private void setMatSilla(MaterialSilla material) {
		this.matSilla = material;
		this.multiplicador=material.getMultiplicadorValor();
	}

	public MaterialSilla getMatSilla() {
		return this.matSilla;
	}
	// TODO A completar

	@Override
	public void mostrar() {
		System.out.println(MESJ);
		System.out.println("Mueble tipo : SILLA - Modelo: " + this.getModelo() + " Precio de Venta:$" + super.calcularPrecioVenta());
		
	}

	@Override
	protected float calcularPrecioCosto() {
		float precioCosto = 0;
		float factor=0;
		
		precioCosto = this.getCostoBase() + multiplicador * this.alto;

		return precioCosto;
	}

}
