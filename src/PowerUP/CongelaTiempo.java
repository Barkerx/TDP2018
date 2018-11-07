package PowerUP;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Player.jugador;
import mapa.Mapa;
import mapa.celda;

public class CongelaTiempo extends powerUp{

	public CongelaTiempo(celda ce, Mapa m) {
		super(ce, m);
		grafico=new JLabel(new ImageIcon(this.getClass().getResource("/resources/detenerTiempo.gif")));
		initgraph();
		velocidad=45;
		puntos=250;
		new powerUpRun(this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accionar(jugador j) {
		j.sumarPuntaje(puntos);
		 m.congelatiempo(this);
		
	}

}
