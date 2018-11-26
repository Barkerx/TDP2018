package misc;
import disparo.*;
import enemigos.Buscador;
import enemigos.EnemigoAbstract;
import obstaculos.*;
import player.Jugador;
import powerup.*;
public abstract  class Visitor {
	/**
	 * objeto asociado al visitor
	 */
   protected Gob objeto;
   
   public abstract boolean VisitDestruible(ParedTodos r);
   public abstract boolean VisitDestruiblePlayer(ParedPlayer w);
   public abstract boolean visitenemigo(EnemigoAbstract p);
   public abstract boolean visitPlayer(Jugador j);
   public abstract boolean visitDisparoPlayer(DisparoP d);
   public abstract boolean visitDisparoEnemigo(DisparoE d);
   public abstract boolean visitPowerUp(PowerUp pw);
   public abstract boolean visitMejorado(Jugador j);
   public abstract boolean visitBuscador(Buscador e);
   public boolean areRunning(Gob o){
	   return objeto.getIsRunning()&& o.getIsRunning();
   }
}
