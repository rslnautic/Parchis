package Parchis;

import java.util.Date;
import java.util.Random;


	public class Dado {
		private static Dado _instanciaDado = null;
		Random random;
		
		private Dado() {
			random = new Random();
			random.setSeed(new Date().getTime());
		}
		
		public static Dado crearDado() {
			if(_instanciaDado == null) {
				_instanciaDado = new Dado();
			}
			return _instanciaDado;
		}
		public int tirarDado() {
			int n = random.nextInt(6)+1;
			System.out.println("Has sacado:" + n);
			return n;
		}
	}

