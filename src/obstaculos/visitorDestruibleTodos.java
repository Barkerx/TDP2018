package obstaculos;

import Player.jugador;
import PowerUP.powerUp;
import disparo.DisparoE;
import disparo.DisparoP;
import enemigos.enemigoAbstract;
import misc.Visitor;

public class visitorDestruibleTodos extends Visitor {

	public visitorDestruibleTodos(ParedTodos paredTodos) {
		objeto=paredTodos;
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
	public boolean visitenemigo(enemigoAbstract p) {
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
		if(d.getIsRunning()&&objeto.getIsRunning()){
			int t=d.getdamage();
			d.destruir();
			objeto.reducirVida(t);}
			return false;
	}

	@Override
	public boolean visitDisparoEnemigo(DisparoE d) {
		if(d.getIsRunning()&&objeto.getIsRunning()){
			int t=d.getdamage();
			d.destruir();
			objeto.reducirVida(t);}
			return false;
		}

	@Override
	public boolean visitPowerUp(powerUp pw) {
		// TODO Auto-generated method stub
		return true;
	}

}
