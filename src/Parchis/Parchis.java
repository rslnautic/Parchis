package Parchis;
import javax.sound.midi.SysexMessage;
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
    private int nJugadores;
	private Jugador jugadorActual;
    private ArrayList<Jugador> jugadores;
	private Dado dado;
	private Iterador iterator;
	private int resultadoDado;
	private int cantidadDe6;
	private Vista vista;
	
	/**
	 * Constructor por defecto de la clase parchis.
	 * @param ninguno 
	 */
	
	public Parchis() {
		tablero = Tablero.crearInstacia();
		dado = Dado.crearDado();
		this.iterator = new Iterador();
        this.jugadores = new ArrayList();
        this.vista = new consoleView();
	}// Cierre del constructor
	
	
	/**
	 * Metodo para a�adir jugadores a la partida
	 * El método pide por consola el color que cada jugador quiera.
	 * @param ninguno 
	 */
    public void addJugadores() {
    	vista.welcolme();
        Scanner sc = new Scanner(System.in);
        nJugadores = vista.askNumeroJugadores();
        ArrayList<Color> colores = new ArrayList<Color>(Arrays.asList(Color.values()));
        for(int i = 0; i < nJugadores; i++) {
            Jugador jugadorAux = null;
            int j = i+1;
            
            int opcion = vista.askColor(j, colores);
            int n = 1;
            for(Color color: colores) {
                if(n==opcion) {
                    jugadorAux = new Jugador(color);
                    colores.remove(color);
                    break;
                }
                n++;
            }
            
            opcion = vista.askTipoJugador();
            if(opcion == 1) {
                jugadorAux.JugadorNormal();
            } else if (opcion == 2) {
                jugadorAux.JugadorIA();
            }
            jugadores.add(jugadorAux);
        }
    }
	/**
	 * Bucle principal del juego en el cual se suceden las tiradas del dado y se piden 
	 * por consola las decisiones que el jugador puede tomar.
	 * 
	 */
	
	public void play() {
		ArrayList<Casilla> listaCasillasConFichas;
		
		while(!end()) {
            for(Jugador jugador: jugadores) {
                jugadorActual = jugador;
                vista.turnoJugador(jugadorActual);
                if(jugador.tipoJ.toString() == "Normal") {
                    Scanner sc = new Scanner(System.in);
                    vista.pressAnyKeyToContinue();
                    resultadoDado = dado.tirarDado();

                    if(resultadoDado == 5 && this.tablero.getFichasEnJuego() <= 4){
                        this.tablero.addFichaAlJuego(jugadorActual.getColor());
                    }else{
                        listaCasillasConFichas = this.iterator.recorrer(jugadorActual.getColor());
                    if(listaCasillasConFichas.size() > 0) {
                            jugadorActual.imprimirLocalizacionFichasJugador();

                            int eleccion = this.jugadorActual.eleccion();
                            this.tablero.moverFicha(listaCasillasConFichas.get(eleccion-1).getFichas().get(0), listaCasillasConFichas.get(eleccion-1), resultadoDado);

                        }

                        //this.tablero.moverFicha(listaFichasJugador.get(jugador.eleccion()-1).getPosicionActual(), jugador.getColor(), resultadoDado);

                    }
                }
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
}


