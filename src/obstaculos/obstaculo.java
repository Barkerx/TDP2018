package obstaculos;

import mapa.*;
import misc.*;

public abstract class obstaculo extends Gob{

	public obstaculo(celda c,Map m){
		this.c=c;
		this.m=m;
		profundidad=0; 
		x=c.getposx();
		y=c.getposy();
		vida=100;      
		c.setelem(profundidad, this);
	}
	
	public void destruir(){
		if(isRunning){ 	
		explotar();
		super.destruir();
		}
	}
	
	
}
