package powerup;

import mapa.Mapa;
import mapa.Celda;
import misc.Unidad;
import misc.Visitor;
import player.Jugador;

public abstract class PowerUp extends Unidad{
	protected int puntos;
	/**
	 * constructor de powerUp
	 * @param ce celda donde se encuntra el powerUP
	 * @param m Mapa donde se encuentra el PowerUP
	 */
	
	public PowerUp(Celda ce, Mapa m) {
		c=ce;
		this.m=m;
		shieldL=null;
		visitor=new VisitorPowerUP(this);
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
	public abstract void accionar(Jugador j);
	
	public void mover(){
		if(isRunning){
			Celda d=c;
			Celda ce=super.mover(ABAJO);
				if (ce.equals(d))
				{	
					destruir();
				}	
		}
	}

}
