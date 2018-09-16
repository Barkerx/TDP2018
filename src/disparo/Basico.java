package disparo;

import Player.jugador;
import mapa.Map;
import mapa.celda;

public class Basico extends DisparoP{

	public Basico(celda ce, Map m,jugador j) {
		super(ce, m,j);
		damage=30;
	}

}
