package ar.edu.ort.tp1.modelo;

public enum ErrorDescripcion {

    USUARIO_INVALIDO("Usuario Invalido"),
    NO_HAY_LUGAR("No hay lugar");

    private String descripcionError;

    ErrorDescripcion(String descripcionError) {
        this.descripcionError = descripcionError;
    }

    public String getDescripcionError() {
        return descripcionError;
    }
}
