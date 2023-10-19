package Test;

import Clases.Droide;
import Clases.Pieza;

public class Test {

	public static void main(String[] args) {
		Droide d1 = new Droide("Storm", true);
		Droide d2 = new Droide("Clone", true);
		Pieza p1= new Pieza("visor");
		
		Pieza p2= new Pieza("laser");
		d1.agregarPieza(p1);
		d1.agregarPieza(p2);
		d1.agregarRoto(new Droide("usado", false));
		d1.agregarRoto(new Droide("roto", false));
		d1.listarRotos();
	}
}
