package Parchis;
import java.io.*;
import java.util.*;

/**
 * 
 * @author Eduardo Terradez, Ramón Serrano y César Gil
 * @version 16/11/2015 v2
 * @see <a href = "https://github.com/rslnautic/Parchis"
 */


public class Parchis {
	
	private Tablero tablero;
	private Jugador jugador;
	private Dado dado;
	private Iterador iterator;
	private int resultadoDado;
	private int cantidadDe6;
	
	/**
	 * Constructor por defecto de la clase parchis.
	 * @param ninguno 
	 */
	
	public Parchis() {
		tablero = Tablero.crearInstacia();
		dado = Dado.crearDado();
		this.iterator = new Iterador();
	}// Cierre del constructor
	
	
	/**
	 * Metodo para añadir un jugador al atributo de la clase
	 * El método pide por consola el color que el jugador quiera
	 * @param ninguno 
	 */
public void addJugador(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenido al Parchis\n¿Con que color quieres jugar?\n");
		System.out.println("1.Rojo\n2.Azul\n3.Amarillo\n4.Verde\n");
		int i = -1;
		i = sc.nextInt();
		Jugador jaux = null;
		switch(i){
		case 1: jaux = new Jugador(Color.ROJO);
		System.out.println("Has elegido el color rojo.\n");
			break;
		case 2: jaux = new Jugador(Color.AZUL);
		System.out.println("Has elegido el color azul.\n");
			break;
		case 3: jaux = new Jugador(Color.AMARILLO);
		System.out.println("Has elegido el color amarillo.\n");
			break;
		case 4: jaux = new Jugador(Color.VERDE);
		System.out.println("Has elegido el color verde.\n");
			break;
		default: System.out.println("que haces");
		addJugador();
		}
		jaux.JugadorNormal();
		//jaux.JugadorIA();
		this.jugador = jaux;
	}
	/**
	 * Bucle principal del juego en el cual se suceden las tiradas del dado y se piden 
	 * por consola las decisiones que el jugador puede tomar.
	 * 
	 */
	
	public void play() {
		ArrayList<Casilla> listaCasillasConFichas;
		
		while(!end()) {
			Scanner sc = new Scanner(System.in);
			pressAnyKeyToContinue();
			resultadoDado = dado.tirarDado();
			if(resultadoDado == 5 && this.tablero.getFichasEnJuego() <= 4){
				this.tablero.addFichaAlJuego(jugador.getColor());
			}else{
				if(this.tablero.getFichasEnJuego()>0) {
					jugador.imprimirLocalizacionFichasJugador();
					listaCasillasConFichas = this.iterator.recorrer(jugador.getColor());
					int eleccion = this.jugador.eleccion();
					//this.tablero.moverFicha(listaCasillasConFichas.get(0).getFichas().get(0), listaCasillasConFichas.get(0).getPosicionActual(), resultadoDado);
					this.tablero.moverFicha(listaCasillasConFichas.get(eleccion-1).getFichas().get(0), listaCasillasConFichas.get(eleccion-1), resultadoDado);
					
				}
				
				//this.tablero.moverFicha(listaFichasJugador.get(jugador.eleccion()-1).getPosicionActual(), jugador.getColor(), resultadoDado);
				
			}
		}
	}
	
	/**
	 * Función que comprueba si el jugador ha ganado
	 * 
	 */
	
	public boolean end() {
		
		if(this.tablero.getPasillo().get(7).getFichas().size() == 4) {
			System.out.println();
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Funcion auxiliar para esperar hasta que el jugador pulse ENTER.
	 * 
	 */
	private void pressAnyKeyToContinue()
	 { 
	        System.out.println("Pulsa ENTER para tirar el dado.\n");
	        try
	        {
	            System.in.read();
	        }  
	        catch(Exception e)
	        {}  
	 }
}
