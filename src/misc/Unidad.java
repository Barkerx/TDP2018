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
	
/**
 * metodo usado para mover una unidad a partir de una direccion( en el caso que se pueda)	
 * @param n la direccion a la cual moverse
 * @return la celda a donde se movera(si no se puede mover retorna null)(usado para metodos que lo redefinen)
 */
	public celda mover(int n){
		celda w=m.mover(c,n);
		if(w!=null)
			intercambiarceldas(w);

		return w;
	}
	/**
	 * realiza la colision en el caso que hallan haciendo el accept aca objeto existente en la celda y tambien el intercambio de celdas.
	 * @param d celda a la cual nos deseamos mover
	 */
	private void intercambiarceldas(celda d){
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
