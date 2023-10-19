package ar.edu.ort.tp1.modelo;

public class UsuarioAndroid extends Usuario {

    private String marca;

    public UsuarioAndroid(String nombre, String password, String marca) {
        super(nombre, password);
        this.marca = marca;
    }

    @Override
    boolean esUsuarioValido() {
        return marca.equals("motorola") || marca.equals("samsung");
    }
}
