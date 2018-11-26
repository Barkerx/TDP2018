package obstaculos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Mapa;
import mapa.Celda;
import misc.Visitor;

public class ParedPlayer extends obstaculo {

	public ParedPlayer(Celda ce, Mapa m) {
		super(ce, m);
		visitor=new visitorDestruibleplayer(this);
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/paredplayer.gif")));
		initgraph();
	}

	@Override
	public boolean Accept(Visitor V) {
		return V.VisitDestruiblePlayer(this);
	}

	
}
