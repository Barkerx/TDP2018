package iAenemigos;

import java.util.Random;

import Player.jugador;
import enemigos.enemigo;
import enemigos.enemigoAbstract;
import gui.Juego;
import mapa.celda;
import misc.Unidad;

public class BuscadorTemporal extends FormaDeAtacar{
	
	protected int dir;
	protected Buscador p;
	public BuscadorTemporal(jugador j, enemigoAbstract e) {
		super(j, e);
		dir=-1;
		p=new Buscador(j,e);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public int mover() {
		int salida=0;
				if(e.getIsRunning()){
					if(e.getVida()){
					dir=dir+1;	
					switch(dir){
					case 0:salida=Unidad.ABAJO;break;
					case 1:salida=Unidad.IZQUIERDA;break;
					case 2:salida=Unidad.ARRIBA;break;
					case 3:salida=Unidad.DERECHA;break;
					}
					if(dir==3){
						dir=-1;}
					}
					else
					salida=p.mover();	
				}
	return salida;
	}
			//
			//nod celda nulo X
		//un hilo general para todos los disparos X
		//un hilo general ia con movimiento, iA no es un hilo, X 
	

		
}


