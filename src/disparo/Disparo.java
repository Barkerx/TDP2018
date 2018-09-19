package disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Map;
import mapa.celda;
import misc.*;

public abstract class Disparo extends Unidad{
	
	protected int damage;
	/**
	 * metodo usado para retornar el daño de un disparo
	 * @return retorna el daño del disparo.
	 */
	public int getdamage(){
		return damage;
	}
	/**
	 * metodo que redefine el mover de unidad
	 */
	public abstract void mover();
	/**
	 * metodo que se va a ejecutar al crear un disparo.
	 */
	public void run(){
		while(isRunning){
			mover();
			try{
				  Thread.sleep(velocidad);
			  }catch(InterruptedException e){
				  
			  }
			
		}
	}
}
