package Parchis;

public class Ficha {
	private Color color;
	//Constructor de Ficha que recibe el color de la misma por parámetro.
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