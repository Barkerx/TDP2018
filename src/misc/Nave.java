package misc;

import mapa.Celda;

public abstract class Nave extends Unidad{
	/**
	 * metodo usado para disparar
	 */
	public abstract void disparar();
	
	public Celda getcelda() {
		
		return c;
	}
	
}
