package Player;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Mejorado extends shield{

	public Mejorado(jugador j) {
		super(j);
		puntos=5;
		image=new JLabel(new ImageIcon(this.getClass().getResource("/resources/shield.gif")));
	}

	
	@Override
	public void levelUp() {
		j.setShield(new Mejorado(j));
		
	}

}
