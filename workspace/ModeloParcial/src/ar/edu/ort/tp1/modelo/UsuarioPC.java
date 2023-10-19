package ar.edu.ort.tp1.modelo;

public class UsuarioPC extends Usuario {

    private int ghz;

    public UsuarioPC(String nombre, String password, int ghz) {
        super(nombre, password);
        this.ghz = ghz;
    }

    @Override
    boolean esUsuarioValido() {
        return ghz >= 2;
    }
}
