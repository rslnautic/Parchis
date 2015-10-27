package Parchis;

public class FabricaFichasVerde implements FabricaAbstractaFichas{
	@Override
	public Ficha crearFicha() {
		Color c1 = Color.VERDE;
		Ficha f1 = new Ficha(c1);
		return f1;
	}
}

