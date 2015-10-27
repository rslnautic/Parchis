package Parchis;

public class FabricaFichasRoja implements FabricaAbstractaFichas{
	@Override
	public Ficha crearFicha() {
		Color c1 = Color.ROJO;
		Ficha f1 = new Ficha(c1);
		return f1;
	}

}
