package disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Player.jugador;
import mapa.Map;
import mapa.celda;

public class Laser extends DisparoP{

	public Laser(celda c, Map m,jugador j) {
		super(c,m,j);
		damage=40;
		velocidad=18;
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/lazer.png")));
		visitor=new visitorDisparoP(this,j);
		moviendo=false;
		initgraph();
		t1=new Thread(this);
		t1.start();
	}

}
