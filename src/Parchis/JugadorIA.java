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
		return Vista.eleccionFichaIA(color, fichasEnJuego);
	}
}
