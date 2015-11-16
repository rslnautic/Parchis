package Parchis;


/**
 * 
 * @author Eduardo Terradez, Ramón Serrano y César Gil
 * @version 16/11/2015 v2
 * @see <a href = "https://github.com/rslnautic/Parchis"
 */
public class Ficha {
	private Color color;
	
/**	 
 * Constructor de Ficha que recibe el color de la misma ficha por parametro
 * @param c1 El parámetro c1 define de que color va a ser la ficha
 */		
public Ficha(Color c1){
	this.color = c1;
}

/**	 
 * Metodo qye devuelve el color de la ficha
 * @return el color de la ficha
 */		
	public Color getColor() {
		return color;
	}
}

enum Color{
	AMARILLO,
	ROJO,
	VERDE,
	AZUL
}