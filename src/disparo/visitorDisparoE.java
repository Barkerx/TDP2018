package disparo;

import Player.jugador;
import PowerUP.powerUp;
import enemigos.enemigo;
import misc.Gob;
import misc.Visitor;
import obstaculos.ParedPlayer;
import obstaculos.ParedTodos;

public class visitorDisparoE extends Visitor{
	
	public visitorDisparoE(Gob o){
		objeto=o;
	}

	@Override
	public boolean VisitDestruible(ParedTodos r) {
		DisparoE aux=(DisparoE) objeto;
		r.reducirVida(aux.getdamage());
		objeto.destruir();
		return false;
	}

	@Override
	public boolean VisitDestruiblePlayer(ParedPlayer w) {
		objeto.destruir();
		return false;
	}

	@Override
	public boolean visitenemigo(enemigo p) {
		return true;
	}

	@Override
	public boolean visitDisparoPlayer(DisparoP d) {
		d.destruir();
		objeto.destruir();
		return false;
	}

	@Override
	public boolean visitDisparoEnemigo(DisparoE d) {
		d.destruir();
		objeto.destruir();
		return true;
	}

	@Override
	public boolean visitPowerUp(powerUp pw) {
		return true;
	}

	@Override
	public boolean visitPlayer(jugador j) {
		DisparoE aux=(DisparoE) objeto;
		j.reducirVida(aux.getdamage());
		objeto.destruir();
		return false;
	}

}
