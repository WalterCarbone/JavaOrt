package ar.edu.ort.tp1.modelo;

import ar.edu.ort.tp1.tdas.implementaciones.ListaOrdenadaNodos;

public class UsuariosRegistradoPorNombre extends ListaOrdenadaNodos<String, Usuario> {

    @Override
    public int compare(Usuario dato1, Usuario dato2) {
        return dato1.getNombre().compareTo(dato2.getNombre());
    }

    @Override
    public int compareByKey(String clave, Usuario usuario) {
        return usuario.getNombre().compareTo(clave);
    }
}
