package trabajo_practico2;
import java.util.Scanner;

public class Ejercicio6 {
	private static Scanner input=new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
String nombre;
String mejorAlumno="";
double promedio =0;
double mejorPromedio=0;

for (int i=0;i<10;i++){
	System.out.println("Ingrese nombre: ");
	nombre=input.nextLine();
	System.out.println("Ingrese promedio: ");
	promedio=input.nextDouble();
	input.nextLine();
	if (promedio>mejorPromedio){
		mejorPromedio=promedio;
		mejorAlumno=nombre;
	}
}

System.out.println("El mejor promedio es el de " + mejorAlumno +". Con un promedio de " + mejorPromedio);
input.close();

	}

}
