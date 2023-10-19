package ar.edu.ort.tp1.modelo;

public class Test {

    public static void main(String[] args) {
        Servidor servidor = new Servidor();

        sobreCargarServer(servidor);

        Usuario usuario1 = new UsuarioIphone("Lucas", "hola123", 2);
        Usuario usuario2 = new UsuarioIphone("Lucas2", "hola123", 10);

        servidor.loggearUsuario(usuario1);
        servidor.loggearUsuario(usuario2);

        servidor.procesarUsuarioPendientes();

        servidor.mostrarHistorial();
    }

    private static void sobreCargarServer(Servidor s){
        int max=5*30;
        for (int i=0;i<max;i++){
            s.loggearUsuario(new UsuarioPC(new Integer(i).toString(), new Integer(i).toString(), 7));// mal
        }
        s.procesarUsuarioPendientes();
    }


}
