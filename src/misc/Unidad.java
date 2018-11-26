package misc;

import javax.swing.JLabel;

import mapa.Celda;

public abstract class Unidad extends Gob {

	public static final int ARRIBA = 4;
	public static final int ABAJO = 0;
	public static final int IZQUIERDA = 2;
	public static final int DERECHA = 6;
	public static final int ABAJOIZQUIERDA = 1;
	public static final int ABAJODERECHA = 3;
	protected int velocidad;
	protected int puntos;
	protected boolean moviendo;
	protected int dir;
	protected JLabel shieldL;
/**
 * metodo usado para mover una unidad a partir de una direccion( en el caso que se pueda)	
 * @param n la direccion a la cual moverse
 * @return la celda a d onde se movera(si no se puede mover retorna null y no hace el cambio de celdas)(usado para metodos que lo redefinen)
 */
	public Celda mover(int n){
		Celda w=c;	
		if(!moviendo){
			w=m.mover(c,n);
		if(w!=c)
			intercambiarceldas(w,n);
		}
		
		return w;
	}
	/**
	 * realiza la colision en el caso que hallan haciendo el accept aca objeto existente en la celda y tambien el intercambio de celdas.
	 * @param d celda a la cual nos deseamos mover
	 */
	private void intercambiarceldas(Celda d,int n){	
		//Si la variable Boolean b es verdadera al salir del loop, quiere decir que recorri todas los objetos que tenia la celda
		//y el visitor de cada uno de ellos devuelve true al visitarlo
		boolean b=true;
		for(int i=0;i<4&&b&&isRunning;i++){
			if( d.objlist()[i]!=null && !d.objlist()[i].Accept(visitor))
					b=false;
		}
		//si aun existo y b es verdadera hago el cambio de celda tanto logico como grafico.
		if(b&&isRunning){	
		moviendo=true;
		dir=n;
		d.setelem(profundidad,this);
		c.setelem(profundidad,null);
		c=d;
		x=d.getposx();
		y=d.getposy();
		movergrafico();
		moviendo=false;
		}

	}
	
	private void movergrafico() {
		m.movegraph(this);
		
	}
	/**
	 * metodo usado cuando se hace un movimiento( ES EL MOVIMIENTO SUAVE ESTO)
	 */
	public void run(){
		for(int i=0;i<9&&isRunning;i++){
			
			  switch(dir){
			  case ABAJO:
				  grafico.setBounds(grafico.getX(), grafico.getY()+5, 45, 45);
				  if(shieldL!=null)
					  shieldL.setBounds(grafico.getX(), grafico.getY()+5, 45, 45);
				  break;
			  case IZQUIERDA:
				  grafico.setBounds(grafico.getX()-5, grafico.getY(), 45, 45);
				  if(shieldL!=null)
					  shieldL.setBounds(grafico.getX()-5, grafico.getY(), 45, 45);
				  break;
			  case ARRIBA:
				  grafico.setBounds(grafico.getX(), grafico.getY()-5, 45, 45);
				  if(shieldL!=null)
					  shieldL.setBounds(grafico.getX(), grafico.getY()-5, 45, 45);
				  break;
			  case DERECHA:
				  grafico.setBounds(grafico.getX()+5, grafico.getY(), 45, 45);
				  if(shieldL!=null)
					  shieldL.setBounds(grafico.getX()+5, grafico.getY(), 45, 45);
				  break;
			  case ABAJOIZQUIERDA:
				  grafico.setBounds(grafico.getX()-5, grafico.getY()+5, 45, 45);
				  if(shieldL!=null)
					  shieldL.setBounds(grafico.getX()-5, grafico.getY()+5, 45, 45);
				  break;
			  case ABAJODERECHA:
				  grafico.setBounds(grafico.getX()+5, grafico.getY()+5, 45, 45);
				  if(shieldL!=null)
					  shieldL.setBounds(grafico.getX()+5, grafico.getY()+5, 45, 45);
				  break;	  
			  default:break;
			  }
			  try{
				  Unidad.sleep(50-velocidad);
			  }catch(InterruptedException e){
				  
			  }
		  }
	this.interrupt();
	}
	 
	
}
  