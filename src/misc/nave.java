package misc;

import mapa.*;

public abstract class nave extends Unidad{

	public nave(celda ce,Map m) {
		super(ce,m);
		profundidad =1;
	}
	public abstract void disparar();
}
