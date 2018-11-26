package disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Mapa;
import mapa.Celda;

public class DisparoEnemy extends DisparoE{

	public DisparoEnemy(Celda c, Mapa m) {
		super(c,m);
		velocidad=35;
		damage=30;
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/disparo.png")));
		initgraph();
		m.addDisparo(this);
		//new DisparoRun(this,m);
	}
}
