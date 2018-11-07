package iAenemigos;

import Player.jugador;
import enemigos.FinalBOSS;
import mapa.celda;
import misc.Unidad;

public class IAFinalBoss extends FormaDeAtacar{

	private int n;
	private boolean buscar;
	private jugador j;
	public IAFinalBoss(FinalBOSS finalBOSS,jugador j) {
		e=finalBOSS;
		this.j=j;
		buscar=false;
		n=0;
	}

	@Override
	public int mover() {
		int salida;
		FinalBOSS s=(FinalBOSS)e;
			if(buscar){
				celda c=j.getcelda();
				celda c2=e.getcelda();
				int x1=c.getposx();
				int x2=c2.getposx();
				int y2=c2.getposy();
				
				if(x1==x2){
					s.cambio();
					salida=Unidad.ABAJO;
				}
				else
					if(x1<x2){
						salida=Unidad.IZQUIERDA;
					}
					else
						salida=Unidad.DERECHA;
				
				if(y2==14){
					s.reset();
					buscar=false;
				}
			}
			else{
			if(s.getDisparos()==30)
				buscar=true;

				e.disparar();
				for(FinalBOSS r:s.getPartner()){
					r.disparar();
				}
				if(n==0){
					n=1;
					salida=Unidad.IZQUIERDA;}
				else{
					n=0;
					salida=Unidad.DERECHA;}
				
			}
		return salida;
	}

}
