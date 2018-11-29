package nave.enemigos;

import mapa.Mapa;
import mapa.Celda;
import unidad.Unidad;
import visitor.VisitorEnemigo;

public abstract class Enemigo extends EnemigoAbstract {
	
	/**
	 * constructor del enemigo, lo crea y pone los graficos.
	 * @param c celda donde va a estar el enemigo
	 * @param m mapa donde va a estar el enemigo
	 * @param a forma de atacar que tendra el enemigo
	 */
	
	protected Enemigo(Celda c,Mapa m,int f,int vida, int speed) {
		profundidad=1;
		this.c=c;
		c.setelem(profundidad,this);
		this.m=m;
		puntos=300;
		shieldL=null;
		x=c.getposx();
		y=c.getposy();
		visitor=new VisitorEnemigo(this);
		fuerza=f;
		this.vida=vida;
		velocidad=speed;
	}
	public abstract void disparar();
	

	@Override
	public void mover() {
		if(isRunning){
			int direccion=IA.mover();	
			Celda ce=m.mover(c, direccion);
				if(c!=ce){
					mover(direccion);
				}
				else
					if(ce.getposy()==14&&direccion==Unidad.ABAJO)
						restart();
		
			}
		}
}
