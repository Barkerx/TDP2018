package iAenemigos;

import enemigos.enemigoAbstract;
import gui.Juego;

public abstract class FormaDeAtacar implements Runnable{
	
	protected Thread t1;
	protected Juego j;
	protected boolean waked=true;
	protected enemigoAbstract e;
	
	protected FormaDeAtacar(Juego j,enemigoAbstract e){
		this.j=j;
		this.e=e;
	}
	
	public void congelar() {
		waked=false;
	}
	
}
