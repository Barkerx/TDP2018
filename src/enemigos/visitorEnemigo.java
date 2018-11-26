package enemigos;

import Player.Mejorado;
import Player.jugador;
import PowerUP.powerUp;
import disparo.DisparoE;
import disparo.DisparoP;
import misc.Gob;
import misc.Visitor;
import obstaculos.ParedPlayer;
import obstaculos.ParedTodos;

public class visitorEnemigo extends Visitor {

	public visitorEnemigo(Gob o) {
		objeto=o;
	}

	@Override
	public boolean VisitDestruible(ParedTodos r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean VisitDestruiblePlayer(ParedPlayer w) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean visitenemigo(enemigoAbstract p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitPlayer(jugador j) {
		if(areRunning(j)){
		objeto.destruir();
		j.reducirVida(50);
		}
		return false;
	}

	@Override
	public boolean visitDisparoPlayer(DisparoP d) {
		if(areRunning(d)){
			int t=d.getdamage();
			d.destruir();
			objeto.reducirVida(t);}
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

	@Override
	public boolean visitMejorado(jugador j) {
		if(areRunning(j)){
			objeto.destruir();
			j.reducirVida(50);
			}
			return false;
	}

	@Override
	public boolean visitBuscador(Buscador e) {
		// TODO Auto-generated method stub
		return false;
	}

}
