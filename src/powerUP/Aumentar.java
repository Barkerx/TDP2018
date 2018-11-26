package powerUP;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Mapa;
import player.Jugador;
import mapa.Celda;

public class Aumentar extends PowerUp{

	public Aumentar(Celda ce, Mapa m) {
		super(ce, m);
		grafico=new JLabel(new ImageIcon(this.getClass().getResource("/resources/aumentarDisparo.png")));
		initgraph();
		puntos=200;
		velocidad=10;
		new PowerUpRun(this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accionar(Jugador j) {
		j.sumarPuntaje(puntos);
		j.getArma().aumentarDisparos();
	}

	
}
