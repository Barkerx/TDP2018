package disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Player.jugador;
import mapa.Map;
import mapa.celda;

public class Basico extends DisparoP{

	public Basico(celda c, Map m,jugador j) {
		super(c,m,j);
		damage=30;
		velocidad=18;
   	 	grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/disparo.png")));
		moviendo=false;
		initgraph();
		t1=new Thread(this);
		t1.start();
	}

}
