package Parchis;

import java.io.*;
import java.util.*;

/**
 * 
 * @author Eduardo Terradez, Ramón Serrano y César Gil
 * @version 16/11/2015 v2
 * @see <a href = "https://github.com/rslnautic/Parchis"
 */
public class Jugador {
	private Color color;
	private Iterador iterador;
	private int fichasEnJuego;
	private ITipoJugador tipoJugador;

/**
 * Constructor de la clase Jugador
 * @param c1 indica el color del jugador
 */	
	public Jugador(Color c1){
		this.color = c1;
		this.iterador = new Iterador();
	}
	
	public void JugadorNormal()
    {
		ITipoJugador jugadorNormal = new JugadorNormal();
		setTipoJugador(jugadorNormal);
    }
 
    public void JugadorIA()
    {
    	ITipoJugador jugadorIA = new JugadorIA();
    	setTipoJugador(jugadorIA);
    }
    
    public void Mover()
    {
        String descripcion = this.tipoJugador.ObtenerDescripcion();
        System.out.println("Tipo de jugador que se mueve " + descripcion);
    }
	
/**
* Metodo que devuelve el color de un jugador
* @return el color del jugador
*/
	public Color getColor() {
		return color;
	}
	
/**
* Metodo que devuelve las casillas que contienen fichas del color del jugador
* @return las casillas con ficha de un color
*/	
public ArrayList<Casilla> getCasillasConFichas() {
		return this.iterador.recorrer(this.color);
	}

/**
* Metodo que imprimme por consola la posicion de las fichas de un jugador
*/	
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

/**
* Metodo que pregunta al jugador que ficha quiere mover y devuelve la ficha elegida 
* @return devuelve la ficha elegida por el jugador 
*/	
	public int eleccion(){
		return this.tipoJugador.eleccion(this.color, this.fichasEnJuego);
	}
/**
* Metodo que obtiene las fichas en juego
* @return las fichas que se encuentran en juego
*/
	public int getFichasEnJuego() {
		return fichasEnJuego;
	}

/**
* Metodo que establece el numero de fichas en juego
* @param fichasEnjuego El parametro fichasEnJuego cantidad de fichas que existen en el juego
*/
	public void setFichasEnJuego(int fichasEnJuego) {
		this.fichasEnJuego = fichasEnJuego;
	}
	
	public ITipoJugador getTipoJugador() {
		return tipoJugador;
	}

	public void setTipoJugador(ITipoJugador tipoJugador) {
		this.tipoJugador = tipoJugador;
	}
}
