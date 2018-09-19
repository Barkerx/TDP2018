package disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Player.jugador;
import mapa.Map;
import mapa.celda;

public class Basico extends DisparoP{

	public Basico(celda c, Map m,jugador j) {
		super(c,m,j);
		damage=20;
		velocidad=40;
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/disparo.png")));
		initgraph();
		run();
	}

}
