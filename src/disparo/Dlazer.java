package disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Mapa;
import player.Jugador;
import mapa.Celda;

public class Dlazer extends DisparoP{

	public Dlazer(Celda c, Mapa m,Jugador j) {
		super(c,m,j);
		damage=40;
		velocidad=40;
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/lazer.png")));
		visitor=new VisitorDisparoP(this,j);
		moviendo=false;
		initgraph();
		m.addDisparo(this);
		//new DisparoRun(this,m);
	}

}
