package Parchis;

import java.util.List;
import java.util.ArrayList;


public class Tablero {
	private static Tablero _instanciaTablero = null;
	
	private List<Casilla> casillasBlancas;
	private List<Casilla> pasillo;
	/**private List<Casilla> pasilloVerde;
	private List<Casilla> pasilloAmarillo;
	private List<Casilla> pasilloAzul;**/
	
	private Tablero() {
		crearBlancas();
		crearPasillo();
	}
	
	public List<Casilla> getCasillasBlancas() {
		return casillasBlancas;
	}

	public void setCasillasBlancas(List<Casilla> casillasBlancas) {
		this.casillasBlancas = casillasBlancas;
	}

	public List<Casilla> getPasillo() {
		return pasillo;
	}

	public void setPasillo(List<Casilla> pasillo) {
		this.pasillo = pasillo;
	}

	public static Tablero crearInstacia() {
		if(_instanciaTablero==null) {
			_instanciaTablero = new Tablero();
		}
		return _instanciaTablero;
	}
	
	public void crearBlancas() {
		FabricaAbstractaFichas fabrica;
		Ficha ficha;
		fabrica = new FabricaFichasRoja();
		ficha = fabrica.crearFicha();
		ArrayList<Ficha> fichas = new ArrayList<Ficha>(4);
		fichas.add(ficha);
		
		casillasBlancas = new ArrayList<Casilla>(68);
		
		for(int i=0; i<68; i++){
			Casilla aux;
			if(i==3 || i==20 || i==37 || i==54) {
				aux = new Casilla(TipoCasilla.SALIDA, i+1); 
			} else if (i== 12 || i==29 || i==46 || i==63){
				aux = new Casilla(TipoCasilla.SEGURO, i+1); 
			} else if (i== 67 || i==16 || i==33 || i==50){
				aux = new Casilla(TipoCasilla.ENTRADA, i+1);
				aux.setFichas(fichas);
			}else {
				aux = new Casilla(TipoCasilla.NORMAL, i+1); 		
			}
			casillasBlancas.add(aux); 
		}
	}
	
	public void crearPasillo() {
		pasillo = new ArrayList<Casilla>(8);
		for(int i= 0; i<8; i++){
			Casilla aux;
			if(i == 7){
				aux = new Casilla(TipoCasilla.META, i+1);
			}else {
				aux = new Casilla(TipoCasilla.PASILLO, i+1);	
			}
			pasillo.add(aux);
		}
	}
		
	
}
