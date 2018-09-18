package arma;

import Player.jugador;
import disparo.Basico;
import disparo.DisparoP;
import disparo.Misil;

public class misil extends arma{

	public misil(jugador j) {
		super(j);
	}

	@Override
	public arma levelUP() {
		// TODO Auto-generated method stub
		return new misil(j);
	}

	@Override
	public DisparoP getDisparo() {
		return new Misil(j.getcelda(),j.getmap(),j);
	}

}
