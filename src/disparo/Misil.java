package disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Player.jugador;
import mapa.Map;
import mapa.celda;

public class Misil extends DisparoP{

	public Misil(celda c, Map m,jugador j) {
		super(c,m,j);
		damage=50;
		velocidad=22;
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/misil.png")));
		visitor=new visitorDisparoP(this,j);
		moviendo=false;
		initgraph();
		t1=new Thread(this);
		t1.start();
	}

}
