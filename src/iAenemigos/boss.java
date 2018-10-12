package iAenemigos;

import Player.jugador;
import enemigos.enemigo;
import enemigos.enemigoAbstract;
import gui.Juego;
import mapa.celda;
import misc.Unidad;

public class boss extends Buscador {
	protected int x=0;
	public boss(jugador j, enemigoAbstract e) {
		super(j, e);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int mover() {
		int salida;
		x=x+1;
		if(x==2){
			x=0;
			salida=-1;
		}
		else
			salida=getxy();
		return salida;
	}
}