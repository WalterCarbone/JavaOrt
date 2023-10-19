package ar.edu.ort.thp.tp4.ej2;

import java.util.ArrayList;

public class Edificio {
	private String direccion;
	private int cantidadDepartamentos;
	private ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
	private ArrayList<Departamento> morosos = new ArrayList<Departamento>();

	/**
	 * Constructor de Edificio
	 * 
	 * @param direccion
	 * @param cantidadDepartamentos
	 */
	public Edificio(String direccion, int cantidadDepartamentos) {
		this.direccion = direccion;
		this.cantidadDepartamentos = cantidadDepartamentos;
		crearDepartamentos();
	}

	/**
	 * Agrega al edificio los departamentos (vacios) asignandole a cada uno su
	 * numero de unidad y un saldo en 0 (cero).
	 */
	private void crearDepartamentos() {
		for (int i = 1; i <= cantidadDepartamentos; i++) {
			departamentos.add(new Departamento(i));
		}

	}

	/**
	 * Suma el importe recibido a la deuda de la unidad.
	 * 
	 * @param nroUnidad
	 *            Nro de la unidad. Debe er valido.
	 * @param importe
	 *            importe a agregar a la deuda. Debe ser positivo.
	 * @return Un booleano que indica si se pudo realizar la operacion.
	 */
	public boolean agregarDeuda(int nroUnidad, int importe) {
		boolean pude = false;
		if (nroUnidad > 0 && nroUnidad <= cantidadDepartamentos && importe > 0) {
			actualizarDeuda(nroUnidad, importe);
			pude = true;
		}
		return pude;
	}

	/**
	 * Resta el importe recibido a la deuda de la unidad. El importe recibido no
	 * puede ser negativo, pero la deuda si puede quedar negativa (saldo a favor
	 * del vecino).
	 * 
	 * @param nroUnidad
	 *            Nro de la unidad. Debe er valido.
	 * @param importe
	 *            importe a agregar a la deuda. Debe ser positivo.
	 * @return Un booleano que indica si se pudo actualizar la deuda.
	 */
	public boolean cancelarDeuda(int nroUnidad, int importe) {
		boolean pude = false;
		if (nroUnidad > 0 && nroUnidad <= cantidadDepartamentos && importe > 0) {
			actualizarDeuda(nroUnidad, -importe);
			pude = true;
		}
		return pude;
	}

	/**
	 * Actualiza el saldo del departamento. Ademas se ocupa de actualizar la
	 * lista de morosos.
	 * 
	 * @param numero
	 * @param importe
	 */
	private void actualizarDeuda(int numero, double importe) {
		Departamento departamento;
		Departamento moroso;

		departamento = departamentos.get(numero - 1);
		moroso = buscarMoroso(numero);
		departamento.actualizarDeuda(importe);
		if (departamento.esMoroso() && moroso == null) {
			pasarAMoroso(departamento);
		} else if (moroso != null && !departamento.esMoroso()) {
			sacarDeMoroso(moroso);
		}
	}

	/**
	 * Asigna una unidad del edificio a un nuevo vecino.
	 * 
	 * @param numero
	 *            Numero de unidad (la primera es 1).
	 * @param dni
	 *            DNI del titular
	 * @param nombre
	 *            Nombre del titular
	 * @return True cuando se pudo habitar la unidad.
	 */
	public boolean habitarUnidad(int numero, String dni, String nombre) {
		boolean pudoHabitar = false;

		if (numero > 0 && numero <= cantidadDepartamentos) {
			pudoHabitar = departamentos.get(numero - 1).habitar(dni, nombre);
		}
		return pudoHabitar;
	}

	/**
	 * Busca el departamento en la lista especificada como parámetro
	 * 
	 * @param lista
	 * @param numero
	 * @return
	 */
	private Departamento buscarMoroso(int numero) {
		int i = 0;
		Departamento departamento = null;

		while (i < morosos.size() && numero != morosos.get(i).getNumero()) {
			i++;
		}
		if (i < morosos.size()) {
			departamento = morosos.get(i);
		}
		return departamento;
	}

	/**
	 * Recibe un departamento, lo agrega a la lista de morosos y lo elimina de
	 * la lista de departamentos con pagos al día.
	 * 
	 * @param departamento
	 */
	private void pasarAMoroso(Departamento departamento) {
		morosos.add(departamento);
	}

	/**
	 * Lista todas las unidades del edificio
	 */
	public void listarUnidades() {
		System.out.println("*LISTADO DETALLADO DE DEPARTAMENTOS*");
		listar(departamentos);
	}

	/**
	 * Lista los departamentos con mora
	 */
	public void listarMorosos() {
		if (morosos.isEmpty()) {
			System.out.println("*NO HAY DEPARTAMENTOS CON MORA*");
		} else {
			System.out.println("*LISTADO DE DEPARTAMENTOS CON MORA*");
			listar(morosos);
		}

	}

	private void listar(ArrayList<Departamento> lista) {
		for (Departamento depto : lista) {
			System.out.println(depto);
		}
	}

	/**
	 * Recibe un departamento, lo agrega a la lista de departamentos con pagos
	 * al día y lo elimina de la lista de morosos.
	 * 
	 * @param departamento
	 */
	private void sacarDeMoroso(Departamento departamento) {
		morosos.remove(departamento);
	}

	@Override
	public String toString() {
		return "Edificio [direccion=" + direccion + ", cantidadDepartamentos=" + cantidadDepartamentos + "]";
	}

}