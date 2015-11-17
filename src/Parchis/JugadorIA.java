package Parchis;

import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class JugadorIA implements ITipoJugador{
	
	
	public String ObtenerDescripcion()
    {
        return "Jugador IA";
    }
	
	public int eleccion(Color color, int fichasEnJuego) {
		//Empieza aquí
		Random rand = new Random();
		rand.setSeed(new Date().getTime());
		int rNumber = rand.nextInt(fichasEnJuego)+1;
		System.out.println("IA-"+color+"- muevo la ficha numero: " + rNumber);
		return rNumber;
	}
}
