package disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Player.jugador;
import mapa.Map;
import mapa.celda;

public class Laser extends DisparoP{

	public Laser(celda c, Map m,jugador j) {
		this.c=c;
		this.m=m;
		this.j=j;
		damage=30;
		velocidad=30;
		visitor=new visitorDisparoP(this,j);
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/lazer.png")));
		initgraph();
		run();
	}

}
