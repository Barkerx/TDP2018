package arma;

import Player.jugador;
import disparo.Basico;
import disparo.DisparoP;

public class basico extends arma{

	public basico(jugador j) {
		super(j);
		// TODO Auto-generated constructor stub
	}

	@Override
	public arma levelUP() {
		return new lazer(j);
		
	}

	@Override
	public DisparoP getDisparo() {
		return new Basico(j.getcelda(),j.getmap(),j);
	}
	
}
