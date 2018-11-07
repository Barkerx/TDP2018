package PowerUP;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Player.jugador;
import mapa.Mapa;
import mapa.celda;

public class AumentarCantDisparos extends powerUp{

	public AumentarCantDisparos(celda ce, Mapa m) {
		super(ce, m);
		grafico=new JLabel(new ImageIcon(this.getClass().getResource("/resources/aumentarDisparo.png")));
		initgraph();
		puntos=200;
		velocidad=10;
		new powerUpRun(this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accionar(jugador j) {
		j.sumarPuntaje(puntos);
		j.aumentar();
		
	}

	
}
