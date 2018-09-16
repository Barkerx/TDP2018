package disparo;

import Player.jugador;
import mapa.Map;
import mapa.celda;

public class Laser extends DisparoP{

	public Laser(celda ce, Map m,jugador j) {
		super(ce, m,j);
		damage=40;
		// TODO Auto-generated constructor stub
	}

}
