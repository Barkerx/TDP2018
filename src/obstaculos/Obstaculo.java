package obstaculos;

import javax.swing.ImageIcon;

import mapa.*;
import misc.*;

public abstract class Obstaculo extends Gob{

	public Obstaculo(Celda c,Mapa m){
		this.c=c;
		this.m=m;
		profundidad=0;
		isRunning=true;
		x=c.getposx();
		y=c.getposy();
		vida=100;      
		c.setelem(profundidad, this);
	}
	
	public void destruir(){
		if(isRunning){ 	
			explotar();
			}
	}
	public void explotar(){
		m.movegraph(this);
	}
	public void run(){
		if(isRunning){
		    c.setelem(profundidad,null);		
			grafico.setIcon(new ImageIcon(this.getClass().getResource("/resources/explotion.gif")));
			grafico.setBounds(x*45, y*45, 45, 45);
			m.addgraph(grafico);
			try {
				Obstaculo.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			grafico.setIcon(null);
			this.interrupt();
			super.destruir();
		}
	}

}
	

