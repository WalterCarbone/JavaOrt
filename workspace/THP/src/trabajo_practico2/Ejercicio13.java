package trabajo_practico2;
import java.util.Scanner;


public class Ejercicio13 {
private static Scanner input=new Scanner(System.in);
public static final char CURSO1='a';
public static final char CURSO2='b';
public static final char CURSO3='c';
public static final char CURSO4='d';
public static final String MATA="taller";
public static final String MATB="fundamentos";
public static final String MATC="matematica";



	public static void main(String[] args) {
		// TODO Auto-generated method stub
int cantAlum=0;
int contMatA=0;
int contMatB=0;
int contMatC=0;
String seleccion=" ";
String mayor= " ";



System.out.println("Ingrese la cantidad de alumnos que desea cargar :");
cantAlum = input.nextInt();


for (int i=0; i<cantAlum;i++){
	ingresoCurso(CURSO1,CURSO2,CURSO3,CURSO4);
	
	seleccion=ingresoMateria(MATA,MATB,MATC);
	
	switch (seleccion){
	case MATA : contMatA++;
	break;
	
	case MATB : contMatB++;
	break;
	
	case MATC : contMatC++;
	break;
		
	}
	
if (contMatA>contMatB && contMatA>contMatC)	{
	mayor = MATA;
}else if (contMatB>contMatA && contMatB>contMatC){
	mayor = MATB;
}else {
	mayor = MATC;
}
	


}
System.out.println("La materia mas requerida fue " + mayor);
input.close();

	}



	private static void ingresoCurso(char curso12, char curso22, char curso32, char curso42) {
		// TODO Auto-generated method stub
		char curso;
		System.out.println("Ingrese el curso (" + curso12 + "/"+curso22+"/"+curso32+"/"+curso42+") :" );
		curso=Character.toLowerCase(input.next().charAt(0));
		
		while (curso !=curso12 && curso!=curso22 && curso!=curso32 && curso!=curso42){
			System.out.println("Error. Curso inválido.");
			System.out.println("Ingrese el curso (" + curso12 + "/"+curso22+"/"+curso32+"/"+curso42+") :" );
			curso=Character.toLowerCase(input.next().charAt(0));
			
		}
	
		input.nextLine();
		
	}



	private static String ingresoMateria(String mata2, String matb2, String matc2) {
		// TODO Auto-generated method stub
		String materia= " ";
		System.out.println("Ingrese la materia ("+ mata2+"/"+matb2+"/"+ matc2+") :");
		materia = input.nextLine();
		
		while (!materia.equals(mata2) && !materia.equals(matb2) && !materia.equals(matc2)){
			System.out.println("Error. Materia inválido.");
			System.out.println("Ingrese la materia ("+ mata2+"/"+matb2+"/"+ matc2+") :");
			materia = input.nextLine();
			
		}
		
		return materia;
	}
	





}
