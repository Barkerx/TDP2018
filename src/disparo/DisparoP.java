package disparo;

import Player.jugador;
import mapa.Map;
import mapa.celda;
import misc.Visitor;

public abstract class DisparoP extends Disparo{
	protected jugador j;
	
	protected DisparoP(celda c,Map m,jugador j){
		this.c=c;
		this.m=m;
		this.j=j;
		visitor=new visitorDisparoP(this,j);
	}
	@Override
	public boolean Accept(Visitor V) {
		return V.visitDisparoPlayer(this);
	}
	
	public jugador get(){
		return j;
	}
	
	public void mover(){
		if(isRunning){
		celda ce=super.mover(ARRIBA);
			if (ce==null)
			{
				destruir();
			}
		
		}
	
	}

}