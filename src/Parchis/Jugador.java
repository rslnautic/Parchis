package Parchis;

public class Jugador {
	private int posicionFicha1;
	private int posicionFicha2;
	private int posicionFicha3;
	private int posicionFicha4;
	private Color color;
	
	
	public Jugador(Color c1){
		this.color = c1;
	}

	public Color getColor() {
		return color;
	}

	public int getPosicionFicha1() {
		return posicionFicha1;
	}

	public void setPosicionFicha1(int posicionFicha1) {
		this.posicionFicha1 = posicionFicha1;
	}

	public int getPosicionFicha2() {
		return posicionFicha2;
	}

	public void setPosicionFicha2(int posicionFicha2) {
		this.posicionFicha2 = posicionFicha2;
	}

	public int getPosicionFicha3() {
		return posicionFicha3;
	}

	public void setPosicionFicha3(int posicionFicha3) {
		this.posicionFicha3 = posicionFicha3;
	}

	public int getPosicionFicha4() {
		return posicionFicha4;
	}

	public void setPosicionFicha4(int posicionFicha4) {
		this.posicionFicha4 = posicionFicha4;
	}
	
	
}
