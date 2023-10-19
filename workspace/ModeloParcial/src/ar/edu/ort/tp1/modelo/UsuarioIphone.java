package ar.edu.ort.tp1.modelo;
public class UsuarioIphone extends Usuario {

    private int so;

    public UsuarioIphone(String nombre, String password, int so) {
        super(nombre, password);
        this.so = so;
    }

    @Override
    boolean esUsuarioValido() {
        return so > 6;
    }

    @Override
    public String toString() {
        return super.toString() + "UsuarioIphone{" +
                "so=" + so +
                '}';
    }
}
