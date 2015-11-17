package Parchis;

import java.util.Scanner;

public class JugadorNormal implements ITipoJugador{
    public String ObtenerDescripcion()
    {
        return "Jugador Normal";
    }
    
    public int eleccion(Color color, int fichasEnJuego) {
    	System.out.println("¿Cual quieres mover?");
		Scanner scc = new Scanner(System.in);
		int i = scc.nextInt(); 
		if(i<=fichasEnJuego) {
			System.out.println("Jugador-"+color+"- muevo la ficha numero: "+i);
			return i;
		} else {
			return 0;
		}
    }
}
