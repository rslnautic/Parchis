package Parchis;

public class Ficha {
	private Color color;
	
	public Ficha(Color c1){
		this.color = c1;
	}
	
	public Color getColor() {
		return color;
	}
}

enum Color{
	AMARILLO,
	ROJO,
	VERDE,
	AZUL
}