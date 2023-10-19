package ar.edu.ort.modelo;

public abstract class DocumentoLegal {

	private Cliente cliente;
	private Empresa empresa;
	private String fechaEmision;
	private String letra;
	private int nro;
	protected double total;



	public DocumentoLegal(Cliente cliente, Empresa empresa, String fechaEmision, int nro) {
		this.cliente = cliente;
		this.empresa = empresa;
		this.fechaEmision = fechaEmision;
		this.letra = calcularLetra(cliente.getCategoriaIva(), empresa.getCategoriaIva());
		this.nro = nro;
		this.total = total;
	}


	private String calcularLetra(CategoriaIva ivaCliente, CategoriaIva ivaEmpresa) {
		String letra = null;

		if (CategoriaIva.RESPONSABLE_INSCRIPTO.equals(ivaEmpresa)) {
			if (CategoriaIva.RESPONSABLE_INSCRIPTO.equals(ivaCliente)) {
				letra = "A";
			} else if (CategoriaIva.MONOTRIBUTO.equals(ivaCliente)) {
				letra = "B";
			} else {
				letra = "C";
			}
		}

		return letra;
	}


	public String getFechaEmision() {
		return fechaEmision;
	}


	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}


	public String getLetra() {
		return letra;
	}


	public void setLetra(String letra) {
		this.letra = letra;
	}


	public int getNro() {
		return nro;
	}


	public void setNro(int nro) {
		this.nro = nro;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public Empresa getEmpresa() {
		return empresa;
	}

	public abstract String getTipoDocumento();
	public abstract void imprimirDetalle();
}
