package Player;

import enemigos.Buscador;
import misc.Gob;

public class visitorMejorado extends visitorPlayer{

	public visitorMejorado(Gob o) {
		super(o);
		// TODO Auto-generated constructor stub
	}
	
	public boolean visitBuscador(Buscador e){
		e.destruir();
		jugador j=(jugador) objeto;
		j.getShield().destruir();
		return false;
	}

}
