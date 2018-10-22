package disparo;


import mapa.Map;
import mapa.celda;
import misc.*;

public abstract class Disparo extends Unidad{
	
	protected int damage;

	protected Disparo(celda c, Map m) {
		this.c=c;
		this.m=m;
		shieldL=null;
		profundidad=2;
		moviendo=false;
	}
	/**
	 * metodo usado para retornar el daño de un disparo
	 * @return retorna el daño del disparo.
	 */
	public int getdamage(){
		return damage;
	}
	/**
	 * metodo que redefine el mover de unidad
	 */
	public abstract void mover();
	/**
	 * metodo que se va a ejecutar al crear un disparo.
	 */
	public int getvelocidad() {
		// TODO Auto-generated method stub
		return velocidad;
	}
	
	public void destruir(){
		//m.killDisparo(this);
		super.destruir();
	}
}
