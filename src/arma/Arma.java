package arma;

import player.Jugador;

public abstract class Arma {
	protected Jugador j;
	protected int disparos;
	protected int maxDisparos;
	/**
	 * constructor de arma
	 * @param j jugador al que va a estar asociado
	 */
	protected Arma(Jugador j){
		this.j=j;
	}
	/**
	 * Metodo usado para cambiar el arma por la siguiente
	 * @return Retorna el arma siguiente a la actual
	 */
	public abstract Arma levelUP();
	/**
	 * Obtiene el disparo asociado al arma
	 * @return el disparo asociado al arma
	 */
	
	public abstract void getDisparo();

	public void aumentarDisparos(){
		if(disparos<maxDisparos)
			disparos++;
	}
}
