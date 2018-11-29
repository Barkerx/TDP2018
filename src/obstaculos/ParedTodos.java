package obstaculos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Mapa;
import mapa.Celda;
import visitor.Visitor;
import visitor.VisitorDestruibleTodos;

public class ParedTodos extends Obstaculo {

	public ParedTodos(Celda ce, Mapa m) {
		super(ce, m);
		visitor=new VisitorDestruibleTodos(this);
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/paredtodos.gif")));
		initgraph();
	}

	@Override
	public boolean Accept(Visitor V) {
	 return	V.VisitDestruible(this); 
	}


}
