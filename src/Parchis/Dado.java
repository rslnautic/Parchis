package Parchis;
import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Eduardo Terradez, Ramón Serrano y César Gil
 * @version 16/11/2015 v2
 * @see <a href = "https://github.com/rslnautic/Parchis"
 */


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
		
/**
* Metodo para obtener un numero aleatorio 
* @return devuelve un numero aleatorio entre 1 y 6
*/			
public int tirarDado() {
	int n = random.nextInt(6)+1;
	System.out.println("Has sacado:" + n);
	return n;
	}
}

