package arma;

import Player.jugador;
import disparo.DisparoP;
import disparo.Laser;

public class lazer extends arma{

	public lazer(jugador j) {
		super(j);
		// TODO Auto-generated constructor stub
	}

	@Override
	public arma levelUP() {
		// TODO Auto-generated method stub
		return new misil(j);
	}

	@Override
	public DisparoP getDisparo() {
		return new Laser(j.getcelda(),j.getmap(),j);
	}

}
