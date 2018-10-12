package iAenemigos;

import Player.jugador;
import enemigos.enemigoAbstract;
import gui.Juego;
import mapa.celda;

public abstract class FormaDeAtacar{
	
	protected jugador j;
	protected enemigoAbstract e;
	
	protected FormaDeAtacar(jugador j,enemigoAbstract e){
		this.j=j;
		this.e=e;
	}
	protected FormaDeAtacar(enemigoAbstract e){
		this.e=e;
	}
	
	
	
	public abstract int mover();
	
}
