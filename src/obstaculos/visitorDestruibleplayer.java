package obstaculos;

import Player.jugador;
import PowerUP.powerUp;
import disparo.DisparoE;
import disparo.DisparoP;
import enemigos.enemigo;
import misc.Visitor;

public class visitorDestruibleplayer extends Visitor {

	public visitorDestruibleplayer(ParedPlayer paredPlayer) {
		objeto=paredPlayer;
	}

	@Override
	public boolean VisitDestruible(ParedTodos r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean VisitDestruiblePlayer(ParedPlayer w) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitenemigo(enemigo p) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean visitPlayer(jugador j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitDisparoPlayer(DisparoP d) {
		objeto.reducirVida(d.getdamage());
		d.destruir();
		return false;
	}

	@Override
	public boolean visitDisparoEnemigo(DisparoE d) {
		return true;
	}

	@Override
	public boolean visitPowerUp(powerUp pw) {
		// TODO Auto-generated method stub
		return true;
	}

}
