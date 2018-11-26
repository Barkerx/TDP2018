package disparo;

import mapa.Mapa;
import mapa.Celda;
import misc.Visitor;
import player.Jugador;

public abstract class DisparoP extends Disparo{
	protected Jugador j;
	protected int pasos;
	/**
	 * Variable PASOS, usada para que el jugador pueda disparar despues de que el disparo el ultimo disparo realize 3 pasos
	 * constructor de disparoPLayer
	 * @param c celda donde estara el disparo
	 * @param m mapa donde estara el disparo
	 * @param j jugador del disparo
	 */
	protected DisparoP(Celda c, Mapa m, Jugador j) {
		super(c,m);
		this.j=j;
		visitor=new VisitorDisparoP(this,j);
		pasos=0;
	}
	
	@Override
	public boolean Accept(Visitor V) {
		return V.visitDisparoPlayer(this);
	}
	
	public Jugador get(){
		return j;
	}
	public void destruir(){
		if(pasos<3)
			j.candisparar();
		super.destruir();
		
	}
	public void mover(){
		if(isRunning){
		//	while(isRunning){
			Celda ce=super.mover(ARRIBA);
				
				if (ce.getposy()==m.getminY())
				{      
					destruir();
				}
		//	}
				
	
		}
		pasos=pasos+1;
		if (pasos==3)
			j.candisparar();
	}
	
	


}