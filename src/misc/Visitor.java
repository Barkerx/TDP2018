package misc;
import disparo.*;
import enemigos.enemigo;
import Player.jugador;
import obstaculos.*;
import PowerUP.*;
public abstract  class Visitor {
   protected Gob objeto;
   
   public abstract boolean VisitDestruible(ParedTodos r);
   public abstract boolean VisitDestruiblePlayer(ParedPlayer w);
   public abstract boolean visitenemigo(enemigo p);
   public abstract boolean visitPlayer(jugador j);
   public abstract boolean visitDisparoPlayer(DisparoP d);
   public abstract boolean visitDisparoEnemigo(DisparoE d);
   public abstract boolean visitPowerUp(powerUp pw);
}
