package nave.player.escudo;


import nave.player.Jugador;
import visitor.Visitor;
import visitor.VisitorPlayer;

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
		
		return v;
	}

	@Override
	public boolean accept(Visitor v) {
		
		return v.visitPlayer(j);
	}

	public void destruir() {
		// debido a que es un escudo basico el escudo basico no se destruye.
	}
	
}
