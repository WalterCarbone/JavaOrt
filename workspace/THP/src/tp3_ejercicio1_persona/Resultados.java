package tp3_ejercicio1_persona;

public enum Resultados {
	OPERACION_EXITOSA("Persona agregada a la agenda"), 
	USUARIO_INEXISTENTE("Persona no encontrada en la agenda"), 
	USUARIO_EXISTENTE("Persona ya ingresada en la agenda"),
	AGENDA_VACIA("agenda vacía");
	
	private final String msj;

	Resultados(String msj) {
        this.msj = msj;
    }

    public String getMsj() {
        return msj;
    }
}
