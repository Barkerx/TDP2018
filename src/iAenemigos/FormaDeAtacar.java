package iAenemigos;

import enemigos.enemigoAbstract;
import gui.Juego;
import mapa.celda;

public abstract class FormaDeAtacar{
	
	protected Thread t1;
	protected Juego j;
	protected enemigoAbstract e;
	
	protected FormaDeAtacar(Juego j,enemigoAbstract e){
		this.j=j;
		this.e=e;
	}
	
	
	
	public abstract int mover();
	
}
