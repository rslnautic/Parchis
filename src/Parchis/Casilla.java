package Parchis;
import java.util.*;
import java.io.*;

/**
 * 
 * @author Eduardo Terradez, Ramón Serrano y César Gil
 * @version 16/11/2015 v2
 * @see <a href = "https://github.com/rslnautic/Parchis"
 */

public class Casilla {
	private List<Ficha> fichas;
	private TipoCasilla tipoCasilla;
	private int posicionActual;

/**	 
 * Constructor de la clase Casilla
 * @param tipo1 El parámetro tipo1 define el tipo de casilla al que pertenece (SALIDA, SEGURO, ENTRADA, PASILLO, META, NORMAL)
 * @param posicion El parametro posicion indica la posición de la casilla en el tablero
 */	
public Casilla(TipoCasilla tipo1, int posicion){
		this.tipoCasilla = tipo1;
		this.posicionActual= posicion;
		
		if(tipo1.equals(TipoCasilla.META)){
			this.fichas = new ArrayList<Ficha>(4);
		}
		else{
			this.fichas = new ArrayList<Ficha>(2);
		}	
}//Cierre del constructor

/**
 * Metodo para borrar una ficha
 * @param ficha El parametro ficha de tipo Ficha indica la ficha que hay que eliminar
 */	
public void borrarFicha(Ficha ficha){
		this.fichas.remove(ficha);
}

/**
 * Metodo para poner una ficha en el tablero
 * @param ficha El parametro ficha de tipo Ficha indica la ficha que hay que añadir
 */	
public void ponerFicha(Ficha ficha){		
	this.fichas.add(ficha);
}

/**
 * Metodo para devolver el array de fichas que tiene esa casilla
 * @return devuelve las fichas que se encuentran en esa casilla
 */	
public List<Ficha> getFichas() {
	return fichas;
}

/**
 * Metodo para introducir un array de fichas en la clase Casilla
 * @param List<Ficha> fichas Array de fichas 
 */	
public void setFichas(List<Ficha> fichas) {
	this.fichas = fichas;
}

/**
 * Metodo para obtener el tipo de casilla (ENTRADA, SALIDA, PASILLO...)
 * @return devuelve el tipo de casilla que es
 */	
public TipoCasilla getTipoCasilla() {
	return tipoCasilla;
}

/**
 * Metodo para definir el tipo de casilla (ENTRADA, SALIDA, PASILLO)
 * @param tipoCasilla El parametro tipoCasilla especifica de que tipo es la casilla (ENTRADA, SALIDA, PASILLO...)
 */	
public void setTipoCasilla(TipoCasilla tipoCasilla) {
	this.tipoCasilla = tipoCasilla;
}

/**
 * Metodo para obtener la posicion de una ficha
 * @return devuelve la posicion actual de la ficha
 */	
public int getPosicionActual() {
	return posicionActual;
}

/**
 * Metodo para introducir la posicion de una ficha 
 * @param posicionActual El parametro posicion actual indica cual es la posicion de la ficha en ese momento 
 */	
public void setPosicionActual(int posicionActual) {
	this.posicionActual = posicionActual;
}
	
}
enum TipoCasilla{
	SALIDA,
	SEGURO,
	ENTRADA,
	PASILLO,
	META,
	NORMAL
}