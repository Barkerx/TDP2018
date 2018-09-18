package disparo;

import Player.jugador;
import mapa.Map;
import mapa.celda;
import misc.Visitor;

public abstract class DisparoP extends Disparo{
	protected jugador j;
	
	@Override
	public boolean Accept(Visitor V) {
		return V.visitDisparoPlayer(this);
	}
	
	public jugador get(){
		return j;
	}
	
	public void mover(){
	/*	boolean sigo=true;
		while(sigo){
			celda ce=super.mover(ARRIBA);
			System.out.print("estoy aca e.e");
			if (ce==null){
				destruir();
				sigo=false;
				System.out.println("entre aca");
				}
		}
	}*/
		if(isRunning){
		System.out.println("Hola entre al mover de disparo p");
		celda ce=super.mover(ARRIBA);
		if (ce==null)
		{
			destruir();
			System.out.print("me destrui");
			isRunning=false;
		}
		
	}
}
	
}