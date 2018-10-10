package obstaculos;

import mapa.*;
import misc.*;

public abstract class obstaculo extends Gob{

	public obstaculo(celda c,Map m){
		this.c=c;
		this.m=m;
		profundidad=0;
		vida=100;      
		c.setelem(profundidad, this);
	}
	
	public void destruir(){
		explotar();
		super.destruir();
	}
	
	
}
