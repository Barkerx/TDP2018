package misc;


import mapa.Map;
import mapa.celda;

public abstract class Unidad extends Gob implements Runnable{

	public static final int ARRIBA = 4;
	public static final int ABAJO = 0;
	public static final int IZQUIERDA = 2;
	public static final int DERECHA = 6;
	protected int velocidad;
	protected int puntos;
	
	
	public celda mover(int n){
		celda w=m.mover(c,n);
		if(w!=null)
			intercambiarceldas(w,n);

		System.out.println(visitor);
		return w;
	}
	private void intercambiarceldas(celda d,int n){
		boolean b=true;
		for(int i=0;i<4&&b&&isRunning;i++){
			if( d.objlist()[i]!=null){
				if (!d.objlist()[i].Accept(visitor))
					b=false;
				}
		}
		
		if(b){
		d.setelem(profundidad,this);
		c.setelem(profundidad,null);
		c=d;
		initgraph();
		}
	}
	
	
}
