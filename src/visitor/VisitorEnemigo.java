package visitor;

import disparo.DisparoE;
import disparo.DisparoP;
import gob.Gob;
import visitor.Visitor;
import obstaculos.ParedPlayer;
import obstaculos.ParedTodos;
import nave.enemigos.Buscador;
import nave.enemigos.EnemigoAbstract;
import nave.player.Jugador;
import powerup.PowerUp;

public class VisitorEnemigo extends Visitor {

	public VisitorEnemigo(Gob o) {
		objeto=o;
	}

	@Override
	public boolean VisitDestruible(ParedTodos r) {
		return false;
	}

	@Override
	public boolean VisitDestruiblePlayer(ParedPlayer w) {
		return true;
	}

	@Override
	public boolean visitenemigo(EnemigoAbstract p) {
		return false;
	}

	@Override
	public boolean visitPlayer(Jugador j) {
		if(areRunning(j)){
			EnemigoAbstract t=(EnemigoAbstract) objeto;
			j.reducirVida(t.getFuerza());
			t.destruir();
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
		return true;
	}

	@Override
	public boolean visitPowerUp(PowerUp pw) {
		return true;
	}

	@Override
	public boolean visitMejorado(Jugador j) {
		if(areRunning(j)){
			EnemigoAbstract t=(EnemigoAbstract) objeto;
			j.reducirVida(t.getFuerza());
			t.destruir();
		}
			return false;
	}

	@Override
	public boolean visitBuscador(Buscador e) {
		return false;
	}

}
