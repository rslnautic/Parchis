package Parchis;

public class Ficha {
	private Color color;
	private int numero;
	
	public Ficha(Color c1, int n){
		this.color = c1;
		this.numero = n;
	}
	
	
	
	public Color getColor() {
		return color;
	}



	public enum Color{
		AMARILLO,
		ROJO,
		VERDE,
		AZUL
	}
}
