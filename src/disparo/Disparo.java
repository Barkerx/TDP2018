package disparo;


import mapa.Mapa;
import mapa.Celda;
import misc.*;

public abstract class Disparo extends Unidad{
	
	protected int damage;

	protected Disparo(Celda c, Mapa m) {
		this.c=c;
		this.m=m;
		shieldL=null;
		profundidad=2;
		moviendo=false;
	}
	/**
	 * metodo usado para retornar el da�o de un disparo
	 * @return retorna el da�o del disparo.
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
