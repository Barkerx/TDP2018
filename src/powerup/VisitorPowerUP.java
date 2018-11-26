package powerup;

import disparo.DisparoE;
import disparo.DisparoP;
import enemigos.Buscador;
import enemigos.EnemigoAbstract;
import misc.Visitor;
import obstaculos.ParedPlayer;
import obstaculos.ParedTodos;
import player.Jugador;

public class VisitorPowerUP extends Visitor {
;
	public VisitorPowerUP(PowerUp o) {
		objeto=o;
	}

	@Override
	public boolean VisitDestruible(ParedTodos r) {
		
		return true;
	}

	@Override
	public boolean VisitDestruiblePlayer(ParedPlayer w) {
		
		return true;
	}

	@Override
	public boolean visitenemigo(EnemigoAbstract p) {
		
		return true;
	}

	@Override
	public boolean visitPlayer(Jugador j) {
		PowerUp p=(PowerUp)objeto;
		p.accionar(j);
		objeto.destruir();
		return true;
	}

	@Override
	public boolean visitDisparoPlayer(DisparoP d) {
		PowerUp p=(PowerUp) objeto;
		Jugador j=d.get();  
		p.accionar(j);
		d.destruir(); 
		objeto.destruir();
		return false;
	}

	@Override
	public boolean visitDisparoEnemigo(DisparoE d) {
		
		return true;
	}

	@Override
	public boolean visitPowerUp(PowerUp pw) {
		
		return false;
	}

	@Override
	public boolean visitMejorado(Jugador j) {
		PowerUp p=(PowerUp)objeto;
		p.accionar(j);
		objeto.destruir();
		return true;
	}

	@Override
	public boolean visitBuscador(Buscador e) {
		
		return true;
	}

}
