package ort.tp1.tdas.implementaciones;

import ort.tp1.tdas.interfaces.Tda;

public class TdaNodos<T> implements Tda {

	protected Nodo<T> first;
	private int limite;
	private int count;

	protected TdaNodos() {
		this(SIN_LIMITE);
	}

	protected TdaNodos(int limite) {
		if (limite != SIN_LIMITE && limite < LIMITE_MINIMO_POSIBLE) {
			throw new IllegalArgumentException(ERR_TAM_ILEGAL);
		}
		this.limite = limite;
		this.first = null;
		this.count = 0;
	}

	protected void incrementCount() {
		count++;
	}

	protected void decrementCount() {
		count--;
	}

	protected int getCount() {
		return count;
	}

	@Override
	public void checkEmptiness() throws RuntimeException {
		if (isEmpty()) {
			throw new RuntimeException(
					String.format(ERR_ESTRUCTURA_VACIA, this.getClass().getInterfaces()[0].getSimpleName()));
		}
	}

	@Override
	public void checkFullness() throws RuntimeException {
		if (isFull()) {
			throw new RuntimeException(
					String.format(ERR_ESTRUCTURA_LLENA, this.getClass().getInterfaces()[0].getSimpleName()));
		}
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public boolean isFull() {
		return count == limite;
	}

	@Override
	public int count() {
		return count;
	}

}
