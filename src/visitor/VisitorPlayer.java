package visitor;

import nave.player.*;
import disparo.DisparoE;
import disparo.DisparoP;
import nave.enemigos.Buscador;
import nave.enemigos.EnemigoAbstract;
import gob.Gob;	
import obstaculos.ParedPlayer;
import obstaculos.ParedTodos;
import powerup.PowerUp;

public class VisitorPlayer extends Visitor{
	
	public VisitorPlayer(Gob o){
		objeto=o;
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
		if(areRunning(p)){
			Jugador j=(Jugador) objeto;		
			j.reducirVida(p.getFuerza());		
			p.destruir();
		}
		return false;
	}

	@Override
	public boolean visitPlayer(Jugador j) {
		
		return true;
	}

	@Override
	public boolean visitDisparoPlayer(DisparoP d) {
		
		return false;
	}

	@Override
	public boolean visitDisparoEnemigo(DisparoE d) {
		if(areRunning(d)){
			d.destruir();
			Jugador j=(Jugador) objeto;
			j.reducirVida(d.getdamage());}
		return true;
	}

	@Override
	public boolean visitPowerUp(PowerUp pw) {
		Jugador j=(Jugador) objeto;
		pw.accionar(j);
		pw.destruir();
		return true;
	}

	@Override
	public boolean visitMejorado(Jugador j) {
		
		return true;
	}

	@Override
	public boolean visitBuscador(Buscador e) {
		if(areRunning(e)){
			Jugador j=(Jugador) objeto;
			j.reducirVida(e.getFuerza());
			e.destruir();
			}
		return false;
	}

}
