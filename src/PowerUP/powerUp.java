package PowerUP;

import Player.jugador;
import mapa.Mapa;
import mapa.celda;
import misc.Unidad;
import misc.Visitor;

public abstract class powerUp extends Unidad{
	protected int puntos;
	/**
	 * constructor de powerUp
	 * @param ce celda donde se encuntra el powerUP
	 * @param m Mapa donde se encuentra el PowerUP
	 */
	
	public powerUp(celda ce, Mapa m) {
		c=ce;
		this.m=m;
		shieldL=null;
		visitor=new visitorPowerUp(this);
		profundidad=3;
		x=c.getposx();
		y=c.getposy();
	}
	
	public boolean Accept(Visitor V){
		return V.visitPowerUp(this);
	}
	/**
	 * metodo usado para afectar al jugador dependiendo del powerUP que sea. 
	 * @param j
	 */
	public abstract void accionar(jugador j);
	
	public void mover(){
		if(isRunning){
		//	while(isRunning){
			celda d=c;
			celda ce=super.mover(ABAJO);
				if (ce==d)
				{	
					destruir();
				}
		//	}	
		}
	}

}
