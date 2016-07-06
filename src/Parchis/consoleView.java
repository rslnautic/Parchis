package Parchis;

import java.util.ArrayList;
import java.util.Scanner;

public class consoleView implements Vista{

	@Override
	public void welcolme() {
		// TODO Auto-generated method stub
		System.out.println("Bienvenido al jeugo del parchis!!!");
	}

	@Override
	public int askNumeroJugadores() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int nJugadores = -1;
		while(nJugadores < 1 || nJugadores > 4){
			System.out.println("¿Cuantos jugadores quereis en la partida? (Debe ser un numero entre 1 y 4)");
			nJugadores = sc.nextInt();
		}
		return nJugadores;
	}

	@Override
	public int askColor(int numJugador, ArrayList<Color> colores) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("El jugador-" + numJugador );
        System.out.println("¿Con que color jugara?");
        int n = 1;
        for(Color color: colores) {
            System.out.println(n+"-"+color.toString());
            n++;
        }
        int opcion = sc.nextInt();
		return opcion;
	}

	@Override
	public int askTipoJugador() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Sera un jugador humano o una IA?");
        System.out.println("1.Humano\n2.Ia\n");
        int opcion = sc.nextInt();
		return opcion;
	}

	@Override
	public void pressAnyKeyToContinue() {
		// TODO Auto-generated method stub
		System.out.println("Pulsa ENTER para tirar el dado.\n");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}  
	}

	@Override
	public void turnoJugador(Jugador jugadorActual) {
		// TODO Auto-generated method stub
		System.out.println("Turno jugador "+ jugadorActual.tipoJ.toString()+"-"+jugadorActual.color.toString());
	}

}
