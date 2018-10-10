package PowerUP;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Player.jugador;
import mapa.Map;
import mapa.celda;

public class SuperMisil extends powerUp{

	public SuperMisil(celda ce, Map m) {
		super(ce, m);
		grafico=new JLabel(new ImageIcon(this.getClass().getResource("/resources/superMisil.png")));
		initgraph();
		new powerUpRun(this);
	}
	
	@Override
	public void accionar(jugador j) {
		j.supermisil();
	}

	
}
