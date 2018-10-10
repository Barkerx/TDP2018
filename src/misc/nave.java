package misc;

import mapa.celda;

public abstract class nave extends Unidad{
	public static final int DISPARAR = -1;
	/**
	 * metodo usado para disparar
	 */
	public abstract void disparar();
	
	public celda getcelda() {
		// TODO Auto-generated method stub
		return c;
	}
	
}
