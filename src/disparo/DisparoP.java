package disparo;

import Player.jugador;
import mapa.Map;
import mapa.celda;
import misc.Visitor;

public abstract class DisparoP extends Disparo{
	protected jugador j;
	public DisparoP(celda ce, Map m,jugador j) {
		super(ce, m);
		this.j=j;
		visitor=new visitorDisparoP(this,j);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean Accept(Visitor V) {
		return V.visitDisparoPlayer(this);
	}
	
	public jugador get(){
		return j;
	}
	
	public void mover(){
		boolean sigo=true;
		while(sigo){
			celda ce=super.mover(ARRIBA);
			if (ce==null){
				destruir();
				sigo=false;
				System.out.println("entre aca");
				}
				else
				super.intercambiarceldas(ce, ARRIBA);	
		}
	}

}
