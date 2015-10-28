package Parchis;
import java.io.*;
import java.util.*;

public class Parchis {
	private Tablero tablero;
	private Jugador jugador;
	private Dado dado;
	private Iterador iterator;
	private int resultadoDado;
	private int cantidadDe6;
	
	
	
	
	public Parchis() {
		tablero = Tablero.crearInstacia();
		dado = Dado.crearDado();
		this.iterator = new Iterador();
		//addJugador();
	}
	
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
		this.jugador = jaux;
		sc.close();
	}
	
	public void play() {
		ArrayList<Casilla> listaCasillasConFichas;
		this.jugador = new Jugador(Color.ROJO);
		
		while(!end()) {
			System.out.println("Tira el dado");
			//CIN PARA TIRAR DADO
			resultadoDado = dado.tirarDado();
			listaCasillasConFichas = this.iterator.recorrer(jugador.getColor());
			
			System.out.println("Has sacado:" + resultadoDado);
			System.out.println(this.tablero.getFichasEnJuego());
			if(resultadoDado == 5 && this.tablero.getFichasEnJuego() <= 4){
				this.tablero.addFicha(jugador.getColor());
			}else{
				System.out.println("Fichas en juego" + this.tablero.getFichasEnJuego());
				if(this.tablero.getFichasEnJuego()!=0) {
					int eleccion;
					jugador.imprimirLocalizacionFichasJugador();
					listaCasillasConFichas = this.iterator.recorrer(jugador.getColor());
					eleccion = this.jugador.eleccion();
					//this.tablero.moverFicha(listaCasillasConFichas.get(0).getFichas().get(0), 38, resultadoDado);
					
				}
				
				//this.tablero.moverFicha(listaFichasJugador.get(jugador.eleccion()-1).getPosicionActual(), jugador.getColor(), resultadoDado);
				
			}
		}
	}
	
	
	
	public boolean end() {
		
		if(this.tablero.getPasillo().get(7).getFichas().size() == 4) {
			return true;
		}else{
			return false;
		}
	}
	
	
}
