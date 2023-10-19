package trabajo_practico2;
import java.util.Scanner;


public class Ejercicio11 {
private static Scanner input=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int a = 0;
int b = 0;
int resultado = 0;

System.out.println("Ingrese primer número entero positivo : ");
a=input.nextInt();
System.out.println("Ingrese segundo número entero positivo : ");
b=input.nextInt();

resultado = calculadora(a,b);
System.out.println("El resultado es : " + resultado);

input.close();

	}
	private static int calculadora(int a, int b) {
	int resultado = 0;
	
	for (int i=0; i<b;i++){
		resultado = resultado + a;
	}
		return resultado;
	}

}
