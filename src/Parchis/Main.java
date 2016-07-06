package Parchis;


/**
 * 
 * @author Eduardo Terradez, Ramón Serrano y César Gil
 * @version 16/11/2015 v2
 * @see <a href = "https://github.com/rslnautic/Parchis"
 */

public class Main {	
	public static void main(String[] args) {
		Parchis parchis = new Parchis();
		parchis.addJugadores();
		parchis.play();
		
		/*Jugador asd = new Jugador(Color.ROJO);
		asd.JugadorIA();
		asd.Mover();
		
		asd.JugadorNormal();
		asd.Mover();*/
	}
}
