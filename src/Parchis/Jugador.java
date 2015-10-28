package Parchis;

import java.io.*;
import java.util.*;


public class Jugador {
	private Color color;
	private Iterador iterador;
	private int fichasEnJuego;
	
	
	public Jugador(Color c1){
		this.color = c1;
		this.iterador = new Iterador();
	}

	public Color getColor() {
		return color;
	}
	
	public ArrayList<Casilla> getCasillasConFichas() {
		return this.iterador.recorrer(this.color);
	}
	
	public void imprimirLocalizacionFichasJugador() {
		ArrayList<Casilla> listaFichasJugador = getCasillasConFichas();
		this.fichasEnJuego = listaFichasJugador.size();
		//System.out.println("Tienes "+ this.fichasEnJuego + " en juego");
		//System.out.println("El jugador "+this.color+ " tiene las fichas en: \n");
		//System.out.println(this.color+"\n");
		for(int i = 0; i < listaFichasJugador.size(); i++) {
			System.out.println("Ficha " + (i+1) + " en casilla: " + listaFichasJugador.get(i).getPosicionActual() + "\n");
		}
	}
	
	public int eleccion(){
		System.out.println("¿Cual quieres mover?");
		Scanner scc = new Scanner(System.in);
		int i = scc.nextInt(); 
		if(i<=4) {
			System.out.println(this.color+"- muevo la ficha numero: "+i);
			return i;
		} else {
			return eleccion();
		}
	}

	public int getFichasEnJuego() {
		return fichasEnJuego;
	}

	public void setFichasEnJuego(int fichasEnJuego) {
		this.fichasEnJuego = fichasEnJuego;
	}
}
