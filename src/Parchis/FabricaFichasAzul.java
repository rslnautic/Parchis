package Parchis;

public class FabricaFichasAzul implements FabricaAbstractaFichas{
	@Override
	public Ficha crearFicha() {
		Color c1 = Color.AZUL;
		Ficha f1 = new Ficha(c1);
		return f1;
	}
}
