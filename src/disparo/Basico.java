package disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Player.jugador;
import mapa.Map;
import mapa.celda;

public class Basico extends DisparoP{

	public Basico(celda c, Map m,jugador j) {
		this.c=c;
		this.m=m;
		this.j=j;
		damage=20;
		velocidad=40;
		visitor=new visitorDisparoP(this,j);
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/disparo.png")));
		initgraph();
		run();
	}

}
