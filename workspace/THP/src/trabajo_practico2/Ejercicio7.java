package trabajo_practico2;
import java.util.Scanner;

public class Ejercicio7 {
private static Scanner input=new Scanner(System.in);

public static void main(String[] args) {
		// TODO Auto-generated method stub
String userId="c";
String pass="2";

String ingresoUser;
String ingresoPass;
int intentos=1;

System.out.println("Ingrese su usuario :");
ingresoUser=input.nextLine();

while (!ingresoUser.equals(userId)){
	System.out.println("Nombre de usuario inválido");
	
	System.out.println("ingrese su usuario :");
	ingresoUser=input.nextLine();
}

System.out.println("Ingrese su contraseña :");
ingresoPass=input.nextLine();

while (!ingresoPass.equals(pass) && (intentos<3)){
	System.out.println("Contraseña inválida");
	intentos++;
	System.out.println("Ingrese su contraseña :");
	ingresoPass=input.nextLine();
}

if (intentos<3){
	System.out.println("Ha ingresador correctamente");
	intentos=1;
	}
else{
	System.out.println("Se ha bloqueado su cuenta" + intentos);
}	
	
input.close();

}

}

