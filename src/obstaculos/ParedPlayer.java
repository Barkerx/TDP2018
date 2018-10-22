package obstaculos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Map;
import mapa.celda;
import misc.Visitor;

public class ParedPlayer extends obstaculo {

	public ParedPlayer(celda ce, Map m) {
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
