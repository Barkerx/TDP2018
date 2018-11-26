package obstaculos;

import disparo.DisparoE;
import disparo.DisparoP;
import enemigos.Buscador;
import enemigos.EnemigoAbstract;
import misc.Visitor;
import player.Mejorado;
import powerUP.PowerUp;
import player.Jugador;

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
	public boolean visitenemigo(EnemigoAbstract p) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean visitPlayer(Jugador j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitDisparoPlayer(DisparoP d) {
		if(areRunning(d)){
		int t=d.getdamage();
		d.destruir();
		objeto.reducirVida(t);}
		return false;
	}

	@Override
	public boolean visitDisparoEnemigo(DisparoE d) {
		return true;
	}

	@Override
	public boolean visitPowerUp(PowerUp pw) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean visitMejorado(Jugador j) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean visitBuscador(Buscador e) {
		// TODO Auto-generated method stub
		return true;
	}

}
