package Parchis;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public interface Vista {
	public void welcolme();

	public int askNumeroJugadores();

	public int askColor(int numJugador, ArrayList<Color> colores);

	public int askTipoJugador();

	public void pressAnyKeyToContinue();

	public void turnoJugador(Jugador jugador);

	public static int eleccionFicha(Color color, int fichasEnJuego) {
		System.out.println("¿Cual quieres mover?" + "-" + color.toString());
		Scanner scc = new Scanner(System.in);
		int i = scc.nextInt();
		if (i <= fichasEnJuego) {
			System.out.println("Jugador-" + color + "- muevo la ficha numero: " + i);
			return i;
		} else {
			return 0;
		}
	}

	public static int eleccionFichaIA(Color color, int fichasEnJuego) {
		// Empieza aquí
		Random rand = new Random();
		rand.setSeed(new Date().getTime());
		int rNumber = rand.nextInt(fichasEnJuego) + 1;
		System.out.println("IA-" + color + "- muevo la ficha numero: " + rNumber);
		return rNumber;
	}

	public static void resultadoDado(int result) {
		System.out.println("Has sacado:" + result);
	}
	
	public static void mostrarFichasEnJuego(ArrayList<Casilla> listaFichasJugador , int size){
		for(int i = 0; i < listaFichasJugador.size(); i++) {
			System.out.println("Ficha " + (i+1) + " en casilla: " + listaFichasJugador.get(i).getPosicionActual() + "\n");
		}
	}
}