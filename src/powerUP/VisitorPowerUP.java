package powerUP;

import disparo.DisparoE;
import disparo.DisparoP;
import enemigos.Buscador;
import enemigos.EnemigoAbstract;
import misc.Visitor;
import obstaculos.ParedPlayer;
import obstaculos.ParedTodos;
import player.Mejorado;
import player.Jugador;

public class VisitorPowerUP extends Visitor {
;
	public VisitorPowerUP(PowerUp o) {
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
	public boolean visitenemigo(EnemigoAbstract p) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean visitPowerUp(PowerUp pw) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return true;
	}

}
