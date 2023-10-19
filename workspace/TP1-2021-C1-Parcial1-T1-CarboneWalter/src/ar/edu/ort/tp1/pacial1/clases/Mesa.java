package ar.edu.ort.tp1.pacial1.clases;

public class Mesa extends Mueble {

	private static final float COEFICIENTE_SUPERFICIE = 0.2f;
	private long largo;
	private long ancho;
	private TipoMesa tipoMesa;
	private float multiplicador;

	public Mesa(String modelo, float costoBase, float porcentajeGanancia, long largo, long ancho, TipoMesa tipoMesa) {
		super(modelo, costoBase, porcentajeGanancia);
		setLargo(largo);
		setAncho(ancho);
		setTipoMesa(tipoMesa);
	}

	private void setLargo(long largo) {
		this.largo = largo;
	}

	private void setAncho(long ancho) {
		this.ancho = ancho;
	}

	private void setTipoMesa(TipoMesa tipoMesa) {
		this.tipoMesa = tipoMesa;
		this.multiplicador=tipoMesa.getMultiplicadorValor();
	}

	public long getLargo() {
		return this.largo;
	}

	public long getAncho() {
		return this.ancho;
	}

	public TipoMesa getTipoMesa() {
		return this.tipoMesa;
	}

	@Override
	public void mostrar() {
		System.out.println(MESJ);
		System.out.println("Mueble tipo : Mesa - Modelo: " + this.getModelo() +" Precio de Venta:$"+ super.calcularPrecioVenta());
	}
// TODO Auto-generated method stub

	

	@Override
	protected float calcularPrecioCosto() {
		float precioCosto = 0;

		precioCosto = this.getCostoBase() * multiplicador+ COEFICIENTE_SUPERFICIE * this.largo * this.ancho;

		return precioCosto;
	}

}
