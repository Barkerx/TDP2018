package enemigos;

import Player.jugador;
import PowerUP.powerUp;
import disparo.DisparoE;
import disparo.DisparoP;
import misc.Visitor;
import obstaculos.ParedPlayer;
import obstaculos.ParedTodos;

public class visitorEnemigo extends Visitor {

	public visitorEnemigo(enemigoAbstract enemigo) {
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
	public boolean visitenemigo(enemigoAbstract p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitPlayer(jugador j) {
		if(j.getIsRunning()&&objeto.getIsRunning()){
		j.reducirVida(50);
		objeto.destruir();
		}
		return false;
	}

	@Override
	public boolean visitDisparoPlayer(DisparoP d) {
		if(objeto.getIsRunning()&&d.getIsRunning()){
		objeto.reducirVida(d.getdamage());
		d.destruir();}
		return true;
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
