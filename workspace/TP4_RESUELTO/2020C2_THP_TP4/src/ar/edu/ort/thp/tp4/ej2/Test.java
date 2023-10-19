/*
 * Los vecinos del edificio Alvear Icon deciden hacerse cargo de la administración del mismo. Del edificio sabemos su dirección, la cantidad de departamentos y los departamentos que lo componen.
De cada departamento se requiere almacenar: Número de unidad (de 1 a cantidad de departamentos), Dni y nombre del propietario, Saldo (double).
Se solicita crear en las clases que correspondan, con los parámetros necesarios e interactuando con otros métodos en caso que se precise (aunque no estén detallados), y los siguientes métodos:
Método público habitarUnidad(). Recibe los datos necesarios para agregar una unidad en el departamento, salvo la deuda que siempre se inicializa en 0 (tener en cuenta para desarrollar el constructor correspondiente). Recordá que el número de unidad no puede repetirse. Retorna un booleano con la confirmación de la acción.
Método público actualizarSaldo() : Recibe por parámetro un número de unidad y un saldo. Si la unidad existe en el edificio, actualiza el saldo por el nuevo que llega al método. Retorna un booleano con la confirmación de la acción.
Método público pasarAMoroso() : Recorre la lista de departamentos del edificio y actualiza el listado de departamentos morosos (aquellos que tengan saldo negativo). 
Método público listarMorosos() : Muestra por pantalla la información de todas las unidades que tengan mora (saldo negativo)

Para resolver este ejercicio, podés utilizar los métodos privados adicionales que consideres necesarios. 
Crear la clase Test, instanciar un objeto Edificio y probar todos los métodos públicos.

 */

package ar.edu.ort.thp.tp4.ej2;

public class Test {

	private static final int CANTIDAD_DE_UNIDADES = 4;

	public static void main(String[] args) {
		Edificio edificio = new Edificio("Aimé Painé 1130", 4);

		System.out.println("*Asignar vecinos a las unidades del edificio*");
		System.out.println(edificio.habitarUnidad(1, "26333111", "Diego"));
		System.out.println(edificio.habitarUnidad(2, "26333112", "Juan"));
		System.out.println(edificio.habitarUnidad(3, "26333119", "Pedro"));
		System.out.println(edificio.habitarUnidad(4, "31192633", "Silvia"));

		System.out.println("*Tratar de habitar una unidad ya habitada*");
		System.out.println(edificio.habitarUnidad(2, "26333112", "Juan"));

		System.out.println("*Actualizaciones de saldo (todos deberan 10000)*");
		for (int u=1; u <= CANTIDAD_DE_UNIDADES; u++) {
			edificio.agregarDeuda(u, 10000);
		}
		// Todos los departamentos
		edificio.listarUnidades();
		
		System.out.println(edificio.cancelarDeuda(1, 10000));
		System.out.println(edificio.cancelarDeuda(2, 4500));
		System.out.println(edificio.cancelarDeuda(2, 6500));
		System.out.println(edificio.cancelarDeuda(3, 8000));
		System.out.println(edificio.cancelarDeuda(30, 8000));

		// Todos los departamentos, actualizados
		edificio.listarUnidades();
		// Listado de Morosos
		edificio.listarMorosos();

	}

}
