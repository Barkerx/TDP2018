package disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Player.jugador;
import mapa.Mapa;
import mapa.celda;

public class Laser extends DisparoP{

	public Laser(celda c, Mapa m,jugador j) {
		super(c,m,j);
		damage=40;
		velocidad=40;
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/lazer.png")));
		visitor=new visitorDisparoP(this,j);
		moviendo=false;
		initgraph();
		m.addDisparo(this);
		//new DisparoRun(this,m);
	}

}
