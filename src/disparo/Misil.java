package disparo;

import Player.jugador;
import mapa.Map;
import mapa.celda;

public class Misil extends DisparoP{

	public Misil(celda ce, Map m,jugador j) {
		super(ce, m,j);
		damage=50;
	}

}
