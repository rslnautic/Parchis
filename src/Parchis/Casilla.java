package Parchis;
import java.util.List;
import java.util.ArrayList;


public class Casilla {
	private List<Ficha> fichas;
	private TipoCasilla tipoCasilla;
	private int posicionActual;
	
	
	public Casilla(TipoCasilla tipo1, int posicion){
		this.tipoCasilla = tipo1;
		this.posicionActual= posicion;
		
		if(tipo1.equals(TipoCasilla.META)){
			this.fichas = new ArrayList<Ficha>(4);
		}
		else{
			this.fichas = new ArrayList<Ficha>(2);
		}
		
	}


	public List<Ficha> getFichas() {
		return fichas;
	}


	public void setFichas(List<Ficha> fichas) {
		this.fichas = fichas;
	}


	public TipoCasilla getTipoCasilla() {
		return tipoCasilla;
	}


	public void setTipoCasilla(TipoCasilla tipoCasilla) {
		this.tipoCasilla = tipoCasilla;
	}


	public int getPosicionActual() {
		return posicionActual;
	}


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