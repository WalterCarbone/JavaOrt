package ar.edu.ort.tp2_ejercicio1;



public class EMail {

	private String cuenta;
	private String dominio;
	

	public EMail(String mail) {
		setMail(mail);

	}

	private void setMail(String mail) {
		String[] partes = mail.split("@");
		this.cuenta = partes[0];
		this.dominio = partes[1];
	}

	public String getCuenta() {
		return this.cuenta;
	}

	public String getDominio() {
		return this.dominio;
	}

	public String getValor() {
		String mail;
		mail = null;
		mail = getCuenta() + "@" + getDominio();
		return mail;
	}

	@Override
	public String toString() {
		return "\n"+cuenta + "@" + dominio;
	}

}
