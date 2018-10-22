package enemigos;

import iAenemigos.*;
import mapa.Map;
import mapa.celda;
import misc.Unidad;
import disparo.disparoEnemy;


public abstract class enemigo extends enemigoAbstract {
	/**
	 * constructor del enemigo, lo crea y pone los graficos.
	 * @param c celda donde va a estar el enemigo
	 * @param m mapa donde va a estar el enemigo
	 * @param a forma de atacar que tendra el enemigo
	 */
	
	protected enemigo(celda c,Map m) {
		profundidad=1;
		this.c=c;
		c.setelem(profundidad,this);
		this.m=m;
		puntos=300;
		shieldL=null;
		x=c.getposx();
		y=c.getposy();
		visitor=new visitorEnemigo(this);

	}
	public abstract void disparar();
	public void congelar() {
		IA=new IADormido(this);
	}
	

	@Override
	public void mover() {
		if(isRunning){
			int direccion=IA.mover();	
			celda ce=m.mover(c, direccion);
				if(c!=ce){
					mover(direccion);
				}
				else
					if(ce.getposy()==14&&direccion==Unidad.ABAJO)
						restart();
		
			}
		}
	
}
