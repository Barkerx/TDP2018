package obstaculos;

import mapa.Map;
import mapa.celda;
import misc.Visitor;

public class ParedTodos extends obstaculo {

	public ParedTodos(celda ce, Map m, Visitor v) {
		super(ce, m);
		visitor=new visitorDestruibleTodos(this);
	}

	@Override
	public boolean Accept(Visitor V) {
	 return	V.VisitDestruible(this); 
	}

}
