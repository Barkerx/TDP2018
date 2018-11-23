package disparo;

import Player.Mejorado;
import Player.jugador;
import PowerUP.powerUp;
import enemigos.Buscador;
import enemigos.enemigoAbstract;
import misc.Gob;
import misc.Visitor;
import obstaculos.ParedPlayer;
import obstaculos.ParedTodos;

public class visitorDisparoP extends Visitor {
	private jugador j;
	
	public visitorDisparoP(Gob o,jugador j) {
		objeto=o;
		this.j=j;
	}

	@Override
	public boolean VisitDestruible(ParedTodos r) {
		if(areRunning(r)){
		DisparoP aux=(DisparoP) objeto;
		int t=aux.getdamage();
		objeto.destruir();
		r.reducirVida(t);
		}
		return false;
	}

	@Override
	public boolean VisitDestruiblePlayer(ParedPlayer w) {
		if(areRunning(w)){
		DisparoP aux=(DisparoP) objeto;
		int t=aux.getdamage();
		objeto.destruir();
		w.reducirVida(t);}
		return false;
	}

	@Override
	public boolean visitenemigo(enemigoAbstract p) {
		if(areRunning(p)){
			DisparoP aux=(DisparoP) objeto;
			int t=aux.getdamage();
			objeto.destruir();
			p.reducirVida(t);
			}
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
		if(areRunning(d)){
			d.destruir();
			objeto.destruir();}
		return false;
	}

	@Override
	public boolean visitPowerUp(powerUp pw) {
		objeto.destruir(); 
		pw.accionar(j);
		pw.destruir();
		return false;
	}

	@Override
	public boolean visitMejorado(jugador j) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean visitBuscador(Buscador e) {
		if(areRunning(e)){
			DisparoP aux=(DisparoP) objeto;
			int t=aux.getdamage();
			objeto.destruir();
			e.reducirVida(t);
			}
		return false;
	}

}
