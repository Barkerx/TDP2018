package disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Map;
import mapa.celda;
import misc.*;

public abstract class Disparo extends Unidad{
	
	protected int damage;

	
	public int getdamage(){
		return damage;
	}
	
	public abstract void mover();
	
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
