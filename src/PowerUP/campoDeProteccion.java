package PowerUP;

import Player.jugador;
import mapa.Map;
import mapa.celda;

public class campoDeProteccion extends powerUp{

	public campoDeProteccion(celda ce, Map m) {
		super(ce, m);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accionar(jugador j) {
		 j.setshield();
		
	}
	

}
