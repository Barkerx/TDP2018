package player;

import misc.Visitor;

public class Ebasico extends Shield{

	public Ebasico(Jugador j){
		super(j);
		puntos=0;
		image=null;
		v=new VisitorPlayer(j);
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
