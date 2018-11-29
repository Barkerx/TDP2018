package visitor;

import gob.Gob;
import nave.enemigos.Enemigo;
import nave.player.Jugador;

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
