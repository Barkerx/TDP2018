package nave.player.escudo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import nave.player.Jugador;
import visitor.Visitor;
import visitor.Visitormejorado;

public class Mejorado extends Shield{

	
	public Mejorado(Jugador j) {
		super(j);
		puntos=5;
		image=new JLabel(new ImageIcon(this.getClass().getResource("/resources/shield.gif")));
		v=new Visitormejorado(j);
	}

	
	@Override
	public void levelUp() {
		j.setShield(new Mejorado(j));
		
	}


	public void destruir() {
		j.setShield(new Ebasico(j));
		
	}


	@Override
	public Visitor getVisitor() {
		
		return v;
	}


	@Override
	public boolean accept(Visitor v) {
		return v.visitMejorado(j);
	}

}
