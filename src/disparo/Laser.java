package disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Player.jugador;
import mapa.Map;
import mapa.celda;

public class Laser extends DisparoP{

	public Laser(celda c, Map m,jugador j) {
		super(c,m,j);
		damage=30;
		velocidad=30;
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/lazer.png")));
		initgraph();
		run();
	}

}
