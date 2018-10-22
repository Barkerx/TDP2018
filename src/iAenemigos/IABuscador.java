package iAenemigos;

import Player.jugador;
import enemigos.enemigoAbstract;
import mapa.celda;
import misc.Unidad;

public class IABuscador extends FormaDeAtacar{
	private int n;
	protected jugador j;	
	public IABuscador(jugador j, enemigoAbstract e) {
		this.e=e;
		this.j=j;
		n=0;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int mover() {
		int salida=getxy();
		return salida;
	}
	
	public int getxy() {
		n++;
		if(n==3){
			n=0;
			e.disparar();
		}
		int salida=Unidad.ABAJO;
		celda c=j.getcelda();
		celda c2=e.getcelda();
		int x1=c.getposx();
		int y1=c.getposy();
		int x2=c2.getposx();
		int y2=c2.getposy();
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
