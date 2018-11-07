package disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Player.jugador;
import mapa.Mapa;
import mapa.celda;

public class Basico extends DisparoP{

	public Basico(celda c, Mapa m,jugador j) {
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
