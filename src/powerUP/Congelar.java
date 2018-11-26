package powerUP;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Mapa;
import player.Jugador;
import mapa.Celda;

public class Congelar extends PowerUp{

	
	public Congelar(Celda ce, Mapa m) {
		super(ce, m);
		grafico=new JLabel(new ImageIcon(this.getClass().getResource("/resources/detenerTiempo.gif")));
		initgraph();
		velocidad=45;
		puntos=250;
		new PowerUpRun(this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accionar(Jugador j) {
		j.sumarPuntaje(puntos);
		Phantom.getInstance(3000, m);
		Phantom.resetInstance();
	}

}
