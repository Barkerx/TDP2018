package PowerUP;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Player.jugador;
import mapa.Map;
import mapa.celda;

public class MejorarDisparo extends powerUp{

	public MejorarDisparo(celda ce, Map m) {
		super(ce, m);
		grafico=new JLabel(new ImageIcon(this.getClass().getResource("/resources/paredplayer.png")));
		initgraph();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accionar(jugador j) {
		j.mejorarDisparo();
		
	}

}
