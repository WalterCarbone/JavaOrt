package ar.edu.ort.tp1.pacial1.clases;

public class Sillon extends Mueble {

	private int cantCuerpos;
	private TelaSillon telaSillon;
	private float multiplicador;

	public Sillon(String modelo, float costoBase, float porcentajeGanancia, int cantCuerpos, TelaSillon telaSillon) {
		super(modelo, costoBase, porcentajeGanancia);
		setCantCuerpos(cantCuerpos);
		setTelaSillon(telaSillon);
	}

	private void setCantCuerpos(int cantCuerpos) {
		this.cantCuerpos = cantCuerpos;
	}

	private void setTelaSillon(TelaSillon telaSillon) {
		this.telaSillon = telaSillon;
		multiplicador=telaSillon.getPorcentaje();
	}

	@Override
	public void mostrar() {
		System.out.println(MESJ);
		System.out.println("Mueble tipo : Sillón - Modelo: " + this.getModelo() +" Precio de venta:$" + super.calcularPrecioVenta());
	}

	

	@Override
	protected float calcularPrecioCosto() {
		float precioCosto = 0;
		precioCosto = this.getCostoBase() * cantCuerpos * multiplicador;

		return precioCosto;
	}

	// TODO A completar

}
