package misc;
import disparo.*;
import enemigos.Buscador;
import enemigos.enemigoAbstract;
import Player.Mejorado;
import Player.jugador;
import obstaculos.*;
import PowerUP.*;
public abstract  class Visitor {
	/**
	 * objeto asociado al visitor
	 */
   protected Gob objeto;
   
   public abstract boolean VisitDestruible(ParedTodos r);
   public abstract boolean VisitDestruiblePlayer(ParedPlayer w);
   public abstract boolean visitenemigo(enemigoAbstract p);
   public abstract boolean visitPlayer(jugador j);
   public abstract boolean visitDisparoPlayer(DisparoP d);
   public abstract boolean visitDisparoEnemigo(DisparoE d);
   public abstract boolean visitPowerUp(powerUp pw);
   public abstract boolean visitMejorado(jugador j);
   public abstract boolean visitBuscador(Buscador e);
}
