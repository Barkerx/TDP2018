package obstaculos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Mapa;
import mapa.Celda;
import misc.Visitor;

public class ParedTodos extends obstaculo {

	public ParedTodos(Celda ce, Mapa m) {
		super(ce, m);
		visitor=new visitorDestruibleTodos(this);
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/paredtodos.gif")));
		initgraph();
	}

	@Override
	public boolean Accept(Visitor V) {
	 return	V.VisitDestruible(this); 
	}


}
