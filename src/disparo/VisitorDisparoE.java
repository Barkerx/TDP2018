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

public class VisitorDisparoE extends Visitor{
	
	public VisitorDisparoE(Gob o){
		objeto=o;
	}

	@Override
	public boolean VisitDestruible(ParedTodos r) {
		if(areRunning(r)){
		DisparoE aux=(DisparoE) objeto;
		int t=aux.getdamage();
		objeto.destruir();
		r.reducirVida(t);}
		return false;
	}

	@Override
	public boolean VisitDestruiblePlayer(ParedPlayer w) {
		if(areRunning(w)){
		objeto.destruir();}
		return false;
	}

	@Override
	public boolean visitenemigo(EnemigoAbstract p) {
		return true;
	}

	@Override
	public boolean visitDisparoPlayer(DisparoP d) {
		if(areRunning(d)){
		d.destruir();
		objeto.destruir();}
		return false;
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
	public boolean visitPlayer(Jugador j) {
		if(areRunning(j)){
		DisparoE aux=(DisparoE) objeto;
		j.reducirVida(aux.getdamage());
		objeto.destruir();}
		return true;
	}

	@Override
	public boolean visitMejorado(Jugador j) {
		if(areRunning(j)){
			DisparoE aux=(DisparoE) objeto;
			j.reducirVida(aux.getdamage());
			objeto.destruir();}
			return false;
	}

	@Override
	public boolean visitBuscador(Buscador e) {
		return true;
	}

}
