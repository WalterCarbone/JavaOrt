package tp4_ejercicio2_edificio;

public enum Resultados {
	UNIDAD_MAYOR("El número de unidad excede al total del edificio"), 
	UNIDAD_INEXISTENTE("Unidad inexistente"), 
	UNIDAD_OCUPADA("La unidad ya se encunetra ocupada");

	
	private final String msj;

	Resultados(String msj) {
        this.msj = msj;
    }

    public String getMsj() {
        return msj;
    }
}
