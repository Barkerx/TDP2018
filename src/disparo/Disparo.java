package disparo;

import mapa.Map;
import mapa.celda;
import misc.*;

public abstract class Disparo extends Unidad{
	
	protected int damage;
	public Disparo(celda ce, Map m) {
		super(ce, m);
		profundidad=2;
		
	}
	
	public int getdamage(){
		return damage;
	}
}
