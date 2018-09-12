package misc;

import mapa.celda;

public abstract class nave extends Unidad{

	public nave(celda ce) {
		super(ce);
	}
	public abstract void disparar();
}
