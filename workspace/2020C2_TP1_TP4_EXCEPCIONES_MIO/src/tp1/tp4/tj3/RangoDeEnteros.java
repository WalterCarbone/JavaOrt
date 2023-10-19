package tp1.tp4.tj3;

public class RangoDeEnteros {
	private int limiteInferior;
	private int limiteSuperior;

	public RangoDeEnteros(int limiteInferior, int limiteSuperior) {
		if (limiteInferior < limiteSuperior) {
			setLimiteInferior(limiteInferior);
			setLimiteSuperior(limiteSuperior);
		} else {
			setLimiteInferior(limiteSuperior);
			setLimiteSuperior(limiteInferior);
		}
	}

	public int getLimiteInferior() {
		return limiteInferior;
	}

	public int getLimiteSuperior() {
		return limiteSuperior;
	}

	public boolean incluye(int aux) {
		return (aux >= getLimiteInferior() && aux <= getLimiteSuperior());
	}

	private void setLimiteInferior(int limiteInferior) {
		if (limiteInferior != (int) limiteInferior) {
			throw new NumberFormatException("El valor ingresado no es un número entero");
		} else {
			this.limiteInferior = limiteInferior;
		}
	}

	private void setLimiteSuperior(int limiteSuperior) {
		if (limiteInferior != (int) limiteInferior) {
			throw new NumberFormatException("El valor ingresado no es un número entero");
		} else {
			this.limiteSuperior = limiteSuperior;
		}

	}

}
