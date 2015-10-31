package Parchis;

import java.util.*;

/*La clase Tablero modela el tablero de parchis mediante arrays de tipo Casilla. 
 */
public class Tablero {
	private static Tablero _instanciaTablero = null;
	//Array de las casillas comunes a todos los jugadores.
	private List<Casilla> casillasBlancas;
	//Array de las casillas del color elegido por el jugador.
	private List<Casilla> pasillo;
	//Numero de fichas que el jugador tiene en juego.
	private int fichasEnJuego;
	//Constructor porn defecto que realiza las llamadas
	private Tablero() {
		crearBlancas();
		crearPasillo();
		fichasEnJuego = 0;
	}
	//Getters y setters
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
	/*Método estático que implementa el patrón Singleton haciendo posible la creación de una instancia
	 * de la clase Tablero unicamente si no hay una instancia ya creada
	 * */
	public static Tablero crearInstacia() {
		if(_instanciaTablero==null) {
			_instanciaTablero = new Tablero();
		}
		return _instanciaTablero;
	}
	//Inicializa el array de las casillas comunes y cambia su tipo en funcion del numero que sea.
	public void crearBlancas() {
		
		casillasBlancas = new ArrayList<Casilla>(68);
		
		for(int i=0; i<68; i++){
			Casilla aux;
			if(i==3 || i==20 || i==37 || i==54) {
				aux = new Casilla(TipoCasilla.SALIDA, i+1); 
			} else if (i== 12 || i==29 || i==46 || i==63){
				aux = new Casilla(TipoCasilla.SEGURO, i+1); 
			} else if (i== 67 || i==16 || i==33 || i==50){
				aux = new Casilla(TipoCasilla.ENTRADA, i+1);
			}else {
				aux = new Casilla(TipoCasilla.NORMAL, i+1); 		
			}
			casillasBlancas.add(aux); 
		}
	}
	//Inicializa el pasillo y setea la ultima casilla como meta.
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
	/*Añade una ficha nueva al jugador haciendo uso del patrón Factory usando diferentes fabricas en 
	 función del color de la ficha a crear.
	*/
	public void addFicha(Color color) {
		  FabricaAbstractaFichas fabrica;
		  Ficha ficha;
		  
		  switch(color) {
		   case ROJO: 
		    fabrica = new FabricaFichasRoja();
		    ficha = fabrica.crearFicha(); 
		    this.casillasBlancas.get(37).ponerFicha(ficha);
		    break;
		   case AMARILLO:
		    fabrica = new FabricaFichasAmarilla();
		    ficha = fabrica.crearFicha(); 
		    this.casillasBlancas.get(3).ponerFicha(ficha);
		    break;
		   case AZUL:
		    fabrica = new FabricaFichasAzul();
		    ficha = fabrica.crearFicha(); 
		    this.casillasBlancas.get(20).ponerFicha(ficha);
		    break;
		   case VERDE:
		    fabrica = new FabricaFichasVerde();
		    ficha = fabrica.crearFicha(); 
		    this.casillasBlancas.get(54).ponerFicha(ficha);
		    break;
		   default:
		    break;
		  }
		  
		  this.fichasEnJuego++;
		 }
	//Método utilizado para mover las fichas.
	public void moverFicha(Ficha ficha, int posicion, int nDado){
		this.casillasBlancas.get(posicion-1+nDado).ponerFicha(ficha);
		this.casillasBlancas.get(posicion-1).borrarFicha(ficha);
		
	}
	//Método utilizado para borrar las fichas.
	public void borrarFicha(int posicion) {
		this.casillasBlancas.get(posicion-1).borrarFicha(this.casillasBlancas.get(posicion-1).getFichas().get(0));
	}
	//Getters y setters
	public int getFichasEnJuego() {
		return fichasEnJuego;
	}
	
	public void setFichasEnJuego(int fichasEnJuego) {
		this.fichasEnJuego = fichasEnJuego;
	}
}
