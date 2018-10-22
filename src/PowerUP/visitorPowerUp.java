package PowerUP;

import Player.jugador;
import disparo.DisparoE;
import disparo.DisparoP;
import enemigos.enemigoAbstract;
import misc.Visitor;
import obstaculos.ParedPlayer;
import obstaculos.ParedTodos;

public class visitorPowerUp extends Visitor {
;
	public visitorPowerUp(powerUp o) {
		objeto=o;
	}

	@Override
	public boolean VisitDestruible(ParedTodos r) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean VisitDestruiblePlayer(ParedPlayer w) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean visitenemigo(enemigoAbstract p) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean visitPlayer(jugador j) {
		powerUp p=(powerUp)objeto;
		objeto.destruir();
		p.accionar(j);
		return true;
	}

	@Override
	public boolean visitDisparoPlayer(DisparoP d) {
		powerUp p=(powerUp) objeto;
		jugador j=d.get();  
		d.destruir(); 
		objeto.destruir();
		p.accionar(j);
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
		return false;
	}

}
