package disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Map;
import mapa.celda;
import misc.*;

public abstract class Disparo extends Unidad{
	
	protected int damage;
	public Disparo(celda ce, Map m) {
		super(ce, m);
		profundidad=2;
		 grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/disparo.png")));
		 velocidad=50;
		 run();
		
	}
	
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
