package obstaculos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Map;
import mapa.celda;
import misc.Visitor;

public class ParedTodos extends obstaculo {

	public ParedTodos(celda ce, Map m, Visitor v) {
		super(ce, m);
		visitor=new visitorDestruibleTodos(this);
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/paredtodos.png")));
		initgraph();
	}

	@Override
	public boolean Accept(Visitor V) {
	 return	V.VisitDestruible(this); 
	}

}
