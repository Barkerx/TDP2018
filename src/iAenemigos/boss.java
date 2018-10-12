package iAenemigos;

import enemigos.enemigo;
import enemigos.enemigoAbstract;
import gui.Juego;
import mapa.celda;
import misc.Unidad;

public class boss extends FormaDeAtacar {
	protected int x=0;
	public boss(Juego j, enemigoAbstract e) {
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
			salida=j.getxy(e);
		return salida;
	}
}