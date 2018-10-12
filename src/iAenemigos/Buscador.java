package iAenemigos;

import Player.jugador;
import enemigos.enemigo;
import enemigos.enemigoAbstract;
import gui.Juego;
import mapa.celda;
import misc.Unidad;

public class Buscador extends FormaDeAtacar{

	public Buscador(jugador j, enemigoAbstract e) {
		super(j, e);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int mover() {
		int salida=getxy();
		return salida;
	}
	
	public int getxy() {
		int salida=Unidad.ABAJO;
		int x1=j.getcelda().getposx();
		int y1=j.getcelda().getposy();
		int x2=e.getcelda().getposx();
		int y2=e.getcelda().getposy();
		int x=Math.abs(x2-x1);
		int y=Math.abs(y2-y1);
		
		if(x<y){
			salida=Unidad.ABAJO;
		}
		else
			if(x==y && y>=0){
				if(x2>x1)
					salida=Unidad.ABAJOIZQUIERDA;
				else
				if(x1>x2)
					salida=Unidad.ABAJODERECHA;
					
				}
			else
				if(x>y){
					if(x2>x1)
					salida=Unidad.IZQUIERDA;
					else
						salida=Unidad.DERECHA;
				}
				
		return salida;
	}
	
		
	
}
