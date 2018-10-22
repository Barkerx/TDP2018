package iAenemigos;

import Player.jugador;
import enemigos.enemigoAbstract;

public class boss extends IABuscador {
	protected int x=0;
	public boss(jugador j, enemigoAbstract boss) {
		super(j,boss);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int mover() {
		int salida;
		x=x+1;
		if(x==2){
			x=0;
			e.disparar();
		}
			salida=getxy();
		return salida;
	}
}