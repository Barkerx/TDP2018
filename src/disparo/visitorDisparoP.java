package disparo;

import Player.jugador;
import PowerUP.powerUp;
import enemigos.enemigoAbstract;
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
		if(r.getIsRunning()&&objeto.getIsRunning()){
		DisparoP aux=(DisparoP) objeto;
		r.reducirVida(aux.getdamage());
		objeto.destruir();}
		return false;
	}

	@Override
	public boolean VisitDestruiblePlayer(ParedPlayer w) {
		if(w.getIsRunning() && objeto.getIsRunning()){
		DisparoP aux=(DisparoP) objeto;
		w.reducirVida(aux.getdamage());
		objeto.destruir();}
		return false;
	}

	@Override
	public boolean visitenemigo(enemigoAbstract p) {
		if(objeto.getIsRunning()&&p.getIsRunning()){
			DisparoP aux=(DisparoP) objeto;
			p.reducirVida(aux.getdamage());
			objeto.destruir();
			}
		return true;
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
		if(d.getIsRunning()&&objeto.getIsRunning()){
			d.destruir();
			objeto.destruir();}
		return false;
	}

	@Override
	public boolean visitPowerUp(powerUp pw) {
		pw.accionar(j);
		pw.destruir();
		objeto.destruir();
		return false;
	}

}
