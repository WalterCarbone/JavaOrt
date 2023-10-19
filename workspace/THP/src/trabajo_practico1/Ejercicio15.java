package trabajo_practico1;
import java.util.Scanner;

public class Ejercicio15 {
private static Scanner input=new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
int num1 ;

boolean estaEnA; // si es 1 digito
boolean estaEnB; // impar
boolean estaEnAmbos;

System.out.println("Ingrese un número: ");
num1 = input.nextInt();
boolean noEstaEnNinguno =false;


if (num1<10){
	estaEnA= true;
}
else {
	estaEnA =false;
}

if ((num1%2)!=0){
	estaEnB=true; // es impar
}
else {
	estaEnB=false; // es par
	}

if (estaEnA==true && estaEnB==true){
	estaEnAmbos=true;
	System.out.println("El número es de un dígito e impar");
}
else if(estaEnA==true && estaEnB==false){
	System.out.println("El número es de un dígito");
}
else if (estaEnA==false && estaEnB==true){
	System.out.println("El número es impar");
}


		input.close();
	}

}
