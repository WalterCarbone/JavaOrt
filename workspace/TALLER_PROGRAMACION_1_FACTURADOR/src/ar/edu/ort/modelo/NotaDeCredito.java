package ar.edu.ort.modelo;

public class NotaDeCredito extends DocumentoLegal {

	private Motivo motivo;
	
	public NotaDeCredito(Cliente cliente, Empresa empresa, String fechaEmision, int nro,Motivo motivo,double total) {
		super(cliente, empresa, fechaEmision, nro);
		this.motivo=motivo;
		this.total=total;
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
