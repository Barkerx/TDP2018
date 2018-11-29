package disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Mapa;
import nave.player.Jugador;
import mapa.Celda;

public class Dbasico extends DisparoP{

	public Dbasico(Celda c, Mapa m,Jugador j) {
		super(c,m,j);
		damage=30;
		velocidad=35;
   	 	grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/disparo.png")));
		moviendo=false;
		initgraph();
		m.addDisparo(this);
	//	new DisparoRun(this,m);
	}

}
