package Parchis;

import java.util.*;

public class Iterador {
	private Tablero tablero;
	
	public Iterador(Tablero tablero) {
		this.tablero = tablero;
	}
	
	public ArrayList<Casilla> recorrer(Color color) {
		ArrayList<Casilla> casillas = new ArrayList<Casilla>();
		
		for(int i = 0; i<tablero.getCasillasBlancas().size(); i++) {
			Casilla casillaActual = tablero.getCasillasBlancas().get(i);
			if(casillaActual.getFichas().size() != 0)
			{
				casillas.add(casillaActual);
			}
		}
		
		for(int i = 0; i<tablero.getPasillo().size(); i++) {
			Casilla casillaActual = tablero.getPasillo().get(i);
			if(casillaActual.getFichas().size() != 0)
			{
				casillas.add(casillaActual);
			}
		}
		return casillas;
	}
}
