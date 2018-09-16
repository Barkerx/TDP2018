package obstaculos;

import mapa.*;
import misc.*;

public abstract class obstaculo extends Gob{

	public obstaculo(celda ce,Map m){
		super(ce,m);
		profundidad=0;
	}
	
	
}
