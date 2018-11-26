package disparo;

import enemigos.Buscador;
import enemigos.EnemigoAbstract;
import misc.Gob;
import misc.Visitor;
import obstaculos.ParedPlayer;
import obstaculos.ParedTodos;
import player.Mejorado;
import powerUP.PowerUp;
import player.Jugador;

public class VisitorDisparoP extends Visitor {
	private Jugador j;
	
	public VisitorDisparoP(Gob o,Jugador j) {
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
	public boolean visitenemigo(EnemigoAbstract p) {
		if(areRunning(p)){
			DisparoP aux=(DisparoP) objeto;
			int t=aux.getdamage();
			objeto.destruir();
			p.reducirVida(t);
			}
		return false;
	}

	@Override
	public boolean visitPlayer(Jugador j) {
		
		return true;
	}

	@Override
	public boolean visitDisparoPlayer(DisparoP d) {
		
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
	public boolean visitPowerUp(PowerUp pw) {
		objeto.destruir(); 
		pw.accionar(j);
		pw.destruir();
		return false;
	}

	@Override
	public boolean visitMejorado(Jugador j) {
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
