package ar.edu.ort.modelo;

public class NotaDeDebito extends DocumentoLegal {

	private Motivo motivo;

	public NotaDeDebito(Cliente cliente, Empresa empresa, String fechaEmision, int nro, Motivo motivo) {
		super(cliente, empresa, fechaEmision, nro);
		this.motivo = motivo;

	}

	@Override
	public String getTipoDocumento() {
		// TODO Auto-generated method stub
		return getClass().getSimpleName();
	}

	@Override
	public void imprimirDetalle() {
		// TODO Auto-generated method stub
		
	}

}
