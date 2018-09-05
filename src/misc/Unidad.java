package misc;

import mapa.celda;

public class Unidad extends Gob {

	
	public Unidad(celda ce){
		c=ce;
	}
	public void setCelda(celda c )
	{
		this.c=c;
		c.objlist()[profundidad]=this;
		System.out.println("coordenadas de x");
		System.out.println(c.getposx());
		System.out.println("coordenadas de y");
		System.out.println(c.getposy());
	}
	public void mover(int n){
		celda w=c.mover(n);
		System.out.println("coordenadas de x en moover");
		System.out.println(c.getposx());
		System.out.println("coordenadas de y en mover");
		System.out.println(c.getposy());
		if(!w.equals(c))
			intercambiarceldas(w,n);
	}
	private void intercambiarceldas(celda d,int n){
		d.setelem(profundidad, this);
		c.setelem(profundidad,null);
		c=d;
		System.out.println("coordenadas de x en intercambiar");
		System.out.println(c.getposx());
		System.out.println("coordenadas de y en intercambiar");
		System.out.println(c.getposy());
	}
	
	
}
