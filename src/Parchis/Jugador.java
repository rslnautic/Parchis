package Parchis;

import java.util.*;
import java.io.*;

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
	
	public int eleccion(){
		System.out.println("¿Cual quieres mover?");
		Scanner sc = new Scanner(System.in);
		
		int i = -1;
		i = sc.nextInt();
		
		if(i<=4) {
			return i;
		} else {
			eleccion();
		}
		sc.close();
		return i;
	}
}
