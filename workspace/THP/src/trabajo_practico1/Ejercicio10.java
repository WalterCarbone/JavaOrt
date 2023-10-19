package trabajo_practico1;
import java.util.Scanner;

public class Ejercicio10 {
public static final int HORA_APERTURA = 10;
public static final int HORA_CIERRE = 18;
private static Scanner input=new Scanner(System.in);


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean estaAbierto= true;
		System.out.println("Ingrese hora");
		int hora=input.nextInt();
		
		if (hora<HORA_APERTURA || hora>HORA_CIERRE){
			System.out.println("Ha ingresado una hora incorrecta");
			estaAbierto=false;
			
		}
		else{
			if (hora>=HORA_APERTURA && hora<HORA_CIERRE){
				estaAbierto= true;
			}
			else{
				estaAbierto=false;
			}
		}
		if (estaAbierto==true){
			System.out.println("Está abierto");
		}
		else {
			System.out.println("Está cerrado");
		}
		input.close();
		
	}

}
