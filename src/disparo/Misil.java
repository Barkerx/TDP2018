package disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Player.jugador;
import mapa.Map;
import mapa.celda;

public class Misil extends DisparoP{

	public Misil(celda c, Map m,jugador j) {
		this.c=c;
		this.m=m;
		this.j=j;
		damage=50;
		velocidad=25;
		visitor=new visitorDisparoP(this,j);
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/misil.png")));
		initgraph();
		run();
	}

}
