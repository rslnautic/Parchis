package Parchis;

public class FabricaFichasAmarilla implements FabricaAbstractaFichas{

	@Override
	public Ficha crearFicha() {
		Color c1 = Color.AMARILLO;
		Ficha f1 = new Ficha(c1);
		return f1;
	}
}
