package disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Map;
import mapa.celda;

public class disparoEnemy extends DisparoE{

	public disparoEnemy(celda c, Map m) {
		super(c,m);
		velocidad=35;
		damage=30;
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/disparo.png")));
		initgraph();
		m.addDisparo(this);
		//new DisparoRun(this,m);
	}
}
