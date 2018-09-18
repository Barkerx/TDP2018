package arma;

import Player.jugador;
import disparo.DisparoP;

public abstract class arma {
	protected jugador j;
	protected arma(jugador j){
		this.j=j;
	}
	
	public abstract arma levelUP();
	public abstract DisparoP getDisparo();
}
