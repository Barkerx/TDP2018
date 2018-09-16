package obstaculos;

import mapa.Map;
import mapa.celda;
import misc.Visitor;

public class ParedPlayer extends obstaculo {

	public ParedPlayer(celda ce, Map m) {
		super(ce, m);
		visitor=new visitorDestruibleplayer(this);
	}

	@Override
	public boolean Accept(Visitor V) {
		return V.VisitDestruiblePlayer(this);
	}

	
}
