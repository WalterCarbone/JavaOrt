package Ejemplo_parcial;
import java.util.Scanner;
import java.util.Random;




public class Parcial_casino {

	private static Scanner input=new Scanner(System.in);
	//DECLARACION DE CONSTANTES
	public static final int CAPITAL= 500;
	public static final double MINIMO =0.2;
	public static final int ACUMULADO = 5000;
	public static final String RULETA_COD = "rul";
	public static final String RULETA_NOM = "Ruleta";
	public static final int RULETA_PREC = 100;
	public static final String BLACK_COD = "black";
	public static final String BLACK_NOM = "Black Jack";
	public static final int BLACK_PREC = 200;
	public static final String POKER_COD = "pok";
	public static final String POKER_NOM = "Poker";
	public static final int POKER_PREC = 500;
	public static final String BIENVENIDA ="*** Bienvendida/o al Casino Nunca Pierdo ***";
	
	
	
	public static void main(String[] args) {
	//DECLARACION DE VARIABLES
	int plataInicial;
	int plataRestante;
	String nombre;
	String juego;
	int contPoker;
	int contJuegos;
	int costoJuego;
	int resultado;
	boolean regla;
	
	plataInicial =0;
	plataRestante =0;
	contPoker = 0;
	contJuegos = 0;
	costoJuego = 0;
	resultado = 0;
	regla = true;
	
	System.out.println(BIENVENIDA);
	
	nombre = ingreseTexto("Ingresá tu nombre :");
	plataInicial = validoCapitalInicial(CAPITAL);
	while (plataInicial<CAPITAL){
		System.out.println("El capital mínimo para jugar es $" + CAPITAL);
		plataInicial = ingreseNumero("Ingresá la cantidad de plata que vas a jugar");
	}
	plataRestante = plataInicial;
	do{
	muestroJuegos();
	juego=obtengoJuego("¿A qué queres jugar?");
	costoJuego = obtengoCostoJuego(juego);
	if (plataRestante >= costoJuego){
		plataRestante = plataRestante - costoJuego;
		resultado = calculoGanancia(costoJuego);
		plataRestante = plataRestante + resultado;
		contJuegos++;
		if (juego.equals(POKER_COD)){
			contPoker ++;
		}
		
	}else{
		System.out.println("No te alcanza para juegar");
	}
	System.out.println("Tu dinero dispobile es $" + plataRestante);
	regla = validoRegla (plataInicial,plataRestante);
	}while(regla == false);
	muestroMensajeFin(nombre,plataRestante,contPoker,contJuegos);
	input.close();	
	}

	
	
	
	
	// FUNCIONES
	
	
	
	
	private static void muestroMensajeFin(String nombre, int plataRestante, int contPoker, int contJuegos) {
		double porc=0;
		porc = contPoker*100/contJuegos;
		System.out.println("Gracias " + nombre + " por jugar con nosotros." + "Tu dinero restante es $" + plataRestante+ ". Jugaste " + contPoker + " veces al poker, el " + porc + "% del total de juegos.");
		
	}





	private static boolean validoRegla(int plataInicial, int plataRestante) {
		boolean resp;
		resp = false;
		double monto=0;
		monto =  (plataInicial) * MINIMO;
		if (plataRestante<monto){
			resp=true;
		}
		if (plataRestante<RULETA_PREC && plataRestante<BLACK_PREC && plataRestante<POKER_PREC){
			resp=true;
		}
		if (plataRestante > (plataInicial+ACUMULADO)){
			resp=true;
		}
		
		return resp;
	}





	private static int calculoGanancia(int costoJuego) {
		int gan=0;
		int result =0;
		result = obtenerResultado();
		switch (result){
			case 2: 
				gan = costoJuego + costoJuego;
				System.out.println("Ganaste!");
				break;
			case 1:
				gan = costoJuego;
				System.out.println("Empataste");
				break;
			case 0:
				gan = 0;
				System.out.println("Lo siento, perdiste");
				break;
		}		
		return gan;
	}





	private static int obtengoCostoJuego(String juego) {
		int costo =0;
		switch (juego){
			case RULETA_COD: 
				costo = RULETA_PREC;
				break;
			case BLACK_COD:
				costo = BLACK_PREC;
				break;
			case POKER_COD:
				costo = POKER_PREC;
				break;
		}
		return costo;
	}





	private static String obtengoJuego(String string) {
		String juego,msj,error;
		msj = "¿A qué queres jugar? :";
		error = "Juego inválido";
		juego= ingreseTexto(msj);
		while (!juego.equals(RULETA_COD) && !juego.equals(BLACK_COD)&& !juego.equals(POKER_COD) )	{
			System.out.println(error);
			juego= ingreseTexto(msj);
		}
		
		return juego;
	}





	private static void muestroJuegos() {
		System.out.println("* * * Juegos disponibles * * *");
		System.out.println(RULETA_NOM + " (" + RULETA_COD + ")" + " .Costo $" + RULETA_PREC);
		System.out.println(BLACK_NOM + " (" + BLACK_COD + ")" + " .Costo $" + BLACK_PREC);
		System.out.println(POKER_NOM + " (" + POKER_COD + ")" + " .Costo $" + POKER_PREC);
	}	





	private static int validoCapitalInicial(int capital) {
		int plata = 0;
		String msj;
		String error;
		msj = "Ingresá el capital inicial $";
		error = "Error, el capital mínimo debe ser $"+capital;
		plata = ingreseNumero(msj);
		while (plata<capital){
			System.out.println(error);
			plata=ingreseNumero(msj);
			}
		return plata;
	}






	public static int ingreseNumero(String msj){
		int num;
		System.out.println(msj);
		num = input.nextInt();
		input.nextLine();
		return num;
	}
	
	public static String ingreseTexto(String msj){
		String texto;
		do{
			System.out.println(msj);
			texto = input.nextLine();
		}while(texto.equals(""));
		
		return texto;
	}
	
	public static int obtenerResultado(){
		Random rn = new Random();
		return rn.nextInt(3);
	}
}
