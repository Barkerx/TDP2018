package PowerUP;

import Player.jugador;
import mapa.Map;
import mapa.celda;
public class pocion extends powerUp{

	public pocion(celda ce, Map m) {
		super(ce, m);
		// TODO Auto-generated constructor stub
	}
	public void accionar(jugador j){
		j.pocion();
	}
}
