package tp1_ejercicio1;

public abstract class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String result;
		int entero;
		
		Grupo miGrupo= new Grupo("Grupo A");
		result = miGrupo.getNombre();
		System.out.println(result);
		entero=miGrupo.gertCantidadintegrantes();
		System.out.println("Cantidad de integrantes :" +entero);
		miGrupo.agregarIntegrante("Walter");
		entero=miGrupo.gertCantidadintegrantes();
		System.out.println("Cantidad de integrantes :" +entero);
		miGrupo.agregarIntegrante("Diego");
		entero=miGrupo.gertCantidadintegrantes();
		System.out.println("Cantidad de integrantes :" +entero);
		miGrupo.agregarIntegrante("Roman");
		entero=miGrupo.gertCantidadintegrantes();
		System.out.println("Cantidad de integrantes :" +entero);
		result=miGrupo.obtenerIntegrante(7);
		System.out.println("El integrante encontrado es : " +result);
		result=miGrupo.removerIntegrante("Diego");
		System.out.println("Se borro el integrante : " + result);
		entero=miGrupo.gertCantidadintegrantes();
		System.out.println("Cantidad de integrantes :" +entero);
		result=miGrupo.removerIntegrante("Diego");
		System.out.println("Se borro el integrante : " + result);
		entero=miGrupo.gertCantidadintegrantes();
		System.out.println("Cantidad de integrantes :" +entero);
		miGrupo.mostrar();
		miGrupo.vaciar();
		miGrupo.mostrar();
	}

}
