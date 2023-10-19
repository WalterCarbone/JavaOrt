package tp4_ejercicio2_edificio;

import java.util.ArrayList;

public class Edificio {

	private ArrayList<Departamento> deptos;
	private ArrayList<Departamento> enMora;
	private String direccion;
	private int cantidadTotal;
	private static final int DEUDA_INI = 0;

	public Edificio(String direccion, int cant) {
		deptos = new ArrayList<>();
		setDireccion(direccion);
		setCantidadTotal(cant);

		for (int i = 0; i < cant; i++) {
			Departamento deptoAgregar = new Departamento(i + 1, null, null, DEUDA_INI, "Vacio", cantidadTotal);
			deptos.add(deptoAgregar);
		}

		enMora = new ArrayList<>();

	}
	
	public void cancelarDeuda(int unidad, int importe){
		Departamento deptoCancela;
		
		deptoCancela=buscarDepto(unidad);
		if(deptoCancela!=null){
			deptoCancela.setDeuda(deptoCancela.getDeuda()-importe);
			if(deptoCancela.getDeuda()==0){
				enMora.remove(deptoCancela);
			}
		}else{
			System.out.println(Resultados.UNIDAD_INEXISTENTE.getMsj());
		}
	}

	public void agregarDeuda(int unidad,int deuda){
		Departamento deptoDeuda;
		Departamento deptoListado;
		deptoDeuda=buscarDepto(unidad);
		if(deptoDeuda!=null){
			deptoDeuda.setDeuda(deptoDeuda.getDeuda()+deuda);
			deptoListado = deptoEnMora(deptoDeuda.getUnidad());
			if(deptoListado==null){
				enMora.add(deptoDeuda);
			}
		}else{
			System.out.println(Resultados.UNIDAD_INEXISTENTE.getMsj());
		}
	}
	
	/*private void actualizarLista() {
		for (Departamento i : deptos) {
			if(i.getDeuda()>0){
					
					}
			}
		}
		
	}*/

	public void habitarUnidad(int unidad, String dni, String propietario) {

		Departamento deptoAocupar;
		deptoAocupar = buscarDepto(unidad);

		if (deptoAocupar != null) {
			if (deptoAocupar.getEstado() == "Vacio") {
				deptoAocupar.setDni(dni);
				deptoAocupar.setPropietario(propietario);
				deptoAocupar.setEstado("Ocupado");
			} else {
				System.out.println(Resultados.UNIDAD_OCUPADA.getMsj());
			}
		} else {
			System.out.println(Resultados.UNIDAD_INEXISTENTE.getMsj());
		}
	}
	
	private Departamento deptoEnMora(int unidad){
		Departamento depto=null;
		int i=0;
		
		while ((i<this.enMora.size() && this.enMora.get(i).getUnidad()!=unidad)){
			i++;
		}
		if (i<this.enMora.size()){
			depto=this.enMora.get(i);
		}
		return depto;
		}

	private Departamento buscarDepto(int unidad) {
		Departamento deptoAencontrar = null;
		int i = 0;

		while ((i < this.deptos.size() && this.deptos.get(i).getUnidad() != unidad)) {
			i++;
		}

		if (i < this.deptos.size()) {
			deptoAencontrar = this.deptos.get(i);
		}

		return deptoAencontrar;
	}
	
	
	public void listarMorosos(){
		System.out.println("*** LISTADO DE MOROSOS ***");
		System.out.println("Dirección: " + this.getDireccion());
		System.out.println("Cantidad total de departamentos: " + this.cantidadTotal);
		for (Departamento m : enMora) {
			System.out.println(m);
		}
	}

	public void listarUnidades() {

		System.out.println("Dirección: " + this.getDireccion());
		System.out.println("Cantidad total de departamentos: " + this.cantidadTotal);
		for (Departamento i : deptos) {
			System.out.println(i);
		}
	}

	public String getDireccion() {
		return this.direccion;
	}

	public int getCantidadTotal() {
		return this.cantidadTotal;
	}

	private void setDireccion(String dire) {
		this.direccion = dire;
	}

	private void setCantidadTotal(int cant) {
		this.cantidadTotal = cant;
	}

}
