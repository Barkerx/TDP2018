package arma;

import Player.jugador;
import disparo.DisparoP;

public abstract class arma {
	protected jugador j;
	/**
	 * constructor de arma
	 * @param j jugador al que va a estar asociado
	 */
	protected arma(jugador j){
		this.j=j;
	}
	/**
	 * Metodo usado para cambiar el arma por la siguiente
	 * @return Retorna el arma siguiente a la actual
	 */
	public abstract arma levelUP();
	/**
	 * Obtiene el disparo asociado al arma
	 * @return el disparo asociado al arma
	 */
	public abstract DisparoP getDisparo();
}
