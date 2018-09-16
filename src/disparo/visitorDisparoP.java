package disparo;

import Player.jugador;
import PowerUP.powerUp;
import enemigos.enemigo;
import misc.Visitor;
import obstaculos.ParedPlayer;
import obstaculos.ParedTodos;

public class visitorDisparoP extends Visitor {
	private jugador j;
	
	public visitorDisparoP(DisparoP o,jugador j) {
		objeto=o;
		this.j=j;
	}

	@Override
	public boolean VisitDestruible(ParedTodos r) {
		DisparoP aux=(DisparoP) objeto;
		r.reducirVida(aux.getdamage());
		objeto.destruir();
		return false;
	}

	@Override
	public boolean VisitDestruiblePlayer(ParedPlayer w) {
		DisparoP aux=(DisparoP) objeto;
		w.reducirVida(aux.getdamage());
		objeto.destruir();
		return false;
	}

	@Override
	public boolean visitenemigo(enemigo p) {
		DisparoP aux=(DisparoP) objeto;
		p.reducirVida(aux.getdamage());
		objeto.destruir();
		return false;
	}

	@Override
	public boolean visitPlayer(jugador j) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean visitDisparoPlayer(DisparoP d) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean visitDisparoEnemigo(DisparoE d) {
		d.destruir();
		objeto.destruir();
		return false;
	}

	@Override
	public boolean visitPowerUp(powerUp pw) {
		pw.accionar(j);
		objeto.destruir();
		pw.destruir();
		return false;
	}

}
