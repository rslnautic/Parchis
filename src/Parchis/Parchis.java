package Parchis;
import java.io.*;
import java.util.*;

public class Parchis {
	private Tablero tablero;
	private List<Jugador> jugadores;
	private Dado dado;
	private Iterador iterador;
	
	public Parchis() {
		tablero = Tablero.crearInstacia();
		jugadores = new ArrayList<Jugador>();
		dado = Dado.crearDado();
		iterador = new Iterador(tablero);
	}
	
	public void addJugador(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenido al Parchis de tu vieja\n¿Con que color quieres jugar?\n");
		System.out.println("1.Rojo\n2.Azul\n3.Amarillo\n4.Verde\n");
		int i = -1;
		i = sc.nextInt();
		Jugador jaux = null;
		switch(i){
		case 1: jaux = new Jugador(Color.ROJO);
		System.out.println("Has elegido el color rojo.\n");
			break;
		case 2: jaux = new Jugador(Color.AZUL);
		System.out.println("Has elegido el color azul.\n");
			break;
		case 3: jaux = new Jugador(Color.AMARILLO);
		System.out.println("Has elegido el color amarillo.\n");
			break;
		case 4: jaux = new Jugador(Color.VERDE);
		System.out.println("Has elegido el color verde.\n");
			break;
		default: System.out.println("que coño haces");
		addJugador();
		}
		jugadores.add(jaux);
		
	}
	
	public void imprimirLocalizacionFichasJugador(Color color) {
		ArrayList<Casilla> listaFichasJugador = this.iterador.recorrer(color);
		System.out.println("Tienes "+ listaFichasJugador.size() + " en juego");
		System.out.println("Tu jugador tiene las fichas en: \n");
		for(Casilla item : listaFichasJugador) {
			System.out.println("Ficha en casilla: " + item.getPosicionActual() + "\n");
		}
	}
	
	public void play() {
		boolean finished = false;
		imprimirLocalizacionFichasJugador(Color.ROJO);
		/*while(!finished){
			
		}*/
	}
}
