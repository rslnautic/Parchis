package Parchis;

import java.util.*;

public class Iterador {
	private Tablero tablero;
	private int indice;
	
	public Iterador() {
		this.tablero = Tablero.crearInstacia();
		this.indice = -1;
	}
	
	public ArrayList<Casilla> recorrer(Color color) {
		ArrayList<Casilla> casillas = new ArrayList<Casilla>();
		Casilla casillaActual = null;
		
		while(hayMas()) {
			casillaActual = siguienteCasilla();
			if(casillaActual.getFichas().size() != 0)
			{	if (casillaActual.getFichas().get(0).getColor().equals(color)) {
					casillas.add(casillaActual);
				}
			}
		} 
		return casillas;
	}
	
	public Casilla siguienteCasilla() {
		Casilla aux = null;
		int indicePasillo = this.indice-this.tablero.getCasillasBlancas().size()+1;
		int sizeAll = this.tablero.getCasillasBlancas().size()+this.tablero.getPasillo().size();
		this.indice++;
		
		if(this.indice<this.tablero.getCasillasBlancas().size()) {
			aux = this.tablero.getCasillasBlancas().get(this.indice);
		} else if(this.indice>=this.tablero.getCasillasBlancas().size() && this.indice<sizeAll){
			if(indicePasillo<this.tablero.getPasillo().size()) {
				aux = this.tablero.getPasillo().get(indicePasillo);
			}
		}
		return aux;
	}
	
	public boolean hayMas() {
		boolean haymas;
		int sizeAll = this.tablero.getCasillasBlancas().size()+this.tablero.getPasillo().size();
		if(this.indice<sizeAll-1) {
			haymas = true;
		} else {
			haymas = false;
		}
		return haymas;
	}
}
