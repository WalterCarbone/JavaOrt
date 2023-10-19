package trabajo_practico2;
import java.util.Scanner;
/* El objetivo de este ejercicio es calcular el sueldo de los empleados y mostrarlos por pantalla. 
 * Para esto se deber√° ingresar: nombre, categor√≠a y antiguedad del empleado, teniendo en cuenta lo siguiente:
* Las categor√≠as validas son A, B o C. 
* La antig√ºedad se considera como v√°lida si es un valor entre 0 y 30.
* A partir de la misma, calcularemos el sueldo que estar√° compuesto de un b√°sico, que dependera de la categor√≠a, 
* m√°s un plus por vacaciones que depender√° de la antig√ºedad. 
* 
* Categoria A recibe un b√°sico de $20000, categor√≠a B un b√°sico de 30000 y C un b√°sico de 40000.
* si la antiguedad es menor a 6, los d√≠as de vacaciones son 14. //ANT_A
* si la antiguedad es mayor a 5 ((6)) y menor a 11, los d√≠as de vacaciones son 21. // ANT_B
* si la antiguedad es mayor a 10,  los d√≠as de vacaciones son 28 // ANT_C
* caso contrario, no tiene d√≠as de vacaciones (( ANT_D
* Desarrollar el programa para poder ingresar los datos necesarios y calcular los sueldos de cada empleado 
* hasta que el nombre del empleado sea "fin"
*/

public class CalculadoraSueldos {
private static Scanner input=new Scanner(System.in);
public static final char CAT_A = 'A';
public static final char CAT_B = 'B';
public static final char CAT_C = 'C';
public static final int ANT_A = 14;
public static final int ANT_B = 21;
public static final int ANT_C = 28;
public static final String ANT_D ="No tiene dÌas de vacaciones.";
public static final String SALIDA = "fin";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String nombre;
char categ;
double antiguedad=0;



System.out.println("Ingrese nombre del empleado (escriba 'fin' para salir) :");
nombre=input.nextLine();
while (!nombre.equals(SALIDA)){

	categ= pedirCategoria();
	

	antiguedad = pedirAntiguedad();
	
	input.nextLine();
	switch (categ){
		case 'A': System.out.println("El sueldo b·sico de " + nombre + " es $20000");
		break;
		
		case 'B' : System.out.println("El sueldo b·sico de " + nombre + " es $30000");
		break;
		
		case 'C' : System.out.println("El sueldo b·sico de " + nombre + " es $40000");
		break;	
	}
	
	if (antiguedad<6){
		System.out.println("Y el plus vacacional es de " + ANT_A + " dÌas.");
	}
	else if (antiguedad>6 && antiguedad <11){
		System.out.println("Y el plus vacacional es de " + ANT_B+ " dÌas.");
	}
	else if (antiguedad>10){
		System.out.println("Y el plus vacacional es de " + ANT_C+ " dÌas.");
	}
	else {
		System.out.println(ANT_D);
	}
	
System.out.println("Ingrese nombre del empleado (escriba 'fin' para salir) :");
nombre=input.nextLine();	
}
System.out.println("Fin del programa");
input.close();
	}

	private static char pedirCategoria() {
		// TODO Auto-generated method stub
		char categ;
		System.out.println("Ingrese categorÌa  (A/B/C) :");
		categ=Character.toUpperCase(input.next().charAt(0));
		
		while(categ != CAT_A && categ != CAT_B && categ != CAT_C){
			System.out.println("CategorÌa inv·lida");
			System.out.println("Ingrese nuevamente la categorÌa (A/B/C) :");
			categ=Character.toUpperCase(input.next().charAt(0));
		}
		input.nextLine();	
		return categ;
	}

	private static double pedirAntiguedad() {
		int antiguedad;
		// TODO Auto-generated method stub
		System.out.println("Ingrese la antig¸edad de  (0 a 30 aÒos) : ");
		antiguedad = input.nextInt();
		while (antiguedad<0 || antiguedad>30){
			System.out.println("Antig¸edad inv·lida.");
			System.out.println("Ingrese nuevamente la antig¸edad (0 a 30 aÒos) : ");
			antiguedad = input.nextInt();
		}
		return antiguedad;
	}

}
