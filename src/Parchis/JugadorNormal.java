package Parchis;

import java.util.Scanner;

public class JugadorNormal implements ITipoJugador{
    public String ObtenerDescripcion()
    {
        return "Jugador Normal";
    }
    
    public int eleccion(Color color, int fichasEnJuego) {
    	return Vista.eleccionFicha(color,fichasEnJuego);
    }
}
