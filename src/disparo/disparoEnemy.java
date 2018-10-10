package disparo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import mapa.Map;
import mapa.celda;

public class disparoEnemy extends DisparoE{

	public disparoEnemy(celda c, Map m) {
		this.c=c;
		this.m=m;
		profundidad=2;
		velocidad=50;
		damage=30;
		shieldL=null;
		moviendo=false;
		visitor=new visitorDisparoE(this);
		grafico =new JLabel(new ImageIcon(this.getClass().getResource("/resources/disparo.png")));
		initgraph();
		new DisparoRun(this);
	}
}
