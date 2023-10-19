package ar.edu.ort.tp1.modelo;

public class Error {

    private String nombreUsuario;
    private ErrorDescripcion descripcionError;

    public Error(String nombreUsuario, ErrorDescripcion descripcionError) {
        this.nombreUsuario = nombreUsuario;
        this.descripcionError = descripcionError;
    }

    @Override
    public String toString() {
        return nombreUsuario + " - " + descripcionError.getDescripcionError();
    }
}
