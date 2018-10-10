package disparo;

import Player.jugador;
import PowerUP.powerUp;
import enemigos.enemigoAbstract;
import misc.Gob;
import misc.Visitor;
import obstaculos.ParedPlayer;
import obstaculos.ParedTodos;

public class visitorDisparoE extends Visitor{
	
	public visitorDisparoE(Gob o){
		objeto=o;
	}

	@Override
	public boolean VisitDestruible(ParedTodos r) {
		if(r.getIsRunning()&&objeto.getIsRunning()){
		DisparoE aux=(DisparoE) objeto;
		int t=aux.getdamage();
		objeto.destruir();
		r.reducirVida(t);}
		return false;
	}

	@Override
	public boolean VisitDestruiblePlayer(ParedPlayer w) {
		if(objeto.getIsRunning()&&w.getIsRunning()){
		objeto.destruir();}
		return true;
	}

	@Override
	public boolean visitenemigo(enemigoAbstract p) {
		return true;
	}

	@Override
	public boolean visitDisparoPlayer(DisparoP d) {
		if(d.getIsRunning()&&objeto.getIsRunning()){
		d.destruir();
		objeto.destruir();}
		return false;
	}

	@Override
	public boolean visitDisparoEnemigo(DisparoE d) {
		return true;
	}

	@Override
	public boolean visitPowerUp(powerUp pw) {
		return true;
	}

	@Override
	public boolean visitPlayer(jugador j) {
		if(j.getIsRunning()&&objeto.getIsRunning()){
		DisparoE aux=(DisparoE) objeto;
		j.reducirVida(aux.getdamage());
		objeto.destruir();}
		return false ;
	}

}
