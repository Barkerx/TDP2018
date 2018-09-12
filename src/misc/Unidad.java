package misc;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.celda;

public abstract class Unidad extends Gob {

	
	public Unidad(celda ce){
		c=ce;
	}
	public void setCelda(celda c )
	{
		this.c=c;
		c.objlist()[profundidad]=this;
	}
	public celda mover(int n){
		celda w=c.mover(n);		
		return w;
	}
	public void intercambiarceldas(celda d,int n){
		d.setelem(profundidad, this);
		c.setelem(profundidad,null);
		c=d;
	}
	
}
