package trabajo_practico2;
import java.util.Scanner;

public class Ejercicio5 {
	private static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int promedio =0;
int cantidad = 1;
int valor=0;
int contador=0;

do{

	System.out.println("Ingrese número :");
	valor= input.nextInt();
	promedio = (promedio + valor)/cantidad;
	cantidad++;
	contador++;
}while(promedio<20);

System.out.println("La cantidad de valores leídos fueron :" + (contador));
	}

}
