package trabajo_practico2;
import java.util.Scanner;


public class Ejemplo2 {
	private static Scanner input=new Scanner(System.in);
	public static final String MSJBIENV = "Biehghfghfghfgndido!";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a;
		a=12;
		
		muestro(a);
		copio(MSJBIENV,a);
		
	}

	private static void copio(String msjbienv2, int a) {
		// TODO Auto-generated method stub
		System.out.println(msjbienv2 + a);
	}

	private static void muestro(int a) {
		// TODO Auto-generated method stub
		System.out.println(MSJBIENV + a);
	}

}
