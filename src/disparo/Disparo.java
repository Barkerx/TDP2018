package disparo;


import misc.*;

public abstract class Disparo extends Unidad{
	
	protected int damage;

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
	
}
