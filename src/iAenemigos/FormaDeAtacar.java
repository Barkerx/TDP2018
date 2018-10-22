package iAenemigos;

import Player.jugador;
import enemigos.enemigo;
import enemigos.enemigoAbstract;
import gui.Juego;
import mapa.celda;

public abstract class FormaDeAtacar{
	
	protected enemigoAbstract e;
	
	
	
	public abstract int mover();
	
}
