package obstaculos;

import mapa.*;
import misc.*;

public abstract class obstaculo extends Gob{

	public obstaculo(celda c,Map m){
		this.c=c;
		this.m=m;
		profundidad=0;
	}
	
	public void destruir(){
		//c.explotar();
		super.destruir();
	}
	
	
}
