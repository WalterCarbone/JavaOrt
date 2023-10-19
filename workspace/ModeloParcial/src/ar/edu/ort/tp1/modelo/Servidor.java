package ar.edu.ort.tp1.modelo;

import ar.edu.ort.tp1.tdas.implementaciones.ColaNodos;
import ar.edu.ort.tp1.tdas.implementaciones.PilaNodos;
import ar.edu.ort.tp1.tdas.interfaces.Cola;
import ar.edu.ort.tp1.tdas.interfaces.Pila;

import java.util.Arrays;

public class Servidor {

    private static final int CANTIDAD_INSTANCIAS = 5;
    private static final int CANTIDAD_USUARIOS = 30;

    private Usuario[][] usuariosLoggeados;
    private int[] cantidadUsuarioLoggeados;
    private Pila<Error> historialErrores;
    private UsuariosRegistradoPorNombre usuariosExistentes;
    private Cola<Usuario> usuariosRecienLlegados;

    public Servidor() {
        this.usuariosLoggeados = new Usuario[CANTIDAD_INSTANCIAS][CANTIDAD_USUARIOS];
        this.cantidadUsuarioLoggeados = new int[CANTIDAD_INSTANCIAS];
        this.historialErrores = new PilaNodos<>();
        this.usuariosExistentes = new UsuariosRegistradoPorNombre();
        this.usuariosRecienLlegados = new ColaNodos<>();
    }

    public void loggearUsuario(Usuario usuario) {
        if (usuario.esUsuarioValido()) {
            Usuario usuarioExistente = usuariosExistentes.search(usuario.getNombre());
            if (usuarioExistente != null && usuarioExistente.getPassword().compareTo(usuario.getPassword()) != 0) {
                historialErrores.push(new Error(usuario.getNombre(), ErrorDescripcion.USUARIO_INVALIDO));
            } else {
                usuariosRecienLlegados.add(usuario);
            }
        } else {
            historialErrores.push(new Error(usuario.getNombre(), ErrorDescripcion.USUARIO_INVALIDO));
        }
    }

    public void procesarUsuarioPendientes() {
        while (!usuariosRecienLlegados.isEmpty()){
            Usuario miUsuario = usuariosRecienLlegados.remove();
            int posicionConMenosUsuarios = buscarInstanciaConMenosUsuarios();
            if (posicionConMenosUsuarios != -1) {
                int posicionALoggear = obtenerPosicionALoggear(posicionConMenosUsuarios);
                usuariosLoggeados[posicionConMenosUsuarios][posicionALoggear] = miUsuario;
                cantidadUsuarioLoggeados[posicionConMenosUsuarios]++;
            } else {
                historialErrores.push(new Error(miUsuario.getNombre(), ErrorDescripcion.NO_HAY_LUGAR));
            }
        }
    }

    private int obtenerPosicionALoggear(int posicionConMenosUsuarios) {
        int resultado = -1;
        int i = 0;
        while (i < usuariosLoggeados[posicionConMenosUsuarios].length) {
            if (usuariosLoggeados[posicionConMenosUsuarios][i] == null) {
                resultado = i;
            }
            i++;
        }

        return resultado;
    }

    private int buscarInstanciaConMenosUsuarios() {
        int resultado = -1;
        int aux = CANTIDAD_USUARIOS;

        for (int i = 0; i < cantidadUsuarioLoggeados.length; i++) {
            if (cantidadUsuarioLoggeados[i] < aux) {
                resultado = i;
                aux = cantidadUsuarioLoggeados[i];
            }
        }

        return resultado;
    }

    public void mostrarHistorial() {
        while (!historialErrores.isEmpty()) {
            System.out.println(historialErrores.pop());
        }
    }

    @Override
    public String toString() {
        return "Servidor{" +
                "usuariosLoggeados=" + Arrays.toString(usuariosLoggeados) +
                ", cantidadUsuarioLoggeados=" + Arrays.toString(cantidadUsuarioLoggeados) +
                ", historialErrores=" + historialErrores +
                ", usuariosExistentes=" + usuariosExistentes +
                ", usuariosRecienLlegados=" + usuariosRecienLlegados +
                '}';
    }
}
