package Player;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import misc.Visitor;

public class Mejorado extends shield{

	
	public Mejorado(jugador j) {
		super(j);
		puntos=5;
		image=new JLabel(new ImageIcon(this.getClass().getResource("/resources/shield.gif")));
		v=new visitorMejorado(j);
	}

	
	@Override
	public void levelUp() {
		j.setShield(new Mejorado(j));
		
	}


	public void destruir() {
		j.setShield(new Basico(j));
		
	}


	@Override
	public Visitor getVisitor() {
		// TODO Auto-generated method stub
		return v;
	}


	@Override
	public boolean accept(Visitor v) {
		return v.visitMejorado(j);
	}

}
