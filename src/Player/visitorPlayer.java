package Player;

import PowerUP.powerUp;
import disparo.DisparoE;
import disparo.DisparoP;
import enemigos.enemigo;
import misc.*;
import obstaculos.ParedPlayer;
import obstaculos.ParedTodos;

public class visitorPlayer extends Visitor{
	
	public visitorPlayer(Gob o){
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
		return false;
	}

	@Override
	public boolean visitenemigo(enemigo p) {
		p.destruir();
		jugador j=(jugador) objeto;
		j.reducirVida(50);
		
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
		return false;
	}

	@Override
	public boolean visitDisparoEnemigo(DisparoE d) {
		d.destruir();
		jugador j=(jugador) objeto;
		j.reducirVida(d.getdamage());
		return false;
	}

	@Override
	public boolean visitPowerUp(powerUp pw) {
		jugador j=(jugador) objeto;
		pw.accionar(j);
		pw.destruir();
		
		return true;
	}

}
