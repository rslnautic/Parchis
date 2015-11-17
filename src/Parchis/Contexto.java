package Parchis;

public class Contexto {
	private ITipoJugador tipoJugador;
	
	public ITipoJugador getTipoJugador() {
		return tipoJugador;
	}

	public void setTipoJugador(ITipoJugador tipoJugador) {
		this.tipoJugador = tipoJugador;
	}

	public String ObtenerDescripcion()
    {
        return tipoJugador.ObtenerDescripcion();
    }
}
