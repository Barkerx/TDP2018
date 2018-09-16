package enemigos;

import Player.jugador;
import PowerUP.powerUp;
import disparo.DisparoE;
import disparo.DisparoP;
import misc.Visitor;
import obstaculos.ParedPlayer;
import obstaculos.ParedTodos;

public class visitorEnemigo extends Visitor {

	public visitorEnemigo(enemigo enemigo) {
		objeto=enemigo;
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
		return false;
	}

	@Override
	public boolean visitPlayer(jugador j) {
		j.reducirVida(50);
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
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean visitPowerUp(powerUp pw) {
		// TODO Auto-generated method stub
		return true;
	}

}
