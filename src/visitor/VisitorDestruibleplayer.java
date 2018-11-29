package visitor;

import disparo.DisparoE;
import disparo.DisparoP;
import nave.enemigos.Buscador;
import nave.enemigos.EnemigoAbstract;
import visitor.Visitor;
import nave.player.Jugador;
import powerup.PowerUp;
import obstaculos.*;

public class VisitorDestruibleplayer extends Visitor {

	public VisitorDestruibleplayer(ParedPlayer paredPlayer) {
		objeto=paredPlayer;
	}

	@Override
	public boolean VisitDestruible(ParedTodos r) {
		
		return false;
	}

	@Override
	public boolean VisitDestruiblePlayer(ParedPlayer w) {
		
		return false;
	}

	@Override
	public boolean visitenemigo(EnemigoAbstract p) {
		
		return true;
	}

	@Override
	public boolean visitPlayer(Jugador j) {
		
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
		
		return true;
	}

	@Override
	public boolean visitMejorado(Jugador j) {
		
		return false;
	}

	@Override
	public boolean visitBuscador(Buscador e) {
		
		return true;
	}

}
