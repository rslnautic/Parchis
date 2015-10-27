package Parchis;

import java.util.ArrayList;

public class Jugador {
	private Color color;
	private Iterador iterador;
	
	
	public Jugador(Color c1){
		this.color = c1;
		this.iterador = new Iterador();
	}

	public Color getColor() {
		return color;
	}
	
	public void imprimirLocalizacionFichasJugador() {
		ArrayList<Casilla> listaFichasJugador = this.iterador.recorrer(this.color);
		System.out.println("Tienes "+ listaFichasJugador.size() + " en juego");
		System.out.println("El jugador "+this.color+ " tiene las fichas en: \n");
		for(int i = 0; i < listaFichasJugador.size(); i++) {
			System.out.println("Ficha " + (i+1) + " en casilla: " + listaFichasJugador.get(i).getPosicionActual() + "\n");
		}
	}
}
