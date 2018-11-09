package enemigos;

import Player.Mejorado;
import Player.jugador;
import misc.Gob;

public class visitorBuscador extends visitorEnemigo{

	public visitorBuscador(Gob o) {
		super(o);
		// TODO Auto-generated constructor stub
	}
	
	public boolean visitMejorado(jugador j){
		j.getShield().destruir();
		enemigo ene=(enemigo) objeto;
		ene.destruir();
		return false;
	}

}
