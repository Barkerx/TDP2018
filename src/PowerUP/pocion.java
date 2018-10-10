package PowerUP;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Player.jugador;
import mapa.Map;
import mapa.celda;
public class pocion extends powerUp{

	public pocion(celda ce, Map m) {
		super(ce, m);
		grafico=new JLabel(new ImageIcon(this.getClass().getResource("/resources/pocion.png")));
		initgraph();
		new powerUpRun(this);
		// TODO Auto-generated constructor stub
	}
	public void accionar(jugador j){
		j.pocion();
	}
}
