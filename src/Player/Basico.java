package Player;

import misc.Visitor;

public class Basico extends shield{

	public Basico(jugador j){
		super(j);
		puntos=0;
		image=null;
		v=new visitorPlayer(j);
	}
	
	@Override
	public void levelUp() {
		j.setShield(new Mejorado(j));
	}

	@Override
	public Visitor getVisitor() {
		// TODO Auto-generated method stub
		return v;
	}

	@Override
	public boolean accept(Visitor v) {
		// TODO Auto-generated method stub
		return v.visitPlayer(j);
	}
	/**
	 * Metodo usado para destruir el escudo, debido a que es un escudo basico el escudo basico no se destruye. 
	 */
	public void destruir() {
	}
	
}
