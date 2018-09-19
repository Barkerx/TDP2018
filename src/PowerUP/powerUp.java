package PowerUP;

import Player.jugador;
import mapa.Map;
import mapa.celda;
import misc.Unidad;
import misc.Visitor;

public abstract class powerUp extends Unidad{
	/**
	 * constructor de powerUp
	 * @param ce celda donde se encuntra el powerUP
	 * @param m Mapa donde se encuentra el PowerUP
	 */
	public powerUp(celda ce, Map m) {
		c=ce;
		this.m=m;
		visitor=new visitorPowerUp(this);
		profundidad=3;
	}
	
	public boolean Accept(Visitor V){
		return V.visitPowerUp(this);
	}
	/**
	 * metodo usado para afectar al jugador dependiendo del powerUP que sea. 
	 * @param j
	 */
	public abstract void accionar(jugador j);
	
	public void run(){
		
	}

}
