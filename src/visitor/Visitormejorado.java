package visitor;

import nave.enemigos.Buscador;
import nave.player.Jugador;
import gob.Gob;

public class Visitormejorado extends VisitorPlayer{

	public Visitormejorado(Gob o) {
		super(o);
		// TODO Auto-generated constructor stub
	}
	
	public boolean visitBuscador(Buscador e){
		e.destruir();
		Jugador j=(Jugador) objeto;
		j.getShield().destruir();
		return false;
	}

}
