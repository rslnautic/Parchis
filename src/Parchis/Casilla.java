package Parchis;
import java.util.List;
import java.util.ArrayList;


public class Casilla {
	private List<Ficha> fichas;
	private TipoCasilla tipoCasilla;
	private int posicionActual;
	
	
	public Casilla(TipoCasilla tipo1){
		this.tipoCasilla = tipo1;
		
		if(tipo1.equals(TipoCasilla.META)){
			this.fichas = new ArrayList<Ficha>(4);
		}
		else{
			this.fichas = new ArrayList<Ficha>(2);
		}
		
	}
	
	
	
	public enum TipoCasilla{
		SALIDA,
		SEGURO,
		PASILLO,
		META,
		NORMAL
	}
}
