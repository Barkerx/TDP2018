package PowerUP;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Player.jugador;
import mapa.Map;
import mapa.celda;

public class AumentarCantDisparos extends powerUp{

	public AumentarCantDisparos(celda ce, Map m) {
		super(ce, m);
		grafico=new JLabel(new ImageIcon(this.getClass().getResource("/resources/aumentarDisparo.png")));
		initgraph();
		velocidad=10;
		new powerUpRun(this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accionar(jugador j) {
		j.aumentar();
		
	}

	
}
