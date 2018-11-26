package enemigos;

import misc.Gob;
import player.Mejorado;
import player.Jugador;

public class VisitorBuscador extends VisitorEnemigo{

	public VisitorBuscador(Gob o) {
		super(o);
		// TODO Auto-generated constructor stub
	}
	
	public boolean visitMejorado(Jugador j){
		j.getShield().destruir();
		Enemigo ene=(Enemigo) objeto;
		ene.destruir();
		return false;
	}

}
