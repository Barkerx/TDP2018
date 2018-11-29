package disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Mapa;
import nave.player.Jugador;
import visitor.VisitorDisparoP;
import mapa.Celda;

public class Dmisil extends DisparoP{

	public Dmisil(Celda c, Mapa m,Jugador j) {
		super(c,m,j);
		damage=50;
		velocidad=35;
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/misil.png")));
		visitor=new VisitorDisparoP(this,j);
		moviendo=false;
		initgraph();
		m.addDisparo(this);
		//new DisparoRun(this,m);
	}

}
