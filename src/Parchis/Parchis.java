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
		addJugador();
	}
	
	public void addJugador(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenido al Parchis de tu vieja\n¿Con que color quieres jugar?\n");
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
	
	public void inicio(){
		
	}
	
	
	
	
	public void play() {
		
		while(!end())
			System.out.println("Tira el dado");
			//CIN PARA TIRAR DADO
			resultadoDado = dado.tirarDado();
			
			System.out.println("Has sacado:" + resultadoDado);
			if(resultadoDado == 5 && this.iterator.recorrer(jugador.getColor()).size() <= 4){
				this.tablero.addFicha(jugador.getColor());
				
				
			}else{
				jugador.imprimirLocalizacionFichasJugador();
				ArrayList<Casilla> listaFichasJugador = this.iterator.recorrer(jugador.getColor());
				
				//this.tablero.moverFicha(listaFichasJugador.get(jugador.eleccion()-1).getPosicionActual(), jugador.getColor(), resultadoDado);
				this.tablero.moverFicha(listaFichasJugador.get(jugador.eleccion()-1).getFichas().get(0), listaFichasJugador.get(jugador.eleccion()-1).getPosicionActual(), resultadoDado);
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
