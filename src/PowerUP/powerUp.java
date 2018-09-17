package PowerUP;

import Player.jugador;
import mapa.Map;
import mapa.celda;
import misc.Unidad;
import misc.Visitor;

public abstract class powerUp extends Unidad{

	public powerUp(celda ce, Map m) {
		super(ce, m);
		visitor=new visitorPowerUp(this);
		profundidad=3;
	}
	
	public boolean Accept(Visitor V){
		return V.visitPowerUp(this);
	}
	
	public abstract void accionar(jugador j);
	
	public void run(){
		
	}

}
