package Parchis;

import java.util.Date;
import java.util.Random;


	public class Dado {
		private static Dado _instanciaDado = null;
		
		private Dado() {
			
		}
		
		public static Dado crearDado() {
			if(_instanciaDado == null) {
				_instanciaDado = new Dado();
			}
			return _instanciaDado;
		}
		public int tirarDado() {
			Random dado = new Random();
			dado.setSeed(new Date().getTime());
			return dado.nextInt(6)+1;
		}
	}

